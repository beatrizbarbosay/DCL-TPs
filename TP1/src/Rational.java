public class Rational {
    private int numerador;
    private int denominador;

    public Rational(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    @Override
    public String toString() {
        return this.getNumerador() + "/" + this.getDenominador() ;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Rational)){
            return false;
        }
        Rational outro = (Rational) obj;
        return (this.numerador == outro.numerador)&&(this.denominador == outro.denominador);
    }

    public Rational sum(Rational outro){
        int ResultadoNumerador = (outro.denominador * this.numerador) + (outro.numerador * this.denominador);
        int ResultadoDenominador = this.denominador * outro.denominador;
        return new Rational(ResultadoNumerador, ResultadoDenominador);
    }
}
