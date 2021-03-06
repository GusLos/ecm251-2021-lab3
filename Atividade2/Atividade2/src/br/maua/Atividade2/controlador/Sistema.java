package br.maua.Atividade2.controlador;

import br.maua.Atividade2.comparadores.ComparadorMembroId;
import br.maua.Atividade2.enums.HorarioSistema;
import br.maua.Atividade2.enums.TiposMembros;
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
        String nome = "";
        String eMail = "";
        int funcao = -1;
        System.out.println("Seu nome:");
        nome = scanner.next();
        System.out.println("Seu e-mail:");
        eMail = scanner.next();
        System.out.println("Tipo/Função do membro:\n0 - Big Brother\n1 - Script Guy\n2 - Heavy Lifter\n" +
                "3 - Mobile Member");
        funcao = scanner.nextInt();
        while((funcao < 0) || (funcao > 3)){
            System.out.println("Número invalido.");
            System.out.println("Tipo/Função do membro:\n0 - Big Brother\n1 - Script Guy\n2 - Heavy Lifter\n" +
                    "3 - Mobile Member");
            funcao = scanner.nextInt();
        }
        colocarMembroTree(0,nome,eMail,funcao);
        LeituraArquivoMembro.lerArquivo(this.file,this.treeMembro);
        System.out.println("Bem vindo\t\t\t\tHorario atual: "+horario.horarioAtual());
        while(opcao != 0){
            //try{
            opcao = menu();
            //}
            //catch (InputMismatchException e){
            //    opcao = 999;
            //}
            analisarOpcao(opcao);
            if(opcao == 1){
                opcao = 0;
                sairSistema();
            }
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
        System.out.println("1 - Salvar dados e sair;");
        System.out.println("2 - Verificar horário atual;");
        System.out.println("3 - Mudar horário atual;");
        System.out.println("4 - Apresentar usuário atual;");
        System.out.println("5 - Postar/Assinar mensagem (usuário atual);");
        System.out.println("6 - Visualizar todos os membros cadastrados (Relatorio);");
        System.out.println("7 - Visualizar mensagem de todos os membros cadastrados;");

        if(atualEhBB(treeMembro)){
            System.out.println("8 - Adicionar membro;");
            System.out.println("9 - Remover um membro;");
            opcao = scanner.nextInt();

        }
        else{
            opcao = scanner.nextInt();
        }
        //try{
        //opcao = scanner.nextInt();
        //}
        //catch (InputMismatchException e){
        //    System.out.println("Tu é cego ?");
        //    opcao = 999;
        //}
        if(!atualEhBB(treeMembro) && ((opcao == 9) || (opcao == 8))){
            return -1;
        }
        else{
            return opcao;
        }
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
                salvarDados(treeMembro);
                break;
            case 2:
                horarioAtual();
                break;
            case 3:
                mudarHorario();
                break;
            case 4:
                apresentacaoPessoal(this.treeMembro);
                break;
            case 5:
                membroAtualMensagem(this.treeMembro);
                break;
            case 6:
                relatorio(this.treeMembro);
                break;
            case 7:
                postarMensagensMembros(this.treeMembro);
                break;
            case 8:
                registrarMembroTree();
                break;
            case 9:
                removerMembro(treeMembro);
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
    private void registrarMembroLista(){
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
     * Método que permite ao usuario cadastrar um membro novo (em um TreeSet),
     * utiliza colocarMembroTree.
     */
    private void registrarMembroTree(){
        int novoId = -1;
        String novoNome = "";
        String novoEMail = "";
        int novoFuncao = -1;
        System.out.println("Digite o ID do membro (0 para voltar): ");
        novoId = scanner.nextInt();
        while (idExistenteTree(novoId)){
            if(novoId == 0){
                return;
            }
            System.out.println("ID invalido, talvez queira voltar ao menu(0) e verificar a lista(6).");
            System.out.println("Digite o ID do novo membro: ");
            novoId = scanner.nextInt();
        }
        System.out.println("Digite o nome: ");
        novoNome = scanner.next();
        System.out.println("Digite o e-mail: ");
        novoEMail = scanner.next();
        System.out.println("Tipo/Função do membro:\n0 - Big Brother\n1 - Script Guy\n2 - Heavy Lifter\n" +
                    "3 - Mobile Member");
        novoFuncao = scanner.nextInt();
        while((novoFuncao < 0) || (novoFuncao > 3)){
            System.out.println("Número invalido.");
            System.out.println("Tipo/Função do membro:\n0 - Big Brother\n1 - Script Guy\n2 - Heavy Lifter\n" +
                        "3 - Mobile Member");
            novoFuncao = scanner.nextInt();
        }
        colocarMembroTree(novoId, novoNome, novoEMail, novoFuncao);
    }

    /**
     * Método que coloca o membro no TreeSet<>.
     * @param id int id do membro.
     * @param nome String nome do membro.
     * @param eMail String eMail do membro.
     * @param funcao int função do membro sendo: 0-BigBrothers; 1-ScriptGuys; 2-HeavyLifters;
     *               3- MobileMembers.
     */
    private void colocarMembroTree(int id, String nome, String eMail, int funcao){
        switch (funcao){
            case 0:
                this.treeMembro.add(new BigBrothers(nome, eMail, id));
                break;
            case 1:
                this.treeMembro.add(new ScriptGuys(nome, eMail, id));
                break;
            case 2:
                this.treeMembro.add(new HeavyLifters(nome, eMail, id));
                break;
            case 3:
                this.treeMembro.add(new MobileMembers(nome, eMail, id));
                break;
            default:
                break;
        }
    }

    /**
     * Método que coloca o membro no TreeSet<>.
     * @param id int id do membro.
     * @param nome String nome do membro.
     * @param eMail String eMail do membro.
     * @param funcao TiposMembros função do membro
     */
    private void colocarMembroTree(int id, String nome, String eMail, TiposMembros funcao){
        switch (funcao){
            case BIG_BROTHERS:
                this.treeMembro.add(new BigBrothers(nome, eMail, id));
                break;
            case SCRIPT_GUYS:
                this.treeMembro.add(new ScriptGuys(nome, eMail, id));
                break;
            case HEAVY_LIFTERS:
                this.treeMembro.add(new HeavyLifters(nome, eMail, id));
                break;
            case MOBILE_MEMBERS:
                this.treeMembro.add(new MobileMembers(nome, eMail, id));
                break;
            default:
                System.out.println("Erro ao inserir dado");
                break;
        }
    }

    /**
     * Método para verificar se id é aceitavel para o caso de um sistema com TreeSet<>.
     * Se for aceitavel, significa que nenhum outro membro tem aquele id.
     * @param id int id que vai ser testado.
     * @return boolean true (não existe outro membro com esse id); false (já existe membro com id).
     */
    public boolean idExistenteTree(int id){
        boolean teste = treeMembro.stream().anyMatch(membro -> membro.getId() == id);
        return (id < 0) || (teste);
    }

    /**
     * Método para verificar se id é aceitavel para o caso de um sistema com TreeSet<>.
     * Se for aceitavel, significa que existe um membro com aquele id.
     * @param id int id que vai ser testado.
     * @return boolean true (existe outro membro com esse id); false (não existe membro com id).
     */
    public boolean idInexistenteTree(int id){
        boolean teste = treeMembro.stream().noneMatch(membro -> membro.getId() == id);
        return (id < 0) || (teste);
    }

    /**
     * Método que permite todos os membros cadastrados (presentes em listaMembros)
     * postar/assinar a sua mensagem, de acordo com sua classe e método assinaMensagem().
     * @param listaMembro LinkedList de Membro com membros do sistema.
     */
    private void postarMensagensMembros(LinkedList<Membro> listaMembro){
        System.out.println();
        listaMembro.forEach(usuario -> usuario.assinaMensagem(horario));
        System.out.println();
    }

    /**
     * Método que permite todos os membros cadastrados (presentes em treeMembro)
     * postar/assinar a sua mensagem, de acordo com sua classe e método assinaMensagem().
     * @param treeMembro Set<> (TreeSet<>) de Membro com membros do sistema.
     */
    private void postarMensagensMembros(Set<Membro> treeMembro){
        System.out.println();
        treeMembro.forEach(usuario -> usuario.assinaMensagem(horario));
        System.out.println();
    }

    /**
     * Método permite que todos os membros em uma LinkedList se apresentem.
     * @param listaMembro LinkedList<> de Membro com membros do sistema.
     */
    private void relatorio(LinkedList<Membro> listaMembro){
        System.out.println();
        listaMembro.forEach(usuario -> System.out.println(usuario.apresentar()));
        System.out.println();
    }

    /**
     * Método permite que todos os membros em uma Set (TreeSet) se apresentem.
     * @param treeMembro TreeSet<> de Membro com membros do sistema.
     */
    private void relatorio(Set<Membro> treeMembro){
        System.out.println();
        this.treeMembro.forEach(usuario -> System.out.println(usuario.apresentar()));
        System.out.println();
    }

    /**
     * Método que permite remover um membro cadastrado (presente na listaMembros).
     * @param listaMembro LinkedList de Membro com membros atuais do sistema.
     */
    private void removerMembro(LinkedList<Membro> listaMembro){
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
     * Método permite apagar um membro do sistema em um TreeSet.
     * @param treeMembro Set<> (TreeSet) de Membro.
     */
    private void removerMembro(Set<Membro> treeMembro){
        int id = -1;
        System.out.println("Digite o ID membro (0 para sair): ");
        id = scanner.nextInt();
        while (idInexistenteTree(id)){
            if(id == 0){
                return;
            }
            System.out.println("ID invalido, talvez queira voltar ao menu(0) e verificar a lista(6).");
            System.out.println("Digite o ID membro: ");
            id = scanner.nextInt();
        }
        if(id == 0){
            return;
        }
        int finalId = id;
        treeMembro.removeIf(membro -> (membro.getId() == finalId));
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
            System.out.println("Já v@1 T@rD3.exe");
        }
    }

    /**
     * Método de sistema que permite salvar os membros atuais em um arquivo.
     * @param listaMembro LinkedList de Membro com membros do sistema.
     */
    private void salvarDados(LinkedList<Membro> listaMembro){
        organizarLista();
        listaMembro.getFirst().setId(listaMembro.getLast().getId()+1);
        LeituraArquivoMembro.salvar(listaMembro,this.file);
        listaMembro.getLast().setId(0);
        organizarLista();
    }

    /**
     * Método de sistema que permite salvar os membros atuais em um arquivo.
     * @param treeMembro Set<> (TreeSet) de Membro.
     */
    private void salvarDados(Set<Membro> treeMembro){
        int id = 1;
        String nome = "";
        String eMail = "";
        TiposMembros funcao = null;
        while (idExistenteTree(id)){
            id++;
        }
        nome = treeMembro.stream().findFirst().get().getNome();
        eMail = treeMembro.stream().findFirst().get().geteMail();
        funcao = treeMembro.stream().findFirst().get().getFuncao();
        treeMembro.removeIf(membro -> membro.getId() == 0);
        colocarMembroTree(id, nome, eMail, funcao);
        LeituraArquivoMembro.salvar(this.treeMembro,this.file);
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

    /**
     * Método que permite o membro atual/"logado" postar uma mensagem.
     * @param listaMembro LinkedList<> listaMembro com membros atuais do sistema.
     */
    private void membroAtualMensagem(LinkedList<Membro> listaMembro){
        listaMembro.getFirst().assinaMensagem(this.horario);
    }

    /**
     * Método que permite o membro atual/"logado" postar uma mensagem.
     * @param treeMembro Set<> (TreeSet<>) treeMembro com membros atuais do sistema.
     */
    private void membroAtualMensagem(Set<Membro> treeMembro){
        treeMembro.stream().findFirst().get().assinaMensagem(this.horario);
    }

    /**
     * Método que permite o usuario atual a se apresentar sozinho.
     * @param listaMembro LinkedList<> Membro com lista de membros atuais do sistema.
     */
    private void apresentacaoPessoal(LinkedList<Membro> listaMembro){
        System.out.println(listaMembro.getFirst().apresentar());
    }

    /**
     * Método que permite o usuario atual a se apresentar sozinho.
     * @param treeMembro Set<> Membro com TreeSet<> de membros atuais do sistema.
     */
    private void apresentacaoPessoal(Set<Membro> treeMembro){
        System.out.println(treeMembro.stream().findFirst().get().apresentar());
    }

    /**
     * Método verifica se o usuário atual é BigBrother.
     * @param treeMembro Set<> (TreeSet) de Membro, onde o primeiro membro do TreeSet
     *                   (0) é o usuario atual.
     * @return boolean, onde: true - usuario (primeiro membro) é BigBrother;
     * false - usuario (primeiro membro) não é BigBrother.
     */
    private boolean atualEhBB(Set<Membro> treeMembro){
        return (treeMembro.stream().findFirst().get().getFuncao() == TiposMembros.BIG_BROTHERS);
    }
}
