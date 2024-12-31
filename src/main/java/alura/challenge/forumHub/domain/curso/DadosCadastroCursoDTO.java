package alura.challenge.forumHub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCursoDTO(

        @NotBlank
        String nome,

        @NotNull
        Categoria categoria
) { }
