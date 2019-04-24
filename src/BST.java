public interface BST<Key,Value> {

    public boolean isEmpty();

    public boolean contains(Key k);

    public void put(Key k, Value v);

    public void delete(Key k);

    public Value get(Key k);
}
