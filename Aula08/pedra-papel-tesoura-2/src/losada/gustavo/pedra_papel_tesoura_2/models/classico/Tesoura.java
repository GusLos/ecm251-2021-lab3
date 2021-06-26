package losada.gustavo.pedra_papel_tesoura_2.models.classico;

import losada.gustavo.pedra_papel_tesoura_2.models.Jogada;
import losada.gustavo.pedra_papel_tesoura_2.models.bazinga.Lagarto;
import losada.gustavo.pedra_papel_tesoura_2.models.bazinga.Spoke;

public class Tesoura extends Jogada {

    @Override
    public Jogada[] jogadasQueGanho(){
        return new Jogada[]{new Papel(), new Lagarto()};
    }

    @Override
    public Jogada[] jogadasQuePerco(){
        return new Jogada[]{new Pedra(), new Spoke()};
    }
    @Override
    public String toString(){
        return "Tesoura";
    }
}
