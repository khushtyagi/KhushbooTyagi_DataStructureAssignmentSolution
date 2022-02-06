package khusub.another.problem2;

public class Main {
    Node node;
    static Node prev = null;
    static Node head = null;

    public static void flattenSkewedTree(Node root, int order) {
        // Base Case
        if (root == null)
            return;

        // Condition to check the order in which the skewed tree to maintained
        if (order == 0) {
            flattenSkewedTree(root.left, order);
        }

        Node right = root.right;

        // Condition to check if the root Node of the skewed tree is not defined
        if (head == null)
            head = root;
         else
            prev.right = root;

        root.left = null;
        prev = root;

        // Similarly, recurse for the left / right subtree on the basis of the order required
        if (order == 0)
            flattenSkewedTree(right, order);
    }

    // Function to traverse the right skewed tree using recursion
    public static void traverseRightSkewed(Node root) {
        if (root == null)
            return;

        // Right skewed for ascending order
        System.out.print(root.val + " ");
        traverseRightSkewed(root.right);
    }

    // Driver Code
    public static void main(String[] args) {
        //         50
        //		 /  \
        // 	   30    60
        //    /\     / \
        //  10 null 55 null

        Main tree = new Main();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);

        // Order of the Skewed tree can be defined as follows -
        // For Increasing order - 0
        // For Decreasing order - 1
        int order = 0;
        flattenSkewedTree(tree.node, order);
        System.out.println("The node values of BST in ascending order");
        traverseRightSkewed(head);
    }
}

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}