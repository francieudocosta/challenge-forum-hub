package alura.challenge.forumHub.domain.curso;

import alura.challenge.forumHub.domain.topico.Topico;

import java.util.List;

public record DadosDetalhadoCursoDTO(

        Long id,
        String nome,
        Categoria categoria
) { }
