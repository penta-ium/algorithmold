package com.algo.heap;

import java.util.Arrays;

/**
 * 最大堆
 */
public class BSBigHeap {

    /**
     * 上浮最后一个元素
     *
     * @param array  数组
     */
    @Deprecated
    public void upAdjust(int[] array) {
        int childIdx  = array.length - 1;
        int parentIdx = (childIdx - 1) / 2;

        while (childIdx > 0) {
            int childValue  = array[childIdx];
            int parentValue = array[parentIdx];

            if (childValue > parentValue) {
                //swap
                int temp = array[childIdx];
                array[childIdx] = array[parentIdx];
                array[parentIdx] = temp;
            }

            childIdx  = parentIdx;
            parentIdx = (childIdx - 1 )/ 2;
        }
    }

    /**
     * 上浮堆中最后一个元素（并一定是数组最后一个元素，需要指堆大小）
     * 用作动态往堆里插入元素
     * @param array
     * @param heapSize
     */
    public void upAdjust(int[] array, int heapSize) {
        int childIdx  = heapSize - 1;
        int parentIdx = (childIdx - 1) / 2;

        while (childIdx > 0) {
            int childValue  = array[childIdx];
            int parentValue = array[parentIdx];

            if (childValue > parentValue) {
                //swap
                int temp = array[childIdx];
                array[childIdx] = array[parentIdx];
                array[parentIdx] = temp;
            }

            childIdx  = parentIdx;
            parentIdx = (childIdx - 1 )/ 2;
        }
    }

    /**
     * 下沉指定元素
     * @param array 数组
     * @param downIdx  下成节点的下标
     * @param heapSize 堆大小
     */
    public void downAdjust(int[] array, int downIdx, int heapSize) {
        int childIdx  = downIdx * 2 + 1;

        while (childIdx < heapSize) {

            if (childIdx + 1 < heapSize && array[childIdx] < array[childIdx + 1]) {
                childIdx += 1;
            }

            if (array[downIdx] < array[childIdx]) {
                //swap
                int temp = array[childIdx];
                array[childIdx] = array[downIdx];
                array[downIdx] = temp;
            }
            downIdx = childIdx;
            childIdx = 2 * downIdx + 1;
        }
    }

    /**
     * 根据已有数组，构建最大堆
     * @param array
     */
    public void buildHeap(int[] array) {

        int buildIdx = (array.length - 1) / 2;

        for (; buildIdx > 0; buildIdx--) {
            downAdjust(array, buildIdx - 1, array.length);
        }
    }

    public static void main1(String[] args) {
        int[] array = new int[]{2, 4, 6, 1, 9, 5, 8, 3, 7};

        //构建
        BSBigHeap bsHeap = new BSBigHeap();
        bsHeap.buildHeap(array);
        System.out.println("排序前");
        System.out.println(Arrays.toString(array));
        System.out.println("--------排序过程--------");

        //排序
        int heapSize = array.length;

        while (heapSize > 1) {
            //swap first and last
            int temp = array[0];
            array[0] = array[heapSize - 1];
            array[heapSize - 1] = temp;

            bsHeap.downAdjust(array, 0, heapSize - 1);
            heapSize -= 1;
            System.out.println(Arrays.toString(array));
        }
        System.out.println("--------排序过程--------");
        System.out.println("排序后");
        System.out.println(Arrays.toString(array));

    }
    public static void main(String[] args) {
        int[] array = new int[10];
        //{2, 4, 6, 1, 9, 5, 8, 3, 7};

        //构建
        BSBigHeap bsHeap = new BSBigHeap();
        //bsHeap.buildHeap(array);
        array[0] = 2;
        array[1] = 4;
        bsHeap.upAdjust(array, 2);
        array[2] = 6;
        bsHeap.upAdjust(array, 3);
        array[3] = 1;
        bsHeap.upAdjust(array, 4);
        array[4] = 9;
        bsHeap.upAdjust(array, 5);
        array[5] = 5;
        bsHeap.upAdjust(array, 6);
        array[6] = 8;
        bsHeap.upAdjust(array, 7);
        array[7] = 3;
        bsHeap.upAdjust(array, 8);
        array[8] = 7;
        bsHeap.upAdjust(array, 9);
        array[9] = 0;
        bsHeap.upAdjust(array, 0);

        System.out.println(Arrays.toString(array));

    }
}
