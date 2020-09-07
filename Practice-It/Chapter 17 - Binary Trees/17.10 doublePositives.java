/**********************************************************************************************
Write a method doublePositives that doubles all data values greater than 0 in a binary tree of
integers. For example, the before and after of a call to doublePositives on a sample tree
areshown below:

                         Before Call                              After Call
                            +----+                                  +----+
                            | -9 |                                  | -9 |
                            +----+                                  +----+
                           /      \                                /      \
                          /        \                              /        \
                      +----+      +----+                      +----+      +----+
                      |  3 |      | 15 |                      |  6 |      | 30 |
                      +----+      +----+                      +----+      +----+
                     /           /      \                    /           /      \
                    /           /        \                  /           /        \
                +----+      +----+      +----+          +----+      +----+      +----+
                |  0 |      | 12 |      | 24 |          |  0 |      | 24 |      | 48 |
                +----+      +----+      +----+          +----+      +----+      +----+
                           /      \                                /      \
                          /        \                              /        \
                      +----+      +----+                      +----+      +----+
                      |  6 |      | -3 |                      | 12 |      | -3 |
                      +----+      +----+                      +----+      +----+

Assume that you are adding this method to the IntTree class as defined below:

                    public class IntTree {
                        private IntTreeNode overallRoot;
                        ...
                    }

***********************************************************************************************/

public void doublePositives() {
    doublePositives(overallRoot);
}

private void doublePositives(IntTreeNode root) {
    if (root != null) {
        if (root.data > 0) root.data *= 2;
        if (root.left != null) doublePositives(root.left);
        if (root.right != null) doublePositives(root.right);
    }
}
