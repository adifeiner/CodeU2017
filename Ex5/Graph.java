import java.util.LinkedList;
import java.util.List;

public class Graph {
    private List<GraphNode> nodesList;

    public Graph(){
        nodesList = new LinkedList<>();
    }

    public void addNode(GraphNode graphNode) {
        this.nodesList.add(graphNode);
    }

    public GraphNode findNode(char character) {
        for (GraphNode graphNode : nodesList) {
            if (graphNode.getCharacter() == character) {
                return graphNode;
            }
        }
        return null;
    }

    public boolean containsChar(char character) {
        if (this.findNode(character) != null) {
            return true;
        }
        return false;
    }

    /**
     * The function return an ordered list of the characters using a topological sort algorithm
     *
     * @return a list of characters
     */
    public List<Character> topologicalSort() {
        List<Character> alphabetOrder = new LinkedList<>();
        List<GraphNode> nodesWithInDegreeZero = findInDegreeZero();

        while (this.nodesList.size() > 0) {
            for (GraphNode node : nodesWithInDegreeZero) {
                alphabetOrder.add(node.getCharacter());
                updateNodesList(node);

            }
            nodesWithInDegreeZero = findInDegreeZero();
        }
        return alphabetOrder;
    }

    /**
     * The function return a list with all the nodes in the graph that their in-degree is zero
     *
     * @return list of nodes
     */
    private List<GraphNode> findInDegreeZero() {
        List<GraphNode> nodesWithInDegreeZero = new LinkedList<>();
        for (GraphNode graphNode : this.nodesList) {
            if (graphNode.getInDegree() == 0) {
                nodesWithInDegreeZero.add(graphNode);
            }
        }
        return nodesWithInDegreeZero;
    }

    /**
     * The function update the nodes list after added character to the topological sort -
     * remove this node from the graph and update the in degree edges in the graph
     *
     * @param node - node from the graph
     */
    private void updateNodesList(GraphNode node) {
        for (char character : node.getAdjacencyList()) {
            this.findNode(character).decrementInDegree();
        }
        this.nodesList.remove(node);
    }

    /**
     * The function receives a list of characters and update the graph accordingly
     *
     * @param alphabet - a list of characters
     */
    public void updateGraph (List<Character> alphabet) {
        for (int i = 0; i < alphabet.size(); i++) {
            Character currChar = alphabet.get(i);
            if (!this.containsChar(currChar)) {
                this.addNode(new GraphNode(currChar));
            }
            if (i > 0) {
                if (this.findNode(alphabet.get(i - 1)).containsChar(currChar)) {
                    continue;
                }
                this.findNode(alphabet.get(i)).incrementInDegree();
                this.findNode(alphabet.get(i - 1)).addCharToAdjList(alphabet.get(i));
            }
        }
    }
}
