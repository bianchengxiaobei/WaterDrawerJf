package com.waterdrawer.clientmain;


import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import com.waterdrawer.clientstate.ClientStateManager;
import com.waterdrawer.ui.UIManager;

public class ClientMain 
{
	private static ClientMain m_oInstance;
	public static ClientMain getInstance()
	{
		if (m_oInstance == null)
		{
			m_oInstance = new ClientMain();
		}
		return m_oInstance;
	}
	public static String projectPath = "D:/WaterDrawer";
	public void start()
	{
		System.out.println("ClientMain Start");
		UIManager.getInstance().Init();
		ClientStateManager.getInstance().EnterDefaultState();
	}
}
