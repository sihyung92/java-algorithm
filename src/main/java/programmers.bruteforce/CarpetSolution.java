package programmers.bruteforce;

public class CarpetSolution {
    public int[] solution(int brown, int red) {
        for (int x = brown; x > 2; x--) {
            for (int y = x; y > 2; y--) {
                if (calculateBrown(x, y) == brown) {
                    if (validateRed(x, y, red)) {
                        return new int[]{x, y};
                    }
                }
            }
        }
        return null;
    }

    private boolean validateRed(int x, int y, int red) {
        return (x - 2) * (y - 2) == red;
    }

    private int calculateBrown(int x, int y) {
        return (x * y) - (x - 2) * (y - 2);
    }

}
