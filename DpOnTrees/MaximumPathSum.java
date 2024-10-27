package DpOnTrees;

public class MaximumPathSum {

    /*
    Given a tree find the path with maximum sum, 
    Example here has 20->2->10>10 = 42 as max sum
      10
     / \
    2   10
   / \    \
  20  1   -25
           / \
          3   4    
    */

    public static void main(String[] args) {
        int[] res = new int[]{Integer.MIN_VALUE};
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10,
                                    new BinaryTreeNode<>(2,
                                    new BinaryTreeNode<>(20), new BinaryTreeNode<>(1)),  new BinaryTreeNode<>(10,
                                                                                        null, new BinaryTreeNode<>(-25,
                                                                                                                new BinaryTreeNode<>(3), new BinaryTreeNode<>(4))));
        //BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, new BinaryTreeNode<>(2), new BinaryTreeNode<>(3));
        new MaximumPathSum().maxSumPath(root, res);
        System.out.println("result: "+res[0]);
    }

    private int maxSumPath(BinaryTreeNode<Integer> root, int[] res){
        if(root == null) return 0;

        int leftSum = maxSumPath(root.left, res);
        int rightSum = maxSumPath(root.right, res);
        // do not include current node as root
        int temp = Math.max(root.val + Math.max(leftSum, rightSum), root.val);
        // current node as root
        int ans = Math.max(temp, root.val + leftSum + rightSum);

        res[0] = Math.max(ans, res[0]);

        return temp;
    }
}
