package com.waterdrawer.clientstate;

import java.util.HashMap;
import java.util.Map;

import com.waterdrawer.clientstate.states.InitLoadingState;
import com.waterdrawer.clientstate.states.WorkingState;

public class ClientStateManager 
{
	private static ClientStateManager m_oInstance;
	public static ClientStateManager getInstance()
	{
		if (m_oInstance == null)
		{
			m_oInstance = new ClientStateManager();
		}
		return m_oInstance;
	}
	Map<ClientStateType, IClientState> m_mapClientStates;
	IClientState m_oCurrentState;
	
	public ClientStateManager()
	{
		m_mapClientStates = new HashMap<ClientStateType, IClientState>();
		m_mapClientStates.put(ClientStateType.CS_InitLoading, new InitLoadingState());
		m_mapClientStates.put(ClientStateType.CS_Working, new WorkingState());
	}
	public IClientState getCurrentState()
	{
		return this.m_oCurrentState;
	}
	
	public void ChangeClientStateTo(ClientStateType type)
	{
		if (m_oCurrentState != null && m_oCurrentState.getStateType() == type)
		{
			return;
		}
		if (m_mapClientStates.containsKey(type))
		{
			if (m_oCurrentState != null)
			{
				m_oCurrentState.exit();
			}
			m_oCurrentState = m_mapClientStates.get(type);
			m_oCurrentState.enter();
		}
	}
	public void EnterDefaultState()
	{
		ChangeClientStateTo(ClientStateType.CS_InitLoading);
	}
}
