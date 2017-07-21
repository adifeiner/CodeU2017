package Ex5;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


class Graph {
    private List<GraphNode> nodesList = new LinkedList<>();
    ;

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
    public void updateGraph(List<Character> alphabet) {

        for (ListIterator<Character> iterator = alphabet.listIterator(); iterator.hasNext(); ) {
            boolean hasPrev = iterator.hasPrevious();
            Character currChar = iterator.next();
            if (!this.containsChar(currChar)) {
                this.addNode(new GraphNode(currChar));
            }
            
            if (hasPrev) {
                iterator.previous();
                Character prev = iterator.previous();
                if (this.findNode(prev).containsChar(currChar)) {
                    continue;
                }
                this.findNode(currChar).incrementInDegree();
                this.findNode(prev).addCharToAdjList(currChar);
                iterator.next();
                iterator.next();
            }
        }
    }

    private class GraphNode {
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
}
