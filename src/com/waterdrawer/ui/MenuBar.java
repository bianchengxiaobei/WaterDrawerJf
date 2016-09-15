package com.waterdrawer.ui;

import java.util.Arrays;
import java.util.Collection;

import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionGroup;
import org.controlsfx.control.action.ActionUtils;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class MenuBar extends BaseUI
{
	private Collection<? extends Action> actions = null;
	javafx.scene.control.MenuBar menu = null;
	@Override
	public void init() 
	{
		actions = Arrays.asList(new ActionGroup("文件", new Action("新建"),new Action("打开"))
		,new ActionGroup("编辑", new Action("撤销")));
	}
	@Override
	public void release() 
	{
		actions = null;
	}
	@Override
	protected void initWidgets() 
	{
		menu = ActionUtils.createMenuBar(actions);
		((VBox) m_oRoot).getChildren().add(menu);
	}

}
