import java.util.Arrays;
import java.util.Scanner;

/**
 * The deadline of this assignment is 09/25/2020 23:59 PST.
 * Please feel free to contact Yafei and Yaqi for any questions.
 */

public class Assignment2_2 {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and outprint its sum.
     *
     * Example 1:
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * Example 2:
     * Input: nums = [1]
     * Output: 1
     */
    // ??? non static
    public static int maxSubArray(int[] nums) {
        //write your code here
        int maxSum = 0;
        int tempSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            tempSum += nums[i];
            if (tempSum <= 0) {
                tempSum = 0;
            }
            if (maxSum < tempSum) {
                maxSum = tempSum;
            }
        }
        return maxSum;
    }

    public static int[] changeInputToIntArray(String[] temp) {
        int totalNumber = temp.length;
        int[] nums = new int[totalNumber];
        // nums = [1]
        if (totalNumber == 1) {
            String[] first = temp[0].split("\\[");
            nums[0] = Integer.parseInt(first[1].split("\\]")[0]);
        } else {
            /* the first and the last is special, they looks like
             *  "nums = [-2" and "4]", so we should deal with them individually*/
            // "nums = [-2"
            String[] first = temp[0].split("\\[");
            nums[0] = Integer.parseInt(first[1]);
            // "4]"
            String[] last = temp[totalNumber - 1].split("\\]");
            nums[totalNumber - 1] = Integer.parseInt(last[0]);
            // the rest number
            for (int i = 1; i < temp.length - 1; ++i) {
                nums[i] = Integer.parseInt(temp[i]);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        //write your code here
        // ??? what is the input format, nums = [-2,1,-3,4,-1,2,1,-5,4] is hard to deal with
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.equals("nums = []")) {
            System.out.println("You did not input number");
        } else {
            String[] temp = input.split(",");
            int[] nums = changeInputToIntArray(temp);
            System.out.println(maxSubArray(nums));
        }
    }
}
