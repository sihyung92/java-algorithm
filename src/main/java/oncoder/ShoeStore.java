package oncoder;

import java.util.ArrayList;
import java.util.List;

/*
* 당신은 신발가게 사장입니다.
크리스마스를 맞아 새로 나온 상품을 주문했는데, 운송과정에서 서로 다른 사이즈의 신발이 섞이는 사고가 발생했습니다.
도착한 신발을 살펴보니 왼쪽 신발과 오른쪽 신발이 N개씩 있습니다.
당신은 모든 신발의 사이즈를 조사하여 짝이 맞지 않는 신발을 교환하려 합니다.
이제 왼쪽 신발과 오른쪽 신발의 사이즈를 나타내는 int[] left 와 int[] right 가 주어집니다.
신발을 교환해야 하는 최소 교환 회수를 리턴하세요
* */
public class ShoeStore {
    public int solution(int[] left, int[] right) {
        List<Integer> shoesList = new ArrayList<>();
        for (int i : left) {
            shoesList.add(i);
        }

        int unfairCount = 0;
        for (int i : right) {
            if (shoesList.contains(i)) {
                shoesList.remove(shoesList.indexOf(i));
                continue;
            }
            unfairCount++;
        }
        return unfairCount;
    }
}
