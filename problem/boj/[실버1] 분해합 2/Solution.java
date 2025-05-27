import java.io.*;
import java.math.BigInteger;

public class BOJ_12348 {

    // 197 + 1 + 9 + 7 = 214, 즉 214의 생성자는 197이다.
    // N의 생성자를 M이라고 했을 때, 식을 세우면 `M + (M의 자리수 합계) = N`
    // 항상 N > M 이다. 즉 생성자와 N은 (M의 자리수의 합계만큼 떨어져 있다.) => 197 + 17 = 214 (214는 197은 17만큼 떨어져 있다.)
    // 그럼 이렇게 떨어질 수 있는 최대의 수를 구하면 된다. 숫자가 세 자리인 경우, 최대 9 + 9 + 9 가 될 수 있다. 이는 27까지만 떨어질 수 있다는 것이다.
    // 그렇다면 N에서 27만큼 떨어진 만큼의 수부터 구하면 된다. 만약 100경이라면? 100경의 1,000,000,000,000,000,000는 19자리 수이다.
    // 100경의 경우 19 * 9 만큼만 떨어질 수 있다. 이런식으로 구하면 된다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String lineN = br.readLine();
        int size = lineN.length();
        BigInteger N = new BigInteger(lineN);

        BigInteger start = N.subtract(new BigInteger(String.valueOf(size * 9)));

        BigInteger result = null;
        while (!N.equals(start)) {
            BigInteger temp = getD(start.toString());
            if (temp.equals(N)) {
                result = start;
                break;
            }
            start = start.add(BigInteger.ONE);
        }

        if (result == null) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }

    public static BigInteger getD(String value) {
        BigInteger result = new BigInteger(value);
        int a = 0;
        for (int i=0; i<value.length(); i++) {
            a += (value.charAt(i) - '0');
        }
        return result.add(new BigInteger(String.valueOf(a)));
    }

}
