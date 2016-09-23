package com.waterdrawwer.event;


import com.waterdrawer.config.IConfig;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PrimitiveDragEnter implements EventHandler<MouseEvent>
{
	private Delta m_oDelta ;
	private Button m_oButton;
	private IConfig m_config;
	public PrimitiveDragEnter(Delta delta,Object source,IConfig c)
	{
		m_oDelta = delta;
		m_oButton = (Button)source;
		m_config = c;
	}
	@Override
	public void handle(MouseEvent event) 
	{
		System.out.println("DragBegin");
		Image icon = new Image(m_config.getPrimitivePath(),50,50,false,false);
		m_oButton.setGraphic(new ImageView(icon));
		m_oButton.setLayoutX(event.getSceneX());
		m_oButton.setLayoutY(event.getSceneY());
		m_oButton.setVisible(true);
		m_oButton.setDisable(true);
		m_oDelta.x = ((Button)event.getSource()).getLayoutX() - event.getSceneX();
		m_oDelta.y = ((Button)event.getSource()).getLayoutY() - event.getSceneY();
	}
}
