/**********************************************************************************************
Write a method toString2 for a binary tree of integers. (On your section handout the method is
called toString, but Practice-It needs you to call your method toString2 because toString is
already used for another purpose.) The method should return "empty" for an empty tree. For a
leaf node, it should return the data in the node as a String. For a branch node, it should
return a parenthesized String that has three elements separated by commas:

                    1. The data at the root.
                    2. A String representation of the left subtree.
                    3. A String representation of the right subtree.

For example, if a variable tree stores a reference to the following tree:

                              +---+
                              | 2 |
                              +---+
                             /     \
                         +---+     +---+
                         | 8 |     | 1 |
                         +---+     +---+
                        /         /     \
                    +---+     +---+     +---+
                    | 0 |     | 7 |     | 6 |
                    +---+     +---+     +---+
                             /               \
                         +---+               +---+
                         | 4 |               | 9 |
                         +---+               +---+

Then the call tree.toString2(); should return the following String:

                    "(2, (8, 0, empty), (1, (7, 4, empty), (6, empty, 9)))"

The quotes above are used to indicate that this is a String but should not be included in the
String you return.

(Note: On the original section handout, this method is called toString, but Practice-It already
defines a toString method for IntTree for use in other problems, so this method must be called
toString2 to avoid a conflict.)

Assume that you are adding this method to the IntTree class as defined below:

                    public class IntTree {
                        private IntTreeNode overallRoot;
                        ...
                    }

***********************************************************************************************/

public String toString2() {
    return toString2(overallRoot).toString();
}

private StringBuilder toString2(IntTreeNode root) {
    StringBuilder build = new StringBuilder();
    if (root == null) {
        build.append("empty");
    } else {
        if (root.left != null || root.right != null) {
            build.append("(");
            build.append(root.data + ", ");
            build.append(toString2(root.left) + ", ");
            build.append(toString2(root.right) + ")");
        } else {
            build.append(root.data);
        }
    }
    return build;
}
