/**********************************************************************************************
Write a method copyStack that takes a stack of integers as a parameter and returns a copy of
the original stack (i.e., a new stack with the same values as the original, stored in the same
order as the original). Your method should create the new stack and fill it up with the same
values that are stored in the original stack. It is not acceptable to return the same stack
passed to the method; you must create, fill, and return a new stack.

You will be removing values from the original stack to make the copy, but you have to be sure to
put them back into the original stack in the same order before you are done. In other words,
when your method is done executing, the original stack must be restored to its original state
and you will return the new independent stack that is in the same state. You may use one queue
as auxiliary storage.
***********************************************************************************************/

public static Stack<Integer> copyStack(Stack<Integer> s) {
    Stack<Integer> temp = new Stack<Integer>();
    Stack<Integer> result = new Stack<Integer>();
    while (!s.isEmpty()) {
        temp.push(s.pop());
    }
    while (!temp.isEmpty()) {
        int n = temp.pop();
        s.push(n);
        result.push(n);
    }
    return result;
}
