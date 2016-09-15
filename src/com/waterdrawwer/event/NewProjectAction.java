package com.waterdrawwer.event;


import javafx.scene.Node;

import org.controlsfx.control.action.Action;

public class NewProjectAction extends Action
{

	public NewProjectAction(String text) 
	{
		super(text);
		setEventHandler(ae -> handle());
	}
	public NewProjectAction(String text,Node image)
	{
		super(text);
		setGraphic(image);
		setEventHandler(ae -> handle());
	}
	private void handle()
	{
		System.out.println("新建工程");
	}
}
