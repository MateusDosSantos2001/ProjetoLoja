package com.example;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserResource {

  @Autowired
  private UserRepository repository;
  /*
   * Construtor do UserResource, preparando uma lista de úsuarios
   */
  public UserResource(UserRepository repository) {
    this.repository = repository;
  }

  /**
   * Metodo de requisicao do tipo GET, para uma lista
   * @param raca tipo de raca para filtrar
   * @return lista de produtos, filtrados ou nao
   */
  @RequestMapping(value = "/users/", method = RequestMethod.GET)
  public Iterable<User> buscarUsuarios(@RequestParam(required = false) String raca) {
    return this.repository.findAll();
  }

  /**
   * Metodo de requisicao do tipo GET, para um item
   * @param id identificador ou indice da colecao dos produtos
   * @return item de produto unico
   */
  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
  public Optional<User> buscarUsuario(@PathVariable Long id) {
    return this.repository.findById(id);
    // return this.produtos.get(id - 1);
  }
  
  /**
   * Metodo de requisicao do tipo DELETE, para remover um item
   * @param id identificador ou indice da colecao dos produtos
   */
  @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
  public void removerUsuario(@PathVariable Long id) {
    this.repository.deleteById(id);
    // this.produtos.remove(id - 1);
  }

  @RequestMapping(value = "/users/", 
  method = RequestMethod.POST)
  public User criarUsuario(@RequestBody User usuario) {
    String nome = usuario.getNome();
    String sobrenome = usuario.getSobrenome();
    Long senha = usuario.getSenha();
    return this.repository.save(new User(nome, sobrenome, senha));
    // return new Product(nome, sobrenome, senha);
  }

  @RequestMapping(value="/users/{id}", 
  method=RequestMethod.PUT)
  public void alterarUsuario(@PathVariable Long id,
  @RequestBody User userParam) {
      // Product produto = this.produtos.get(id - 1);
      User user = this.repository.findById(id).get();
      user.setNome(userParam.getNome());
      user.setSobrenome(userParam.getSobrenome());
      user.setSenha(userParam.getSenha());
  }

}
