package programmers.mothlychallenge;

public class reverseTernary {
    public int solution(int n) {
        String reverseTernary = makeReverseTernary(n);

        int answer = makeDecimalFromTernary(reverseTernary);

        return answer;
    }

    private int makeDecimalFromTernary(String reverseTernary) {
        int threeSquared = 1;
        int result = 0;
        char[] chars = reverseTernary.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            result += Integer.parseInt(String.valueOf(chars[i])) * threeSquared;
            threeSquared *= 3;
        }
        return result;
    }

    private String makeReverseTernary(int n) {
        StringBuffer sb = new StringBuffer();

        while (n / 3 > 0) {
            sb.insert(0, n % 3);
            n /= 3;
        }
        sb.insert(0, n);
        return sb.reverse().toString();
    }

}
