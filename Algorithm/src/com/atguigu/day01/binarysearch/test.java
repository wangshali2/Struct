package com.atguigu.day01.binarysearch;

/**
 * @Author wsl
 * @Date 2022-06-13-10:10
 * @Description  递归实现
 */
public class test {
    public static void main(String[] args) {
        int[] a = {1, 3, 8, 10, 11, 67, 100};
        int target = 11;
        System.out.println(search(a,target,0,a.length-1));;
    }


    private static int search(int[] arr, int m, int low, int high) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (arr[mid] == m) {
            return mid;
        } else if (arr[mid] > m) {
            return search(arr, m, low, mid - 1);
        } else if (arr[mid] < m) {
            return search(arr, m, low+1, high);
        }
        return -1;
    }


}
