package com.example.imagebitmaptest.sf;

public  class Test1 {

    public static void  main(String [] args){

        int[] a = {1,2,3,4,5};

      int c =   binarySearch(a,5);

      System.out.println("c=="+c);
    }


    public static  int binarySearch(int[] nums, int target) {
        // 左右都闭合的区间 [l, r]
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            if (nums[mid] > target)
                // 搜索区间变为 [left, mid - 1]
                right = mid - 1;
        }
        return -1;
    }


}
