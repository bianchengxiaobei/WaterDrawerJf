package com.waterdrawer.config;

public abstract class IConfig 
{
	protected String m_sName;
	protected String m_sFilePath;
	protected String m_sPrimitivePath;
	public IConfig(String name,String filePath,String primitivePath)
	{
		this.m_sName = name;
		this.m_sFilePath = filePath;
		this.m_sPrimitivePath = primitivePath;
	}
	public String getName() {
		return m_sName;
	}
	public void setName(String m_sName) {
		this.m_sName = m_sName;
	}
	public String getFilePath() {
		return m_sFilePath;
	}
	public void setFilePath(String m_sFilePath) {
		this.m_sFilePath = m_sFilePath;
	}
	public String getPrimitivePath() {
		return m_sPrimitivePath;
	}
	public void setPrimitivePath(String m_sPrimitivePath) {
		this.m_sPrimitivePath = m_sPrimitivePath;
	}
}
