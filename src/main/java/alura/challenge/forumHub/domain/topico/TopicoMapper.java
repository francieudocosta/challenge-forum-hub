package alura.challenge.forumHub.domain.topico;

import alura.challenge.forumHub.domain.curso.CursoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CursoMapper.class)
public interface TopicoMapper {

    @Mapping(target = "curso.id", source = "idCurso")
    Topico toEntiny(DadosCadastroNovoTopicoDTO topicoDto);

    @Mapping(target = "curso", source = "curso")
    DadosDetalhamentoTopicoDTO toDTO(Topico topico);

    DadosListagemTopicosDTO toDTOListar(Topico t);
}
