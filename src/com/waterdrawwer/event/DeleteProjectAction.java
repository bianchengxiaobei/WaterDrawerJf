package com.waterdrawwer.event;


import javafx.scene.Node;

import org.controlsfx.control.action.Action;

public class DeleteProjectAction extends Action
{

	public DeleteProjectAction(String text) {
		super(text);
		setEventHandler(ae -> deleteProject());
	}
	public DeleteProjectAction(String text,Node image)
	{
		super(text);
		setGraphic(image);
		setEventHandler(ae -> deleteProject());
	}
	private void deleteProject()
	{
		
	}
}
