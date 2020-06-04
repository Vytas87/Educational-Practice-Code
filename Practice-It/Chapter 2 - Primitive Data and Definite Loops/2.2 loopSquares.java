/**********************************************************************************************
Write a for loop that produces the following output:

                    1 4 9 16 25 36 49 64 81 100

For added challenge, try to modify your code so that it does not need to use the * multiplica-
tion operator. (It can be done! Hint: Look at the differences between adjacent numbers.)
***********************************************************************************************/

int sum = 0;

for (int i = 1; i <= 9; i++) {
    sum += i + i - 1;
    System.out.print(sum + " ");
}

System.out.println(sum += i + i - 1);
