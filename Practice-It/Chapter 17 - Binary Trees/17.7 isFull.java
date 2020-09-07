/**********************************************************************************************
Write a method isFull that returns whether or not a binary tree is full (true, if it is, false
if otherwise). A full binary tree is one in which every node has 0 or 2 children. Below are examples of each.

                    full tree               not a full tree
                      +---+                     +---+
                      | 2 |                     | 7 |
                      +---+                     +---+
                     /     \                   /     \
                 +---+     +---+           +---+     +---+
                 | 3 |     | 1 |           | 4 |     | 0 |
                 +---+     +---+           +---+     +---+
                /     \                   /     \         \
            +---+     +---+           +---+     +---+     +---+
            | 8 |     | 7 |           | 9 |     | 2 |     | 8 |
            +---+     +---+           +---+     +---+     +---+

By definition, the empty tree is considered full.

Assume that you are adding this method to the IntTree class as defined below:

                    public class IntTree {
                        private IntTreeNode overallRoot;
                        ...
                    }

***********************************************************************************************/

public boolean isFull() {
    return isFull(overallRoot);
}

private boolean isFull(IntTreeNode root) {
    if (root == null)
        return true;
    else if (root.left != null && root.right == null ||
             root.left == null && root.right != null)
        return false;
    else
        return isFull(root.right) && isFull(root.left);
}
