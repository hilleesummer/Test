package popen;

import java.io.*;
public class Popen {
	
	// ��      �� : popen.
	// �Ķ���� : none
	// ���ǻ��� : write �� ���๮�ڸ� �ݵ�� �����ؾ���
	public static void popen() {
//		String [] cmd = new String[] { "cmd", "/C", "dir", ">", "redirect.txt" };
		String [] cmd = new String[] { "cmd" };
		try {
			Process p = new ProcessBuilder(cmd).start();
			BufferedReader br = new BufferedReader( new InputStreamReader( p.getInputStream()) );
			BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( p.getOutputStream()) );
			
			bw.write("ping -n 3 127.0.0.1\n");
			bw.flush();
			bw.close();
			String stream = null;
			while ( ( stream = br.readLine() ) != null ) {
				System.out.println( stream );
			}
			p.waitFor();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		popen();
	}

}
