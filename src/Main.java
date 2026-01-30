import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[6];
        int [] reverse = new int[nums.length];
        Scanner sc = new Scanner(System.in);

        for (int i = 0 ; i<nums.length; i++){
            nums[i] = sc.nextInt();
        }
        for (int i = 0 ; i< nums.length ; i ++){
            reverse [i] = nums[nums.length-i-1];
        }

        for (int j : reverse) {
            System.out.println(j);
        }
    }
}
