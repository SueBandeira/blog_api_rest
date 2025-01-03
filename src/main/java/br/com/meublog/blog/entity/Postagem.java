package br.com.meublog.blog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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
  private Autor autor;

  @OneToMany(mappedBy = "postagem")
  private List<Comentario> comentario = new ArrayList<Comentario>();
}
