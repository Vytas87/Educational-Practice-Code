/**********************************************************************************************
Write a method removeEvens that removes the values in even-numbered indexes from a list,
returning a new list containing those values in their original order. For example, if a variable
list1 stores these values:

                    list1: [8, 13, 17, 4, 9, 12, 98, 41, 7, 23, 0, 92]

And the following call is made:

                    LinkedIntList list2 = list1.removeEvens(); 

After the call, list1 and list2 should store the following values:

                    list1: [13, 4, 12, 41, 23, 92]
                    list2: [8, 17, 9, 98, 7, 0]

Notice that the values stored in list2 are the values that were originally in even-valued positions
(index 0, 2, 4, etc.) and that these values appear in the same order as in the original list. Also
notice that the values left in list1 also appear in their original relative order. Recall that
LinkedIntList has a zero-argument constructor that returns an empty list. You may not call any
methods of the class other than the constructor to solve this problem. You are not allowed to
create any new nodes or to change the values stored in data fields to solve this problem; You must
solve it by rearranging the links of the list.

Assume that you are adding this method to the LinkedIntList class as defined below:

                    public class LinkedIntList {
                        private ListNode front;   // null for an empty list
                        ...
                    }

***********************************************************************************************/

public LinkedIntList removeEvens() {
    LinkedIntList result = new LinkedIntList();
    ListNode current = front;
    
    if (current != null) {
        result.front = current;
        front = current.next;
        current = front;
    
        ListNode resultCurrent = result.front;
        while (current != null && current.next != null) {
            resultCurrent.next = current.next;
            current.next = current.next.next;
            resultCurrent = resultCurrent.next;
            current = current.next;
        }
        resultCurrent.next = null;
    }
    return result;
}
