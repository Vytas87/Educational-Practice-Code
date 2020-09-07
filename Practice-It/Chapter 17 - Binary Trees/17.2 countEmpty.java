/**********************************************************************************************
Write a method countEmpty that returns the number of empty branches in a tree. An empty tree is
considered to have one empty branch (the tree itself). For non-empty trees, your method(s)
should count the total number of empty branches among the nodes of the tree. A leaf node has
two empty branches. A node with one non-empty child has one empty branch. A node with two non-
empty children (a full branch) has no empty branches. For example the tree below has 15 empty
branches (indicated by circles):

                                        +---+
                                        | 0 |
                                        +---+
                                       /     \
                                   +---+     +---+
                                   | 4 |     | 6 |
                                   +---o     +---+
                                  /         /     \
                              +---+     +---+     +---+
                              | 3 |     | 0 |     | 1 |
                              +---o     +---+     o---+
                             /         /     \         \
                         +---+     +---+     +---+     +---+
                         | 4 |     | 3 |     | 8 |     | 5 |
                         +---o     o---+     o---o     +---+
                        /               \             /     \
                    +---+               +---+     +---+     +---+
                    | 1 |               | 9 |     | 2 |     | 7 |
                    o---o               o---o     o---o     o---o

Assume that you are adding this method to the IntTree class as defined below:

                    public class IntTree {
                        private IntTreeNode overallRoot;
                        ...
                    }

***********************************************************************************************/

public int countEmpty() {
    return countEmpty(overallRoot);
}

private int countEmpty(IntTreeNode root) {
    if (root == null) {
        return 1;
    } else {
        return countEmpty(root.left) + countEmpty(root.right);
    }
}
