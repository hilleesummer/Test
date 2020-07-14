package directory;

import java.io.*;

public class SearchDir {

	public static void searchDir(String pRootPath, int pLevel, String pFullPath) {
		File dir = new File(pRootPath);
		File [] files = dir.listFiles();
		if( files != null && files.length > 0) {
			for( File file : files ) {
				if( pLevel == 0 ) pFullPath = "";
				else pFullPath += "/";
				pFullPath += file.getName();
				System.out.println( pFullPath );
				if( file.isDirectory() ) searchDir(file.getAbsolutePath(), pLevel+1, pFullPath);
			}
		}
		
	}
	public static void main(String[] args) {
		searchDir( "./", 0, null );
	}

}
