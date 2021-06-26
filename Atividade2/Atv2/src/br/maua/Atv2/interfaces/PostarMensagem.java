package br.maua.Atv2.interfaces;

import br.maua.Atv2.controlador.SistemaHorario;

/**
 * Interface que os Membros devem implementar para poder postar sua mensagem.
 */
public interface PostarMensagem {

    /**
     * Método que Membros (e seus filhos) devem ter, para postar/assinar mensagem.
     * @return
     */
    public void assinaMensagem(SistemaHorario horario);
}
