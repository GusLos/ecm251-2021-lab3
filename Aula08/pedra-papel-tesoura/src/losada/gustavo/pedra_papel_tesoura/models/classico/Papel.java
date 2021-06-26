package losada.gustavo.pedra_papel_tesoura.models.classico;

import losada.gustavo.pedra_papel_tesoura.models.Jogada;
import losada.gustavo.pedra_papel_tesoura.models.bazinga.Lagarto;
import losada.gustavo.pedra_papel_tesoura.models.bazinga.Spoke;

public class Papel extends Jogada {

    @Override
    public boolean verificaSeGanhei(Jogada jogada){
        return (jogada instanceof Pedra) || (jogada instanceof Spoke);
    }

    @Override
    public boolean verificaSePerdi(Jogada jogada){
        return (jogada instanceof Lagarto) || (jogada instanceof Tesoura);
    }

    @Override
    public String toString(){
        return "Papel";
    }
}
