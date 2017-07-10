import java.util.LinkedList;
import java.util.List;

public class GraphNode {
    private char character;
    private List<Character> adjacencyList;
    private int inDegree;

    public GraphNode(char character) {
        this.character = character;
        adjacencyList = new LinkedList<>();
        inDegree = 0;
    }

    public void incrementInDegree(){
        this.inDegree++;
    }

    public void addCharToAdjList(char character) {
        this.adjacencyList.add(character);
    }

    public void decrementInDegree(){
        this.inDegree--;
    }
    public char getCharacter() {
        return this.character;
    }

    public int getInDegree() {
        return inDegree;
    }

    public List<Character> getAdjacencyList() {
        return adjacencyList;
    }

    public boolean containsChar(char character) {
        return this.adjacencyList.contains(character);
    }

}
