package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Comentario.ComentarioController;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Comentario.ComentarioUsecase;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Produto.ProdutoUsecase;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Usuario.UsuarioUsecase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioDTO;
import br.com.cesurgmarau.trabalho_final.core.usecase.UsuarioUsecaseIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComentarioControllerIMPL implements ComentarioController {
    @Autowired
    ComentarioUsecase comentarioUsecase;
    @Autowired
    UsuarioUsecase usuarioUsecase;
    @Autowired
    ProdutoUsecase produtoUsecase;

    @Override @PostMapping("/comentario")
    public void cadastrarComentario(@RequestBody ComentarioDTO comentarioDTO) {
        Usuario usuario = usuarioUsecase.getId(comentarioDTO.getUsuario_id());
        Produto produto = produtoUsecase.getId(comentarioDTO.getProduto_id());

        comentarioUsecase.cadastrarComentario(new Comentario(null, comentarioDTO.getAssunto(), comentarioDTO.getDescricao(), usuario,produto));
    }

    @Override @GetMapping("/comentario")
    public List<Comentario> listarComentario() {
        return comentarioUsecase.listarComentario();
    }

    @Override @GetMapping("/comentario/{id}")
    public Comentario getId(@PathVariable Long id) {
        return comentarioUsecase.getId(id);
    }

    @Override @PutMapping("/comentario/{id}")
    public void atualizarComentario(@RequestBody ComentarioDTO comentarioDTO, Long id) {
        Usuario usuario = usuarioUsecase.getId(comentarioDTO.getUsuario_id());
        Produto produto = produtoUsecase.getId(comentarioDTO.getProduto_id());

        comentarioUsecase.atualizarComentario(new Comentario(null, comentarioDTO.getAssunto(), comentarioDTO.getDescricao(), usuario,produto), id);
    }

    @Override @DeleteMapping("/comentario/{id}")
    public void deletaComentario(Long id) {
        comentarioUsecase.deletaComentario(id);
    }
}
