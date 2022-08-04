package lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class SkillTree {
  public static class Solution {
    public int solution( String skill, String[] skill_tress ) {
      int answer = 0;
      ArrayList<String> arrayList = new ArrayList<>();

      for( int i = 0; i < skill_tress.length; i++ ) {
        StringBuilder sb = new StringBuilder();
        for( int j = 0; j < skill_tress[i].length(); j++ ) {
          Character ch = skill_tress[i].charAt(j);
          if( skill.contains( String.valueOf( ch ) ) ) {
            sb.append( ch );
          }
        }
        arrayList.add( sb.toString() );
      }

      ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
      for( String ss : arrayList ) {
        ArrayList<Integer> innerTemp = new ArrayList<>();
        for( int i = 0; i < ss.length(); i++ ) {
          innerTemp.add( skill.indexOf( ss.charAt(i) ) );
        }
        temp.add( innerTemp );
      }

      boolean[] check = new boolean[skill_tress.length];
      Arrays.fill( check, true );

      int k = -1;
      for( ArrayList<Integer> i : temp ) {
        boolean flag = true;
        k++;
        int j = 0;
        for( int ii : i ) {
          if( ii != j ) {
            check[k] = false;
          }
          j++;
        }
      }

      for( boolean f : check ) {
        if( f == true ) {
          answer++;
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String skill =  "CBD";
    String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

    int result = solution.solution( skill, skill_trees );
    System.out.println( "RESULT = " + result );
  }
}
