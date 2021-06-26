package losada.gustavo.models;

import losada.gustavo.controlador.SistemaHorario;
import losada.gustavo.enums.TiposMembros;

/**
 * Classe que reprensenta os membros MobileMembers.
 */
public class MobileMembers extends Membro{

    /**
     * Construtor da classe, recebe id do usuário, nome do usuário e eMail do usuário.
     * @param nome Nome do usuário HeavyLifters
     * @param eMail E-mail do usuário HeavyLifters
     * @param id ID do usuário HeavyLifters
     */
    public MobileMembers(String nome, String eMail, int id) {
        super(nome, eMail, TiposMembros.MOBILE_MEMBERS, id);
    }

    /**
     * Método que permite usuário mandar mensagem de acordo com o horario do sistema.
     * @param horario Para saber se o sistema está em NORMAL ou 'EXTRA'
     */
    @Override
    public void assinaMensagem(SistemaHorario horario) {
        if (horario.horarioEhNormal()){
            System.out.println("Happy Coding!");
        }
        else {
            System.out.println("Happy_C0d1ng. Maskers");
        }
    }
}
