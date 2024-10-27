package DpOnTrees;

public class DiameterOfBinaryTree {

    /**
     * Between any leaf nodes of the tree, what is the longest path legth.
    */

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, 
                                        null, 
                                        new BinaryTreeNode<Integer>(2));

        int result = new DiameterOfBinaryTree().diameterOfTree(root, new int[]{0});
        System.out.println("result: "+result);
    }

    private int diameterOfTree(BinaryTreeNode<Integer> root, int[] res){
        // base condition
        if(root == null) return 0;

        // 
        int left = diameterOfTree(root.left, res);
        int right = diameterOfTree(root.right, res);

        int temp = 1 + Math.max(left, right);
        int ans = Math.max(temp, 1 + left + right);
        res[0] = Math.max(res[0], ans);
        return temp;
    }
}

