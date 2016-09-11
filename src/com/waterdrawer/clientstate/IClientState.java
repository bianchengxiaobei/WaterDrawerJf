package com.waterdrawer.clientstate;

public interface IClientState 
{
	ClientStateType getStateType();
	void SetStateTo(ClientStateType csType);
	void enter();
	void exit();
}
