package dao;

import java.util.*;

public class MyOperation {
	String delimiter = "#";
	List<MyData> list;
	HashMap<String, Integer> map;
	
	public MyOperation() {
		list = new ArrayList<MyData>();
		map = new HashMap<String, Integer>();
	}
	
	// ���ڵ� �ļ�
	private String[] parseRecord(String record) {
		String[] f = record.split(delimiter);
		for( int i = 0; i < f.length; i++) {
			System.out.print(f[i] + " ");
		}
		System.out.println("");
		return f;
	}
	
	// list�� �Ľ̵� ���ڵ� �߰�
	public void addToList(String record) {
		String[] f = parseRecord(record);
		MyData data = new MyData(f[0], f[1], f[2]);
		list.add(data);
	}
	
	// ù��° �ʵ�� ����
	public void sortList() {
		Collections.sort(list);
		for( MyData datas : list) {
			System.out.println(datas.f1);
		}
	}
	
	// �ι�° �ʵ�� ���� ( comparator�� �̿��ؼ� )
	public void sortListByComparator() {
		Collections.sort(list, new Comparator<MyData>() {

			@Override
			public int compare(MyData arg0, MyData arg1) {
				// TODO Auto-generated method stub
				return arg0.f2.compareTo(arg1.f2);
			}
			
		});
	}
	
	// list�� �����͸� ������ hashmap ����
	public void updateHashMap() {
		for( MyData datas : list) {
			String key = datas.f2;
			int value = 0;
			if( map.containsKey(key)) {
				value = map.get(key) + 1;
			}else {
				value = 1;
			}
			map.put(key,  value);
			System.out.println("key = " + key + ", value =" + value);
		}
	}
	
	
}
