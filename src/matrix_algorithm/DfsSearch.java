package matrix_algorithm;

import java.util.Stack;

public class DfsSearch { //인접노드 탐색, Stack 활용
    int count;
    boolean[] visited;
    int[][] matrix;
    Stack<Integer> stack;

    public DfsSearch(int count) {
        this.count = count;
        visited = new boolean[count];
        stack = new Stack<Integer>();
    }

    public void dfsTravers() {
        stack.push(0);//시작지점 초기화. stack 에 0이 들어가고, visited 로 마킹된 것.
        visited[0] = true;

        while (stack.size() != 0) {
            int node = stack.pop();
            System.out.print(node + " "); //하나씩 뺀다.

            for (int j = 0; j < count; j++) {
                //stack에 넣는 걸 visited 라고 말하고, matrix[node][j]=0이면 연결 안된 것
                if (matrix[node][j] != 0 && !visited[j]) {
                    stack.push(j);
                    visited[j] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        int count = 8;
        UndirectedGraph graph = new UndirectedGraph(count);
        DfsSearch dfs = new DfsSearch(count);

        graph.addEgde(0, 1, 1);
        graph.addEgde(0, 2, 1);
        graph.addEgde(1, 3, 1);
        graph.addEgde(1, 4, 1);
        graph.addEgde(2, 5, 1);
        graph.addEgde(2, 6, 1);
        graph.addEgde(4, 5, 1);
        graph.addEgde(3, 7, 1);

        dfs.matrix = graph.getVertexMatrix();
        dfs.dfsTravers();


    }

}
