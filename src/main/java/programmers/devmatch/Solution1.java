package programmers.devmatch;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Solution1 {
    public String solution(String p, int n) {
        String[] dateArray = p.split(" ");
        String amOrPm = dateArray[0];
        String time = dateArray[1];

        String[] times = time.split(":");
        int hours = Integer.parseInt(times[0]);
        hours %= 12;
        int minutes = Integer.parseInt(times[1]);
        int seconds = Integer.parseInt(times[2]);

        seconds += n;
        if(seconds >= 60){
            minutes += (seconds / 60);
            seconds %= 60;
        }
        if(minutes >= 60){
            hours += (minutes / 60);
            minutes %= 60;
        }
        if(amOrPm.equals("PM")){
            hours += 12;
        }
        if(hours >= 24){
            hours %= 24;
        }

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
