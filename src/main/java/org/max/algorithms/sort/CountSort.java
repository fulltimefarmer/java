package org.max.algorithms.sort;

import java.util.Arrays;

public class CountSort {

	public static void main(String[] args) {
		int[] arr = DataUtil.generateRandomArray(30, 99);

		DataUtil.printArray(arr);
		countSort(arr);
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

	public static int[] countSort(int[] arr) {
		int[] result = new int[arr.length];
		int[] count = new int[10];
		for(int i=0; i<arr.length; i++) {
			count[arr[i]]++;
		}
		System.out.println(Arrays.toString(count));
//		for(int i=0, j=0; i<count.length; i++) {
//			while(count[i]-- > 0) result[j++] = i;
//		}
		for(int i=1; i<count.length; i++) {
			count[i] = count[i] + count[i-1];
		}
		System.out.println(Arrays.toString(count));
		for(int i=arr.length-1;i>=0; i--) {
			result[--count[arr[i]]] = arr[i];
		}
		return result;
	}

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
