package com.waterdrawer.clientmain;

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
	public void start()
	{
		System.out.println("ClientMain Start");
		ClientStateManager.getInstance().EnterDefaultState();
		UIManager.getInstance().Init();
	}
}
