package br.com.meublog.blog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
@Setter
@Getter
@Entity
public class Postagem implements Serializable {

  private static final long seralVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String titulo;
  private String texto;

  @ManyToOne
  @JoinColumn(name = "autor_id", nullable = false)
  private Autor autor;

  @OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL)
  private List<Comentario> comentarios;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public Autor getAutor() {
    return autor;
  }

  public void setAutor(Autor autor) {
    this.autor = autor;
  }

  public List<Comentario> getComentario() {
    return comentarios;
  }

  public void setComentario(List<Comentario> comentarios) {
    this.comentarios = comentarios;
  }
}
