package losada.gustavo.pedra_papel_tesoura.models.classico;

import losada.gustavo.pedra_papel_tesoura.models.Jogada;
import losada.gustavo.pedra_papel_tesoura.models.bazinga.Lagarto;
import losada.gustavo.pedra_papel_tesoura.models.bazinga.Spoke;

public class Pedra extends Jogada {

    @Override
    public boolean verificaSeGanhei(Jogada jogada){
        return (jogada instanceof Lagarto) || (jogada instanceof Tesoura);
    }

    @Override
    public boolean verificaSePerdi(Jogada jogada){
        return (jogada instanceof Papel) || (jogada instanceof Spoke);
    }

    @Override
    public String toString(){
        return "Pedra";
    }
}
