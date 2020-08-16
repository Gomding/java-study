import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DecimalConvert {

    public void convert(int num, int system) {

        StringBuilder sb = new StringBuilder();
        sb.append(num);
        sb.append("을 ");
        sb.append(system);
        sb.append("진법으로 변환하면 결과값은 ");

        List<Integer> nums = new ArrayList<>();



         do {
            int result = num % system;
            nums.add(result);
            num /= system;
        } while (num / system != 0);

        nums.add(num);

        for (int i = nums.size() - 1; i >= 0; i--) {
            sb.append(nums.get(i));
        }

        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("변환하고 싶은 정수를 입력해주세요. > ");
        int num = Integer.parseInt(br.readLine());

        System.out.print("변환하고 싶은 진법을 입력해주세요. > ");
        int system = Integer.parseInt(br.readLine());

        new DecimalConvert().convert(num, system);

    }

}
