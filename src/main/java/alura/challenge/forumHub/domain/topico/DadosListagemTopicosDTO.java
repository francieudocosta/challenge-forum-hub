package alura.challenge.forumHub.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopicosDTO(

        Long id,
        String titulo,
        String mensagem,
        LocalDateTime data,
        Boolean estado,
        String autor
) { }
