package com.company;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] data = {1,2};
        for(int i = 0;i < nums.length;i++) {
            for(int j = i+1;j<nums.length;j++) {
                if(nums[i]+nums[j] == target && i < j)
                {
                    data[0] = i;
                    data[1] = j;
                }
            }
        }
        return data;
}
}
class  Main {
    public static void main(String args[]) {
        Solution sol1 = new Solution();
        int[] data = {3,3};
        int[] op = sol1.twoSum(data,6);
        for(int x: op) {
            System.out.println(x);
        }
    }

}
