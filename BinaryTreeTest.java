import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by adi on 6/1/2017.
 */
public class BinaryTreeTest {

    @Test
    public void testPrintAncestors(){
        BinaryTree<Integer> myTree = new BinaryTree(16);
        myTree.setInsertChild(BinaryTree.InsertChild.Left);
        myTree.insert(9, 16);
        myTree.insert(3, 9);
        myTree.insert(1, 3);
        myTree.setInsertChild(BinaryTree.InsertChild.Right);
        myTree.insert(18, 16);
        myTree.insert(14, 9);
        myTree.insert(5, 3);
        myTree.insert(19, 18);

        List<Integer> result = new ArrayList<>();
        result.add(3);
        result.add(9);
        result.add(16);

        assertEquals(result , myTree.printAncestors(myTree, 5));

        assertNull(myTree.printAncestors(myTree, 4));

        result.remove(2);
        result.remove(1);
        result.remove(0);

        assertEquals(result, myTree.printAncestors(myTree, 16));
    }
    @Test
    public void tesLowestCommonAncestor() throws Exception {
        BinaryTree<Integer> myTree = new BinaryTree(16);
        myTree.setInsertChild(BinaryTree.InsertChild.Left);
        myTree.insert(9, 16);
        myTree.insert(3, 9);
        myTree.insert(1, 3);
        myTree.setInsertChild(BinaryTree.InsertChild.Right);
        myTree.insert(18, 16);
        myTree.insert(14, 9);
        myTree.insert(5, 3);
        myTree.insert(19, 18);

        BinaryTreeNode<Integer> node1 = myTree.lowestCommonAncestor(myTree, myTree.exists(5), myTree.exists(14));
        assertEquals(myTree.exists(9), node1);

        BinaryTreeNode<Integer> node2 = myTree.lowestCommonAncestor(myTree, myTree.exists(5), myTree.exists(5));
        assertNull(node2);

        BinaryTreeNode<Integer> node3 = myTree.lowestCommonAncestor(myTree, myTree.exists(19).getLeftChild(),
                myTree.exists(5));
        assertNull(node3);

        BinaryTreeNode<Integer> node4 = myTree.lowestCommonAncestor(myTree, myTree.exists(5), myTree.exists(-5));
        assertNull(node4);

        BinaryTreeNode<Integer> node5 = myTree.lowestCommonAncestor(myTree, myTree.exists(16), myTree.exists(18));
        assertEquals(myTree.getRoot(), node5);
    }

}