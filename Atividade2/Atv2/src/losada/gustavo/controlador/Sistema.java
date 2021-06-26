package losada.gustavo.controlador;

import losada.gustavo.enums.HorarioSistema;
import losada.gustavo.enums.TiposMembros;
import losada.gustavo.models.BigBrothers;

import java.util.Scanner;

/**
 * Classe que faz todas as interações.
 */
public class Sistema {
    private static SistemaHorario horario;
    private Scanner scanner;
    private BigBrothers bigBrother;

    /**
     * Construtor de sistema, prepara a classe sistema para ser utilizada.
     */
    public Sistema(){
        this.horario = new SistemaHorario(HorarioSistema.NORMAL);
        this.scanner = new Scanner(System.in);
        this.bigBrother = new BigBrothers("G","G@H.com",00);
    }

    /**
     * Método que permite o sistema funcionar.
     */
    public void run(){
        int opcao = 1;
        while(opcao != 0){
            opcao = menu();
            analisarOpcao(opcao);
        }
    }

    /**
     * Método que mostra o menu para o usuário para que ele selecione uma ação (opção).
     * @return int op, sendo op a opção de acordo com o menu apresentado.
     */
    private int menu(){
        int op = 1;
        System.out.println("Bem vindo\t\t\t\tHorario atual: "+horario.horarioAtual());
        System.out.println();
        System.out.println("Escolha sua ação:");
        System.out.println("0 - Sair do sistema;");
        System.out.println("1 - Verificar horário atual;");
        System.out.println("2 - Mudar horário atual;");
        System.out.println("3 - Postar/Assinar mensagem;");
        System.out.println("4 - Apresentar usuário atual;");
        op = scanner.nextInt();
        return op;
    }

    /**
     * Método que avalia o parametro opcao (que é a opção do usuário), e realiza uma ação específica.
     * @param opcao
     */
    private void analisarOpcao(int opcao){
        switch (opcao){
            case 0:
                System.out.println("Se cuida, até mais.");
                break;
            case 1:
                System.out.println("Horario atual do sistema: "+horario.horarioAtual());
                break;
            case 2:
                horario.mudarHorario();
                System.out.println("Horario mudado com sucesso para: "+horario.horarioAtual());
                break;
            case 3:
                bigBrother.assinaMensagem(horario);
                break;
            case 4:
                System.out.println(bigBrother.apresentar());
                break;
            default:
                System.out.println("Opção invalida.");
        }
    }

    private void registrarMembro(){}

    private void postarMensagem(){}

}
