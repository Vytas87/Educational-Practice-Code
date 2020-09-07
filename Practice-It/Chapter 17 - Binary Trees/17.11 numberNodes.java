/**********************************************************************************************
Write a method numberNodes that changes the data stored in a binary tree, assigning sequential
integers starting with 1 to each node so that a pre-order traversal will produce the numbers in
order(1, 2, 3, etc.). For example, given the tree referenced by tree below at left, the call of
tree.numberNodes(); would overwrite the existing data assigning the nodes values from 1 to 6 so
that a pre-order traversal of the tree would produce 1, 2, 3, 4, 5, 6.

                       Before Call                      After Call
                          +---+                           +---+
                          | 7 |                           | 1 |
                          +---+                           +---+
                         /     \                         /     \
                     +---+     +---+                 +---+     +---+
                     | 3 |     | 9 |                 | 2 |     | 5 |
                     +---+     +---+                 +---+     +---+
                    /     \         \               /     \         \
                +---+     +---+     +---+       +---+     +---+     +---+
                | 9 |     | 2 |     | 0 |       | 3 |     | 4 |     | 6 |
                +---+     +---+     +---+       +---+     +---+     +---+

You are not to change the structure of the tree. You are simply changing the values stored in
the data fields. Your method should return a count of how many nodes were in the tree.

Assume that you are adding this method to the IntTree class as defined below:

                    public class IntTree {
                        private IntTreeNode overallRoot;
                        ...
                    }

***********************************************************************************************/

public int numberNodes() {
    return numberNodes(overallRoot, 0);
}

private int numberNodes(IntTreeNode root, int count) {
    if (root != null) {
        count++;
        root.data = count;
        count = numberNodes(root.left, count);
        count = numberNodes(root.right, count);
    }
    return count;
}
