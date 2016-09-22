package com.waterdrawer.config.primitive;


import com.waterdrawer.config.IConfig;

public class SphereConfig extends IConfig
{
	public SphereConfig(String name, String filePath,String p) 
	{
		super(name, filePath,p);		
	}
	public String radius;
	public String fillColor;	
}
