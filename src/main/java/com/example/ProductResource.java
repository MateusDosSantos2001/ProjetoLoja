package com.example;

import java.util.Optional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class ProductResource {
  @Autowired
  private ProductRepository repository;
  /*
   * Construtor do ProductResource, preparando uma lista de produtos
   */
  public ProductResource(ProductRepository repository) {
    this.repository = repository;
  }

  /**
   * Metodo de requisicao do tipo GET, para uma lista
   * @return lista de produtos.
   */
  @RequestMapping(value = "/produtos/", method = RequestMethod.GET)
  public Iterable<Product> buscarProdutos() {
    return this.repository.findAll();
  }

  /**
   * Metodo de requisicao do tipo GET, para um item
   * @param id identificador do produto
   * @return item de produto unico
   */
  @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
  public Optional<Product> buscarProduto(@PathVariable Long id) {
    return this.repository.findById(id);
  }
  
  /**
   * Metodo de requisicao do tipo DELETE, para remover um item
   * @param id identificador do produto
   */
  @RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
  public void removerProduto(@PathVariable Long id) {
    this.repository.deleteById(id);
  }

  /**
   * Metodo de requisicao do tipo POST, para adicionar um novo item
   * @return um novo produto na lista produtos
   */
  @RequestMapping(value = "/produtos/", 
  method = RequestMethod.POST)
  public Product criarProduto(@RequestBody Product product) {
    String nome = product.getNome();
    String genero = product.getGenero();
    String data_de_lancamento = product.getDatadelancamento();
    double valor = product.getValor();
    int quantidade = product.getQuantidade();
    return this.repository.save(new Product(nome, genero, data_de_lancamento, valor, quantidade));
  }

  /**
   * Metodo de requisicao do tipo PUT, para atualizar um item existente
   * @param id identificador do item a ser atualizado na lista produtos
   */
  @RequestMapping(value="/produtos/{id}", 
  method=RequestMethod.PUT)
  public void alterarProduto(@PathVariable Long id,
  @RequestBody Product produtoParam) {
      Product produto = this.repository.findById(id).get();
      produto.setQuantidade(produtoParam.getQuantidade());
      produto.setValor(produtoParam.getValor());
      produto.setNome(produtoParam.getNome());
  }

}
