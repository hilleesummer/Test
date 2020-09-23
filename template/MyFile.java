import java.io.*;
import java.util.*;

public class MyFile {
	// ��      �� : ���Ͽ��� ���ڵ� read.
	// �Ķ���� : ���丮, ���ϸ�, ���ڵ�
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
	
	// ��      �� : ���Ͽ� ���ڵ� append.
	// �Ķ���� : ���丮, ���ϸ�, ���ڵ�
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
