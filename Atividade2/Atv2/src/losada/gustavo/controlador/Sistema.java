package losada.gustavo.controlador;

import losada.gustavo.enums.HorarioSistema;
import losada.gustavo.enums.TiposMembros;
import losada.gustavo.models.Membro;

import java.util.Scanner;

public class Sistema {
    private static HorarioSistema horario;
    private Scanner scanner;
    private Membro membro;

    public Sistema(){
        this.horario = HorarioSistema.NORMAL;
        this.scanner = new Scanner(System.in);
        this.membro = new Membro("G","G@H.com", TiposMembros.BIG_BROTHERS);
    }

    public void run(){
        boolean op = true;
        while(op){
            System.out.println(horario);
            System.out.println(horarioEhNormal());
            System.out.println("---------------------------");
            mudarHorario();
            System.out.println(horarioEhNormal());
            System.out.println(horario);
            op = false;
        }
    }

    private void menu(){
        
    }

    private void registrarMembro(){}

    /**
     * Método deixa o horário mais apresentavel.
     * @return Se horário do sistema está em NORMAL, retorna String "Normal", se não String "Extra".
     */
    private String horarioAtual(){
        if (horarioEhNormal()){
            return "Normal";
        }
        else{
            return "'Extra'";
        }
    }

    private void postarMensagem(){}

    /**
     * Método que é usado para mudar o harário do sistema.
     * De NORMAL para EXTRA, ou de EXTRA para NORMAL.
     */
    private void mudarHorario(){
        if (horarioEhNormal()){
            this.horario = HorarioSistema.EXTRA;
        }
        else{
            this.horario = HorarioSistema.NORMAL;
        }
    }

    /**
     * Método verifica se o horário do sistema está atualmente como NORMAl.
     * @return Se horário (do sistema) estiver em (==) NORMAL, retorna true, se não false.
     */
    private boolean horarioEhNormal(){
        return this.horario == HorarioSistema.NORMAL;
    }

}
