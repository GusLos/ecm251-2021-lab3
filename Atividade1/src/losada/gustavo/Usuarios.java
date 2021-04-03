package losada.gustavo;

public class Usuarios {
    private String nome;
    private String senha;
    private String eMail;

    public Usuarios(String nome, String senha, String eMail){
        this.nome = nome;
        this.senha = senha;
        this.eMail = eMail;
    }

    public String getNome(){
        return this.nome;
    }

    public String getSenha() { return this.senha; }

    @Override
    public String toString() {
        return "Usuarios{" +
                "nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
