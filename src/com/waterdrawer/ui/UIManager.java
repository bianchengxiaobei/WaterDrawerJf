package com.waterdrawer.ui;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.Group;
import javafx.scene.layout.VBox;


public class UIManager
{
	private static UIManager m_oInstance;
	public static UIManager getInstance()
	{
		if (m_oInstance == null)
		{
			m_oInstance = new UIManager();
		}
		return m_oInstance;
	}
	public static VBox root ;
	public Map<UIType, BaseUI> m_mapUIs; 
	public UIManager()
	{
		m_mapUIs = new HashMap<UIType, BaseUI>();
		m_mapUIs.put(UIType.UIT_MenuBar, new MenuBar());
		m_mapUIs.put(UIType.UIT_ToolBar, new ToolBar());
		root = new VBox();
		root.setMaxHeight(Double.MAX_VALUE);
	}
	public void Init()
	{
		for(BaseUI ui : m_mapUIs.values())
		{
			ui.init();
		}
	}
}
