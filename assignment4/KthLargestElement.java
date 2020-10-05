import java.util.Arrays;
import java.util.Scanner;

public class KthLargestElement {
    public int kthLargestElement(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    public int[] transferInputToIntArray(String input) {
        String[] temp = input.split(",");
        int[] nums = new int[temp.length];
        for (int i = 0; i < temp.length; ++i) {
            nums[i] = Integer.parseInt(temp[i]);
        }
        return nums;
    }
    public static void main(String[] args) {
        KthLargestElement obj = new KthLargestElement();
        Scanner sc = new Scanner(System.in);
        // the nums' format is like: 3,2,3,1,2,4,5,5,6
        String input = sc.nextLine();
        int[] nums = obj.transferInputToIntArray(input);
        // k is always valid, 1 ≤ k ≤ array's length
        int k = sc.nextInt();
        System.out.println(obj.kthLargestElement(nums, k));
    }
}
