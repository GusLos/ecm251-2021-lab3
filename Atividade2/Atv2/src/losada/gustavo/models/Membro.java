package losada.gustavo.models;

import losada.gustavo.enums.TiposMembros;

public class Membro extends Membros{

    public Membro (String nome, String eMail, TiposMembros funcao){
        super(nome, eMail, funcao);
    }

    @Override
    public String apresentar() {
        return "Usuario: "+ this.nome + " ("+ this.funcao +")";
    }

    @Override
    public String assinaMensagem() {
        return null;
    }
}
