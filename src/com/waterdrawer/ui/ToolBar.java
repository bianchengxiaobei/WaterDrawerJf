package com.waterdrawer.ui;

import java.util.Arrays;
import java.util.Collection;





import javafx.scene.layout.VBox;

import org.controlsfx.control.action.Action;


import org.controlsfx.control.action.ActionUtils;
import org.controlsfx.control.action.ActionUtils.ActionTextBehavior;


public class ToolBar extends BaseUI
{
	private Collection<? extends Action> actions = null;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		actions = Arrays.asList(new Action("元件放大"),new Action("元件缩小"),new Action("元件旋转"));
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void initWidgets() 
	{
		javafx.scene.control.ToolBar toolBar = ActionUtils.createToolBar(actions, ActionTextBehavior.SHOW);
		((VBox)m_oRoot).getChildren().add(toolBar);
	}

}
