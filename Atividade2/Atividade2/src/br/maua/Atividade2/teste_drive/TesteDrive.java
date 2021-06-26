package br.maua.Atividade2.teste_drive;

import br.maua.Atividade2.controlador.SistemaHorario;
import br.maua.Atividade2.enums.HorarioSistema;
import br.maua.Atividade2.models.*;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Classe para testar ideias antes de implementar.
 */
public class TesteDrive {
    public static void main(String[] args){
        SistemaHorario horario = new SistemaHorario(HorarioSistema.EXTRA);
        LinkedList<Membro> membros = new LinkedList<>();


        membros.add(new HeavyLifters("Max","Max@gmail.com", 01));
        membros.add(new ScriptGuys("Mel","Mel@gmail.com", 02));
        membros.add(new MobileMembers("Stella","Stella@gmail.com",03));
        membros.add(new BigBrothers("G","G@M.com",05));


        System.out.println("-------------------------------------------");
        System.out.println("Passando por lista ligada");
        membros.forEach(pessoa -> System.out.println(pessoa.apresentar()));
        System.out.println("-------------------------------------------");
        membros.forEach(pessoa -> pessoa.assinaMensagem(horario));
        /*
        int id = 0;
        try{
            id = membros.getFirst().getId();
        }
        catch(NoSuchElementException e){
            id = 0;
        }
        System.out.println(id);
        */
        System.out.println("-------------------------------------------");
        membros.remove(1);
        membros.forEach(pessoa -> System.out.println(pessoa.apresentar()));
        System.out.println("-------------------------------------------");
    }
}
