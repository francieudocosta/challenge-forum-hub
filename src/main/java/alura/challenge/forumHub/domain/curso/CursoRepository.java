package alura.challenge.forumHub.domain.curso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findCursoByNomeContainsIgnoreCase(String nome);
}
