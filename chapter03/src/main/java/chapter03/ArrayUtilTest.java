package chapter03;

import java.util.Arrays;

public class ArrayUtilTest {

	public static void main(String[] args) {
		
		double[] d1 = ArrayUtil.IntToDouble(new int[]{10,20,30,40});
		//for(double d : d1) {
		//	System.out.print(d + " ");
		//}
		System.out.println(Arrays.toString(d1));
		
		//int[] a1 = ArrayUtil.IntToDouble(new double[]{10.1,20.2,30.3,40.4});
		//int[] a2 = ArrayUtill.concat(new int[] {1,2,3}, new int[] {4,5,6})
	}

}
