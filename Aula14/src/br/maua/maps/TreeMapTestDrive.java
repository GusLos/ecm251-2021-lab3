package br.maua.maps;

import br.maua.models.Item;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTestDrive {
    public static void main(String[] args){
        Map<String, Item> itemMap = new TreeMap<>();

        //Adiciona elementos no HashMap
        itemMap.put("Item1", new Item("Maça",1));
        itemMap.put("Item2", new Item("Pera",2));
        itemMap.put("Item0", new Item("Maça",1));
        itemMap.put("Item1", new Item("Banana",3));

        itemMap.forEach((chave, valor) -> System.out.println("Chave:"+chave+"\tValor:"+valor));

        System.out.println(itemMap);

        //Recuperação dos itens do Mapa
        Item item = itemMap.get("Item1");
        System.out.println(item);
        item = itemMap.get("Item10");
        System.out.println(item);
        //"mostra item10, se não tiver item10, mostra ..."
        item = itemMap.getOrDefault("Item10", new Item("Vegeta",1001));
        System.out.println(item);
        //Fazer isso não adiciona o item (vegeta) no Map
        System.out.println(itemMap);
    }
}
