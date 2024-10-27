package DpOnTrees;

public class BinaryTreeNode<V> {
    V val;
    BinaryTreeNode<V> left;
    BinaryTreeNode<V> right;

    public BinaryTreeNode(V _v){
        val = _v;
        left = null;
        right = null;
    }

    public BinaryTreeNode(V _v, BinaryTreeNode<V> _left, BinaryTreeNode<V> _right){
        val = _v;
        left = _left;
        right = _right;
    }

    public BinaryTreeNode<V> createBinaryTree(int[] arr){
        //
        return null;
    }
}
