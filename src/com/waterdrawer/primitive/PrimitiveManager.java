package com.waterdrawer.primitive;

import java.util.HashMap;
import java.util.Map;

import com.waterdrawer.config.PrimitiveType;

public class PrimitiveManager 
{
	private static PrimitiveManager m_oInstance;
	public static PrimitiveManager getInstance()
	{
		if (m_oInstance == null)
		{
			m_oInstance = new PrimitiveManager();			
		}
		return m_oInstance;
	}
	public static Map<PrimitiveType, PrimitiveBase> m_mapPrimitives = new HashMap<PrimitiveType, PrimitiveBase>();
	PrimitiveManager()
	{
		m_mapPrimitives.put(PrimitiveType.Sphere, new SpherePrimitive());
	}
	public void Init()
	{
		for (PrimitiveBase p : m_mapPrimitives.values())
		{
			p.init();
		}
	}
}
