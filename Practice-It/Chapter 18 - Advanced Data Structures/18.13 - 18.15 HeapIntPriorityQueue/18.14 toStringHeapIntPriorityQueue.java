/**********************************************************************************************
Write a method in the HeapIntPriorityQueue class called toString that returns a string represen-
tation of the elements in the queue, such as "[42, 50, 45, 78, 61]". The order of the elements
in the string does not matter as long as they are all present in the proper format.
***********************************************************************************************/

public String toString() {
    StringBuilder build = new StringBuilder();
    build.append("[");
    if (size >= 1) {
        build.append(elementData[1]);
    }
    for (int i = 2; i <= size; i++) {
        build.append(", ");
        build.append(elementData[i]);
    }
    build.append("]");
    return build.toString();
}
