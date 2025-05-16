import java.io.*;

public class BOJ_2011ss {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int N = line.length();
        long[] dp = new long[N];
        int[] numbers = new int[N];

        for (int i=0; i<N; i++) numbers[i] = Character.getNumericValue(line.charAt(i));

        if (numbers[0] == 0) {
            System.out.println(0);
            return;
        }

        dp[0] = 1;

        if (N >= 2) {
            if (numbers[0] * 10 + numbers[1] <= 26 && numbers[1] != 0) dp[1] = 2;
            } else if (numbers[1] == 0 && numbers[0] * 10 + numbers[1] > 26) {
                System.out.println(0);
                return;
            } else dp[1] = 1;

            for (int i=2; i<N; i++) {
                // numbers[i] == 0이면 붙인 것만 검사한다.
                int previousNumber = numbers[i - 1];
                int currentNumber = numbers[i];
                int merged = previousNumber * 10 + currentNumber;

                // 0아 아니면 dp[i] += dp[i-1]
                if (currentNumber != 0) dp[i] += dp[i - 1] % 1000000;

                if (merged <= 26 && previousNumber != 0) dp[i] += dp[i - 2] % 1000000;

                if (merged > 26 && currentNumber == 0) {
                    System.out.println(0);
                    return;
                }
            }       
        }
        System.out.println(dp[N-1] % 1000000);
    }