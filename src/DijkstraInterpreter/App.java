package DijkstraInterpreter;

public class App {
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        algorithm.interpretExperssion("( ( 1 + 2 ) * ( 2 + 1 ) )");
        algorithm.result();
    }
}
