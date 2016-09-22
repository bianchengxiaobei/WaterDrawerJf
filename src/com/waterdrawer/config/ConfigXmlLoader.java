package com.waterdrawer.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ConfigXmlLoader
{
	public static void load(IConfig config)
	{
		try 
		{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			InputStream in = new FileInputStream(config.m_sFilePath);
			Document doc = builder.parse(in);
			NodeList list = doc.getElementsByTagName(config.m_sName);
			if (list.getLength() > 0)
			{
				Node node = list.item(0);
				NodeList childs = node.getChildNodes();
				for (int j= 0;j<childs.getLength();j++)
				{
					if (childs.item(j).getNodeName().equals("#text"))
						continue;
					Field field = config.getClass().getDeclaredField(childs.item(j).getNodeName());
					field.set(config, childs.item(j).getTextContent());
				}
			}
			in.close();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
