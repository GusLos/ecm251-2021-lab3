package br.maua.Atividade2.teste_drive;

import br.maua.Atividade2.enums.TiposMembros;

public class Item {
    final public String nome;
    final public int id;
    final public String eMail;
    final public TiposMembros tipo;

    public Item(int id, String nome, String eMail, TiposMembros tipo){
        this.nome = nome;
        this.id = id;
        this.eMail = eMail;
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return "Item{" +
                "nome='"+ this.nome + '\''+
                ", id="+this.id+'\''+
                ", eMail='"+this.eMail+'\''+
                ", tipo='"+this.tipo+'}';
    }

    /**
     * Método quee cria um objeto item dada uma string de entrada
     * @param dados String com os valores necessario
     * @return Uma instancia de item
     */
    public static Item pegaItem(String dados){
        return new Item(Integer.parseInt(dados.split(";")[0]),
                dados.split(";")[1],
                dados.split(";")[2],
                TiposMembros.valueOf(dados.split(";")[3]));
    }
}
