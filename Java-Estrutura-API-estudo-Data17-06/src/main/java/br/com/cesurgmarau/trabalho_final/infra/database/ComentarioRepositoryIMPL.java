package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Comentario.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComentarioRepositoryIMPL implements ComentarioRepository {
    @Autowired
    EntityManager entityManager;

    @Transactional
    @Override
    public void cadastrarComentario(Comentario comentario) {
        String query = "INSERT INTO comentario(assunto, descricao, usuario_id, produto_id) VALUES(:assunto, :descricao, :usuario_id, :produto_id)";

        entityManager.createNativeQuery(query)
                .setParameter("assunto", comentario.getAssunto())
                .setParameter("descricao", comentario.getDescricao())
                .setParameter("usuario_id", comentario.getUsuario().getId())
                .setParameter("produto_id", comentario.getProduto().getId())
                .executeUpdate();
    }

    @Override
    public List<Comentario> listarComentario() {
        String query = "SELECT * FROM comentario";

        return entityManager.createNativeQuery(query, Comentario.class)
                .getResultList();
    }

    @Override
    public Comentario getId(Long id) {
        String query = "SELECT * FROM comentario WHERE id = :id";

        return (Comentario) entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    @Transactional
    @Override
    public void atualizarComentario(Comentario comentario, Long id) {
        String query = "UPDATE comentario SET(assunto, descricao, usuario_id, produto_id) = (:assunto, :descricao, :usuario_id, :produto_id) WHERE id = :id";

        entityManager.createNativeQuery(query)
                .setParameter("assunto", comentario.getAssunto())
                .setParameter("descricao", comentario.getDescricao())
                .setParameter("usuario_id", comentario.getUsuario().getId())
                .setParameter("produto_id", comentario.getProduto().getId())
                .setParameter("id", id)
                .executeUpdate();
    }
    @Transactional
    @Override
    public void deletaComentario(Long id) {
        String query = "DELETE FROM comentario WHERE id = :id";

        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }
}
