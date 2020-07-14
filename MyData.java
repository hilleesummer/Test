package dao;

public class MyData implements Comparable<MyData>{
	String f1;
	String f2;
	String f3;
	
	MyData(String f1, String f2, String f3){
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
	}
	
	@Override
	public int compareTo(MyData arg0) {
		// TODO Auto-generated method stub
		return this.f1.compareTo(arg0.f1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}