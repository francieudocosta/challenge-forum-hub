package alura.challenge.forumHub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Boolean existsTopicoByTituloContainsIgnoreCaseAndMensagemContainsIgnoreCase(String titulo, String mensagem);

    @Query("select  t from Topico t join fetch  t.curso where t.id = :id")
    Optional<Topico> findByIdWithCurso(Long id);

    @Query("select t from Topico t join fetch t.curso where t.curso.id = :id")
    Page<Topico> findByCursoIdWithPagination(Long id, Pageable paginacao);

    @Query("select  t from Topico t where t.estado = :estado")
    Page<Topico> findByEstado(Boolean estado, Pageable pageable);
}
