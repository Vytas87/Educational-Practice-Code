/**********************************************************************************************
Write a method depthSum that returns the sum of the values stored in a binary tree of integers
weighted by the depth of each value. You should return the value at the overallRoot plus 2 times
the values stored at the next level of the tree plus 3 times the values stored at the next level
of the tree plus 4 times the values stored at the next level of the tree and so on. For example,
in the tree below:

                              +---+
                              | 9 |
                              +---+
                             /     \
                         +---+     +---+
                         | 7 |     | 6 |
                         +---+     +---+
                        /     \         \
                    +---+     +---+     +---+
                    | 3 |     | 2 |     | 4 |
                    +---+     +---+     +---+
                             /               \
                         +---+               +---+
                         | 5 |               | 2 |
                         +---+               +---+

The sum would be computed as:

                    1 * 9 + 2 * (7 + 6) + 3 * (3 + 2 + 4) + 4 * (5 + 2) = 90

Assume that you are adding this method to the IntTree class as defined below:

                    public class IntTree {
                        private IntTreeNode overallRoot;
                        ...
                    }

***********************************************************************************************/

public int depthSum() {
    return depthSum(overallRoot, 1);
}

private int depthSum(IntTreeNode root, int level) {
    if (root == null) {
        return 0;
    } else {
        return level * root.data + depthSum(root.left, level + 1) + depthSum(root.right, level + 1);
    }
}
