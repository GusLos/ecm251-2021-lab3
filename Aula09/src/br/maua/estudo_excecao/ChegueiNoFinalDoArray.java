package br.maua.estudo_excecao;

// -lembrar de checked exceptions (precisa ser tratado)
//  e unchecked exceptions (precisa tratar mas roda)

//Unchecked
//public class ChegueiNoFinalDoArray extends ArrayIndexOutOfBoundsException{
//Checked
public class ChegueiNoFinalDoArray extends Exception{
    @Override
    public String getMessage() {
        return "Array chegou no final";
    }
}
