package alura.challenge.forumHub.domain.topico;

import alura.challenge.forumHub.domain.curso.Curso;
import alura.challenge.forumHub.domain.curso.CursoMapper;
import alura.challenge.forumHub.domain.curso.DadosDetalhadoCursoDTO;
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
