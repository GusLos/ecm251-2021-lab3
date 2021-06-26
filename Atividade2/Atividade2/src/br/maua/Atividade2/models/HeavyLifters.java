package br.maua.Atividade2.models;

import br.maua.Atividade2.controlador.SistemaHorario;
import br.maua.Atividade2.enums.TiposMembros;

/**
 * Classe para representar os membros HeavyLifters
 */
public class HeavyLifters extends Membro{

    /**
     * Construtor da classe, recebe id do usuário, nome do usuário e eMail do usuário.
     * @param nome Nome do usuário HeavyLifters
     * @param eMail E-mail do usuário HeavyLifters
     * @param id ID do usuário HeavyLifters
     */
    public HeavyLifters(String nome, String eMail, int id) {
        super(nome, eMail, TiposMembros.HEAVY_LIFTERS, id);
    }

    /**
     * Método que permite usuário mandar mensagem de acordo com o horario do sistema.
     * @param horario Para saber se o sistema está em NORMAL ou 'EXTRA'
     */
    @Override
    public void assinaMensagem(SistemaHorario horario) {
        if (horario.horarioEhNormal()){
            System.out.println("Podem contar conosco!");
        }
        else {
            System.out.println("N00b_qu3_n_Se_r3pita.bat");
        }
    }
}
