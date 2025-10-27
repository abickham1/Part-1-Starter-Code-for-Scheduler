import java.util.Comparator;

//implement in driver

public class BinarySearchTree<Task> {
    private Node root;
    private Comparator<Task> com;

    class Node{
        private Task value;
        private Node left;
        private Node right;

        Node(Task value){
            this.value = value;
            left = null;
            right = null;
        }
    }

    public BinarySearchTree(Comparator<Task> com){
        this.com = com;
    }

    public void insert(Task value){
        root = insertRecursion(root, value);
    }

    private Node insertRecursion(Node root,Task value){
        int cmp;
        if(root == null){
            root = new Node(value);
            return root;
        }
        cmp = com.compare(value, root.value);
        if(cmp < 0){
            root.left = insertRecursion(root.left, value);
        } else {
            root.right = insertRecursion(root.right, value);
        }
        return root;
    }

    public boolean getMin() {
        return getMinRecursion() != null;
    }

    private Node getMinRecursion(){
        //Node current =
        if(root == null){
            return null;
        }
        if(root.left == null){
            return (Node) root.value;
        }
        return root.left = getMinRecursion();
    }

    public boolean deleteMin() {
        return deleteMinRecursion() != null;
    }

    private Task deleteMinRecursion(){
        if (root == null) {
            return null;
        }
        if(root.left == null){
            Task min = root.value;
            root = root.right;
            return min;
        }

        Node current = root.left;

         current = getMinRecursion();
         Task min = current.value;
         root.left = current.right;

         return min;
    }

    public void delete(Task value){
        root = deleteRecursion(root, value);
    }

    private Node deleteRecursion(Node root,Task value){
        int cmp;
        if(root == null){
            return null;
        }
        cmp = com.compare(value, root.value);
        if(cmp < 0){
            root.left = deleteRecursion(root.left, value);
        } else if(cmp > 0){
            root.right = deleteRecursion(root.right, value);
        } else{
            if(root.left == null){
                return root.right;
            } if(root.right == null){
                return root.left;
            }
        }
        return root;
    }

    public boolean search(Task value) {
        return searchRecursion(root, value) != null;
    }

    private Node searchRecursion(Node root,Task value){
        int cmp;
        if(root == null){
            return null;
        }
        cmp = com.compare(value, root.value);
        if(cmp == 0){
            return root;
        } else if(cmp < 0) {
            return searchRecursion(root.left, value);
        } else {
            return searchRecursion(root.right, value);
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

}
