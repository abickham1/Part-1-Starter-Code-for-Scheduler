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

    private Node insert(Node root,Task value){
        int cmp;
        if(root == null){
            root = new Node(value);
            return root;
        }
        cmp = com.compare(value, root.value);
        if(cmp < 0){
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    private Node delete(Node root,Task value){
        int cmp;
        if(root == null){
            return null;
        }
        cmp = com.compare(value, root.value);
        if(cmp < 0){
            root.left = delete(root.left, value);
        } else if(cmp > 0){
            root.right = delete(root.right, value);
        } else{
            if(root.left == null){
                return root.right;
            } if(root.right == null){
                return root.left;
            }
        }
        return root;
    }

    private Node search(Node root,Task value){
        int cmp;
        if(root == null){
            return null;
        }
        cmp = com.compare(value, root.value);
        if(cmp == 0){
            return root;
        } else if(cmp < 0) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

}
