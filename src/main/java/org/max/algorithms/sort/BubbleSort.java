package org.max.algorithms.sort;

import java.time.Duration;
import java.time.Instant;

@SuppressWarnings("unused")
public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = DataUtil.generateRandomArray(9, 999);
		int[] arr1 = DataUtil.copyArray(arr);
		int[] arr2 = DataUtil.copyArray(arr);
		DataUtil.printArray(arr);
		Instant start = Instant.now();
		bubbleSort1(arr);
		Instant end = Instant.now();
		Duration between = Duration.between(start, end);
		System.out.println(between.getNano());
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
	
	public static void bubbleSort1(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i - 1; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}
	
	public static void bubbleSort2(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 0 ~ N-1
		// 0 ~ N-2
		// 0 ~ N-3
		for (int e = arr.length - 1; e > 0; e--) { // 0 ~ e
			for (int i = 0; i < e; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}


	public static void bubbleSort3(int[] arr) {
		
	}
	
	// 交换arr的i和j位置上的值
	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
}
