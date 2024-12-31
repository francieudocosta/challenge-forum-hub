package alura.challenge.forumHub.domain.topico;

import alura.challenge.forumHub.domain.curso.Curso;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String titulo;
    @Setter
    private String mensagem;

    private final LocalDateTime data = LocalDateTime.now();
    @Setter
    private Boolean estado = true;
    @Setter
    private String autor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id")
    @Setter
    private Curso curso;
}
