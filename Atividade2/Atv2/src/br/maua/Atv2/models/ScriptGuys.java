package br.maua.Atv2.models;

import br.maua.Atv2.controlador.SistemaHorario;
import br.maua.Atv2.enums.TiposMembros;

/**
 * Classe que reprensenta os membros ScriptGuys.
 */
public class ScriptGuys extends Membro{

    /**
     * Construtor da classe, recebe id do usuário, nome do usuário e eMail do usuário.
     * @param nome Nome do usuário HeavyLifters
     * @param eMail E-mail do usuário HeavyLifters
     * @param id ID do usuário HeavyLifters
     */
    public ScriptGuys(String nome, String eMail, int id) {
        super(nome, eMail, TiposMembros.SCRIPT_GUYS, id);
    }

    /**
     * Método que permite usuário mandar mensagem de acordo com o horario do sistema.
     * @param horario Para saber se o sistema está em NORMAL ou 'EXTRA'
     */
    @Override
    public void assinaMensagem(SistemaHorario horario) {
        if (horario.horarioEhNormal()){
            System.out.println("Prazer em ajudar novos amigos de código!");
        }
        else {
            System.out.println("QU3Ro_S3us_r3curs0s.py");
        }
    }
}
