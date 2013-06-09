package middleware;

import javax.servlet.*;
import javax.servlet.http.*;

import middleware.StafControl;

import java.io.*;

//import java.util.Enumeration;

public class StartStress extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StafControl sc;
	private static boolean runFlag = true;
	private static long refreshCount = 0;

	// server configure
	private String projectName;
	private String serverIp;
	private String startServerCmd;

	// stress configure
	private String startStressCmd;
	private String stressName;
	private String stressLog;

	// client configure
	private static final String PROJECT_NAME = "Project_name";
	private static final String MONITOR_PROCESS = "Monitor_process";
	private static final String MONITOR_LOG = "Monitor_log";

	// client command
	private static final String CLIENT_PATH = "/home/admin/perf_visual/";
	private static final String startClientCmd = "cd " + CLIENT_PATH
			+ " && ./doperflog.sh &";
	private static final String clientConfig = CLIENT_PATH + "config";

	public StartStress() {
		sc = new StafControl();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(!runFlag) {
			refreshCount++;
			System.out.println("Refresh " + refreshCount + " times......");
			
			// redirect to index.jsp
			request.getRequestDispatcher("/index.jsp").forward(request,response);
			
			return;
		}
		
		// response.setContentType("text/html;charset=GBK");
		request.setCharacterEncoding("GBK");
		// PrintWriter out = response.getWriter();

		// get global parameters from web
		projectName = request.getParameter("projectName");
		serverIp = request.getParameter("serverIp");
		startServerCmd = request.getParameter("startServerCmd");
		System.out.println("get projectName from web: " + projectName);
		System.out.println("get serverIp from web: " + serverIp);
		System.out.println("get startServerCmd from web: " + startServerCmd);

		// get stress parameters from web
		startStressCmd = request.getParameter("startStressCmd");
		stressLog = request.getParameter("stressLog");
		stressName = request.getParameter("stressName");
		System.out.println("get startStressCmd from web: " + startStressCmd);
		System.out.println("get stressName from web: " + stressName);

		// get stress IP from web
		String[] clients = request.getParameterValues("client");
		int clientsLen = clients.length;
		System.out.println("get clients count from web: " + clientsLen);
		if (clientsLen != 0) {
			for (String client : clients) {
				System.out.println("get client from web: " + client);

				// change projectName in client.config
				sc.modifyConfigFile(client, clientConfig, PROJECT_NAME,
						projectName);
				sc.modifyConfigFile(client, clientConfig, MONITOR_PROCESS,
						stressName);
				sc.modifyConfigFile(client, clientConfig, MONITOR_LOG,
						stressLog);
			}
		} else {
			System.err.println("get no client!!!");
			return;
		}

		// start servers
		System.out.println("start servers......");
		String startServerRet = (String) (sc.executeCmd(serverIp,
				startServerCmd, String.class));
		System.out.println(startServerRet);

		sc.waitto(15);
		
		// start stress
		System.out.println("start stress......");
		for (String client : clients) {
			System.out.println("start stress on " + client + "......");
			String startStressRet = (String) (sc.executeCmd(client,
					startStressCmd, String.class));
			System.out.println("result: " + startStressRet);
		}
		sc.waitto(15);

		// start clients
		for (String client : clients) {
			System.out.println("start client on " + client + "......");
			sc.executeCmd(client, startClientCmd);
		}
		
		// redirect to index.jsp
		request.getRequestDispatcher("/index.jsp").forward(request,response);
		
		runFlag = false;

		// String cmd = "cd /home/admin/ashu/ycsb && ./run.sh workload put @";\

		// if (ret1 != null && ret2 != null && ret3 != null) {
		// out.println("get host by staf: " + ret1);
		// out.println("<br>");
		// out.println("get host by staf: " + ret2);
		// out.println("<br>");
		// out.println("get host by staf: " + ret3);
		// out.println("<br>");
		// }

		// out.close();

		// Enumeration paramNames = request.getParameterNames();
		// while (paramNames.hasMoreElements()) {
		// String paramName = (String) paramNames.nextElement();
		// out.print("<TR><TD>" + paramName + "<TD>");
		// out.println("<BR>");//print new line
		// String[] paramValues = request.getParameterValues(paramName);
		// if (paramValues.length == 1) {
		// String paramValue = paramValues[0];
		// if (paramValue.length() == 0)
		// out.println("<I>No Value</I>");
		// else
		// out.println(paramValue);
		// } else {
		// out.println("<UL>");
		// for (int i = 0; i < paramValues.length; i++) {
		// out.println("<LI>" + paramValues[i]);
		// }
		// out.println("</UL>");
		// }
		// }
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
