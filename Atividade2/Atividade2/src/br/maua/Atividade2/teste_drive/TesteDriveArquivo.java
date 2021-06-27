package br.maua.Atividade2.teste_drive;

import br.maua.Atividade2.comparadores.ComparadorMembroId;
import br.maua.Atividade2.controlador.SistemaHorario;
import br.maua.Atividade2.enums.HorarioSistema;
import br.maua.Atividade2.interacao_arquivo.LeituraArquivoMembro;
import br.maua.Atividade2.models.membro_generico.Membro;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class TesteDriveArquivo {
    public static void main(String[] args){
        //File file = new File("arquivo_super_Secreto_nao_abrir.csv");
        String file = "arquivo_super_Secreto_nao_abrir.csv";
        LinkedList<Membro> listaMembros = new LinkedList<>();
        SistemaHorario horario = new SistemaHorario(HorarioSistema.EXTRA);
        Set<Membro> treeMembros = new TreeSet<>(new ComparadorMembroId());


        LeituraArquivoMembro.lerArquivo(file,treeMembros);

        treeMembros.forEach(membro -> System.out.println(membro.apresentar()));
        //System.out.println("-------------------------------------------");
        //treeMembros.forEach(pessoa -> pessoa.assinaMensagem(horario));



    }

}
