package util;

public class Int2AnyType {
	
	public static void int2String() {
		int src = 123;
		String dest = Integer.toString(src);
		System.out.println(dest);
	}
	
	public static void int2CharArray() {
		int src = 123;
		char dest[] = String.valueOf(src).toCharArray();
		System.out.println(dest);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int2String();
		int2CharArray();
	}

}
