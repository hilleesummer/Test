package file;

import java.io.*;

public class ReadFile {
	
	// ��      �� : ���Ͽ��� ���ڵ� read.
	// �Ķ���� : ���丮, ���ϸ�, ���ڵ�
	public static void readFile(String pDir, String pFileNm) {
		if( pDir == null ) pDir = "";

		File file = new File( pDir + "/" + pFileNm );
		if( !file.exists() ) {
			System.out.println( file + " is not exists.");
		}
		
		String record = null;
		try {
			BufferedReader br = new BufferedReader( new FileReader( file ) );
			while ( ( record = br.readLine() ) != null ) {
				System.out.println( record );
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readFile( ".", "append.txt");
	}

}
