import java.util.*;

public class MyOperation {
	String delimiter = "#";
	
	public MyOperation() {

	}
	
	// 레코드 파서
	private String[] parseRecord(String pRecord) {
		String[] f = pRecord.split(delimiter);
//		for( int i = 0; i < f.length; i++) {
//			System.out.print(f[i] + " ");
//		}
//		System.out.println("");
		return f;
	}
	
	// list에 파싱된 레코드 추가
	public List<MyData> parseList(List<String> pList) {
		MyUtil.printMethodNm( new Exception().getStackTrace()[0].getMethodName());
		
		List<MyData> rList = new ArrayList<MyData>();
		for( int i = 0; i < pList.size(); i++ ) {
			String record = pList.get(i);
			String[] f = parseRecord(record);
			if( f.length >= 3) {
				MyData data = new MyData(f[0], f[1], f[2]);
				rList.add( data );
			}
		}
		
		return rList;
	}
	
	public List<MyData> copyLists(List<MyData> src){
		MyUtil.printMethodNm( new Exception().getStackTrace()[0].getMethodName());
		List<MyData> dest = null;
		dest = MyUtil.copyList2List( src, dest );
		return dest;
	}
	
	// 첫번째 필드로 정렬
	public List<MyData> sortList(List<MyData> pList) {
		Collections.sort(pList);
		for( MyData data : pList) {
			System.out.println(data.f1);
		}
		
		return pList;
	}
	
	// 두번째 필드로 정렬 ( comparator를 이용해서 )
	public List<MyData> sortListByComparator(List<MyData> pList) {
		MyUtil.printMethodNm( new Exception().getStackTrace()[0].getMethodName());
		
		Collections.sort(pList, new Comparator<MyData>() {

			@Override
			public int compare(MyData arg0, MyData arg1) {
				// TODO Auto-generated method stub
				return arg0.f2.compareTo(arg1.f2);
			}
			
		});
		
		return pList;
	}
	
	// list의 데이터를 가지고 hashmap 구성
	public HashMap<String, Integer> updateHashMap(List<MyData> pList) {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for( MyData data : pList) {
			String key = data.f2;
			int value = 0;
			if( map.containsKey(key)) {
				value = map.get(key) + 1;
			}else {
				value = 1;
			}
			map.put(key,  value);
			System.out.println("key = " + key + ", value =" + value);
		}
		
		return map;
	}
	
	public List<String> process( List<MyData> pList){
		List<String> rList = new ArrayList<String>();
		
		for(int i = 0; i < pList.size(); i++ ) {
			String str = pList.get(i).f1;
			rList.add( str );
		}
		
		return rList;
	}
	
	public void printList(List<MyData> pList) {
		for( MyData data : pList ) {
			System.out.print( data.f1 + " ");
			System.out.print( data.f2 + " ");
			System.out.print( data.f3 + " ");
			System.out.println("");
		}
	}
	
}
