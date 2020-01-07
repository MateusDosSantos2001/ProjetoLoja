package com.example;

import java.util.Optional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CartResource {
  
  @Autowired
  private CartRepository repository;

  @Autowired
  private ProductRepository product;

  @Autowired
  private UserRepository user;
  /*
   * Construtor do CartResource, preparando o carrinho
   */
  public CartResource(CartRepository repository) {
    this.repository = repository;
  }

  /**
   * Metodo de requisicao do tipo GET, para uma lista
   * @return lista do carrinho
   */
  @RequestMapping(value = "/cart/", method = RequestMethod.GET)
  public Iterable<Cart> buscarCompras() {
    return this.repository.findAll();
  }

  /**
   * Metodo de requisicao do tipo GET, para um item
   * @param id identificador do carrinho
   * @return item unico do carrinho
   */
  @RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
  public Optional<Cart> buscarCompra(@PathVariable Long id) {
    return this.repository.findById(id);
  }

    /**
   * Metodo de requisicao do tipo DELETE, para todos os itens
   * @param id identificador das compras
   */
  @RequestMapping(value = "/cart", method = RequestMethod.DELETE)
  public void removerCompras() {
    this.repository.deleteAll();
  }
  
  /**
   * Metodo de requisicao do tipo DELETE, para remover um item
   * @param id identificador do item
   */
  @RequestMapping(value = "/cart/{id}", method = RequestMethod.DELETE)
  public void removerCompra(@PathVariable Long id) {
    this.repository.deleteById(id);
  }

    /**
   * Metodo de requisicao do tipo POST, para adicionar um novo item
   * @return um novo item no carrinho
   */
  @RequestMapping(value = "/cart/", 
  method = RequestMethod.POST)
  public Cart adicionarCompra(@RequestBody Cart cart) {
    Product produto = this.product.findById(cart.getProduct().getId()).get();
    User user = this.user.findById(cart.getUser().getId()).get();
    return this.repository.save(new Cart(produto, user));
  }

  /**
   * Metodo de requisicao do tipo PUT, para atualizar um item existente
   * @param id identificador do item a ser atualizado na lista users
   */
  @RequestMapping(value="/cart/{id}", 
  method=RequestMethod.PUT)
  public Cart alterarItem(@PathVariable Long id, @RequestBody Cart userParam) {
      Cart item = this.repository.findById(id).get();
      item.setProduct(userParam.getProduct());
      item.setUser(userParam.getUser());
      return this.repository.save(item);
  }

}