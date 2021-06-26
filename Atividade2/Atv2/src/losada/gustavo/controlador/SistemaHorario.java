package losada.gustavo.controlador;

import losada.gustavo.enums.HorarioSistema;

public class SistemaHorario {
    private static HorarioSistema horario;

    public SistemaHorario(HorarioSistema horario){
        this.horario = horario;
    }

    /**
     * Método deixa o horário mais apresentavel.
     * @return Se horário do sistema está em NORMAL, retorna String "Normal", se não String "Extra".
     */
    public String horarioAtual(){
        if (horarioEhNormal()){
            return "Normal";
        }
        else{
            return "'Extra'";
        }
    }

    /**
     * Método verifica se o horário do sistema está atualmente como NORMAl.
     * @return Se horário (do sistema) estiver em (==) NORMAL, retorna true, se não false.
     */
    private boolean horarioEhNormal(){
        return this.horario == HorarioSistema.NORMAL;
    }

    /**
     * Método que é usado para mudar o harário do sistema.
     * De NORMAL para EXTRA, ou de EXTRA para NORMAL.
     */
    public void mudarHorario(){
        if (horarioEhNormal()){
            this.horario = HorarioSistema.EXTRA;
        }
        else{
            this.horario = HorarioSistema.NORMAL;
        }
    }
}
