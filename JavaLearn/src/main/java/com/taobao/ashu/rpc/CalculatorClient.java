package com.taobao.ashu.rpc;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {

	public static void main(String[] args) {
		calculate("10 * 120");
	}

	private static void calculate(String expr) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			Calculator calculator = (Calculator) registry.lookup("Calculator");
			String result = calculator.calculate(expr);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
