package lv1.pcc;

//[PCCP 기출문제] 1번 / 동영상 재생기
public class VideoPlayer {
  public static class Solution {

    public String returnTime( String pos, String command, String video_len ) {
      String returnTime = "";
      String[] split = pos.split( ":" );
      String minute = split[0];
      String second = split[1];

      if( command.equals( "next" ) ) {
        int tempSecond = Integer.parseInt( second ) + 10;
        int plusMinutes = tempSecond / 60;
        int plusSeconds = tempSecond % 60;

        minute = String.valueOf( Integer.parseInt( minute ) + plusMinutes );
        second = String.valueOf( plusSeconds );

        if( Integer.parseInt( minute ) < 10 ) {
          minute = "0" + minute;
        }
        if( Integer.parseInt( second) < 10 ) {
          second = "0" + second;
        }

        returnTime = minute + ":" + second;
        if( Integer.parseInt( returnTime.replace( ":", "") ) > Integer.parseInt( video_len.replace( ":", "" ) ) ) {
          returnTime = video_len;
        }
      } else {
        if( Integer.parseInt( pos.replace( ":", "" ) ) < 10 ) {
          return "00:00";
        }
        int tempSecond  = Integer.parseInt( second ) - 10;
        int tempMinutes = Integer.parseInt( minute );
        if( tempSecond < 0 ) {
          tempSecond = 60 + tempSecond;
          tempMinutes = tempMinutes - 1;
          if( tempMinutes < 0 ) {
            return "00:00";
          }
        }
        minute = String.valueOf( tempMinutes );
        second = String.valueOf( tempSecond );

        if( Integer.parseInt( minute ) < 10 ) {
          minute = "0" + minute;
        }
        if( Integer.parseInt( second) < 10 ) {
          second = "0" + second;
        }

        returnTime = minute + ":" + second;
      }
      return returnTime;
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
      String answer = "";

      int intOpStart = Integer.parseInt(op_start.replace(":", ""));
      int intOpEnd   = Integer.parseInt(op_end.replace(":", ""));
      int intPos     = Integer.parseInt(pos.replace(":", ""));
      if( intPos >= intOpStart && intPos <= intOpEnd ) {
        pos = op_end;
      }

      String temp = pos;
      for (String command : commands) {
        temp = returnTime( temp, command, video_len );
        int intTemp = Integer.parseInt(temp.replace(":", ""));
        if(intTemp >= intOpStart && intTemp <= intOpEnd) {
          temp = op_end;
        }
      }

      answer = temp;

      return answer;
    }
  }

  public static void main(String[] args) {
    String video_len = "34:33";
    String pos = "13:00";
    String op_start = "00:55";
    String op_end = "02:55";
    String[] commands = { "next", "prev" };

    Solution solution = new Solution();
    String result = solution.solution(video_len, pos, op_start, op_end, commands);
    System.out.println( "result = " + result );
  }
}
