using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCode75
{
    public class TwoPointer
    {
        public static void MoveZeroes(int[] nums)
        {
            int slow = 0;

            for (int fast = 0; fast < nums.Length; fast++)
            {
                if (nums[fast] != 0)
                {
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;

                    slow++;
                }
            }
        }

        public static bool IsSubsequence(string s, string t)
        {
            int i = 0, j = 0;
            while (i < s.Length && j < t.Length)
            {
                if (s[i] == t[j])
                {
                    i++;
                }
                j++;
            }
            return i == s.Length;
        }
    }
}
