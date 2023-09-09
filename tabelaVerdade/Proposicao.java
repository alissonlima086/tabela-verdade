public class Proposicao {
    private Boolean valor;
    private Boolean isNegation;

    public Boolean getValor() {
        return valor;
    }

    public void setValor(Boolean valor) {
        this.valor = valor;
    }

    public Boolean getIsNegation() {
        return isNegation;
    }

    public void setIsNegation(Boolean isNegation) {
        this.isNegation = isNegation;
    }

    public Boolean verifyProposition(Proposicao proposition){
        if(proposition.isNegation == true){
            proposition.valor = !proposition.valor;
        }
        return proposition.valor;
    }
}
