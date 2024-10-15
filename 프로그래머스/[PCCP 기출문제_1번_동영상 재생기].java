import java.util.Arrays;
import java.lang.String;
import java.lang.Integer;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        pos = checkOpenning(pos, op_start, op_end);
        for(String command : commands){
            pos = calTime(pos, command, video_len);
            pos = checkOpenning(pos, op_start, op_end);
        }

        return pos;
    }

    public String calTime(String pos, String command, String video_len){
        String[] time = pos.split(":");
        int mm = Integer.parseInt(time[0]);
        int ss = Integer.parseInt(time[1]);

        if(command.equals("prev")){
            ss -= 10;
        }
        else if(command.equals("next")){
            ss += 10;
        }

        return checkTime(mm, ss, video_len);
    }

    public String checkTime(int mm, int ss, String video_len){
        String[] videoTime = video_len.split(":");
        int vmm = Integer.parseInt(videoTime[0]);
        int vss = Integer.parseInt(videoTime[1]);

        if(ss< 0){
            mm -= 1;
            ss += 60;
            if(mm < 0){
                mm = 0;
                ss = 0;
            }
        }
        else if(ss > 59){
            mm += 1;
            ss -= 60;
        }
        if(mm > vmm || (mm == vmm && ss >= vss)){
            mm = vmm;
            ss = vss;
        }
        return String.format("%02d:%02d", mm, ss);
    }

    public String checkOpenning(String pos, String op_start, String op_end){
        String[] posTime = pos.split(":");
        String[] startTime = op_start.split(":");
        String[] endTime = op_end.split(":");
        int pmm = Integer.parseInt(posTime[0]);
        int pss = Integer.parseInt(posTime[1]);
        int smm = Integer.parseInt(startTime[0]);
        int sss = Integer.parseInt(startTime[1]);
        int emm = Integer.parseInt(endTime[0]);
        int ess = Integer.parseInt(endTime[1]);

        if(pmm < smm || pmm > emm)
            return pos;
        if((pmm == smm && pss < sss) || (pmm == emm && pss > ess))
            return pos;
        return op_end;
    }
}