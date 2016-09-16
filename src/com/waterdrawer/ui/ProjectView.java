package com.waterdrawer.ui;

import java.util.Arrays;
import java.util.Collection;

import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionGroup;
import org.controlsfx.control.action.ActionUtils;

import com.waterdrawer.clientmain.ClientMain;
import com.waterdrawer.util.ResourceUtil;
import com.waterdrawer.util.WDFileUtil;
import com.waterdrawwer.event.DeleteProjectAction;
import com.waterdrawwer.event.NewProjectAction;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ProjectView extends BaseUI
{
	private ScrollPane projectScrollPane;
	private Tab networkTab;
	private Tab primitiveTab;
	private Collection<? extends Action> contextMenuActions;
	private TreeView<String> projectTreeView;
	@Override
	public void init() 
	{
		projectScrollPane = new ScrollPane();
		networkTab = new Tab("网络视图");
		primitiveTab = new Tab("元件");
		contextMenuActions = Arrays.asList(new NewProjectAction("新建工程",ResourceUtil.getImageView("new.png")),new DeleteProjectAction("删除工程",ResourceUtil.getImageView("delete_config.png")),new Action("重命名"));	
		projectTreeView = new TreeView<String>(WDFileUtil.scanAllFile(ClientMain.projectPath));
	}

	@Override
	public void release()
	{
		
	}

	@Override
	protected void initWidgets() 
	{
		projectScrollPane.setContent(projectTreeView);
		networkTab.setContent(projectScrollPane);
		UIManager.projectViewTabPane.getTabs().add(networkTab);
		UIManager.projectViewTabPane.getTabs().add(primitiveTab);
		projectScrollPane.setContextMenu(ActionUtils.createContextMenu(contextMenuActions));
	}
	
}
