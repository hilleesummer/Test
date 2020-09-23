import java.util.*;

public class MyUtil {
	public static <T> List<T> copyList2List(List<T> src, List<T> dest){
		if( dest == null ) dest = new ArrayList<T>();
		dest.addAll( src );
		return dest;
	}
	
	public static void printMethodNm(String parm){
		System.out.println("[Method Name] >" + parm);
	}
}
