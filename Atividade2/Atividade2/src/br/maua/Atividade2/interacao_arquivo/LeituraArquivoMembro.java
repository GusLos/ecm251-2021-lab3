package br.maua.Atividade2.interacao_arquivo;

import br.maua.Atividade2.enums.TiposMembros;
import br.maua.Atividade2.models.membro_especifico.BigBrothers;
import br.maua.Atividade2.models.membro_especifico.HeavyLifters;
import br.maua.Atividade2.models.membro_especifico.MobileMembers;
import br.maua.Atividade2.models.membro_especifico.ScriptGuys;
import br.maua.Atividade2.models.membro_generico.Membro;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Classe que carrega dados do arquivo, sendo os dados membros por linha:
 * id;nome;eMail;tipo/funcao
 */
public class LeituraArquivoMembro {

    /**
     * Método que carrega os dados do arquivo localizado em localArquivo para a lista ligada
     * membros.
     * @param localArquivo String com o local do arquivo a ser carregado;
     * @param membros Lista ligada de Membro que vai receber os dados do arquivo;
     * @return Lista ligada de Membro com dados do arquivo;
     */
    public static void lerArquivo(String localArquivo, LinkedList<Membro> membros){
        //"arquivo_super_Secreto_nao_abrir.csv"
        File file = new File(localArquivo);
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String linha = scanner.nextLine();
                membros.add(LeituraArquivoMembro.pegarMembro(linha));
            }
        }
        catch (Exception exception){
            System.out.println("Arquivo muito secreto para abrir ... (ou não existe).");
        }
    }

    /**
     * Método que separa as linhas em 2 (duas) String, um Int e um TiposMembros.
     * @param linha String de linha que (normalmente) vem de um arquivo para separar os ';';
     * @return Uma instancia da classe específica de acordo com TipoMembros na linha.
     */
    private static Membro pegarMembro(String linha){
        switch (TiposMembros.valueOf(linha.split(";")[3])){
            case BIG_BROTHERS:
                return new BigBrothers(linha.split(";")[1],
                        linha.split(";")[2],
                        Integer.parseInt(linha.split(";")[0]));
            case SCRIPT_GUYS:
                return new ScriptGuys(linha.split(";")[1],
                        linha.split(";")[2],
                        Integer.parseInt(linha.split(";")[0]));
            case HEAVY_LIFTERS:
                return new HeavyLifters(linha.split(";")[1],
                        linha.split(";")[2],
                        Integer.parseInt(linha.split(";")[0]));
            case MOBILE_MEMBERS:
                return new MobileMembers(linha.split(";")[1],
                        linha.split(";")[2],
                        Integer.parseInt(linha.split(";")[0]));
            default:
                return new Membro(linha.split(";")[1],
                        linha.split(";")[2],
                        TiposMembros.valueOf(linha.split(";")[3]),
                        Integer.parseInt(linha.split(";")[0]));
        }
    }

    /**
     * Método permite salvar membros atuais no sistema (em listaMembro), em um arquivo no localArquivo.
     * @param listaMembro Lista Ligada de Membro;
     * @param localArquivo String com o local/nome do arquivo.
     */
    public static void salvar(LinkedList<Membro> listaMembro,String localArquivo){
        try{
        FileWriter fileWrite = new FileWriter(localArquivo);
        for (Membro membro : listaMembro) {
            fileWrite.append(membro.getId() + ";" +
                      membro.getNome() + ';' +
                      membro.geteMail() + ';' +
                      membro.getFuncao()+'\n');
            }
        fileWrite.close();
        } catch (Exception exception){
            System.out.println("ERRO na hora de salvar arquivo!");
        }
    }
}
