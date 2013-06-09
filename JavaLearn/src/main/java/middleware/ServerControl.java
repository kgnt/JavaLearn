package middleware;

import java.util.concurrent.Callable;
import com.ibm.staf.STAFResult;

public class ServerControl extends StafControl implements Callable<Boolean> {

	private String serverIp;
	private String cmd;

	/**
	 * @param serverIp
	 *            server IP
	 * @param cmd
	 *            command to execute
	 */
	public ServerControl(String serverIp, String cmd) {
		this.setServerIp(serverIp);
		this.setCmd(cmd);
	}

	/**
	 * @see java.util.concurrent.Callable#call()
	 * @return whether command execute successful
	 */
	public Boolean call() throws Exception {
		boolean ret = false;

		STAFResult result = executeByStaf(stafHandle, serverIp, cmd);
		if (result.rc != 0) {
			System.err.println(serverIp + " result.rc not 0! " + result.rc);
		} else {
			ret = true;
		}

		return ret;
	}

	/**
	 * @param serverIp
	 *            the serverIp to set
	 */
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	/**
	 * @return the serverIp
	 */
	public String getServerIp() {
		return serverIp;
	}

	/**
	 * @param cmd
	 *            the cmd to set
	 */
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	/**
	 * @return the cmd
	 */
	public String getCmd() {
		return cmd;
	}

}
