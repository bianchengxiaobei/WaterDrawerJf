package com.waterdrawer.ui;

import java.util.Arrays;
import java.util.Collection;

import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionGroup;
import org.controlsfx.control.action.ActionUtils;

import com.waterdrawer.clientmain.ClientMain;
import com.waterdrawer.config.ConfigLoadManager;
import com.waterdrawer.config.IConfig;
import com.waterdrawer.util.ResourceUtil;
import com.waterdrawer.util.WDFileUtil;
import com.waterdrawwer.event.DeleteProjectAction;
import com.waterdrawwer.event.Delta;
import com.waterdrawwer.event.NewProjectAction;
import com.waterdrawwer.event.PrimitiveDragEnd;
import com.waterdrawwer.event.PrimitiveDragEnter;
import com.waterdrawwer.event.PrimitiveDragOver;
import com.waterdrawwer.event.TreeViewEventCellImpl;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ProjectView extends BaseUI
{
	private ScrollPane projectScrollPane;
	private ScrollPane primitiveScrollPane;
	private Tab networkTab;
	private Tab primitiveTab;
	private Collection<? extends Action> contextMenuActions;
	private TreeView<String> projectTreeView;
	private GridPane primitiveGridPane;
	@Override
	public void init() 
	{
		projectScrollPane = new ScrollPane();
		primitiveScrollPane = new ScrollPane();
		networkTab = new Tab("网络视图");
		primitiveTab = new Tab("元件");
		contextMenuActions = Arrays.asList(new NewProjectAction("新建工程",ResourceUtil.getImageView("new.png")),new DeleteProjectAction("删除工程",ResourceUtil.getImageView("delete_config.png")),new Action("重命名"));	
		projectTreeView = new TreeView<String>(WDFileUtil.scanAllFile(ClientMain.projectPath));
		primitiveGridPane = new GridPane();
		initGridPane(primitiveGridPane);
	}

	@Override
	public void release()
	{
		
	}

	@Override
	protected void initWidgets() 
	{
		projectTreeView.setEditable(true);
		projectTreeView.setCellFactory(p -> new TreeViewEventCellImpl());
		projectScrollPane.setContent(projectTreeView);
		networkTab.setContent(projectScrollPane);
		UIManager.projectViewTabPane.getTabs().add(networkTab);
		UIManager.projectViewTabPane.getTabs().add(primitiveTab);
		projectScrollPane.setContextMenu(ActionUtils.createContextMenu(contextMenuActions));
		
		primitiveScrollPane.setContent(primitiveGridPane);
		primitiveScrollPane.setFitToWidth(true);
		primitiveTab.setContent(primitiveScrollPane);
	}
	private void initGridPane(GridPane g)
	{
		g.setHgap(5);
		g.setVgap(5);
		int maxColumns = 2;
		int col = 0;
		int row = 0;
		for (IConfig c : ConfigLoadManager.getInstance().m_mapAllConfig.values())
		{
			Image icon = new Image(c.getPrimitivePath(),50,50,false,false);
			Button button = new Button();
			button.setGraphic(new ImageView(icon));
			Delta delta = new Delta();
			button.setOnMousePressed(new PrimitiveDragEnter(delta,UIManager.copyButton,c));
			button.setOnMouseDragged(new PrimitiveDragOver(delta,UIManager.copyButton));
			button.setOnMouseReleased(new PrimitiveDragEnd(delta, UIManager.copyButton));
			//button.setMaxWidth(Double.MAX_VALUE);
			col = col % maxColumns + 1;
			if (col == 1) row++;
			g.add(button, col, row);
			GridPane.setFillHeight(button, true);
			GridPane.setFillWidth(button, true);
		}
	}
}
