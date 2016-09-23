package com.waterdrawwer.event;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class PrimitiveDragOver implements EventHandler<MouseEvent>
{
	private Delta m_oDelta ;
	private Button m_oButton;
	public PrimitiveDragOver(Delta delta,Object source)
	{
		m_oDelta = delta;
		m_oButton = (Button)source;
	}
	@Override
	public void handle(MouseEvent event) 
	{
		this.m_oButton.setTranslateX(event.getSceneX() + m_oDelta.x);
		this.m_oButton.setTranslateY(event.getSceneY() + m_oDelta.y);
	}
	
}
