package br.com.meublog.blog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
@Setter
@Getter
@Entity
public class Comentario implements Serializable {

  private static final long seralVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "postagem_id", nullable = false)
  private Postagem postagem;

  @ManyToOne
  @JoinColumn(name = "autor_id", nullable = false)
  private Autor autor;

  private String texto;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }
}
