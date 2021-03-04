package org.max.algorithms.sort;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = DataUtil.generateRandomArray(30, 99);
		
		DataUtil.printArray(arr);
		selectionSort(arr);
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
	
	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 0 ~ N-1
		// 1~n-1
		// 2
		for (int i = 0; i < arr.length - 1; i++) { // i ~ N-1
			// 最小值在哪个位置上  i～n-1
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) { // i ~ N-1 上找最小值的下标 
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			}
			swap(arr, i, minIndex);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
