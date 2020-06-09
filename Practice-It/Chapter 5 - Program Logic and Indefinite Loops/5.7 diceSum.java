/**********************************************************************************************
Write a method named diceSum that prompts the user for a desired sum, then repeatedly rolls two
six-sided dice until their sum is the desired sum. Here is the expected dialogue with the user:

                    Desired dice sum: 9
                    4 and 3 = 7
                    3 and 5 = 8
                    5 and 6 = 11
                    5 and 6 = 11
                    1 and 5 = 6
                    6 and 3 = 9

***********************************************************************************************/

public static void diceSum() {
    Scanner input = new Scanner(System.in);
    Random random = new Random();
    System.out.print("Desired dice sum: ");
    int sum = input.nextInt();
    
    int dice1 = random.nextInt(6) + 1;
    int dice2 = random.nextInt(6) + 1;
    int rolledSum = dice1 + dice2;
    System.out.println(dice1 + " and " + dice2 + " = " + rolledSum);
    while (rolledSum != sum) {
        dice1 = random.nextInt(6) + 1;
        dice2 = random.nextInt(6) + 1;
        rolledSum = dice1 + dice2;
        System.out.println(dice1 + " and " + dice2 + " = " + rolledSum);
    }
}
