package com.waterdrawer.primitive;

import javafx.scene.canvas.GraphicsContext;

import com.waterdrawer.config.IConfig;


public abstract class PrimitiveBase 
{
	private int m_iId;
	private String m_sName;
	private IConfig m_config;
	public abstract void draw(GraphicsContext gc);
	public abstract void init();
	public int getM_iId() {
		return m_iId;
	}
	public void setM_iId(int m_iId) {
		this.m_iId = m_iId;
	}
	public String getM_sName() {
		return m_sName;
	}
	public void setM_sName(String m_sName) {
		this.m_sName = m_sName;
	}
	public IConfig getM_config() {
		return m_config;
	}
	public void setM_config(IConfig m_config) {
		this.m_config = m_config;
	}
	
}
