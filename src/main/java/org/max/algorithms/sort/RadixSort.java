package org.max.algorithms.sort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr = DataUtil.generateRandomArray(30, 99);

		DataUtil.printArray(arr);
		radixSort(arr);
		DataUtil.printArray(arr);

		//对数器
//        int testTime = 500000;
//        int maxSize = 100;
//        int maxValue = 100;
//        boolean succeed = true;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = DataUtil.generateRandomArray(maxSize, maxValue);
//            int[] arr2 = DataUtil.copyArray(arr1);
//            heapSort(arr1);
//            DataUtil.comparator(arr2);
//            if (!DataUtil.isEqual(arr1, arr2)) {
//                succeed = false;
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}
	
	public static int[] radixSort(int[] arr) {
		int[] result = new int[arr.length];
		int[] count = new int[10];
		for(int i=0; i<3; i++) {
			int division = (int)Math.pow(10, i);
			System.out.println(division);
			for(int j=0; j<arr.length; j++) {
				int num = arr[j]/division % 10;
				System.out.print(num + " ");
				count[num]++; 
			}
			System.out.println();
			System.out.println(Arrays.toString(count));
			for(int m=1; m<count.length; m++) {
				count[m] = count[m] + count[m-1];
			}
			System.out.println(Arrays.toString(count));
			for(int n=arr.length-1;n>=0; n--) {
				int num = arr[n]/division % 10;
				result[--count[num]] = arr[n];
			}
			System.arraycopy(result, 0, arr, 0, arr.length);
			Arrays.fill(count, 0);

		}
		return result;
	}
	
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
