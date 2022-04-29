package chapter03;

public class ArrayUtil {

	public static double[] IntToDouble(int[] a) {
		double[] result = new double[a.length];
		for(int i = 0; i < a.length; i++) {
			result[i] = a[i];
		}
		return result;
	}

}
