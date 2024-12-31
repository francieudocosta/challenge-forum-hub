package alura.challenge.forumHub.domain.curso;

import alura.challenge.forumHub.domain.topico.Topico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.List;

@Table(name = "cursos")
@Entity(name = "Curso")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @Setter
    private String nome;

    @Setter
    @Enumerated(EnumType.STRING)
    private  Categoria categoria;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<Topico> topicos;
}
