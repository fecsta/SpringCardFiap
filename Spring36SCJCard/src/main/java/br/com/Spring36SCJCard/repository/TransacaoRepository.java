package br.com.Spring36SCJCard.repository;

import br.com.Spring36SCJCard.entity.Aluno;
import br.com.Spring36SCJCard.entity.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao,Integer> {
    Page<Transacao> findAll(Pageable pageable);

    @Query("from Transacao t where t.aluno = :aluno")
    List<Transacao> findByAluno(@Param("aluno") Aluno aluno);
}
