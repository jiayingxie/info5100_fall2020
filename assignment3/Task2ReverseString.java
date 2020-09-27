import java.util.Scanner;

/* 1.A word is defined as a sequence of non-space characters.
2.Input string may contain leading or trailing spaces. However, your reversed
string should not contain leading or trailing spaces.
3.You need to reduce multiple spaces between two words to a single space in
the reversed string.*/
public class Task2ReverseString {
    public String reverse(String s) {
        // A word is defined as a sequence of non-space characters.
        String[] temp = s.split(" ");
        StringBuffer ans = new StringBuffer();
        for (int i = temp.length - 1; i >= 0; --i) {
            // reduce multiple spaces between two words to a single space
            if (temp[i].equals("")) continue;
            else {
                ans.append(temp[i]);
                ans.append(" ");
            }
        }
        // string should not contain leading or trailing spaces
        return ans.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Task2ReverseString obj = new Task2ReverseString();
        String ans = obj.reverse(input);
        System.out.println(ans);
    }
}
