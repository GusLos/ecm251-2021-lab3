package losada.gustavo.models;

import losada.gustavo.enums.TiposMembros;

/**
 * Classe que reprensenta os membros individualmente.
 */
public class Membro extends Membros{

    /**
     * Construtor da classe, recebe nome do usuário, eMail do usuário e sua função na 'sociedade'.
     * @param nome
     * @param eMail
     * @param funcao
     */
    public Membro (String nome, String eMail, TiposMembros funcao){
        super(nome, eMail, funcao);
    }

    /**
     * Método que permite o usuário fazer sua apresentação.
     * @return String "formal" contendo nome, eMail e função.
     */
    @Override
    public String apresentar() {
        return "Usuario: "+ this.nome + " ("+ this.funcao +") e-mail: "+this.eMail ;
    }

    /**
     * Método que manda mensagem de acordo com a função e com horario do sistema.
     * @return
     */
    @Override
    public String assinaMensagem() {
        return null;
    }
}
