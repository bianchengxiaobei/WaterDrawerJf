package com.waterdrawer.clientstate.states;

import com.waterdrawer.clientstate.ClientStateType;
import com.waterdrawer.clientstate.IClientState;
import com.waterdrawer.config.ConfigLoadManager;
import com.waterdrawer.config.IConfig;
import com.waterdrawer.config.PrimitiveType;
import com.waterdrawer.config.primitive.SphereConfig;

public class WorkingState implements IClientState{

	ClientStateType m_eStateTo;
	@Override
	public ClientStateType getStateType() 
	{
		return ClientStateType.CS_Working;
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
		System.out.println("Working");
		
	}

	@Override
	public void exit() 
	{
				
	}

}
