package util;

public class Double2AnyType {
	
	public static void double2String() {
		double src = 10.1;
		String dest = String.valueOf(src);
		System.out.println(dest);
	}
	
	// ����
	public static void double2Int() {
		double src = 10.9;
		int dest = (int)src;
		System.out.println(dest);
	}
	
	// n�ڸ� �ݿø�
	public static void doubleRoundUp() {
		double src = 3.14159265358979;
		double dest = Math.round(src);
		System.out.println(dest);
		
		// �Ҽ� ��°�ڸ� �ݿø� - �����Ϸ��� ���ؼ� int�� ĳ�����ϰ� ����
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
