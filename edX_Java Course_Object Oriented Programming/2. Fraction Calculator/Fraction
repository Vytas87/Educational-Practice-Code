public class Fraction {
    // Fields
    private int numerator;
    private int denominator;

    // Constructors
    public Fraction (int n, int m){

        if (m == 0){ // division by 0 is undefined
            throw new IllegalArgumentException("The denominator cannot be 0.");
        } else if (m < 0){ // if the fraction is <0, "-" is kept with the numerator
            this.numerator = - n;
            this.denominator = - m;
        } else {
            this.numerator = n;
            this.denominator = m;
        }
    }

    public Fraction (int n){
        this(n, 1);
    }

    public Fraction (){
        this(0);
    }

    // Methods
    public int getNumerator(){
        return this.numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    public String toString(){

        if (numerator == 0){
            return "0";
        } else if (denominator == 1){
            return "" + numerator;
        } else {
            return numerator + "/" + denominator;
        }
    }

    public double toDouble(){
        return (double) numerator / (double) denominator;
    }

    public Fraction add(Fraction other){

        int denominatorNew = this.denominator * other.denominator;
        int numeratorNew = this.numerator * other.denominator + other.numerator * this.denominator;

        return new Fraction(numeratorNew, denominatorNew);
    }

    public Fraction subtract(Fraction other){

        int denominatorNew = this.denominator * other.denominator;
        int numeratorNew = this.numerator * other.denominator - other.numerator * this.denominator;

        return new Fraction(numeratorNew, denominatorNew);
    }

    public Fraction multiply(Fraction other){

        int numeratorNew = this.numerator * other.numerator;
        int denominatorNew = this.denominator * other.denominator;

        return new Fraction(numeratorNew, denominatorNew);
    }

    public Fraction divide(Fraction other){

        if (other.getNumerator() == 0){
            throw new IllegalArgumentException("The denominator cannot be a 0.");
        } else {
            int numeratorNew = this.numerator * other.denominator;
            int denominatorNew = this.denominator * other.numerator;

            return new Fraction(numeratorNew, denominatorNew);
        }
    }

    public boolean equals(Object other){

        if (other instanceof Fraction){
            Fraction o = (Fraction) other;
            return this.subtract(o).getNumerator() == 0;
        } else {
            return false;
        }
    }

    public Fraction toLowestTerms(){

        int n = gcd(Math.abs(this.numerator), denominator);
        this.numerator /= n;
        this.denominator /= n;

        return this;
    }

    public static int gcd(int a, int b){ // greatest common divisor

        while (a > 0 && b > 0){
            int c = a % b;
            a = b;
            b = c;
        }

        return a;
    }
}
