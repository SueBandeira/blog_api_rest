package br.com.meublog.blog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
@Setter
@Getter
@Entity
public class Autor implements Serializable {

  private static final long seralVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String descricao;

  @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
  private List<Postagem> postagens;

  @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
  private List<Comentario> comentarios;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
