package br.maua.Atividade2.controlador;

import br.maua.Atividade2.comparadores.ComparadorMembroId;
import br.maua.Atividade2.enums.HorarioSistema;
import br.maua.Atividade2.interacao_arquivo.LeituraArquivoMembro;
import br.maua.Atividade2.models.membro_generico.Membro;
import br.maua.Atividade2.models.membro_especifico.BigBrothers;
import br.maua.Atividade2.models.membro_especifico.HeavyLifters;
import br.maua.Atividade2.models.membro_especifico.MobileMembers;
import br.maua.Atividade2.models.membro_especifico.ScriptGuys;

import java.util.*;

/**
 * Classe que faz todas as interações.
 */
public class Sistema {
    private static SistemaHorario horario;
    private Scanner scanner;
    private Set<Membro> treeMembro;
    private LinkedList<Membro> listaMembro;
    private final String file = "arquivo_super_Secreto_nao_abrir.csv";

    /**
     * Construtor de sistema, prepara a classe sistema para ser utilizada.
     */
    public Sistema(){
        this.listaMembro = new LinkedList<>();
        this.treeMembro = new TreeSet<>(new ComparadorMembroId());
        this.horario = new SistemaHorario(HorarioSistema.NORMAL);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Método que permite o sistema funcionar.
     */
    public void run(){
        int opcao = 1;
        registrarMembro();
        LeituraArquivoMembro.lerArquivo(this.file,treeMembro);
        System.out.println("Bem vindo\t\t\t\tHorario atual: "+horario.horarioAtual());
        while(opcao != 0){
            //try{
            opcao = menu();
            //}
            //catch (InputMismatchException e){
            //    opcao = 999;
            //}
            analisarOpcao(opcao);
        }
    }

    /**
     * Método que mostra o menu para o usuário para que ele selecione uma ação (opção).
     * @return int op, sendo op a opção de acordo com o menu apresentado.
     */
    private int menu(){
        int opcao = 1;
        System.out.println();
        System.out.println("Escolha sua ação:");
        System.out.println("0 - Sair do sistema;");
        System.out.println("1 - Verificar horário atual;");
        System.out.println("2 - Mudar horário atual;");
        System.out.println("3 - Postar/Assinar mensagem;");
        System.out.println("4 - Apresentar usuário atual;");
        //fazer if usuario é big brother ?
        System.out.println("5 - Adicionar membro;");
        //
        System.out.println("6 - Visualizar todos os membros cadastrados (Relatorio);");
        System.out.println("7 - Visualizar mensagem de todos os membros cadastrados;");
        System.out.println("8 - Remover um membro;");
        System.out.println("9 - Salvar membros atuais em um arquivo;");

        //try{
        opcao = scanner.nextInt();
        //}
        //catch (InputMismatchException e){
        //    System.out.println("Tu é cego ?");
        //    opcao = 999;
        //}
        return opcao;
    }

    /**
     * Método que avalia o parametro opcao (que é a opção do usuário), e realiza uma ação específica.
     * @param opcao
     */
    private void analisarOpcao(int opcao){
        switch (opcao){
            case 0:
                sairSistema();
                break;
            case 1:
                horarioAtual();
                break;
            case 2:
                mudarHorario();
                break;
            case 3:
                listaMembro.getFirst().assinaMensagem(horario);
                break;
            case 4:
                System.out.println(listaMembro.getFirst().apresentar());
                break;
            case 5:
                registrarMembro();
                break;
            case 6:
                relatorio();
                break;
            case 7:
                postarMensagensMembros();
                break;
            case 8:
                removerMembro();
                break;
            case 9:
                salvarDados();
                break;
            default:
                System.out.println("Opção invalida.");
                break;
        }
    }

    /**
     * Método para registrar novos membros na lista ligada existente no sistema.
     * Caso não tenha ninguém cadastrado (presente em listaMembros), conta como um
     * "LogIn", onde o usuário que entrar no sistema e usar o sistema vai ser
     * marcado com id = 0 e será o primeiro da lista listaMembros.
     */
    private void registrarMembro(){
        organizarLista();
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
        try{
            id = this.listaMembro.getLast().getId();
        }
        catch (NoSuchElementException e){
            id = -1;
        }
        id ++;
        switch (tipoMembro){
            case 0:
                this.listaMembro.add(new BigBrothers(nomeMembroNovo,eMailMembroNovo,id));
                break;
            case 1:
                this.listaMembro.add(new ScriptGuys(nomeMembroNovo,eMailMembroNovo,id));
                break;
            case 2:
                this.listaMembro.add(new HeavyLifters(nomeMembroNovo,eMailMembroNovo,id));
                break;
            case 3:
                this.listaMembro.add(new MobileMembers(nomeMembroNovo,eMailMembroNovo,id));
                break;
            default:
                System.out.println("Erro!");
        }
    }

    /**
     * Método que permite todos os membros cadastrados (presentes em listaMembros)
     * postar/assinar a sua mensagem, de acordo com sua classe e método assinaMensagem().
     */
    private void postarMensagensMembros(){
        System.out.println();
        listaMembro.forEach(usuario -> usuario.assinaMensagem(horario));
        System.out.println();
    }

    /**
     * Esse método mostra todos os membros que estão cadastrados no sistema
     * (membros presentes em listaMembro).
     * Faz uso do método apresentacao() de Membro.
     */
    private void relatorio(){
        System.out.println();
        this.listaMembro.forEach(usuario -> System.out.println(usuario.apresentar()));
        System.out.println();
    }

    /**
     * Método que permite remover um membro cadastrado (presente na listaMembros).
     */
    private void removerMembro(){
        int i = -1;
        System.out.println("ID do membro a ser removido, (0 para voltar):");
        i = scanner.nextInt();
        while((i < 0) || (i > listaMembro.getLast().getId())){
            System.out.println("ID invalido, se quiser volte ao menu (0) e " +
                    "ver lista de membros (6) ...");
            System.out.println("ID do membro a ser removido, (0 para voltar):");
            i = scanner.nextInt();
        }
        if(i != 0){
            listaMembro.remove(i);
            organizarLista();
        }
    }

    /**
     * Método que permite organizar a listaMembros.
     */
    private void organizarLista(){
        for (int x = 0; x < listaMembro.size(); x++){
            listaMembro.get(x).setId(x);
        }
    }

    /**
     * Método chamado para realizar ultima ação do sistema (mandar uma mensagem de despedida).
     */
    private void sairSistema(){
        if(horario.horarioEhNormal()) {
            System.out.println("Se cuida, até mais.");
        }
        else{
            System.out.println("Já vai tarde.");
        }
    }

    /**
     * Método de sistema que permite salvar os membros atuais em um arquivo.
     */
    private void salvarDados(){
        organizarLista();
        listaMembro.getFirst().setId(listaMembro.getLast().getId()+1);
        LeituraArquivoMembro.salvar(listaMembro,this.file);
        listaMembro.getLast().setId(0);
        organizarLista();
    }

    /**
     * Método que permite usuário ver o horario atual do sistema.
     */
    private void horarioAtual(){
        System.out.println("Horario atual do sistema: "+horario.horarioAtual());
    }

    /**
     * Método permite o usuário mudar o horario do sistema.
     */
    private void mudarHorario(){
        horario.mudarHorario();
        System.out.println("Horario mudado com sucesso para: "+horario.horarioAtual());
    }

}
