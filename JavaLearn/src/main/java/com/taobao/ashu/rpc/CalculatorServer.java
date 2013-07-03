package com.taobao.ashu.rpc;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer implements Calculator {
	
	public String calculate(String expr) throws RemoteException {
		return expr;
	}

	public void start() throws RemoteException, AlreadyBoundException {
		Calculator stub = (Calculator) UnicastRemoteObject
				.exportObject(this, 0);
		Registry registry = LocateRegistry.getRegistry();
		registry.rebind("Calculator", stub);
	}
}
