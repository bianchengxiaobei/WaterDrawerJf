package com.waterdrawer.ui;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.Tab;

public class Canvas extends BaseUI
{
	private Map<String, javafx.scene.canvas.Canvas> m_mapCanvas;
	@Override
	public void init() 
	{		
		m_mapCanvas = new HashMap<String, javafx.scene.canvas.Canvas>();
	}

	@Override
	public void release()
	{
				
	}

	@Override
	protected void initWidgets() 
	{
		
	}
	public void addCanvas(String name,int id)
	{
		Tab t = new Tab(name);
		if (m_mapCanvas.containsKey(name))
		{
			t.setContent(m_mapCanvas.get(name));
		}
		javafx.scene.canvas.Canvas c = new javafx.scene.canvas.Canvas(800, 600);
		m_mapCanvas.put(name, c);
		t.setContent(c);
		UIManager.canvasViewTabPane.getTabs().add(id, t);
	}

}
