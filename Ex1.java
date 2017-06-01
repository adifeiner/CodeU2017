import java.util.HashMap;

class Node {

    private int data;
    private Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public int getData(){
        return this.data;
    }

    public Node getNext(){
        return this.next;
    }

    public void setNext(Node next){
        this.next = next;
    }
}

class LinkedList {

    private Node head;

    public Node getHead(){
        return this.head;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);

        if (this.head != null) {
            newNode.setNext(this.head);
        }

        this.head = newNode;
    }
}

public class Ex1 {

    public static void main(String[] args) {
        //test q1
        System.out.println(isPermutation("Listen", "Silent")); //true

        //test q2
        LinkedList list = new LinkedList();
        list.addFirst(0);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        System.out.println(findKthToLastElement(list, 2)); // 2
    }

    public static boolean isPermutation(String firstStr, String secondStr) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Check if one of the strings are null or if their length is not equal
        if (firstStr == null || secondStr == null || firstStr.length() != secondStr.length()) {
            return false;
        }

        // Create a hash map so that the key is the character
        // and the value is the number of times that the character appears in the string
        for (int i = 0; i < firstStr.length(); i++) {
            Character currChar = Character.toLowerCase(firstStr.charAt(i));

            // Update the value of the character by increasing it by one or create a new key with value one
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
        }

        // Check if the second string is a permutation of the first string
        for (int i = 0; i < secondStr.length(); i++) {
            Character currChar = Character.toLowerCase(secondStr.charAt(i));

            // Save the value of the currChar if mapped, otherwise zero
            int num = map.getOrDefault(currChar, 0);

            // If num is greater than zero, update the value of the character by reducing it by one
            if (num > 0) {
                map.put(currChar, num - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * The function finds the kth to last element of a singly linked list
     * @param list
     * @param k
     * @return The data of the node kth to last element
     */
    public static int findKthToLastElement(LinkedList list, int k) {
        // If the list is empty, return -1
        if (list.getHead() == null) {
            return -1;
        }

        // The first pointer progress k steps from the head node of the list
        Node firstPointer = list.getHead();

        for (int i = 0; i < k; i++) {
            firstPointer = firstPointer.getNext();
        }
        Node secondPointer = list.getHead();

        // As long as the next node of the first pointer isn't null, the first pointer and the second pointer
        // progress to the next node
        while (firstPointer.getNext() != null) {
            firstPointer = firstPointer.getNext();
            secondPointer = secondPointer.getNext();
        }
        // When the first pointer is at the last node of the list,
        // the second pointer is on kth to last element of the list
        return secondPointer.getData();
    }
}





