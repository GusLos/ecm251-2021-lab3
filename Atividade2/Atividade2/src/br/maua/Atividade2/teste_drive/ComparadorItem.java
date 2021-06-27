package br.maua.Atividade2.teste_drive;

import br.maua.Atividade2.models.membro_generico.Membro;

import java.util.Comparator;

/**
 * Classe para ser utilizada por TreeSet para fazer a comparação.
 */
public class ComparadorItem implements Comparator<Membro> {

    /**
     * Regra para comparação entre os Membros
     * @param o1 Membro 1
     * @param o2 Membro 2
     * @return Int, sendo: 1 - o1.id>o2.id; 0 - o1.id=o2.id; -1 - o1.id<o2.id
     */
    @Override
    public int compare(Membro o1, Membro o2) {
        if (o1.getId() > o2.getId()){
            return 1;
        }
        else if(o1.getId() == o2.getId()){
            return 0;
        }
        else{
            return -1;
        }
    }
}
