package alura.challenge.forumHub.domain.topico;

import alura.challenge.forumHub.domain.ValidacaoException;
import alura.challenge.forumHub.domain.curso.CursoRepository;
import alura.challenge.forumHub.domain.topico.validacoes.ValidadorTopicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private List<ValidadorTopicos> validadorTopicos;

    @Autowired
    private TopicoMapper topicoMapper;

    public DadosDetalhamentoTopicoDTO criarNovoTopico(DadosCadastroNovoTopicoDTO dados){

        validadorTopicos.forEach(t -> t.validar(dados));

        var topico = topicoMapper.toEntiny(dados);
        topicoRepository.save(topico);

        topico = topicoRepository.findByIdWithCurso(topico.getId()).orElseThrow(() -> new ValidacaoException("Topico não encontrado"));

        return  topicoMapper.toDTO(topico);
    }

    public Page<DadosListagemTopicosDTO> listarTodosTopicos(Pageable paginacao){

        return topicoRepository.findAll(paginacao).map(t -> topicoMapper.toDTOListar(t));
    }

    public Page<DadosListagemTopicosDTO> listarTodosTopicosAtivos(Pageable paginacao){

        return topicoRepository.findByEstado(true,paginacao).map(t -> topicoMapper.toDTOListar(t));
    }

    public Page<DadosListagemTopicosDTO> listarTodosTopicosDesativados(Pageable paginacao){

        return topicoRepository.findByEstado(false,paginacao).map(t -> topicoMapper.toDTOListar(t));
    }


    public Page<DadosListagemTopicosDTO> listarTopicosPorCurso(Pageable paginacao, String nomeCurso){

        var curso = cursoRepository.findCursoByNomeContainsIgnoreCase(nomeCurso);


        return topicoRepository.findByCursoIdWithPagination(curso.getId(),paginacao)
                .map(t-> topicoMapper.toDTOListar(t));
    }

    public DadosDetalhamentoTopicoDTO atualizarTopico(DadosAtualizarTopicoDTO dados){

        var topico = topicoRepository.getReferenceById(dados.id());

        topico.atualizarInformacoes(dados);

        return topicoMapper.toDTO(topico);
    }

    public void excluirTopico(Long id){

        topicoRepository.findById(id).orElseThrow(() -> new ValidacaoException("Tópico não encontrado"));

        topicoRepository.deleteById(id);
    }

    public void desativarTopico(Long id){

        var topico = topicoRepository.getReferenceById(id);

        topico.desativarTopico(id);
    }
}
