package br.com.cesurgmarau.trabalho_final.core.dto;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ComentarioDTO {
    private String assunto;
    private String descricao;
    private Long usuario_id;
    private Long produto_id;
}
