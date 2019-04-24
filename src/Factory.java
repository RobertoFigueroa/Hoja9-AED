import java.awt.*;

public  class Factory<K extends Comparable<K>,V>{

    public BST<K,V> Factory(int keyForImplementation){
        switch (keyForImplementation){
            case 1:
                return new SplayBST<>();
            case 2:
                return new RedBlackBST<>();
        }
        return null;
    }
}
