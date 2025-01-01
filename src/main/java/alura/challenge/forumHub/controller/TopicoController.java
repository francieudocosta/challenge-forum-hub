package alura.challenge.forumHub.controller;

import alura.challenge.forumHub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopicoDTO> cadastrar(@RequestBody @Valid DadosCadastroNovoTopicoDTO dados){

        var dto = topicoService.criarNovoTopico(dados);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicosDTO>> listar(@PageableDefault(size=10, page=0, sort={"data"},
            direction = Sort.Direction.DESC) Pageable paginacao){

        return ResponseEntity.ok(topicoService.listarTodosTopicos(paginacao));
    }

    @GetMapping("/ativos")
    public ResponseEntity<Page<DadosListagemTopicosDTO>> listarTopicosAtivos(@PageableDefault(size=10, page=0, sort={"data"},
            direction = Sort.Direction.DESC) Pageable paginacao){

        return ResponseEntity.ok(topicoService.listarTodosTopicosAtivos(paginacao));

    }

    @GetMapping("/desativados")
    public ResponseEntity<Page<DadosListagemTopicosDTO>> listarTopicosDesativados(@PageableDefault(size=10, page=0, sort={"data"},
            direction = Sort.Direction.DESC) Pageable paginacao){

        return ResponseEntity.ok(topicoService.listarTodosTopicosDesativados(paginacao));

    }

    @GetMapping("/{nome}")
    public  ResponseEntity<Page<DadosListagemTopicosDTO>> listarTopicosCurso(@PathVariable String nome, @PageableDefault(size=10, page=0, sort={"data"}, direction = Sort.Direction.DESC) Pageable paginacao){

        var dto = topicoService.listarTopicosPorCurso(paginacao, nome);

        return  ResponseEntity.ok(dto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopicoDTO> atualizar(@RequestBody @Valid DadosAtualizarTopicoDTO dados){

        var topicoAtualizado = topicoService.atualizarTopico(dados);

        return  ResponseEntity.ok(topicoAtualizado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){

        topicoService.excluirTopico(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/desativar/{id}")
    @Transactional
    public ResponseEntity<Void> desativar(@PathVariable Long id){

        topicoService.desativarTopico(id);

        return ResponseEntity.noContent().build();
    }
}
