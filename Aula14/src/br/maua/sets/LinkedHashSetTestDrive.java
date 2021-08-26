package br.maua.sets;

import br.maua.models.Item;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTestDrive {
    public static void main(String[] args){
        Set<Item> itemSet = new LinkedHashSet<>();

        //Adiciona os elementos no HashSet
        itemSet.add(new Item("Maça",1));
        itemSet.add(new Item("Pera",2));
        itemSet.add(new Item("Maça",1));
        itemSet.add(new Item("Banana",3));

        //Exibe os itens
        itemSet.forEach(item -> System.out.println(item));
    }
}
