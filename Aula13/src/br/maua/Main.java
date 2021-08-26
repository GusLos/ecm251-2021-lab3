package br.maua;

import br.maua.model.Item;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Item> itens = new ArrayList<>();
        File file = new File("dados.txt");
        //Realiza a leitura do conteúdo desse arquivo
        try{
            //Cria elemento para iterar pelo arquivo
            Scanner scanner = new Scanner(file);
            //Passa por todos os elementos do arquivo
            while (scanner.hasNext()){
                String linha = scanner.nextLine();
                itens.add(Item.pegaItem(linha));
            }
            //Exibiu um resumo dos dados
            exibeResumo(itens);
            //Cria um arquivo com o resumo dos dados
            criarNota(itens);
        }
        catch (Exception exception){
            System.out.println("Algo deu errado.");
        }
    }

    private static void exibeResumo(List<Item> itens){
        System.out.println("=== Resumo pedido ===");
        System.out.println("Total de Itens: " + itens.size());
        double total = 0;
        System.out.println("Itens: ");
        for (Item item : itens) {
            System.out.println(item.nome+"\t"+item.preco);
            total += item.preco;
        }
        System.out.println("Total do pedido:"+total);
    }

    private static void criarNota(List<Item> itens) throws Exception {
        FileWriter fileWriter = new FileWriter("nota.toguro");
        fileWriter.write("=== Resumo do Pedido ==="+"\n");
        fileWriter.append("Total de Itens:"+itens.size()+"\n");
        double total = 0;
        fileWriter.append("Itens:"+"\n");
        for (Item item : itens){
            fileWriter.append(item.nome+"\t"+item.preco+"\n");
            total += item.preco;
        }
        fileWriter.append("Total do pedido:"+total+"\n");
        //Fechar o arquivo
        fileWriter.close();
    }
}
