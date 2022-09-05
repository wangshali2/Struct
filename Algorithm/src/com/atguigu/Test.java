package com.atguigu;

import java.util.Arrays;
import java.util.HashSet;

public class Test {

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        System.out.println(test(num));
        System.out.println(test2(num));

    }

    public static boolean test(int[] num) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <= num.length - 1; i++) {
            boolean exist = set.contains(num[i]);
            if (exist) {
              return  true;
            } else {
                set.add(num[i]);
            }
        }

      return false;
    }

    public static boolean test2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
