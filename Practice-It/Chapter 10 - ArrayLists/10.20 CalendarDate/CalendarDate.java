public class CalendarDate implements Comparable<CalendarDate> {
    private int year;
    private int month;
    private int day;
    
    public CalendarDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public int getYear() {
        return year;
    }
    
    public int getMonth() {
        return month;
    }
    
    public int getDay() {
        return day;
    }
    
    public String toString() {
        String result = year + "/";
        if (month < 10) {
            result += "0";
        }
        result += month + "/";
        if (day < 10) {
            result += "0";
        }
        result += day;
        return result;
    }
    
// YOUR CODE GOES HERE

}
