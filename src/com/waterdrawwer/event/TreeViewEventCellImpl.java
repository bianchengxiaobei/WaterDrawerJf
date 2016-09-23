package com.waterdrawwer.event;




import com.waterdrawer.clientmain.ClientMain;
import com.waterdrawer.clientstate.ClientStateManager;
import com.waterdrawer.clientstate.ClientStateType;
import com.waterdrawer.ui.Canvas;
import com.waterdrawer.ui.UIManager;
import com.waterdrawer.ui.UIType;
import com.waterdrawer.util.ResourceUtil;
import com.waterdrawer.util.WDFileUtil;








import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;import javafx.scene.input.KeyCode;


public class TreeViewEventCellImpl extends TreeCell<String>
{
	private TextField textField;
	private ContextMenu projectMenu = new ContextMenu();
	private ContextMenu networkMenu = new ContextMenu();
	public TreeViewEventCellImpl()
	{		
		MenuItem newNetworkItem = new MenuItem("新建网络模型");
		projectMenu.getItems().add(newNetworkItem);
		newNetworkItem.setOnAction(ae ->createNetwork());
		
		MenuItem renameNetworkItem = new MenuItem("删除网络模型");
		MenuItem openNetworkItem = new MenuItem("打开");
		networkMenu.getItems().addAll(renameNetworkItem,openNetworkItem);
		renameNetworkItem.setOnAction(ae -> deleteNetwork());
		openNetworkItem.setOnAction(ae -> openNetwork());
	}
	@Override
	public void startEdit()
	{
		super.startEdit();
		if (textField == null)
		{
			createTextField();
		}
		setText(null);
		setGraphic(textField);
		textField.selectAll();
	}
	@Override
	public void cancelEdit()
	{
		super.cancelEdit();
		setText(getItem());
		setGraphic(getTreeItem().getGraphic());
	}
	public void updateItem(String item, boolean empty)
	{
		super.updateItem(item, empty);
		if (empty)
		{
			setText(null);
			setGraphic(null);
		}
		else
		{
			if (isEditing())
			{
				if (textField != null)
				{
					textField.setText(getString());
				}
				setText(null);
				setGraphic(textField);
			}else
			{
				setText(getString());
				setGraphic(getTreeItem().getGraphic());
				if (getTreeItem().getParent() != null && getTreeItem().isExpanded())
				{
					setContextMenu(projectMenu);
				}
				else if(getTreeItem().getParent() != null && !getTreeItem().isExpanded())
				{
					setContextMenu(networkMenu);
				}
			}
		}
	}
	private String getString()
	{
		return getItem() == null ? "" : getItem().toString();
	}
	private void createTextField()
	{
		textField = new TextField(getString());
		String oldName = getString();
		textField.setOnKeyReleased(t -> {
			if (t.getCode() == KeyCode.ENTER)
			{
				commitEdit(textField.getText());
				StringBuilder sb = new StringBuilder();
				TreeItem<String> p = getTreeItem().getParent();
				while (p != null && p.getValue() != "项目工程")
				{
					sb.insert(0,p.getValue()+"/");
					p = p.getParent();
				}
				WDFileUtil.renameFolder(ClientMain.projectPath+"/"+sb.toString(), oldName, textField.getText());				
			}else if(t.getCode() == KeyCode.ESCAPE)
			{
				cancelEdit();
			}
		});
	}
	private void createNetwork()
	{
		TreeItem<String> newNetwork = new TreeItem<String>("NewNetwork.wd",ResourceUtil.getImageView("file_obj.png"));
		newNetwork.setExpanded(false);
		getTreeItem().getChildren().add(newNetwork);
		WDFileUtil.createFile("NewNetwork.wd", ClientMain.projectPath+"/"+getString());
		
		//ClientStateManager.getInstance().ChangeClientStateTo(ClientStateType.CS_Working);
		((Canvas)UIManager.getInstance().getUI(UIType.UIT_Canvas)).addCanvas("NewNetwork.wd", 0);
		
	}
	private void openNetwork()
	{
		//ClientStateManager.getInstance().ChangeClientStateTo(ClientStateType.CS_Working);
	}
	private void deleteNetwork()
	{
		
	}
}
