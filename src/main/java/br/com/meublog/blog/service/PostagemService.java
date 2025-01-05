package br.com.meublog.blog.service;

import br.com.meublog.blog.entity.Postagem;
import br.com.meublog.blog.interfaces.PostagemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostagemService {

  @Autowired
  private PostagemRepository repo;

  public List<Postagem> buscarTodos() {
    return repo.findAll();
  }

  public Postagem buscar(int id) {
    Optional<Postagem> obj = repo.findById(id);
    return obj.orElse(null);
  }

  public Postagem salvar(Postagem obj) {
    obj.setId(null);
    return repo.save(obj);
  }

  public void deletar (int id) {
    buscar(id);
    repo.deleteById(id);
  }

  public Postagem editar (Postagem obj) {
    Postagem newObj = buscar(obj.getId());
    modificar(newObj, obj);
    return repo.save(newObj);
  }

  public void modificar(Postagem newObj, Postagem obj) {
    newObj.setAutor(obj.getAutor());
    newObj.setComentario(obj.getComentario());
    newObj.setTexto(obj.getTexto());
    newObj.setTitulo(obj.getTitulo());
  }
}
