package br.com.Spring36SCJCard.service;

import br.com.Spring36SCJCard.dto.TransacaoDTO;
import br.com.Spring36SCJCard.entity.Aluno;

import java.util.List;

public interface TransacaoService {
    List<TransacaoDTO> findAll();
    List<TransacaoDTO> findByAluno(Aluno aluno);
    TransacaoDTO create(TransacaoDTO transacaoDTO);
    void delete(Integer id);
}
