package alura.challenge.forumHub.domain.topico.validacoes;

import alura.challenge.forumHub.domain.topico.DadosCadastroNovoTopicoDTO;

public interface ValidadorTopicos {

    void validar(DadosCadastroNovoTopicoDTO dados);
}
