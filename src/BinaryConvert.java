public class BinaryConvert {

    public int convert(String num) {

        int length = num.length() - 1;
        int result = 0;

        char[] nums;
        nums = num.toCharArray();

       for (int i = length; i >= 0; i--) {
           int realNum = nums[length - i] - 48;
           result += realNum * Math.pow(2, i);
       }

        return result;
    }

    public static void main(String[] args) {
        int result = new BinaryConvert().convert("1111");

        System.out.println(result);
    }

}
