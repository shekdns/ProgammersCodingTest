package lv2;

public class ConnectedPaths {
  static int[][] grid = {
          {1, 0, 1, 1},
          {1, 1, 0, 1},
          {0, 1, 1, 0},
          {1, 0, 0, 1}
  };
  static boolean[][] visited = new boolean[4][4];
  static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
  static int[] dy = {0, 0, -1, 1};
  static int groupCount = 0; // 그룹 개수

  public static void main(String[] args) {
    // 이어지는 길 확인
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        // 방문하지 않은 노드에서 DFS 시작
        if (!visited[i][j] && grid[i][j] == 1) {
          groupCount++; // 새로운 그룹 발견
          System.out.println("Group " + groupCount + " starts at (" + i + ", " + j + ")");
          dfs(i, j);
        }
      }
    }

    System.out.println("Total Groups: " + groupCount);
  }

  public static void dfs(int x, int y) {
    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y] || grid[x][y] == 0) {
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