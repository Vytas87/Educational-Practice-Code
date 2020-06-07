/**********************************************************************************************
Write a method named smallestLargest that asks the user to enter numbers, then prints the
smallest and largest of all the numbers typed in by the user. You may assume the user enters a
valid number greater than 0 for the number of numbers to read. Here is an example dialogue:

                    How many numbers do you want to enter? 4
                    Number 1: 5
                    Number 2: 11
                    Number 3: -2
                    Number 4: 3
                    Smallest = -2
                    Largest = 11

***********************************************************************************************/

public static void smallestLargest() {
    Scanner input = new Scanner(System.in);
    System.out.print("How many numbers do you want to enter? ");
    int n = input.nextInt();
    
    System.out.print("Number 1: ");
    int temp = input.nextInt();
    int smallest = temp;
    int largest = temp;
    
    for (int i = 2; i <= n; i++) {
        System.out.print("Number " + i + ": ");
        temp = input.nextInt();
        if (temp < smallest) {
            smallest = temp;
        } else if (temp > largest) {
            largest = temp;
        }
    }
    
    System.out.println("Smallest = " + smallest);
    System.out.println("Largest = " + largest);
}
