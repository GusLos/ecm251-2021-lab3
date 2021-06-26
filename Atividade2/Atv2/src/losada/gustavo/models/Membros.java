package losada.gustavo.models;

import losada.gustavo.enums.TiposMembros;

/**
 * Classe abstrata Membros possui o que os membros tem em comum:
 * nome - nome do usuario;
 * eMail - e-mail do usuario;
 * funcao - função ou o tipo de membro que ele é.
 */
public abstract class Membros {
    private String nome;
    private String eMail;
    private TiposMembros funcao;
}
