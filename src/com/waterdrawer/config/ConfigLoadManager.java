package com.waterdrawer.config;

import java.util.HashMap;
import java.util.Map;

import com.waterdrawer.config.primitive.SphereConfig;

public class ConfigLoadManager 
{
	private static ConfigLoadManager m_oInstance;
	public static ConfigLoadManager getInstance()
	{
		if (m_oInstance == null)
		{
			m_oInstance = new ConfigLoadManager();			
		}
		return m_oInstance;
	}
	public Map<PrimitiveType, IConfig> m_mapAllConfig = new HashMap<PrimitiveType, IConfig>();
	
	public ConfigLoadManager()
	{
		m_mapAllConfig.put(PrimitiveType.Sphere, new SphereConfig("sphere", "src/com/waterdrawer/config/xml/sphere.xml","/com/waterdrawer/primitive/source/sphere.jpg"));
	}
	public void loadAll()
	{
		for (IConfig c : m_mapAllConfig.values())
		{
			ConfigXmlLoader.load(c);
		}		
	}
	public IConfig getConfig(PrimitiveType type)
	{
		if (m_mapAllConfig.size() != 0)
		{
			IConfig config = m_mapAllConfig.get(type);
			if (config != null)
			{
				return config;
			}
		}
		return null;
	}
}
