package alura.challenge.forumHub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopicoDTO(

        @NotNull
        Long id,
        String titulo,
        String mensagem
) { }
