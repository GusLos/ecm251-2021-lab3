package br.maua.Atividade2.interfaces;

import br.maua.Atividade2.controlador.SistemaHorario;

/**
 * Interface que os Membros devem implementar para poder postar sua mensagem.
 */
public interface PostarMensagem {

    /**
     * Método que Membros (e seus filhos) devem ter, para postar/assinar mensagem.
     * @return print da mensagem especial de cada membro.
     */
    public void assinaMensagem(SistemaHorario horario);
}
