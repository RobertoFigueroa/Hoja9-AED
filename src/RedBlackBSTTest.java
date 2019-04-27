public class RedBlackBSTTest {

    @org.junit.Test
    public void put() {
        BST redBlackBST = new SplayBST<>();
        redBlackBST.put("house","casa");
    }

    @org.junit.Test
    public void contains() {
        BST redBlackBST = new SplayBST<>();
        redBlackBST.put("house","casa");
        redBlackBST.contains("house");
    }
}