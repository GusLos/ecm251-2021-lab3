package br.maua.Atividade2.models;

import br.maua.Atividade2.enums.TiposMembros;
import br.maua.Atividade2.models.membro_generico.Membro;

import java.io.File;
import java.util.List;
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
    public static List<Membro> lerArquivo(String localArquivo, List<Membro> membros){
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
        return membros;
    }

    /**
     * Método que separa as linhas em 2 (duas) String, um Int e um TiposMembros.
     * @param linha String de linha que (normalmente) vem de um arquivo para separar os ';';
     * @return Uma instancia de Membro.
     */
    private static Membro pegarMembro(String linha){
        return new Membro(linha.split(";")[1],
                linha.split(";")[2],
                TiposMembros.valueOf(linha.split(";")[3]),
                Integer.parseInt(linha.split(";")[0]));
    }
}
