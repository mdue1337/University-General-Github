import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1, nums2);
        int total = nums1.length + nums2.length;

        return (total % 2 == 1)
                ? merged[total / 2]
                : (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
    }

    private int[] merge(int[] nums1, int [] nums2){
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = new int[n+m];
        int i = 0, l = 0, r = 0;

        while (l < n && r < m) {
            if (nums1[l] <= nums2[r]) {
                merged[i++] = nums1[l++];
            } else {
                merged[i++] = nums2[r++];
            }
        }

        // Copy remaining elements
        while (l < n) merged[i++] = nums1[l++];
        while (r < m) merged[i++] = nums2[r++];

        return merged;
    }
}