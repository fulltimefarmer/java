package org.max.algorithms.structure;

public class ArrayUtil {

	public static boolean exist(int[] sortedArr, int num) {
		if (sortedArr == null || sortedArr.length == 0) {
			return false;
		}
		int L = 0;
		int R = sortedArr.length - 1;
		int mid = 0;
		// L..R
		while (L < R) {
			// mid = (L+R) / 2;
			// L 10亿 R 18亿
			// mid = L + (R - L) / 2
			// N / 2 N >> 1
			mid = L + ((R - L) >> 1); // mid = (L + R) / 2
			if (sortedArr[mid] == num) {
				return true;
			} else if (sortedArr[mid] > num) {
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return sortedArr[L] == num;
	}

	public static int getLessIndex(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1; // no exist
		}
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (arr[mid] > arr[mid - 1]) {
				right = mid - 1;
			} else if (arr[mid] > arr[mid + 1]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return left;
	}
	
	// 在arr上，找满足>=value的最左位置
	public static int nearestLeftIndex(int[] arr, int value) {
		int L = 0;
		int R = arr.length - 1;
		int index = -1; // 记录最左的对号
		while (L <= R) {
			int mid = L + ((R - L) >> 1);
			if (arr[mid] >= value) {
				index = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return index;
	}

	// 在arr上，找满足<=value的最右位置
	public static int nearestRightIndex(int[] arr, int value) {
		int L = 0;
		int R = arr.length - 1;
		int index = -1; // 记录最右的对号
		while (L <= R) {
			int mid = L + ((R - L) >> 1);
			if (arr[mid] <= value) {
				index = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		return index;
	}
	
	public static int getMax(int[] arr) {
		return process(arr, 0, arr.length - 1);
	}

	// arr[L..R]范围上求最大值  L ... R   N
	public static int process(int[] arr, int L, int R) {
		if (L == R) { // arr[L..R]范围上只有一个数，直接返回，base case
			return arr[L];
		}
		int mid = L + ((R - L) >> 1); // 中点   	1
		int leftMax = process(arr, L, mid);
		int rightMax = process(arr, mid + 1, R);
		return Math.max(leftMax, rightMax);
	}
	
}
