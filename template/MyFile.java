import java.io.*;
import java.util.*;

public class MyFile {
	// 설      명 : 파일에서 레코드 read.
	// 파라미터 : 디렉토리, 파일명, 레코드
	public List<String> readFile(String pDir, String pFileNm) {
		
		List<String> ret = new ArrayList<String>();
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
				ret.add( record );
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	// 설      명 : 파일에 레코드 append.
	// 파라미터 : 디렉토리, 파일명, 레코드
	public void appendFile(String pDir, String pFileNm, List<String> tList) {
		if( pDir == null ) pDir = "";

		File file = new File( pDir + "/" + pFileNm );
		
		try {
			BufferedWriter bw = new BufferedWriter( new FileWriter( file, true ) );
			for( int i = 0; i < tList.size(); i++ ) {
				String record = tList.get( i );
				bw.write( record );
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
