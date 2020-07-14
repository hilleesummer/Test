package file;

import java.io.*;

public class AppendFile {

	// ��      �� : ���Ͽ� ���ڵ� append.
	// �Ķ���� : ���丮, ���ϸ�, ���ڵ�
	public static void appendFile(String pDir, String pFileNm, String pRecord) {
		if( pDir == null ) pDir = "";

		File file = new File( pDir + "/" + pFileNm );
		
		try {
			BufferedWriter bw = new BufferedWriter( new FileWriter( file, true ) );
			bw.write( pRecord );
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		appendFile(".", "append.txt", "1st record");
		appendFile(".", "append.txt", "2nd record");
	}

}
