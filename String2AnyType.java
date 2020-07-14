package util;

public class String2AnyType {
	
	public static void string2Int() {
		String src = "123";
		int dest = Integer.parseInt(src);
		System.out.println(dest);
	}
	
	public static void string2Double() {
		String src = "10.1";
		double dest = Double.valueOf(src);
		System.out.println(dest);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		string2Int();
		string2Double();
	}

}
