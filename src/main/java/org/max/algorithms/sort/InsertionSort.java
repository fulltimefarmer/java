package org.max.algorithms.sort;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = DataUtil.generateRandomArray(30, 99);
		
		DataUtil.printArray(arr);
		insertionSort(arr);
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

	public static void insertionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 0~0 有序的
		// 0~i 想有序
		for (int i = 1; i < arr.length; i++) { // 0 ~ i 做到有序
			for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				swap(arr, j, j + 1);
			}
		}
	}

	// i和j是一个位置的话，会出错
	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
	
}
