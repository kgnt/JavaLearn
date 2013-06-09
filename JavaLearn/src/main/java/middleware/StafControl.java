package middleware;

import java.util.List;
import java.util.Map;
import com.ibm.staf.STAFException;
import com.ibm.staf.STAFHandle;
import com.ibm.staf.STAFResult;
import com.ibm.staf.STAFUtil;

public class StafControl {
	protected STAFHandle stafHandle = null;

	/**
	 * Initialize stafHandle
	 */
	public StafControl() {
		try {
			stafHandle = new STAFHandle("Base Handle");
		} catch (STAFException e) {
		}
	}

	/**
	 * Execute command by stafHandle on IP
	 * 
	 * @param stafHandle
	 *            execute by which stafHandle
	 * @param ip
	 *            host IP
	 * @param cmd
	 *            command that to execute
	 * @return STAF execute result
	 */
	public final STAFResult executeByStaf(STAFHandle stafHandle, String ip,
			String cmd) {
		STAFResult result = stafHandle.submit2(ip, "PROCESS",
				"START SHELL COMMAND " + STAFUtil.wrapData(cmd)
						+ " WAIT RETURNSTDOUT STDERRTOSTDOUT");
		return result;
	}

	/**
	 * Get command return string executed by stafHandle
	 * 
	 * @param result
	 *            STAFResult type parameter
	 * @return command return string
	 */
	@SuppressWarnings("rawtypes")
	public final String getStafOutput(STAFResult result) {
		Map rstMap = (Map) result.resultObj;
		List rstList = (List) rstMap.get("fileList");
		Map stdoutMap = (Map) rstList.get(0);
		String stdout = (String) stdoutMap.get("data");
		return stdout;
	}

	/**
	 * Execute command on specified IP
	 * 
	 * @param ip
	 *            host IP
	 * @param cmd
	 *            command to execute
	 */
	public void executeCmd(String ip, String cmd) {
		STAFResult result = executeByStaf(stafHandle, ip, cmd);
		if (result.rc != 0) {
			System.err.println(ip + " result.rc not 0 while execute cmd: "
					+ cmd + " -- " + result.rc);
		}
	}

	/**
	 * Execute command on specified IP, then return specified type object
	 * 
	 * @param ip
	 *            host IP
	 * @param cmd
	 *            command to execute
	 * @param cls
	 *            returned value's class
	 * @return specified type object
	 */
	public Object executeCmd(String ip, String cmd, Class<?> cls) {
		Object ret = null;
		STAFResult result = executeByStaf(stafHandle, ip, cmd);
		if (result.rc != 0) {
			System.err.println(ip + " result.rc not 0 while execute cmd: "
					+ cmd + " -- " + result.rc);
		} else {
			String stdout = getStafOutput(result);
			try {
				if (cls.equals(Integer.class))
					ret = new Integer(stdout.trim());
				else if (cls.equals(String.class))
					ret = stdout.trim();
				else
					System.err.println("cls not supported! " + cls.getName());
			} catch (Exception e) {
				System.err.println("get verify exception: " + stdout);
				e.printStackTrace();
			}
		}
		return ret;
	}

	/**
	 * Wait specified seconds
	 * 
	 * @param second
	 *            second count
	 */
	public final void waitto(int second) {
		System.out.println("wait for " + second + "s......");
		try {
			Thread.sleep(second * 1000);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("wait encured exception!");
		}
	}

	/**
	 * Modify key's value to specified value
	 * 
	 * @param ip
	 *            host IP
	 * @param confname
	 *            file which to modify(should include full path)
	 * @param key
	 *            key to modify
	 * @param value
	 *            target value
	 */
	public void modifyConfigFile(String ip, String confname, String key,
			String value) {
		System.out.println("change file:" + confname + " on " + ip + " key="
				+ key + " value=" + value);
		String valueRep = value.replaceAll("/", "\\\\/");
		String cmd = "sed -i \"s/" + key + "=.*$/" + key + "=" + valueRep + "/\" "
				+ confname + " && grep \"" + key + "=.*$\" " + confname
				+ "|awk -F\"=\" \'{print $2}\'";
		STAFResult result = executeByStaf(stafHandle, ip, cmd);
		if (result.rc != 0) {
			System.err.println(ip + " result.rc not 0: " + result.rc);
		} else {
			String stdout = getStafOutput(result);
			if (!stdout.trim().equals(value))
				System.err.println("change failed! result: " + stdout.trim());
		}
	}
	
}
