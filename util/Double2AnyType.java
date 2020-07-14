package util;

public class Double2AnyType {
	
	public static void double2String() {
		double src = 10.1;
		String dest = String.valueOf(src);
		System.out.println(dest);
	}
	
	// 버림
	public static void double2Int() {
		double src = 10.9;
		int dest = (int)src;
		System.out.println(dest);
	}
	
	// n자리 반올림
	public static void doubleRoundUp() {
		double src = 3.14159265358979;
		double dest = Math.round(src);
		System.out.println(dest);
		
		// 소수 넷째자리 반올림 - 버림하려면 곱해서 int로 캐스팅하고 나눠
		dest = Math.round(src*1000)/1000.0;
		System.out.println(dest);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double2String();
		double2Int();
		doubleRoundUp();
	}

}
