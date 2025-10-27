import java.util.Comparator;
import java.util.Map;

public class PriorityQueue<Task> {
    private BinarySearchTree<Task> bst;

    public PriorityQueue(Comparator<Task> com){
        bst = new BinarySearchTree<>(com);
    }

    public void insert(Task value, int priority){
        bst.insert(value);
    }
    public boolean findMin() {
        return bst.getMin(); // or getMax(), depending on comparator
    }
    public boolean deleteMin(){
        return bst.deleteMin();
    }

    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
