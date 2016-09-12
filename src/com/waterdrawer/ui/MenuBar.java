package com.waterdrawer.ui;

import java.util.Arrays;
import java.util.Collection;

import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionGroup;
import org.controlsfx.control.action.ActionUtils;

import javafx.scene.layout.VBox;


public class MenuBar extends BaseUI
{
	VBox root = new VBox(10);
	private Collection<? extends Action> actions = null;
	@Override
	public void init() 
	{
		root.setMaxHeight(Double.MAX_VALUE);	
		actions = Arrays.asList(new ActionGroup("文件", new Action("新建"),new Action("打开"))
		,new ActionGroup("编辑", new Action("撤销")));
	}

	@Override
	public void release() 
	{
		root = null;
		actions = null;
	}
	@Override
	protected void initWidgets() 
	{
		javafx.scene.control.MenuBar menu = ActionUtils.createMenuBar(actions);
		root.getChildren().add(menu);
		m_oRoot.getChildren().add(root);
	}

}
