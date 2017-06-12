import jdk.internal.cmm.SystemResourcePressureImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by adi on 6/1/2017.
 */
public class BinaryTreeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private BinaryTree<Integer> myTree;
    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
        myTree = new BinaryTree(16);
        myTree.insert(9, 16, BinaryTree.InsertChild.LEFT);
        myTree.insert(3, 9, BinaryTree.InsertChild.LEFT);
        myTree.insert(1, 3, BinaryTree.InsertChild.LEFT);
        myTree.insert(18, 16, BinaryTree.InsertChild.RIGHT);
        myTree.insert(14, 9, BinaryTree.InsertChild.RIGHT);
        myTree.insert(5, 3, BinaryTree.InsertChild.RIGHT);
        myTree.insert(19, 18, BinaryTree.InsertChild.RIGHT);
    }

    @After
    public void cleanUpStream() {
        System.setOut(null);
    }

    @Test
    public void testFindAncestors_existingNode() {
        List<Integer> result = new ArrayList<>(Arrays.asList(3, 9, 16));
        assertEquals("Lists should be identical", result, this.myTree.findAncestors(5));
    }

    @Test
    public void testFindAncestors_missingNode() {
        assertNull(myTree.findAncestors(4));
    }

    @Test
    public void testPrintAncestors_existingNode(){
        this.myTree.printAncestors(5);
        assertEquals("3 9 16 ", outContent.toString());
    }

    @Test
    public void testPrintAncestors_missingNode(){
        this.myTree.printAncestors(4);
        assertEquals("Should be empty", "",outContent.toString());
    }

    @Test
    public void testLowestCommonAncestor_existingAncestor() {
        assertEquals("The ancestor should be 9", (Integer) 9, this.myTree.lowestCommonAncestor(5, 14));
    }

    @Test
    public void testLowestCommonAncestor_sameValue() {
        assertNull(this.myTree.lowestCommonAncestor(5, 5));
    }

    @Test
    public void testLowestCommonAncestor_missingKey() {
        assertNull(this.myTree.lowestCommonAncestor(17, 5));
    }

    @Test
    public void testLowestCommonAncestor_missing2keys() {
        assertNull(this.myTree.lowestCommonAncestor(5, -5));
    }

    @Test
    public void testLowestCommonAncestor_theKeyIsTheAncestor() {
        assertEquals("The key is the ancestor", (Integer) 16, this.myTree.lowestCommonAncestor(16, 18));
    }
}