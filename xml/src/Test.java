import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 1000000; i++) {
            map.put(i, i);
        }

        for (int i = 0; i < 100; i++) {
            int sum = 0;
            long start = System.currentTimeMillis();
            for (int j = 0; j < 1000000; j++) {
                sum += map.get(j);
            }
            long end = System.currentTimeMillis();
            if (i >= 95)
                System.out.printf("第 %d 轮测试，sum: %d, 花费的时间: %dms\n", i, sum, end - start);
        }
    }
}
