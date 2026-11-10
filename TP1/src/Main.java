//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Rational n1 = new Rational(5,3);
        Rational n2 = new Rational (4,5);
        Rational n3 = new Rational (1,2);
        Rational n4 = new Rational (5,3);
        System.out.println(n1); //toString
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n1 == n4);
        System.out.println(n1.equals(n4));
        Rational n5 = n1.mul(n2);
        Rational n6 = n5.opposite();
        System.out.println(n5);

    }
}