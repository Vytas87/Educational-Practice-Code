/**********************************************************************************************
    This is the first project in the course. It tests the ability to use the very fundamental
    concepts of the introduction to Java: structuring code into methods that carry out specific
    tasks according to SOLID principles, variable declaration, implementing interacive code,
    etc.
    
    The task is to create an interactive program that asks the user various practical questions
    about the planned trip and gives answers.
***********************************************************************************************/

import java.util.Scanner;

public class TripPlanner {

    public static void main (String[] args){
        greeting();
        travelTimeBudget();
        travelDistance();
        timeDifference();
        cntryArea();
    }

    public static void greeting(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Nice to meet you, " + name + ". Where are you traveling to? ");
        String destination = input.nextLine();
        System.out.println("Great! " + destination + " sounds like a great trip!");
        System.out.println();
    }

    public static void travelTimeBudget () {
        Scanner input = new Scanner(System.in);
        System.out.print("How many days are you going to spend traveling? ");
        int trvlTime = input.nextInt();
        System.out.print("How much money, in DKK, are you planning to spend on your trip? ");
        int budget = input.nextInt();
        System.out.print("What is the international three letter symbol of the currency in your travel destination? ");
        String currency = input.next();
        System.out.print("How many " + currency + " are there in 100 DKK? ");
        double crncyRate = input.nextDouble();
        System.out.println();

        System.out.print("If you are traveling for " + trvlTime + " days that is the same as " + trvlTime*24);
        System.out.println(" hours, or " + trvlTime*24*60 + " minutes.");
        System.out.print("If you are going to spend " + budget + " DKK");
        System.out.println(" that means you can spend up to " + (int)(budget/trvlTime*100)/100.0 + " DKK per day.");
        System.out.print("Your total budget in " + currency + " is " + (int) (budget*crncyRate)/100.0 + " " + currency);
        System.out.println(" , which is " + (int)(budget*crncyRate/trvlTime)/100.0 + " " + currency + " per day");
        System.out.println();
    }

    public static void travelDistance () {
        Scanner input = new Scanner(System.in);
        int r = 6378;
        System.out.print("What is your home longitude in degrees? ");
        double lon1 = input.nextDouble();
        System.out.print("What is your home latitude in degrees? ");
        double lat1 = input.nextDouble();
        System.out.print("What is your destinantion longitude in degrees? ");
        double lon2 = input.nextDouble();
        System.out.print("What is your destinantion latitude in degrees? ");
        double lat2 = input.nextDouble();
        double fi1 = Math.toRadians(lat1);
        double fi2 = Math.toRadians(lat2);
        double la1 = Math.toRadians(lon1);
        double la2 = Math.toRadians(lon2);
        double sin2lat = Math.pow(Math.asin((fi2-fi1)/2),2);
        double cosLatsSin2lon = Math.cos(fi1)*Math.cos(fi2)*Math.pow(Math.asin((la2-la1)/2),2);
        double d = 2*r*Math.asin(Math.sqrt(sin2lat+cosLatsSin2lon));
        System.out.println("The distance between your home and your destination is " + (int)d + " km.");
        System.out.println();
    }

    public static void timeDifference () {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        int hours = input.nextInt();
        System.out.print("That means that when it is midnight at home it will be " + (24 + hours) % 24);
        System.out.println(":00 in your travel destination,");
        System.out.println("and when it is noon at home it will be " + (12 + hours) + ":00.");
        System.out.println();
    }

    public static void cntryArea () {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the square area of your destination country in km^2? ");
        int areaInKm = input.nextInt();
        System.out.println("In miles^2, that is " + (int)(areaInKm*0.38601369) +".");
        System.out.println();
    }

}
