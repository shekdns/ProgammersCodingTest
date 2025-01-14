package javaStudy.structure.dfs;

public class DFSDemo {
  static int[][] grid = {
          {1, 0, 1, 1},
          {1, 1, 0, 1},
          {0, 1, 1, 0},
          {1, 0, 0, 1}
  };
  static boolean[][] visited = new boolean[4][4];
  static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) {
    dfs(0, 0); // (0,0)에서 탐색 시작
  }

  public static void dfs(int x, int y) {
    // 범위 초과 또는 이미 방문한 경우 종료
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == 0) {
      return;
    }

    visited[x][y] = true; // 방문 처리
    System.out.println("Visited: (" + x + ", " + y + ")");

    // 상하좌우 탐색
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      dfs(nx, ny);
    }
  }
}