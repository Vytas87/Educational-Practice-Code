/**********************************************************************************************
Write a method combineWith that could be added to the IntTree class. The method accepts another
binary tree of integers as a parameter and combines the two trees into a new third tree which
is returned. The new tree's structure should be a union of the structures of the two original
trees. It should have a node in any location where there was a node in either of the original
trees (or both). The nodes of the new tree should store an integer indicating which of the
original trees had a node at that position (1 if just the first tree had the node, 2 if just
the second tree had the node, 3 if both trees had the node).

For example, suppose IntTree variables t1 and t2 have been initialized and store the following trees:

                              t1                                  t2
                            +----+                              +----+
                            |  9 |                              |  0 |
                            +----+                              +----+
                           /      \                            /      \
                          /        \                          /        \
                      +----+      +----+                  +----+      +----+
                      |  6 |      | 14 |                  | -3 |      |  8 |
                      +----+      +----+                  +----+      +----+
                     /      \           \                /           /      \
                    /        \           \              /           /        \
                +----+      +----+      +----+      +----+      +----+      +----+
                |  9 |      |  2 |      | 11 |      |  8 |      |  5 |      |  6 |
                +----+      +----+      +----+      +----+      +----+      +----+
                           /                                          \
                          /                                            \
                      +----+                                          +----+
                      |  4 |                                          |  1 |
                      +----+                                          +----+

Then the following call:

                    IntTree t3 = t1.combineWith(t2);

Will return a reference to the following tree:

                                    t3
                                   +---+
                                   | 3 |
                               ___ +---+ ___
                             /               \
                         +---+               +---+
                         | 3 |               | 3 |
                         +---+               +---+
                        /     \             /     \
                    +---+     +---+     +---+     +---+
                    | 3 |     | 1 |     | 2 |     | 3 |
                    +---+     +---+     +---+     +---+
                             /               \
                         +---+               +---+
                         | 1 |               | 2 |
                         +---+               +---+

You may define private helper methods to solve this problem, but otherwise you may not call any
other methods of the class nor create any data structures such as arrays, lists, etc. Your
method should not change the structure or contents of either of the two trees being compared.

Assume that you are adding this method to the IntTree class as defined below:

                    public class IntTree {
                        private IntTreeNode overallRoot;
                        ...
                    }

***********************************************************************************************/

public IntTree combineWith(IntTree other) {
    IntTree result = new IntTree();
    result.overallRoot = combineWith(overallRoot, other.overallRoot);
    return result;
}

private IntTreeNode combineWith(IntTreeNode root1, IntTreeNode root2) {
    if (root1 == null && root2 == null) {
        return null;
    } else if (root1 != null && root2 == null) {
        IntTreeNode root = new IntTreeNode(1);
        root.left = combineWith(root1.left, null);
        root.right = combineWith(root1.right, null);
        return root;
    } else if (root1 == null && root2 != null) {
        IntTreeNode root = new IntTreeNode(2);
        root.left = combineWith(null, root2.left);
        root.right = combineWith(null, root2.right);
        return root;
    } else {
        IntTreeNode root = new IntTreeNode(3);
        root.left = combineWith(root1.left, root2.left);
        root.right = combineWith(root1.right, root2.right);
        return root;
    }
}
