package com.waterdrawer.ui;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


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
	public static VBox Root ;
	public static SplitPane splitPane;
	public static TabPane projectViewTabPane;
	public static TabPane canvasViewTabPane;
	public static TabPane networkViewTabPane;
	public static Button copyButton;
	public Map<UIType, BaseUI> m_mapUIs; 
	public UIManager()
	{
		m_mapUIs = new HashMap<UIType, BaseUI>();
		m_mapUIs.put(UIType.UIT_MenuBar, new MenuBar());
		m_mapUIs.put(UIType.UIT_ToolBar, new ToolBar());
		m_mapUIs.put(UIType.UIT_ProjectView, new ProjectView());
		m_mapUIs.put(UIType.UIT_Canvas, new Canvas());
		Root = new VBox();
		splitPane = new SplitPane();
		projectViewTabPane = new TabPane();
		networkViewTabPane = new TabPane();
		canvasViewTabPane = new TabPane();		
		splitPane.getItems().addAll(projectViewTabPane,canvasViewTabPane,networkViewTabPane);
		splitPane.setDividerPositions(0.2f,0.8f,1.0f);
		
		copyButton = new Button();
		//copyButton.setVisible(false);
	}
	public void Init()
	{
		for(BaseUI ui : m_mapUIs.values())
		{
			ui.init();
		}
	}
	public BaseUI getUI(UIType type)
	{
		if (m_mapUIs.containsKey(type))
		{
			return m_mapUIs.get(type);
		}
		else
		{
			return null;
		}
	}
}
