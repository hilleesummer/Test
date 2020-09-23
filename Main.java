import java.util.*;

public class Main {
	static MyFile myFile = new MyFile();
	static MyOperation myOper = new MyOperation();
	
	// String
	static List<String> iList;	// string records from input file
	static List<String> oList;	// string records from input file
	// Data
	static List<MyData> mList;	// parsed main data list
	static List<MyData> cList;	// copied data of main data list


	public static void main(String[] args) {
		iList = myFile.readFile(".", "INPUT.TXT");
		mList = myOper.parseList( iList );
//		myOper.printList( mList );
		
		cList = myOper.copyLists( mList );
//		myOper.printList( cList );
		
		cList = myOper.sortListByComparator( cList );
//		myOper.printList( cList );
		
		oList = myOper.process( mList );
		myFile.appendFile(".", "OUTPUT.TXT", oList);
	}

}
