package com.algo.backtracking.maxproduct;

import com.google.common.primitives.Ints;

public class MaxProductSolution {

    public int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int len = nums.length;
        int result = nums[0];
        int[] max = new int[len];
        int[] min = new int[len];
        min[0] = nums[0];
        max[0] = nums[0];

        for (int i = 1; i < len; ++i) {
            if (nums[i] >= 0) {
                max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(min[i - 1] * nums[i], nums[i]);
            } else {
                max[i] = Math.max(min[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(max[i - 1] * nums[i], nums[i]);
            }

            //result = Math.max(result, max[i]);
        }
        //print(max);
        //print(min);

        return result;
    }

    public int maxProduct2(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int[] plusMax = new int[nums.length];
        int[] minusMin = new int[nums.length];

        plusMax[0] = nums[0];
        minusMin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            plusMax[i] = Math.max(Math.max(plusMax[i - 1] * nums[i], minusMin[i - 1] * nums[i]), nums[i]);
            minusMin[i] = Math.min(Math.min(plusMax[i - 1] * nums[i], minusMin[i - 1] * nums[i]), nums[i]);
            //max = Math.max(Math.max(plusMax[i], minusMin[i]), max);
        }
        //print(plusMax);
        //print(minusMin);
        return max;
    }

    public void maxProduct3(Integer[] nums) {
        Integer[] max = new Integer[nums.length];
        Integer[] min = new Integer[nums.length];

        max[0] = nums[0];
        min[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];

/*            if (max[i - 1] * value > max[i - 1])
                max[i] = max[i - 1] * value;*/
            //max[i - 1] * value;
            //max[i] = Math.max(max[i - 1] * value, max[i - 1]);
            //max[i] = Math.max(max[i - 1] * value, max[i - 1]);
            //min[i] = min[i - 1] * value;
            //max[i] = Math.max(max[i - 1], product[i]);
            int a = max[i - 1] * value;
            int b = min[i - 1] * value;
            int c = value;
            max[i] = Ints.max(a, b, c);
            System.out.println(String.format("a:%d b:%d c:%d", a, b, c));

            int l = min[i - 1] * value;
            int m = max[i - 1] * value;
            int n = value;
            min[i] = Ints.min(l, m, n);
            System.out.println(String.format("l:%d m:%d n:%d", l, m, n));
        }

        //print(Ints.toByteArray(5));
        print(nums);
        print(max);
        print(min);
        //System.out.println(Ints.max(nums));
        //System.out.println(Ints.min(nums));
    }

    public int maxProduct4(Integer[] nums) {

        if (nums.length == 0)
            return 0;


        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = nums[0];
        min[0] = nums[0];

        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int v = nums[i];

            if (v >= 0) {
                max[i] = Ints.max(max[i-1] * v, v);
                min[i] = Ints.min(min[i-1] * v, v);
            } else {
                max[i] = Ints.min(max[i-1] * v, v);
                min[i] = Ints.max(min[i-1] * v, v);
            }
            res = Ints.max(res, max[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        //Integer[] nums = new Integer[]{-1, 2, -3, 4, -5, 6, -7};
        Integer[] nums = new Integer[]{2, 3, -4, 3};
        //System.out.println(new MaxProductSolution().maxProduct3(nums));
        System.out.println(new MaxProductSolution().maxProduct4(nums));
    }

    static void print(byte[]  bytes) {
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i] + " ");
        }
        System.out.println();
    }

    static void print(Number[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
