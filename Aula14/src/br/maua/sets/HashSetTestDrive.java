package br.maua.sets;

import java.util.HashSet;
import java.util.Set;
import br.maua.models.Item;

public class HashSetTestDrive {
    public static void main(String[] args){
        Set<Item> itemSet = new HashSet<>();

        //Adiciona os elementos no HashSet
        itemSet.add(new Item("Maça",1));
        itemSet.add(new Item("Pera",2));
        itemSet.add(new Item("Maça",1));
        itemSet.add(new Item("Banana",3));

        //Exibe os itens
        itemSet.forEach(item -> System.out.println(item));
    }
}
