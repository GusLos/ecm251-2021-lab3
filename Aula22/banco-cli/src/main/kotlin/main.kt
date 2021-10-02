import dao.ProdutoDAO
import models.Produto
import java.sql.DriverManager

fun main(args: Array<String>) {
    //Cria um DAO para os produtos
    val produtosDAO = ProdutoDAO()
    var produtos = produtosDAO.pegarTodosSeguro()
    //Intera pelo resultado obtido
    //produtosDAO.inserirUm(Produto(0,"agua",5.0,12))

    //produtosDAO.inserirVarios(listOf(
    //    Produto(0,"Clementine",799.98,1),
    //   Produto(0,"Listerine",15.99,80)))

    produtosDAO.deletar(7)
    produtosDAO.atualizar(Produto(8,"Batata",1.95,50))
    
    produtos = produtosDAO.pegarTodosSeguro()
    for (produto in produtos){
        println(produto)
    }


}