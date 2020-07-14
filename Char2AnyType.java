package util;

public class Char2AnyType {
	
	public static void charArray2Int() {
		char[] src = { '1', '2', '3'};
		int dest = Integer.parseInt(String.valueOf(src));
		System.out.println(dest);
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		charArray2Int();
	}

}
