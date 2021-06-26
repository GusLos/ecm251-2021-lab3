package losada.gustavo.controlador;

import losada.gustavo.enums.HorarioSistema;
import losada.gustavo.enums.TiposMembros;
import losada.gustavo.models.Membro;

import java.util.Scanner;

public class Sistema {
    private static SistemaHorario horario;
    private Scanner scanner;
    private Membro membro;

    public Sistema(){
        this.horario = new SistemaHorario(HorarioSistema.NORMAL);
        this.scanner = new Scanner(System.in);
        this.membro = new Membro("G","G@H.com", TiposMembros.BIG_BROTHERS);
    }

    public void run(){
        boolean op = true;
        while(op){
            System.out.println(horario.horarioAtual());
            System.out.println("---------------------------");
            horario.mudarHorario();
            System.out.println(horario.horarioAtual());
            op = false;
        }
    }

    private void menu(){

    }

    private void registrarMembro(){}

    private void postarMensagem(){}

}
