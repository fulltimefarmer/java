package org.max.algorithms.sort;

/**
 * @description:
 * @author: Max Zhou
 * @create: 2020-09-25 14-23
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = DataUtil.generateRandomArray(30, 99);
        DataUtil.printArray(arr);
        mergeSort(arr);
        DataUtil.printArray(arr);
    }

    public static void mergeSort(int[] arr) {
        if(null == arr || arr.length < 2){
            return;
        }
        process(arr, 0, arr.length-1);
    }

    public static void process(int[] arr, int left, int right) {
        // base case
        if(arr[left] == arr[right]){
            return;
        }
        int middle = left + ((right - left) >> 1);
        process(arr, left, middle);
        process(arr,middle + 1, right);
        merge(arr, left, middle, right);
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = middle + 1;
        while (p1 <= middle && p2 <= right) {
            temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= middle) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[i++] = arr[p2++];
        }
        for(i = 0; i < temp.length; i++){
            arr[left + i] = temp[i];
        }
    }

}
