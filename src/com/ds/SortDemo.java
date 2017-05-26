package com.ds;

import com.utils.ArrayUtils;


/**
 * Created by jiping_zhou on 2016/11/9.
 *
 */
public class SortDemo {
    /**
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     */
    public void bubbleSort(int[] numbers) {
        System.out.println("=================start bubbleSort ====================");
        if (numbers == null || numbers.length < 2) return;

        for (int i = 0; i < numbers.length; i++) {
            boolean is_swap = false;
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    is_swap = true;
                }
            }
            ArrayUtils.printlnArray(numbers);
            if (!is_swap) break;
        }
    }

    /**
     * 选出最小的一个数与第一个位置的数交换；
     * 然后在剩下的数当中再找最小的与第二个位置的数交换
     *
     * @param numbers
     */
    public void selectSort(int[] numbers) {
        System.out.println("=================start selectSort ====================");
        if (numbers == null || numbers.length < 2) return;

        for (int i = 0; i < numbers.length; i++) {
            int min = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < min) {
                    min = numbers[j];
                    numbers[j] = numbers[i];
                }
            }
            numbers[i] = min;
            ArrayUtils.printlnArray(numbers);
        }
    }

    /**
     * 每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置
     * （从后向前找到合适位置后），直到全部插入排序完为止
     *
     * @param numbers:
     */
    public void insertSort(int[] numbers) {
        System.out.println("=================start insertSort ====================");
        if (numbers == null || numbers.length < 2) return;

        for (int i = 1; i < numbers.length; i++) {
            int currentValue = numbers[i];
            int insertPosition = i;
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j] > currentValue) {
                    numbers[j + 1] = numbers[j];
                    insertPosition--;
                }
            }
            numbers[insertPosition] = currentValue;
            ArrayUtils.printlnArray(numbers);
        }
    }

    /**
     * 每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置
     * （从后向前找到合适位置后），直到全部插入排序完为止
     *
     * @param numbers:
     */
    public void insertSortV2(int[] numbers) {
        System.out.println("=================start insertSort ====================");
        if (numbers == null || numbers.length < 2) return;

        for (int i = 1; i < numbers.length; i++) {
            int currentValue = numbers[i];
            int insertPosition = i;
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j] > currentValue) {
                    insertPosition = j;
                }
            }

            for(int j = i; j > insertPosition; j--){
                numbers[j] = numbers[j - 1];
            }

            numbers[insertPosition] = currentValue;
            ArrayUtils.printlnArray(numbers);
        }
    }

    /**
     *
     * @param numbers
     */
    public void shellSort(int[] numbers){
        System.out.println("=================start shellSort ====================");
        if (numbers == null) return;
        for (int increment = numbers.length/2; increment > 0; increment /= 2 ){
            for (int i = increment; i < numbers.length; i++) {
                for(int j = i; j >= increment; j -=increment){
                    if (numbers[j] < numbers[j - increment]){
                        int temp = numbers[j];
                        numbers[j] = numbers[j - increment];
                        numbers[j-increment] = temp;
                    }else{
                        break;
                    }
                    ArrayUtils.printlnArray(numbers);
                }
            }
        }
    }

    /**
     *  将两个（或两个以上）有序表合并成一个新的有序表
     *  即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
     *  时间复杂度为O(nlogn)
     *  空间复杂度O(n)
     * @param numbers
     * @param low
     * @param high
     */
    public void mergeSort(int[] numbers, int low, int high){
//        System.out.println("=================start shellSort ====================");
        if (high <= low) return;

        int middle = (low + high)/2;
        mergeSort(numbers, 0, middle);
        mergeSort(numbers, middle + 1, high);
        merge(numbers, low, middle, high);
    }

    /**
     *
     * @param numbers
     * @param low
     * @param middle
     * @param high
     */
    public void merge(int[] numbers, int low, int middle, int high){
        if (high <= low) return;
        int[] mergeArray = new int[high - low + 1];
        int i = low;
        int j = middle + 1;
        int k = 0;

        while(i <= middle && j <= high){
            if (numbers[i] < numbers[j]){
                mergeArray[k++] = numbers[i++];
            }else{
                mergeArray[k++] = numbers[j++];
            }
        }

        while(i <= middle){
            mergeArray[k++] = numbers[i++];
        }

        while(j <= high){
            mergeArray[k++] = numbers[j++];
        }

        for(int m=0; m < mergeArray.length; m++){
            numbers[m+low] = mergeArray[m];
        }
    }

    /**
     *
     * @param numbers
     */
    public void quickSort(int[] numbers){
        if (numbers == null) return;
        quick(numbers, 0, numbers.length - 1);
    }

    public void quick(int[] numbers, int low, int high){
        if (high > low){
            int pivot = getPivot(numbers, low, high);
            quick(numbers, low, pivot);
            quick(numbers, pivot + 1, high);
        }
    }

    public int getPivot(int[] numbers, int low, int high){
        int temp = numbers[low];
        while ( high > low){
            while (high > low && numbers[high] >= temp){
                high--;
            }
            numbers[low] = numbers[high];
            System.out.printf("low=%d, high=%d\t", low, high);
            ArrayUtils.printlnArray(numbers);
            while(high > low && numbers[low] <= temp){
                low++;
            }
            numbers[high] = numbers[low];
            System.out.printf("low=%d, high=%d\t", low, high);
            ArrayUtils.printlnArray(numbers);
        }
        numbers[low] = temp;
        System.out.printf("low=%s\n", low);
        return low;
    }

    public static void runBubbleSort(){
        SortDemo sort = new SortDemo();
        int[] numbers = ArrayUtils.getRandomArray(10);
        System.out.println("=================before bubbleSort ====================");
        ArrayUtils.printlnArray(numbers);
        sort.bubbleSort(numbers);
        System.out.println("=================after bubbleSort ====================");
        ArrayUtils.printlnArray(numbers);
    }

    public static void runSelectSort(){
        SortDemo sort = new SortDemo();
        int[] numbers = ArrayUtils.getRandomArray(10);
        System.out.println("=================before selectSort ====================");
        ArrayUtils.printlnArray(numbers);
        sort.selectSort(numbers);
        System.out.println("=================after selectSort ====================");
        ArrayUtils.printlnArray(numbers);
    }

    public static void runInsertSort(){
        SortDemo sort = new SortDemo();
        int[] numbers = ArrayUtils.getRandomArray(10);
        System.out.println("=================before insertSort ====================");
        ArrayUtils.printlnArray(numbers);
        sort.insertSortV2(numbers);
        System.out.println("=================after insertSort ====================");
        ArrayUtils.printlnArray(numbers);
    }

    public static void runInsertSortV2(){

    }

    public static void runShellSort(){
        SortDemo sort = new SortDemo();
        int[] numbers = ArrayUtils.getRandomArray(10);
        System.out.println("=================before shellSort ====================");
        ArrayUtils.printlnArray(numbers);
        sort.shellSort(numbers);
        System.out.println("=================after shellSort ====================");
        ArrayUtils.printlnArray(numbers);
    }

    public static void runMergeSort(){
        SortDemo sort = new SortDemo();
        int[] numbers = ArrayUtils.getRandomArray(10);
        System.out.println("=================before mergeSort ====================");
        ArrayUtils.printlnArray(numbers);
        sort.mergeSort(numbers, 0, numbers.length - 1);
        System.out.println("=================after mergeSort ====================");
        ArrayUtils.printlnArray(numbers);

    }

    public static void runQuickSort(){
        SortDemo sort = new SortDemo();
        int[] numbers = ArrayUtils.getRandomArray(10);
//        numbers = new int[]{6, 8, 7, 6, 5, 1, 3, 2};
        System.out.println("=================before quickSort ====================");
        ArrayUtils.printlnArray(numbers);
        sort.getPivot(numbers, 0, numbers.length - 1);
//        sort.quickSort(numbers);
//        sort.merge(numbers, 0, 2, numbers.length - 1);
        System.out.println("=================after quickSort ====================");
        ArrayUtils.printlnArray(numbers);
    }

    public static void runHeapSort(){

    }

    public static void main(String args[]) {
//        runBubbleSort();
//        runInsertSort();
//        runInsertSortV2();
//        runMergeSort();
//        runQuickSort();
//        runShellSort();
//        runSelectSort();
        runHeapSort();
    }
}
