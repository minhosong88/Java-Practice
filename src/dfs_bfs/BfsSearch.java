package dfs_bfs;

import java.util.ArrayList;

public class BfsSearch { //한 노드에 인접한 모든 노드를 탐색, 큐를 활용
    int count;
    boolean[] visited;
    int[][] matrix;
    ArrayList<Integer> queue;

    public BfsSearch(int count) {
        this.count = count;
        visited = new boolean[count];
        queue = new ArrayList<Integer>();
    }

    public void bfsTraverse() {
        queue.add(0);
        visited[0] = true;

        while (queue.size() != 0) {
            int node = queue.remove(0);
            System.out.print(node + " ");
            for (int j = 0; j < count; j++) {
                if (matrix[node][j] != 0 && !visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        int count = 8;
        UndirectedGraph graph = new UndirectedGraph(count);
        BfsSearch bfs = new BfsSearch(count);

        graph.addEgde(0, 1, 1);
        graph.addEgde(0, 2, 1);
        graph.addEgde(1, 3, 1);
        graph.addEgde(1, 4, 1);
        graph.addEgde(2, 5, 1);
        graph.addEgde(2, 6, 1);
        graph.addEgde(4, 5, 1);
        graph.addEgde(3, 7, 1);

        bfs.matrix = graph.getVertexMatrix();
        bfs.bfsTraverse();
    }

}
