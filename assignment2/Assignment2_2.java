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
    public int maxSubArray(int[] nums) {
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

    public static int[] transferInputToIntArray(String input) {
        String[] temp = input.split(",");
        int totalNumber = temp.length;
        int[] nums = new int[totalNumber];
        // nums = [1]
        if (totalNumber == 1) {
            String[] first = temp[0].split("\\[");
            nums[0] = Integer.parseInt(first[1].split("\\]")[0]);
        } else {
            /* the first and the last is special, they looks like
             *  "nums = [-2" and "4]", so we should deal with them individually*/

            // the first number, "nums = [-2"
            String[] first = temp[0].split("\\[");
            // now, they are "nums = " and "-2"
            nums[0] = Integer.parseInt(first[1]);

            // the last number, "4]"
            String[] last = temp[totalNumber - 1].split("\\]");
            // now, it is "4"
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
    	System.out.println("Please enter your number, the format should"
    			+ " like this:nums = [-2,1,-3,4,-1,2,1,-5,4]");
        Assignment2_2 obj = new Assignment2_2();
        Scanner sc = new Scanner(System.in);
        // read input, the input format is: nums = [-2,1,-3,4,-1,2,1,-5,4]
        String input = sc.nextLine();
        if (input.equals("nums = []")) {
            System.out.println("You did not input number, please try again");
        } else {
            /* need to deal with input, because the input includes not
               only numbers but also word and characters */
            int[] nums = transferInputToIntArray(input);
            // to get the contiguous subarray's largest sum
            System.out.println(obj.maxSubArray(nums));
        }
    }
}
