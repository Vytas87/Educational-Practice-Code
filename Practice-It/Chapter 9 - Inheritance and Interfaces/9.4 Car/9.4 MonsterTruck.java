/**********************************************************************************************
Write a class MonsterTruck whose methods have the behavior below. Don't just print/return the
output; whenever possible, use inheritance to reuse behavior from the superclass.

Method     Output/Return
m1          monster 1
m2          truck 1
            car 1
toString    "monster vroomvroom"

***********************************************************************************************/

public class MonsterTruck extends Truck{
    public void m1(){
        System.out.println("monster 1");
    }
    
    public void m2(){
        super.m1();
        super.m2();
    }
    
    public String toString(){
        return "monster " + super.toString();
    }
}
