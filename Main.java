import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Main {

    public static void main(String[] args) {
        // Tests
        JUnitCore junit = new JUnitCore();
        Result result = junit.run(BinaryTreeTest.class);
        if (result.wasSuccessful()) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
}
