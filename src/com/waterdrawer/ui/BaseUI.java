package com.waterdrawer.ui;

import javafx.scene.layout.VBox;

public abstract class BaseUI 
{
	protected VBox m_oRoot;
	protected String m_sUIName;
	protected boolean m_bResident;
	protected boolean m_bIsVisible = false;
	
	public abstract void init();
	
	public abstract void release();
	
	protected abstract void initWidgets();
	
	public boolean IsVisible()
	{
		return this.m_bIsVisible;
	}
	public void Show(VBox parent)
	{
		if (m_oRoot == null)
		{
			m_oRoot = parent;
		}
		initWidgets();
		m_bIsVisible = true;
	}
	
}
