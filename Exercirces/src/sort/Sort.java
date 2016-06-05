package sort;

import java.util.Date;


public class Sort {
	int length = 10;
	int[] test = new int[length];
	int[] copy = new int[length];
	
	
	public int[] moveZeros(int[] in){
		int tmp = 0;
		for (int i = 1; i < in.length; i++){
			if (in[i] == 0 && i != 0){
					for (int j = i; j > 0;j--){
						in[j]=in[j-1];
					}
			in[tmp++]=0;
			}
		}
		return in;
	}
	
	public void insertionSort(int[] test){
		int tmp = -1;
		for (int i = 0; i < test.length; i++){
			for (int j = i+1; j < test.length; j++ ){
				if (i < test.length-1 && j < test.length-1 ){
					if (test[i] > test[j]){
						tmp = test[j];
						test[j] = test [i];
						test[i] = tmp;
					}
				}
			}
		}
	}
	
	public void merge(int[] a, int start, int mid, int end){
		int[] temp = new int[end - start + 1];
		int i1 = start;
		int i2 = mid+1;
		int i3 = 0;
		//prendo i piccoli elementi tra i due sotto array per primo
		for ( ; (i1 <= mid) && (i2 <= end); i3++){
			if (a[i1] < a[i2]){
				temp[i3] = a[i1++];
			}else{
				temp[i3] = a[i2++];
			}		
			System.out.println(i1+","+i2);
		}
		System.out.println("Inizia il secondo ciclo for");
		//continuo a prendere i restanti elementi del primo sotto array
		for(; i1 <= mid; i1++)
			temp[i3++] = a[i1];
		
		System.out.println("Inizia il terzo ciclo for");
		//continuo a prendere i restanti elementi del secondo sotto array
		for(; i2 <= end; i2++)
					temp[i3++] = a[i2];
		
		//travaso da temp all'originale
		for(int j = 0; j<= end; j++)
			a[j] = temp [j];
		
	}
	
	
	public void mergesort(int[] test, int start, int end){
			int mid = (int)Math.abs(((end - start)/2));
			System.out.println("mid: " + mid);
			if (start < end){
					mergesort(test, start, mid);
					mergesort(test, mid+1, end);
					merge(test,start, mid, end);
			}
					
			
	}
	
	public int sumPairNumbers(int max){
		int sum = 0;
		for(int num=0; num <= max; num++){
			if ((num%2) ==0)
			sum+=num;
		}
		return sum;
	}
	
	public static void main (String[] args){
		Date start;
		Date end;
		long duration;
		
		Sort s = new Sort();
		s.test = ArrayUtil.randomPopulate(s.length);
		System.out.println("First test Array");
		ArrayUtil.print(s.test);
		
		s.copy = ArrayUtil.duplicateArray(s.test);
		
		System.out.println("Copy Array");
		ArrayUtil.print(s.copy);
		
		start = new Date();
		s.insertionSort(s.copy);
		end = new Date();
		duration = end.getTime() - start.getTime();
		System.out.println("Duration insertion sort: "+ duration + "ms" );
		ArrayUtil.print(s.copy);
		System.out.println("Array after insertion sort");
		
		System.out.println("**********************************");
		s.copy = ArrayUtil.duplicateArray(s.test);
		System.out.println("Copy Array");
		ArrayUtil.print(s.copy);
		start = new Date();
		//s.mergesort(s.copy,0,s.copy.length-1);
		end = new Date();
		duration = end.getTime() - start.getTime();
		System.out.println("Array after merge sort");
		ArrayUtil.print(s.copy);
		System.out.println("Duration merge sort: "+ duration + "ms" );
		int[] in = {1,0,1,2,0,3,2,5,0};
		ArrayUtil.print(in);
		System.out.println(s.moveZeros(in));
		ArrayUtil.print(in);
		System.out.println("sum dei numeri pari minori di 10: " + s.sumPairNumbers(10));
	}
	
}
