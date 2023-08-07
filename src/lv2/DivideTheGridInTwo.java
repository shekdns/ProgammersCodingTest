package lv2;
//전력망을 둘로 나누기(완전탐색)
public class DivideTheGridInTwo {
  public static class Solution {
    public int solution( int n, int[][] wires ) {
      int answer = -1;

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n1 = 9;
    int[][] wires1 = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 }  };

    System.out.println( "RESULT = " + solution.solution( n1, wires1 ) );
  }
}
