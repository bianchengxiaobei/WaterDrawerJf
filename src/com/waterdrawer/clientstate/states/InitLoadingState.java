package com.waterdrawer.clientstate.states;

import com.waterdrawer.clientstate.ClientStateType;
import com.waterdrawer.clientstate.IClientState;
import com.waterdrawer.ui.UIManager;
import com.waterdrawer.ui.UIType;

public class InitLoadingState implements IClientState
{
	ClientStateType m_eStateTo;
	@Override
	public ClientStateType getStateType()
	{
		return ClientStateType.CS_InitLoading;
	}

	@Override
	public void SetStateTo(ClientStateType csType) 
	{
		m_eStateTo = csType;
	}

	@Override
	public void enter() 
	{
		SetStateTo(ClientStateType.CS_Continue);	
		UIManager.getInstance().m_mapUIs.get(UIType.UIT_MenuBar).Show(UIManager.root);
	}

	@Override
	public void exit() 
	{
			
	}

}
