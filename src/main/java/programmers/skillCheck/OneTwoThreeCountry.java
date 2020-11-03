package programmers.skillCheck;

public class OneTwoThreeCountry {
    public String solution(int n) {
        String answer = "";
        int reminder;

        while(n > 0){
            reminder= n%3;
            n = n/3;

            if(reminder == 0){
                n -= 1;
                reminder = 4;
            }
            answer = reminder + answer;
        }
        return answer;
    }
}
