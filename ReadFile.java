package file;

import java.io.*;

public class ReadFile {
	
	// 설      명 : 파일에서 레코드 read.
	// 파라미터 : 디렉토리, 파일명, 레코드
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
