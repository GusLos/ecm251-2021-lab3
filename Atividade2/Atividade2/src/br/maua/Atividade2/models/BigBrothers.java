package br.maua.Atividade2.models;

import br.maua.Atividade2.controlador.SistemaHorario;
import br.maua.Atividade2.enums.TiposMembros;

/**
 * Classe que reprensenta os membros BigBrothers.
 */
public class BigBrothers extends Membro{

    /**
     * Construtor da classe, recebe id do usuário, nome do usuário e eMail do usuário.
     * @param nome Nome do usuário HeavyLifters
     * @param eMail E-mail do usuário HeavyLifters
     * @param id ID do usuário HeavyLifters
     */
    public BigBrothers(String nome, String eMail, int id){
        super(nome, eMail, TiposMembros.BIG_BROTHERS, id);
    }

    /**
     * Método que permite usuário mandar mensagem de acordo com o horario do sistema.
     * @param horario Para saber se o sistema está em NORMAL ou 'EXTRA'
     */
    @Override
    public void assinaMensagem(SistemaHorario horario) {
        if (horario.horarioEhNormal()){
            System.out.println("Sempre ajudando as pessoas membros ou não S2!");
        }
        else {
            System.out.println("...");
        }
    }
}
