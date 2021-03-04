package org.max.algorithms.sort;


public class ShellSort {

	public static void main(String[] args) {
		int[] arr = DataUtil.generateRandomArray(30, 99);

		DataUtil.printArray(arr);
		shellSort(arr);
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

	public static void shellSort(int[] arr) {
		int h = 1;
		while(h <= arr.length /3 ) {
			h = h*3 + 1;
		}
		for(int gap = h; gap > 0; gap = (gap-1)/3) {
			for(int i=gap; i<arr.length; i++) {
				for(int j=i; j>gap-1; j-=gap) {
					if(arr[j] < arr[j-gap]) {
						swap(arr, j, j-gap);
					}
				}
			}
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
