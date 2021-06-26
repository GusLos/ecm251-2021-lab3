package losada.gustavo.controlador;

import losada.gustavo.enums.HorarioSistema;

import java.util.Scanner;

public class Sistema {
    private static HorarioSistema horario;
    private Scanner scanner;

    public Sistema(){
        this.horario = HorarioSistema.NORMAL;
        this.scanner = new Scanner(System.in);
    }

    public void run(){
        while(true){
            System.out.println("Bem vindo.");
        }
    }

    private void registrarMembro(){}

    private void horarioAtual(){}

    private void postarMensagem(){}

    private void mudarHorario(){}


}
