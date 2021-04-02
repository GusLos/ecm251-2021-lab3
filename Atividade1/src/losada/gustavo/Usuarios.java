package losada.gustavo;

public class Usuarios {
    private String nome;
    private String senha;
    private String eMail;

    public Usuarios(String nome){
        this.nome = nome;
        this.senha = senha;
        this.eMail = eMail;
    }

    public String getNome(){
        return this.nome;
    }

}
