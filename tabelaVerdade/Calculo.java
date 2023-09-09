import java.util.Scanner;

public class Calculo { 
    Scanner scan = new Scanner(System.in);
    

    public void inserirValores(){
        Proposicao proposicaoP = new Proposicao();
        Proposicao proposicaoQ = new Proposicao();

        System.out.println("Proposicao P: ");
        proposicaoP = valor();

        System.out.println("----------");

        System.out.println("Proposicao Q");
        proposicaoQ = valor();

        menuCalculo(proposicaoP, proposicaoQ);
    }

    public Proposicao valor(){
        int varControl;
        Proposicao proposicao = new Proposicao();

        System.out.println("Insira o valor(1 = Verdadeiro, 0 = Falso)");
        varControl = scan.nextInt();
        if(varControl == 1){
            proposicao.setValor(true);
        }else{
            proposicao.setValor(false);
        }

        System.out.println("É negado? 1- Sim, 0= Não");
        varControl = scan.nextInt();
        if(varControl == 1){
            proposicao.setIsNegation(true);
        } else{
            proposicao.setIsNegation(false);
        }
        return proposicao;
    }

    public void menuCalculo(Proposicao prop1, Proposicao prop2){
        System.out.println("Qual o tipo de conectivo");
        System.out.println("1- Conjunção(E)");
        System.out.println("2- Disjunção(OU)");
        System.out.println("3- Condicional(Se... Então)");
        System.out.println("4- Bicondicional(Se e Somente Se)");
        System.out.println("5- Cancelar");
        System.out.println("-------------------");
        int opcaoMenu = scan.nextInt();

        switch(opcaoMenu){
            case 1:
            conjuncaoSimplificada(prop1, prop2);
                break;
            case 2:
            disjuncaoSimplificada(prop1, prop2);
                break;
            case 3:
            condicionalSimplificada(prop1, prop2);
                break;
            case 4:
            bicondicionalSimplificada(prop1, prop2);
                break;
            default:
                break;
        }
    }

    // ---------------------------------------------------------------------------------------------------
    //Abaixo há duas versoes para cada um, utilizando mais e utilizando menos recursos de condicionais
    // ---------------------------------------------------------------------------------------------------

    //Maior custo
    public void conjuncao(Proposicao prop1, Proposicao prop2){
        boolean conclusao;

        if(prop1.getValor() == true && prop1.getIsNegation() == false && prop2.getValor() == true && prop2.getIsNegation() == false){
            conclusao = true;
        }else if(prop1.getValor() == true && prop1.getIsNegation() == false && prop2.getValor() == false && prop2.getIsNegation() == true){
            conclusao = true;
        }else if(prop1.getValor() == false && prop1.getIsNegation() == true && prop2.getValor() == true && prop2.getIsNegation() == false){
            conclusao = true;
        }else if(prop1.getValor() == false && prop1.getIsNegation() == true && prop2.getValor() == false && prop2.getIsNegation() == true){
            conclusao = true;
        }else{
            conclusao = false;
        }

        System.out.println("Conclusão: "+ conclusao);
    }

    //Menor custo
    public void conjuncaoSimplificada(Proposicao prop1, Proposicao prop2){
        Proposicao proposicaoControle = new Proposicao();
        Boolean conclusao;
        if(proposicaoControle.verifyProposition(prop1) == true && proposicaoControle.verifyProposition(prop2) == true){
            conclusao = true;
        }else{
            conclusao = false;
        }

        System.out.println("Conclusão: "+ conclusao);
    }

    // -----------------------------------------------------------------------------------------

    //Maior custo
    public void disjuncao(Proposicao prop1, Proposicao prop2){
        boolean conclusao;

        if(prop1.getValor() == true && prop1.getIsNegation() ==  false){
            conclusao = true;
        }else if(prop1.getValor() == false && prop1.getIsNegation() == true){
            conclusao = true;
        }else if(prop2.getValor() == true && prop2.getIsNegation() ==  false){
            conclusao = true;
        }else if(prop2.getValor() == false && prop2.getIsNegation() == true){
            conclusao = true;
        }else{
            conclusao = false;
        }

        System.out.println("Conclusão: "+ conclusao);
    }

    //Menor custo
    public void disjuncaoSimplificada(Proposicao prop1, Proposicao prop2){
        Proposicao proposicaoControle = new Proposicao();
        boolean conclusao;

        if(proposicaoControle.verifyProposition(prop1) == true || proposicaoControle.verifyProposition(prop2) == true){
            conclusao = true;
        }else{
            conclusao = false;
        }

        System.out.println("Conclusão: "+ conclusao);
    }

    // -----------------------------------------------------------------------------------------

    //Maior custo
    public void condicional(Proposicao prop1, Proposicao prop2){
        boolean conclusao;

        if(prop1.getValor() == true && prop1.getIsNegation() == false && prop2.getValor() == false && prop2.getIsNegation() == false){
            conclusao = false;
        }else if(prop1.getValor() == false && prop1.getIsNegation() == true && prop2.getValor() == false && prop2.getIsNegation() == false){
            conclusao = false;
        }else if(prop1.getValor() == false && prop1.getIsNegation() == true && prop2.getValor() == true && prop2.getIsNegation() == true){
            conclusao = false;
        }else{
            conclusao = true;
        }

        System.out.println("Conclusão: "+ conclusao);
    }

    //Menor custo
    public void condicionalSimplificada(Proposicao prop1, Proposicao prop2){
        Proposicao proposicaoControle = new Proposicao();
        boolean conclusao;

        if(proposicaoControle.verifyProposition(prop1) == true && proposicaoControle.verifyProposition(prop2) == false){
            conclusao = false;
        }else{
            conclusao = true;
        }
        System.out.println("Conclusão: "+ conclusao);
    }

    // -----------------------------------------------------------------------------------------

    //Maior custo
    public void bicondicional(Proposicao prop1, Proposicao prop2){
        boolean conclusao;

        if(prop1.getValor() == true && prop1.getIsNegation() == false && prop2.getValor() == true && prop2.getIsNegation() == false){
            conclusao = true;
        }else if(prop1.getValor() == false && prop1.getIsNegation() == true && prop2.getValor() == false && prop2.getIsNegation() == true){
            conclusao = true;


        }else if(prop1.getValor() == false && prop1.getIsNegation() == false && prop2.getValor() == false && prop2.getIsNegation() == false){
            conclusao = true;
        }else if(prop1.getValor() == true && prop1.getIsNegation() == true && prop2.getValor() == true && prop2.getIsNegation() == true){
            conclusao = true;


        }else if(prop1.getValor() == false && prop1.getIsNegation() == false && prop2.getValor() == true && prop2.getIsNegation() == true){
            conclusao = true;
        }else if(prop1.getValor() == true && prop1.getIsNegation() == false && prop2.getValor() == false && prop2.getIsNegation() == true){
            conclusao = true;
        }else{
            conclusao = false;
        }

        System.out.println("Conclusão: "+ conclusao);
    }

    //Menor custo
    public void bicondicionalSimplificada(Proposicao prop1, Proposicao prop2){
        Proposicao proposicaoControle = new Proposicao();
        boolean conclusao;

        if(proposicaoControle.verifyProposition(prop1) == proposicaoControle.verifyProposition(prop2)){
            conclusao = true;
        }else{
            conclusao = false;
        }

        System.out.println("Conclusão: "+ conclusao);
    }



}
