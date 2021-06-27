package br.maua.Atividade2.teste_drive;

import br.maua.Atividade2.controlador.SistemaHorario;
import br.maua.Atividade2.enums.HorarioSistema;
import br.maua.Atividade2.models.LeituraArquivoMembro;
import br.maua.Atividade2.models.membro_especifico.HeavyLifters;
import br.maua.Atividade2.models.membro_generico.Membro;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TesteDriveArquivo {
    public static void main(String[] args){
        //File file = new File("arquivo_super_Secreto_nao_abrir.csv");
        String file = "arquivo_super_Secreto_nao_abrir.csv";
        LinkedList<Membro> listaMembros = new LinkedList<>();
        SistemaHorario horario = new SistemaHorario(HorarioSistema.EXTRA);


        //listaMembros = LeituraArquivoMembro.lerArquivo(file,listaMembros);

        listaMembros.forEach(usuario -> System.out.println(usuario.apresentar()));


        //realiza leitura do arquivo
        /*
        try{
            Scanner scanner = new Scanner(file);

            while(scanner.hasNext()){
                String linha = scanner.nextLine();
                listaMembros.add(LeituraArquivoMembro.lerArquivo(linha));
            }
        }
        catch (Exception exception){
            System.out.println("Arquivo muito secreto para abrir ... (ou não existe).");
        }
        */
        String localArquivo = "arquivo_super_Secreto_nao_abrir2.csv";
        LeituraArquivoMembro.lerArquivo(file,listaMembros);
        listaMembros.add(new HeavyLifters("M3l","mel324@hotmail.com",80));
        listaMembros.forEach(usuario -> System.out.println(usuario.apresentar()));
        //listaMembros.forEach(usuario -> usuario.assinaMensagem(horario));

        LeituraArquivoMembro.salvar(listaMembros,localArquivo);

    }

}
