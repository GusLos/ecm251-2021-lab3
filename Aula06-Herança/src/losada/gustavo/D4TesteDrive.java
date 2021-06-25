package losada.gustavo;

public class D4TesteDrive {
    public static void main(String[] args) {
        D4 d1 = new D4();
        System.out.println("Primeira Leitura: "+ d1.pegarFaceAtual());
        for (int i = 0; i < 10; i++) {
            System.out.println("Numero sorteado: " + d1.sortearNumero());
            System.out.println("Face atual: "+ d1.pegarFaceAtual());
        }
    }
}
