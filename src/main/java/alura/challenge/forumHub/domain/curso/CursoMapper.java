package alura.challenge.forumHub.domain.curso;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    //@Mapping(target = "id", ignore = true)
    //@Mapping(target = "topicos", ignore = true)
    Curso toEntity(DadosCadastroCursoDTO dto);

    DadosDetalhadoCursoDTO toDto(Curso curso);

    DadosListagemCursoDTO toDtoListagem(Curso curso);
}
