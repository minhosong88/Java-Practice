package dfs_bfs;

class MyGraph {
    private int count;
    private int[][] vertexMatrix;
    private boolean[] visited;
    private int[] distance;

    private static int UNLIMIT = 99999999;

    public MyGraph(int count) {
        this.count = count;
        vertexMatrix = new int[count][count];
        visited = new boolean[count];
        distance = new int[count];
    }

    public void addEdge(int from, int to, int weight) {
        vertexMatrix[from][to] = weight;
        vertexMatrix[to][from] = weight;
    }

    public void calcShortestPath(int from) {
        for (int i = 0; i < count; i++) {
            distance[i] = UNLIMIT; // 일단 모든 거리 초기화
        }

        visited[from] = true; //시작점 초기화
        distance[from]=0;

        for (int i = 0; i < count; i++) { //시작점과 연결된 노드와의 거리 갱신
            if (visited[from]&&vertexMatrix[from][i] != 0) {
                distance[i] = vertexMatrix[from][i];
            }
        }

        for (int j = 0; j < count-1; j++) { //중복 for문 사용
            //시작점은 count에 포함되지만, 이미 사용되었으므로 count-1을 해서 중복을 줄인다.
            int min = UNLIMIT; // 초기 값을 최대로 부여한 후 나중에 갱신하는 방식을 사용한다.
            int minIndex = -1; // 하나는 인덱스 갱신을 통한 최소거리 찾기

            for (int i = 0; i < count; i++) {
                if (!visited[i] && distance[i] != UNLIMIT) { //방문 안했지만 거리가 갱신되었다면,
                    if (distance[i] < min) {

                        min = distance[i];  //최소 거리를 최대 값에서 갱신된 거리로 변경
                        minIndex = i;// 인덱스 변경

                    }
                }
            }//반복문이기 때문에 결국 마지막에 설정된 값 하나가 반복문을 빠져나가서 다음 연산을 하게 된다.

                visited[minIndex] = true;
            for (int i = 0; i < count; i++) {
                if (!visited[i] && vertexMatrix[minIndex][i] != 0) {
                    if (distance[i] > distance[minIndex] + vertexMatrix[minIndex][i]) {
                        distance[i] = distance[minIndex] + vertexMatrix[minIndex][i];
                    }
                }
            }
        }
    }

    public void showDistance(int from) {
        for (int i = 0; i < count; i++) {
            System.out.println("The minimum distance from " + from + "node to " + i + "node is: " + distance[i]);
        }
    }


}
public class ShortestPath {
    public static void main(String[] args) {
        MyGraph graph = new MyGraph(6);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 8);
        graph.addEdge(3, 5, 3);
        graph.addEdge(4, 5, 4);

        graph.calcShortestPath(0);
        graph.showDistance(0);
    }
}
