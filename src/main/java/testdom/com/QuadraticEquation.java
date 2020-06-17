package testdom.com;

public class QuadraticEquation {
/*
* Implement the function findRoots to find the roots of the quadratic equation: ax2 + bx + c = 0.
* If the equation has only one solution, the function should return that solution as both elements of the testdom.com.Roots.
* The equation will always have at least one solution.
* The roots of the quadratic equation can be found with the following formula: A quadratic equation.
* For example, the roots of the equation 2x2 + 10x + 8 = 0 are -1 and -4.
* Conclusion: it's better to take in account some impossible arithmetical operation like Math.sqrt of negative valuer; divide by zero etc producing NaN value
 **/
    public static Roots findRoots(double a, double b, double c) {

        double  d = Math.sqrt((b*b)-4*a*c);
        double x1 = (-b+d)/(2*a);
        double x2 = (-b-d)/(2*a);

        return new Roots(x1,x2);
    }

    public static void main(String[] args) {
        Roots roots = QuadraticEquation.findRoots(10, 10, 8);
        System.out.println("testdom.com.Roots: " + roots.x1 + ", " + roots.x2);
    }
}

class Roots {
    public final double x1, x2;

    public Roots(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}
