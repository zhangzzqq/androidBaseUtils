package com.example.imagebitmaptest.sf;

public class Test2 {

    public static void main(String [] args){
        int[] a = {1,2,3,4,5};

        int c =   binarySearchLeft(a,5);
        System.out.println("c=="+c);

    }

    public static int binarySearchLeft(int[] nums, int target) {
        // 搜索区间为 [left, right]
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            }
            if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            }
            if (nums[mid] == target) {
                // 收缩右边界
                right = mid - 1;
            }
        }
        // 检查是否越界
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }


}
