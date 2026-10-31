import java.util.Arrays;
public class RemoveDuplicatesSortedArray {
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int unique = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[unique - 1]) {
                nums[unique] = nums[i];
                unique++;
            }
        }
        return unique;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int length = removeDuplicates(nums);
        System.out.println("Length = " + length);
        System.out.println(Arrays.toString(
            Arrays.copyOf(nums, length)));
    }
}
