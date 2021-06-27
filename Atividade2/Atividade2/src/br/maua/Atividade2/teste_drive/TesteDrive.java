package br.maua.Atividade2.teste_drive;

import br.maua.Atividade2.comparadores.ComparadorMembroId;
import br.maua.Atividade2.controlador.SistemaHorario;
import br.maua.Atividade2.enums.HorarioSistema;
import br.maua.Atividade2.models.membro_generico.Membro;
import br.maua.Atividade2.models.membro_especifico.BigBrothers;
import br.maua.Atividade2.models.membro_especifico.HeavyLifters;
import br.maua.Atividade2.models.membro_especifico.MobileMembers;
import br.maua.Atividade2.models.membro_especifico.ScriptGuys;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Classe para testar ideias antes de implementar.
 */
public class TesteDrive {
    public static void main(String[] args){
        SistemaHorario horario = new SistemaHorario(HorarioSistema.EXTRA);
        LinkedList<Membro> membros = new LinkedList<>();
        Set<Membro> treeMembros = new TreeSet<>(new ComparadorMembroId());


        treeMembros.add(new HeavyLifters("Max","Max@gmail.com", 01));
        treeMembros.add(new ScriptGuys("Mel","Mel@gmail.com", 43));
        treeMembros.add(new MobileMembers("Stella","Stella@gmail.com",27));
        treeMembros.add(new BigBrothers("G","G@M.com",05));


        System.out.println("-------------------------------------------");
        System.out.println("Passando por lista ligada");
        treeMembros.forEach(pessoa -> System.out.println(pessoa.apresentar()));
        System.out.println("-------------------------------------------");
        //treeMembros.forEach(pessoa -> pessoa.assinaMensagem(horario));

        //System.out.println(treeMembros.size());

        /*
        treeMembros.removeIf(membro -> (membro.getId() == 10));
        System.out.println("-------------------------------------------");
        treeMembros.forEach(pessoa -> System.out.println(pessoa.apresentar()));
        */
        treeMembros.add(new BigBrothers("M","M@M.com",0));
        treeMembros.add(new BigBrothers("S","S@S.com",0));
        treeMembros.forEach(pessoa -> System.out.println(pessoa.apresentar()));

        //System.out.println(treeMembros.stream().anyMatch(membro -> membro.getId() == 999));
        //System.out.println("-------------------------------------------");
        //System.out.println(treeMembros.stream().findFirst().get().apresentar());


    }
}
