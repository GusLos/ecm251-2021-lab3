package losada.gustavo.models;

import losada.gustavo.controlador.SistemaHorario;
import losada.gustavo.enums.HorarioSistema;
import losada.gustavo.enums.TiposMembros;

/**
 * Classe que reprensenta os membros individualmente.
 */
public class Membro extends Membros{

    /**
     * Construtor da classe, recebe nome do usuário, eMail do usuário e sua função na 'sociedade'.
     * @param nome
     * @param eMail
     * @param funcao
     */
    public Membro (String nome, String eMail, TiposMembros funcao){
        super(nome, eMail, funcao);
    }

    /**
     * Método que permite o usuário fazer sua apresentação.
     * @return String "formal" contendo nome, eMail e função.
     */
    @Override
    public String apresentar() {
        return "Usuario: "+ this.nome + " ("+ this.funcao +") e-mail: "+this.eMail ;
    }

    /**
     * Método que manda mensagem de acordo com a função e com horario do sistema.
     * @return
     */
    @Override
    public void assinaMensagem(SistemaHorario horario) {
        if (horario.horarioEhNormal()){
            switch (this.funcao){
                case BIG_BROTHERS:
                    System.out.println("Sempre ajudando as pessoas membros ou não S2!");
                    break;
                case SCRIPT_GUYS:
                    System.out.println("Prazer em ajudar novos amigos de código!");
                    break;
                case HEAVY_LIFTERS:
                    System.out.println("Podem contar conosco!");
                    break;
                case MOBILE_MEMBERS:
                    System.out.println("Happy Coding!");
                    break;
                default:
                    System.out.println("Deu ruim, quem é esse maluco, meu deus, apaga ele");
                    break;

            }
        }
        else {
            switch (this.funcao){
                case BIG_BROTHERS:
                    System.out.println("...");
                    break;
                case SCRIPT_GUYS:
                    System.out.println("QU3Ro_S3us_r3curs0s.py");
                    break;
                case HEAVY_LIFTERS:
                    System.out.println("N00b_qu3_n_Se_r3pita.bat");
                    break;
                case MOBILE_MEMBERS:
                    System.out.println("Happy_C0d1ng. Maskers");
                    break;
                default:
                    System.out.println("D3u R01m...");
            }
        }
    }
}
