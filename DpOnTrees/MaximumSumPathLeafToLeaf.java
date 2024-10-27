package DpOnTrees;

public class MaximumSumPathLeafToLeaf {
    public static void main(String[] args) {
        int[] res = new int[]{Integer.MIN_VALUE};
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10,
                                    new BinaryTreeNode<>(2,
                                    new BinaryTreeNode<>(20), new BinaryTreeNode<>(1)),  new BinaryTreeNode<>(10,
                                                                                        null, new BinaryTreeNode<>(-25,
                                                                                                                new BinaryTreeNode<>(3), new BinaryTreeNode<>(4))));
        //BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, new BinaryTreeNode<>(2), new BinaryTreeNode<>(3));
        new MaximumSumPathLeafToLeaf().maxSumPath(root, res);
        System.out.println("result: "+res[0]);
    }

    private int maxSumPath(BinaryTreeNode<Integer> root, int[] res){
        if(root == null) return 0;

        int leftSum = maxSumPath(root.left, res);
        int rightSum = maxSumPath(root.right, res);
        // do not include current node as root
        // if node is leaf only then send the current value only
        int temp = root.val + Math.max(leftSum, rightSum);
        
        // if left root is null
        if(root.left == null){
            return root.val + rightSum;
        }
        // if right root is null
        if(root.right == null){
            return root.val + leftSum;
        }

        res[0] = Math.max(root.val + leftSum + rightSum, res[0]);

        return temp;
    }
}
