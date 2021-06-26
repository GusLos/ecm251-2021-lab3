package br.maua.Atv2.controlador;

import br.maua.Atv2.enums.HorarioSistema;
import br.maua.Atv2.models.Membro;


import java.util.LinkedList;

public class TesteDriveLinkedList {

    public static void main(String[] args){
        SistemaHorario horario = new SistemaHorario(HorarioSistema.EXTRA);
        LinkedList<Membro> membros = new LinkedList<>();

/*
        membros.add(new HeavyLifters("Max","Max@gmail.com", 01));
        membros.add(new ScriptGuys("Mel","Mel@gmail.com", 02));
        membros.add(new MobileMembers("Stella","Stella@gmail.com",03));
        membros.add(new BigBrothers("G","G@M.com",00));
*/

        System.out.println("-------------------------------------------");
        System.out.println("Passando por lista ligada");
        membros.forEach(pessoa -> System.out.println(pessoa.apresentar()));
        System.out.println("-------------------------------------------");
        membros.forEach(pessoa -> pessoa.assinaMensagem(horario));

        int id = membros.getFirst().getId();
        System.out.println(id);
    }
}
