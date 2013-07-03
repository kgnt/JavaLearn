package com.taobao.ashu.rpc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
	String calculate(String expr) throws RemoteException;
}
