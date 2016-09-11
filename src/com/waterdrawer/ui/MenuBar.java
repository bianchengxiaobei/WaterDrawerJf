package com.waterdrawer.ui;

import javafx.scene.control.Button;


public class MenuBar extends BaseUI
{
	@Override
	public void init() 
	{
			
	}

	@Override
	public void release() 
	{
			
	}
	@Override
	protected void initWidgets() 
	{
		Button btn = new Button("Hello World");	
		m_oRoot.getChildren().add(btn);
	}

}
