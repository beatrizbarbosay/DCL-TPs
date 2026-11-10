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
        int resultadoNumerador = (outro.denominador * this.numerador) + (outro.numerador * this.denominador);
        int resultadoDenominador = this.denominador * outro.denominador;
        return new Rational(resultadoNumerador, resultadoDenominador);
    }

    public Rational mul(Rational outro){
        int resultadoNumerador = outro.numerador * this.numerador;
        int resultadoDenominador = outro.denominador * this.denominador;
        return new Rational (resultadoNumerador, resultadoDenominador);
    }

    public Rational opposite(){ //quando um metodo so usa o objeto que chama, nao coloca nada
        return new Rational(-this.numerador, this.denominador);
    }

    public Rational sub(Rational outro){
        return this.sum(outro.opposite());
    }

    public Rational invert(){
        return new Rational(this.denominador, this.numerador);
    }

    public Rational div(Rational outro){
        return this.mul(outro.invert());

    }


}
