package matrix_algorithm.mazeProblem;

public class MazeTest {
    public static void main(String[] args) {
        PathSearch pathSearch;
        System.out.println("Exit: ( 7, 7 )");

        pathSearch = new PathSearch();
        pathSearch.findPath(0, 0, 7, 7);
        pathSearch.showPath();
    }
}
