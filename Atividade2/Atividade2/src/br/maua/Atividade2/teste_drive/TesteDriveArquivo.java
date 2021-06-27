package br.maua.Atividade2.teste_drive;

import br.maua.Atividade2.models.LeituraArquivoMembro;
import br.maua.Atividade2.models.membro_generico.Membro;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteDriveArquivo {
    public static void main(String[] args){
        //File file = new File("arquivo_super_Secreto_nao_abrir.csv");
        String file = "arquivo_super_Secreto_nao_abrir.csv";
        List<Membro> listaMembros = new ArrayList<>();


        //listaMembros = LeituraArquivoMembro.lerArquivo(file,listaMembros);

        listaMembros.forEach(usuario -> System.out.println(usuario.apresentar()));


        //realiza leitura do arquivo
        /*
        try{
            Scanner scanner = new Scanner(file);

            while(scanner.hasNext()){
                String linha = scanner.nextLine();
                itens.add(Item.pegaItem(linha));
            }
        }
        catch (Exception exception){
            System.out.println("Arquivo muito secreto para abrir ... (ou não existe).");
        }
        */
    }

}
