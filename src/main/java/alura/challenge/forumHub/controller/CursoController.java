package alura.challenge.forumHub.controller;

import alura.challenge.forumHub.domain.curso.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoMapper cursoMapper;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCursoDTO dados, UriComponentsBuilder uriBuilder){


        var curso = cursoMapper.toEntity(dados);

        cursoRepository.save(curso);

        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(cursoMapper.toDto(curso));
    }


    @GetMapping
    public ResponseEntity<Page<DadosListagemCursoDTO>> listar(@PageableDefault(size=10, page=0, sort={"nome"}) Pageable paginacao){

        var page = cursoRepository.findAll(paginacao).map(n -> cursoMapper.toDtoListagem(n));

        return ResponseEntity.ok(page);
    }
}
