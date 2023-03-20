package javaStudy.structure.dfs;

import java.util.Scanner;
import java.util.Stack;

//DFS 깊이 우선 탐색
public class Dfs {
  static final int MAX_N = 10;
  static int N, E;
  static int[][] graph = new int[MAX_N][MAX_N];
  static boolean[] visited = new boolean[MAX_N];

  static void dfs( int node ) {
    visited[node] = true;
    System.out.print( node + " " );

    for( int next = 0; next < N; ++next ) {
      if( !visited[next] && graph[node][next] != 0 ) {
        dfs( next );
      }
    }
  }

  static void dfsStack( int node ) {
    boolean[] visitedStack = new boolean[MAX_N];

    Stack<Integer> myStack = new Stack<>();
    myStack.push( node );

    while( !myStack.empty() ) {
      int curr = myStack.pop();

      if( visitedStack[curr] ) {
        continue;
      }

      visitedStack[curr] = true;
      System.out.print( curr + " " );

      for( int next = 0; next < N; ++next ) {
        if( !visitedStack[next] && graph[curr][next] != 0 ) {
          myStack.push( next );
        }
      }
    }
  }

  public static void main(String[] args) {
    //5 노드의 수 6 간선의 수
    Scanner scan = new Scanner( System.in );
    N = scan.nextInt();
    E = scan.nextInt();

    for( int i = 0; i < E; ++i ) {
      int u = scan.nextInt();
      int v = scan.nextInt();
      graph[u][v] = graph[v][u] = 1;
    }
    dfsStack(0);
  }
}

