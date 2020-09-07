/**********************************************************************************************
Write a method printLevel that accepts an integer parameter n and that prints the values at
level n from the left to right, one per line. We will use the convention that the overallRoot is
at level 1, that its children are at level 2, and so on. For example, if a variable tree stores
a reference to the following tree:

                                +----+
                                | 12 |
                                +----+
                               /      \
                              /        \
                          +----+      +----+
                          | 19 |      | 93 |
                          +----+      +----+
                         /      \           \
                        /        \           \
                    +----+      +----+      +----+
                    | 11 |      | 14 |      | 15 |
                    +----+      +----+      +----+
                               /
                              /
                          +----+
                          | 10 |
                          +----+

Then the call tree.printLevel(3); would produce the following output:

                    11
                    14
                    15

If there are no values at the level, your method should produce no output. Your method should
throw an IllegalArgumentException if passed a value for a level n that is less than 1.

Assume that you are adding this method to the IntTree class as defined below:

                    public class IntTree {
                        private IntTreeNode overallRoot;
                        ...
                    }

***********************************************************************************************/

public void printLevel(int n) {
    if (n < 1) {
        throw new IllegalArgumentException();
    }
    printLevel(overallRoot, 1, n);
}

private void printLevel(IntTreeNode root, int currLevel, int targetLevel) {
    if (root != null) {
        if (currLevel == targetLevel) {
            System.out.println(root.data);
        } else if (currLevel < targetLevel) {   // no need to traverse past the target level
            printLevel(root.left, currLevel + 1, targetLevel);
            printLevel(root.right, currLevel + 1, targetLevel);
        }
    }
}
