package alura.challenge.forumHub.domain.topico.validacoes;

import alura.challenge.forumHub.domain.ValidacaoException;
import alura.challenge.forumHub.domain.topico.DadosCadastroNovoTopicoDTO;
import alura.challenge.forumHub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
A API não deve permitir o cadastro de tópicos duplicados (contendo o mesmo título e mensagem).
 */
@Component
public class ValidadorTopicosIguais implements ValidadorTopicos{

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DadosCadastroNovoTopicoDTO dados) {

        var titulo = dados.titulo();
        var mensagem = dados.mensagem();

        if(isContemTopico(titulo, mensagem)){

            throw new ValidacaoException("Já existe Topico com esse titulo e mensagem!");
        }

    }

    private Boolean isContemTopico(String titulo, String mensagem){

        return topicoRepository.existsTopicoByTituloContainsIgnoreCaseAndMensagemContainsIgnoreCase(titulo,mensagem);
    }
}
