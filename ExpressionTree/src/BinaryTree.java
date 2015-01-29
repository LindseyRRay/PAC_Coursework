/**
 * Created by lrraymond13 on 12/8/14.
 */
public class BinaryTree {
    public static final int INORDER = 1;
    public static final int PREORDER = 2;
    public static final int POSTORDER = 3;



    //node class
    protected class BTNode {
        //tree can hold any type of info as long as it implements the Comparable interface
        protected Comparable info;
        protected BTNode left;
        protected BTNode right;

        BTNode(Comparable o){
            this(o, null, null);
        }

        BTNode(Comparable o, BTNode l, BTNode r) {
            this.info = o;
            this.left = l;
            this.r = r;
        }

    }

    //create root
    protected BTNode root;
    ArrayQueue q ;
//constructor
    public BinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        //determines if tree is empty
        return (root == null);
    }

    public boolean isFull() {
        //determines if tree is full- we assume it is never full
        return false;
    }

    public int NumberOfNodes(BTNode tree){
        //determines total number of nodes in tree
        if (tree == null) {
            return 0;
        }
        else {
                return NumberofNodes(tree.right) + NumberofNodes(tree.left) +1;
            }
        }


    public Comparable isThere(Comparable item, BSNode tree) {
//        Determines if element matching item in tree
        if (tree==null) return false;
        else if (item.info.compareTo(tree.info)< 0) {
            return isThere(tree.left);
        }
        else if (item.info.compareTo(tree.info)> 0) {
            return isThere(tree.right);
        }
        else return true;

    }

    public Comparable retrieve(Comparable item) {
//        Returns element with the same key as item
        if (tree==null) return false;
        else if (item.info.compareTo(tree.info)< 0) {
            return retrieve(tree.left);
        }
        else if (item.info.compareTo(tree.info)> 0) {
            return retrieve(tree.right);
        }
        else return tree.info;
    }

    public void insert(Comparable item) {
        if (tree == null) {
            //insert
            tree = new BSNode(item, null, null);
        }
        else if (item.compareTo(tree.item) >0 ) {
            tree.left = insert(tree.right);
        }
        else
            tree.right= insert(tree.left);
        return tree;
    }

    public void delete (Comparable item) {
//        finds node, deletes and returns reference to new tree
        root = delete(item);
        if (item.compareTo(tree.info) < 0)
            return delete(tree.left);
        else if (item.compareTo(tree.info) > 0)
            tree= ShiftDelete(tree.right);
            return tree;
    }

    private ShiftDelete(BSNode node) {
        if (tree.left == null)
            return tree.right;
        else if (tree.right == null)
            return tree.left;
        else {
            replacement = getPredecessor(tree.left);
            tree.info = replacement;
            tree.left = delete(data, tree.left);
            return tree;
        }

    }

    private Comparable getPredecessor(BSNode node) {
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree.info;
    }


    public int reset(int orderType) {
//        Generates a queue of tree nodes in specified order
        int numNodes = NumberofNodes();
        ArrayQueue q = new ArrayQueue(numNodes);
        if (orderType == INORDER) {
            inOrder(root);
        }
        else if (orderType == PREORDER)
            preOrder(root);
        else if (orderType = POSTORDER) {
            postOrder(root);
        }
        return numNodes;
    }

    private inOrder(BSNode tree){
        if (tree != null) {
            inOrder(tree.left);
            q.enqueue(tree.info);
            inOrder(tree.right);}
        }
    private preOrder(BSNode tree) {
        if (tree != null) {
        q.enqueue(tree.info);
        preOrder(tree.left);
        preOrder(tree.right); }
    }

    private postOrder(BSnode tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            q.enqueue(tree.info);
        }
    }

    public Comparable getNextItem(int orderType) {
//        Returns a copy of the element at current position inf BST and advances based on orderTYpe
          return (Comparable)q.dequeue();
    }



}
