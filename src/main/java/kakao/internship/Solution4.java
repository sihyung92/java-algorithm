package kakao.internship;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution4 {
    public int solution(int[][] board) {
        final int X = board[0].length;
        final int Y = board.length;
        Queue<Point> q = new LinkedList<>();
        int x = 0;
        int y = 0;
        int size = 0;
        int cnt = 0;
        int cost = 0;
        List<Integer> costList = new ArrayList<Integer>();
        Point p;
        q.add(new Point(0, 0));
        return 0;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

