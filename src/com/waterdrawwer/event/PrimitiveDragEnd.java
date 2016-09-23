package com.waterdrawwer.event;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class PrimitiveDragEnd implements EventHandler<MouseEvent>
{
	private Delta m_oDelta ;
	private Button m_oButton;
	public PrimitiveDragEnd(Delta delta,Object source)
	{
		m_oDelta = delta;
		m_oButton = (Button)source;
	}
	@Override
	public void handle(MouseEvent event) 
	{
		System.out.println("DragEnd");
		m_oDelta.x = 0;
		m_oDelta.y = 0;
		m_oButton.setVisible(false);
	}
}
