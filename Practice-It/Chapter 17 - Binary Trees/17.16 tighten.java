/**********************************************************************************************
Write a method tighten that eliminates branch nodes that have only one child. For example, if a
variable called tree stores the tree below at left, the call of tree.tighten(); should leave
tree storing the tree at right:

                             Before Call                             After Call
                                +---+                                  +---+
                                | 2 |                                  | 2 |
                            ___ +---+ ___                          ___ +---+ ___
                          /               \                      /               \
                      +---+               +---+              +---+               +---+
                      | 8 |               | 9 |              | 7 |               | 0 |
                      +---+               +---+              +---+               +---+
                     /                   /                  /     \             /     \
                 +---+               +---+              +---+     +---+     +---+     +---+
                 | 7 |               | 6 |              | 4 |     | 3 |     | 4 |     | 5 |
                 +---+               +---+              +---+     +---+     +---+     +---+
                /     \                   \
            +---+     +---+               +---+
            | 4 |     | 1 |               | 0 |
            +---+     +---+               +---+
                           \             /     \
                           +---+     +---+     +---+
                           | 3 |     | 4 |     | 5 |
                           +---+     +---+     +---+

The nodes that stored the values 8, 9, 6, and 1 have been eliminated because each had one child.
When a node is removed, it is replaced by its child. This can lead to multiple replacements
because the child might itself be replaced (as in the case of 9 which is replaced by 6 which is
replaced by 0).

Assume that you are adding this method to the IntTree class as defined below:

                    public class IntTree {
                        private IntTreeNode overallRoot;
                        ...
                    }

***********************************************************************************************/

public void tighten() {
    overallRoot = tighten(overallRoot);
}

private IntTreeNode tighten(IntTreeNode root) {
    if (root == null) {
        return null;
    } else if (root.right == null && root.left != null) {
        return tighten(root.left);
    } else if (root.left == null && root.right != null) {
        return tighten(root.right);
    } else {
        root.left = tighten(root.left);
        root.right = tighten(root.right);
        return root;
    }
}
