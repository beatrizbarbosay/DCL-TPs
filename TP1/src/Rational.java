/**
 * Represents an immutable rational number.
 * A rational number is stored as a numerator and a denominator
 * and is automatically reduced to its irreducible form when created.
 */
public class Rational {

    private int numerador;
    private int denominador;

    /**
     * Creates a rational number with the given numerator and denominator.
     * The fraction is automatically reduced using the greatest common divisor.
     *
     * @param numerador the numerator of the rational number
     * @param denominador the denominator of the rational number
     */
    public Rational(int numerador, int denominador) {
        int gcd = gcd(numerador, denominador);
        this.numerador = numerador / gcd;
        this.denominador = denominador / gcd;
    }

    /**
     * Returns the numerator of this rational number.
     *
     * @return the numerator
     */
    public int getNumerador() {
        return numerador;
    }

    /**
     * Returns the denominator of this rational number.
     *
     * @return the denominator
     */
    public int getDenominador() {
        return denominador;
    }

    /**
     * Returns a textual representation of this rational number
     * in the form numerator/denominator.
     *
     * @return a string representation of this rational number
     */
    @Override
    public String toString() {
        return this.getNumerador() + "/" + this.getDenominador();
    }

    /**
     * Compares this rational number with another object.
     * Two rational numbers are considered equal when they have
     * the same numerator and denominator.
     *
     * @param obj the object to compare with this rational number
     * @return true if the objects represent the same rational number,
     *         false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rational)) {
            return false;
        }

        Rational outro = (Rational) obj;

        return (this.numerador == outro.numerador)
                && (this.denominador == outro.denominador);
    }

    /**
     * Adds another rational number to this rational number.
     * Neither operand is modified; a new Rational object is returned.
     *
     * @param outro the rational number to add
     * @return a new Rational representing the sum
     */
    public Rational sum(Rational outro) {
        int resultadoNumerador =
                (outro.denominador * this.numerador)
                        + (outro.numerador * this.denominador);

        int resultadoDenominador =
                this.denominador * outro.denominador;

        return new Rational(resultadoNumerador, resultadoDenominador);
    }

    /**
     * Multiplies this rational number by another rational number.
     * Neither operand is modified.
     *
     * @param outro the rational number to multiply by
     * @return a new Rational representing the product
     */
    public Rational mul(Rational outro) {
        int resultadoNumerador =
                outro.numerador * this.numerador;

        int resultadoDenominador =
                outro.denominador * this.denominador;

        return new Rational(resultadoNumerador, resultadoDenominador);
    }

    /**
     * Returns the additive inverse of this rational number.
     * The current object is not modified.
     *
     * @return a new Rational representing the opposite value
     */
    public Rational opposite() {
        return new Rational(-this.numerador, this.denominador);
    }

    /**
     * Subtracts another rational number from this rational number.
     * The subtraction is implemented as the addition of the opposite value.
     *
     * @param outro the rational number to subtract
     * @return a new Rational representing the difference
     */
    public Rational sub(Rational outro) {
        return this.sum(outro.opposite());
    }

    /**
     * Returns the multiplicative inverse of this rational number.
     *
     * @return a new Rational with the numerator and denominator exchanged
     */
    public Rational invert() {
        return new Rational(this.denominador, this.numerador);
    }

    /**
     * Divides this rational number by another rational number.
     * The division is implemented as multiplication by the inverse.
     *
     * @param outro the rational number used as the divisor
     * @return a new Rational representing the quotient
     */
    public Rational div(Rational outro) {
        return this.mul(outro.invert());
    }

    /**
     * Computes the greatest common divisor (GCD) of two integers.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the greatest common divisor of a and b
     */
    private static int gcd(int a, int b) {
        for (int i = Math.min(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}