package matrix_algorithm;

public class UndirectedGraph {
    int count;
    int[][] vertexMatrix;

    public UndirectedGraph(int count) {
        this.count =count;
        vertexMatrix = new int[count][count];
    }

    public void addEgde(int from, int to, int weight) {
        vertexMatrix[from][to] = weight;
        vertexMatrix[to][from] = weight;
    }

    public int[][] getVertexMatrix() {
        return vertexMatrix;
    }
}
