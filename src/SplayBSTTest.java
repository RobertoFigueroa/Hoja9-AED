public class SplayBSTTest {

    @org.junit.Test
    public void put() {
        BST testSplay = new SplayBST<>();
        testSplay.put("house","casa");
    }

    @org.junit.Test
    public void contains() {
        BST testSplay = new SplayBST<>();
        testSplay.put("house","casa");
        testSplay.contains("house");
    }
}