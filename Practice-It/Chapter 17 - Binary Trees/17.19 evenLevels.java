/**********************************************************************************************
Write a method evenLevels that could be added to the IntTree class from lecture and section.
The method should make sure that all branches end on an even level. If a leaf node is on an odd
level it should be removed from the tree. We will define the root as being on level 1.

The following table shows the results of a call of your method on a particular tree:

                      before                                            after
                      +----+                                            +----+
                      | 67 |                                            | 67 |
                      +----+                                            +----+
                   /          \                                      /          \
                /                \                                /                \
           +----+                +----+                      +----+                +----+
           | 80 |                | 52 |                      | 80 |                | 52 |
           +----+                +----+                      +----+                +----+
          /      \              /      \                           \               /
         /        \            /        \                           \             /
     +----+     +----+      +----+    +----+                      +----+      +----+
     | 16 |     | 21 |      | 99 |    | 12 |                      | 21 |      | 99 |
     +----+     +----+      +----+    +----+                      +----+      +----+ 
                 /  \           \                                  /  \           \
                /    \           \                                /    \           \
            +----+  +----+      +----+                        +----+  +----+      +----+
            | 45 |  | 33 |      | 67 |                        | 45 |  | 33 |      | 67 |
            +----+  +----+      +----+                        +----+  +----+      +----+
                        \
                         \
                         +----+
                         | 22 |
                         +----+

You may define private helper methods to solve this problem, but otherwise you may not call any
other methods of the tree class nor create any data structures such as arrays, lists, etc. You
should not construct any new node objects or change the data of any nodes. For full credit, your
solution must be recursive and properly utilize the x = change(x) pattern.

Assume that you are adding this method to the IntTree class as defined below:

                    public class IntTree {
                        private IntTreeNode overallRoot;
                        ...
                    }

***********************************************************************************************/

public void evenLevels() {
    overallRoot = evenLevels(overallRoot, 1);
}

private IntTreeNode evenLevels(IntTreeNode root, int level) {
    if (root == null) {
        return null;
    } else if (root.left == null && root.right == null && level % 2 == 1) {
        return null;
    } else {
        root.left = evenLevels(root.left, level + 1);
        root.right = evenLevels(root.right, level + 1);
        return root;
    }
}
