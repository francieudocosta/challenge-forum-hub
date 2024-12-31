package alura.challenge.forumHub.domain.topico;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroNovoTopicoDTO(

        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String autor,
        @NotNull
        Long idCurso
) { }
