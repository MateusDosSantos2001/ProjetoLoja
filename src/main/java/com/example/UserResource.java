package com.example;

import java.util.Optional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
   * @return lista de usuários
   */
  @RequestMapping(value = "/users/", method = RequestMethod.GET)
  public Iterable<User> buscarUsuarios() {
    return this.repository.findAll();
  }

  /**
   * Metodo de requisicao do tipo GET, para um item
   * @param id identificador do usuário
   * @return usuário unico
   */
  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
  public Optional<User> buscarUsuario(@PathVariable Long id) {
    return this.repository.findById(id);
  }
  
  /**
   * Metodo de requisicao do tipo DELETE, para remover um usuário
   * @param id identificador do usuário
   */
  @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
  public void removerUsuario(@PathVariable Long id) {
    this.repository.deleteById(id);
  }

    /**
   * Metodo de requisicao do tipo POST, para adicionar um novo usuário
   * @return um novo usuário na lista users
   */
  @RequestMapping(value = "/users/", 
  method = RequestMethod.POST)
  public User criarUsuario(@RequestBody User usuario) {
    String nome = usuario.getNome();
    String sobrenome = usuario.getSobrenome();
    Long senha = usuario.getSenha();
    return this.repository.save(new User(nome, sobrenome, senha));
  }

  /**
   * Metodo de requisicao do tipo PUT, para atualizar um usuário existente
   * @param id identificador do usuário a ser atualizado na lista users
   */
  @RequestMapping(value="/users/{id}", 
  method=RequestMethod.PUT)
  public void alterarUsuario(@PathVariable Long id,
  @RequestBody User userParam) {
      User user = this.repository.findById(id).get();
      user.setNome(userParam.getNome());
      user.setSobrenome(userParam.getSobrenome());
      user.setSenha(userParam.getSenha());
  }

}
