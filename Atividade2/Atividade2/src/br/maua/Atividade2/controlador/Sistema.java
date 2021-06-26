package br.maua.Atividade2.controlador;

import br.maua.Atividade2.enums.HorarioSistema;
import br.maua.Atividade2.models.*;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Classe que faz todas as interações.
 */
public class Sistema {
    private static SistemaHorario horario;
    private Scanner scanner;
    private BigBrothers bigBrother;
    private LinkedList<Membro> listaMembro;

    /**
     * Construtor de sistema, prepara a classe sistema para ser utilizada.
     */
    public Sistema(){
        this.listaMembro = new LinkedList<>();
        this.horario = new SistemaHorario(HorarioSistema.NORMAL);
        this.scanner = new Scanner(System.in);
        this.bigBrother = new BigBrothers("G","G@H.com",00);
    }

    /**
     * Método que permite o sistema funcionar.
     */
    public void run(){
        int opcao = 1;
        registrarMembro();
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
        int opcao = 1;
        System.out.println("Bem vindo\t\t\t\tHorario atual: "+horario.horarioAtual());
        System.out.println();
        System.out.println("Escolha sua ação:");
        System.out.println("0 - Sair do sistema;");
        System.out.println("1 - Verificar horário atual;");
        System.out.println("2 - Mudar horário atual;");
        System.out.println("3 - Postar/Assinar mensagem;");
        System.out.println("4 - Apresentar usuário atual;");
        //fazer if usuario é big brother ?
        System.out.println("5 - Adicionar membro;");
        System.out.println("");
        opcao = scanner.nextInt();
        return opcao;
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
            case 5:
                registrarMembro();
                break;
            default:
                System.out.println("Opção invalida.");
        }
    }

    /**
     * Método para registrar novos membros na lista ligada existente no sistema.
     */
    private void registrarMembro(){
        String nomeMembroNovo = "";
        String eMailMembroNovo = "";
        int tipoMembro = -1;
        System.out.println("Nome: ");
        nomeMembroNovo = scanner.next();
        System.out.println("E-mail:");
        eMailMembroNovo = scanner.next();
        //Algum jeito melhor de fazer isso ?
        System.out.println("Tipo/Função do membro:\n0 - Big Brother\n1 - Script Guy\n2 - Heavy Lifter\n" +
                "3 - Mobile Member");
        tipoMembro = scanner.nextInt();
        while((tipoMembro < 0) || (tipoMembro > 3)){
            System.out.println("Número invalido.");
            System.out.println("Tipo/Função do membro:\n0 - Big Brother\n1 - Script Guy\n2 - Heavy Lifter\n" +
                    "3 - Mobile Member");
            tipoMembro = scanner.nextInt();
        }
        int id = 0;
        id = listaMembro.getLast().getId();
        switch (tipoMembro){
            case 0:
                listaMembro.add(new BigBrothers(nomeMembroNovo,eMailMembroNovo,10));
                break;
            case 1:
                listaMembro.add(new ScriptGuys(nomeMembroNovo,eMailMembroNovo,10));
                break;
            case 2:
                listaMembro.add(new HeavyLifters(nomeMembroNovo,eMailMembroNovo,10));
                break;
            case 3:
                listaMembro.add(new MobileMembers(nomeMembroNovo,eMailMembroNovo,10));
                break;
            default:
                System.out.println("Erro!");
        }
    }

    private void postarMensagem(){}

}
