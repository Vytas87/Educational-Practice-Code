/**********************************************************************************************
Write a method deleteBack that deletes the last value (the value at the back of the list) and
returns the deleted value. If the list is empty, your method should throw a NoSuchElementException.

Assume that you are adding this method to the LinkedIntList class as defined below:

                    public class LinkedIntList {
                        private ListNode front;   // null for an empty list
                        ...
                    }

***********************************************************************************************/

public int deleteBack() {
    if (front == null) {
        throw new NoSuchElementException();
    }
    
    int value = front.data;
    if (front.next == null) {
        front = null;
    } else {    
        ListNode current = front;
        while (current.next.next != null) {
            current = current.next;
        }
        value = current.next.data;
        current.next = null;
    }
    
    return value;
}
