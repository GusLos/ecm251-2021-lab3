package losada.gustavo.interfaces;

import losada.gustavo.controlador.SistemaHorario;
import losada.gustavo.enums.HorarioSistema;

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
