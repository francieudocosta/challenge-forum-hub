package alura.challenge.forumHub.domain.topico;

import alura.challenge.forumHub.domain.curso.DadosDetalhadoCursoDTO;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopicoDTO(

        Long id,
        String titulo,
        String mensagem,
        LocalDateTime data,
        Boolean estado,
        String autor,
        DadosDetalhadoCursoDTO curso
) { }
