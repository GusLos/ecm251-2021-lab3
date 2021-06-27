package br.maua.Atividade2.teste_drive;

import br.maua.Atividade2.enums.TiposMembros;
import br.maua.Atividade2.models.membro_generico.Membro;

public class Item extends Membro {

    public Item(int id, String nome, String eMail, TiposMembros tipo){
        super(nome,eMail,tipo,id);
    }

    @Override
    public String toString(){
        return "Item{" +
                "nome='"+ this.nome + '\''+
                ", id="+this.id+'\''+
                ", eMail='"+this.eMail+'\''+
                ", tipo='"+this.funcao+'}';
    }

    /**
     * Método quee cria um objeto item dada uma string de entrada
     * @param dados String com os valores necessario
     * @return Uma instancia de item
     */
    public static Item pegaMembro(String dados){
        return new Item(Integer.parseInt(dados.split(";")[0]),
                dados.split(";")[1],
                dados.split(";")[2],
                TiposMembros.valueOf(dados.split(";")[3]));
    }
}
