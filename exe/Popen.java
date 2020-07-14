package exe;

import java.io.*;
public class Popen {
	
	// 설      명 : popen.
	// 파라미터 : none
	// 주의사항 : write 시 개행문자를 반드시 삽입해야함
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
