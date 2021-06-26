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
            System.out.println("Bem vindo.");
            System.out.println(membro.apresentar());
            op = false;
        }
    }

    private void registrarMembro(){}

    private void horarioAtual(){}

    private void postarMensagem(){}

    private void mudarHorario(){}


}
