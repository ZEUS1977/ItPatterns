package sort;

public class ArrayUtil {
	
	public static int[] randomPopulate(int length){
		int[] res = new int[length];
		for (int i = 0; i < length; i++) {
			res[i] = 1 + (int)(Math.random() * 100);
		}
		return res;
	}
	
	public static void print(int[] test){
		for(int i = 0; i < test.length; i++) {
			System.out.print(test[i] + "," );
		}
		System.out.println();
	}
	
	public static int[] duplicateArray(int[] test){
		int[] copy = new int[test.length];
		for (int i = 0; i < test.length; i ++)
			copy[i] = test[i]; 
		return copy;
	}
	
}
