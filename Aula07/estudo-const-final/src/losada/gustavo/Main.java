package losada.gustavo;

public class Main {

    public static void main(String[] args) {
	    final Pessoa pessoa = new Pessoa("Deku","12321");
	    pessoa.mudar = 21;
	    System.out.println(pessoa);
	    //Se pessoa estiver com final, não da para mudar, não se pode "criar" outro objeto pessoa
	    //pessoa = new Pessoa("Bakugo","32123");
        pessoa.mudar = 14;
	    System.out.println(pessoa);

	    //exemplo de polimorfismo de sobrecarga
        System.out.println("-------------------Sobrecarga---------------------------------------------");
	    Estudante estudante1 = new Estudante("Asuka","22","02");
	    Estudante estudante2 = new Estudante("Rei","01");
	    System.out.println("Estudante 1: "+estudante1);
        System.out.println("Estudante 2: "+estudante2);

        //Exemplo de polimorfismo de sobreposição
        System.out.println("-------------------Sobreposicao-------------------------------------------");
        Pessoa pessoa1 = new Estudante("Shinji","33","01");//criar estudante com referencia de pessoa
        //isso pode/ocorre porcausa da herança como:
        Object estudante4 = new Estudante("HanSolo","00","00");
        Estudante estudante3 = new Estudante("Kaoru","44","02");//criar estudante com referencia de estudante
        System.out.println("Estudante como Estudante: "+estudante3);
        System.out.println("Estudante como Pessoa: "+pessoa1);
        System.out.println("Estudante como Object: "+estudante4);
        //usa métodos das filhas (sobreescrita)

        //IMPORTANTE
        System.out.println("-------------------Cuidado com heranca--------------------------------------");
        System.out.println("Ola de Estudante como Pessoa: " + pessoa1.Ola());
        System.out.println("Ola de Estudante como Estudante: " + estudante3.Ola());
        //System.out.println("Ola de Estudante como Object: " + estudante4.Ola());
        //classe pai não acessa clase filha, classe object não tem nenhum método chamado ola()
        //nem tem como usar Override

        //Estudante estudante5 = new Pessoa("Murilo","123"); Nem toda Pessoa é um estudante
        //mas t0d0 Estudante é uma Pessoa

        System.out.println("-------------------typeOf()--------------------------------------");
        System.out.println("Ola de Estudante como Pessoa: " + pessoa1.getClass());
        System.out.println("Ola de Estudante como Estudante: " + estudante3.getClass());
        System.out.println("Ola de Estudante como Object: " + estudante4.getClass());

        System.out.println("Ola de Estudante como Object: " + ((Estudante)estudante4).Ola());
        //cast do estudante4 para estudante e então chamando ola
        //"força" o estudante4 a agir como estudante ?
        //não é legal de fazer, mas talvez precise
        //só funciona naquela linha
    }
}
