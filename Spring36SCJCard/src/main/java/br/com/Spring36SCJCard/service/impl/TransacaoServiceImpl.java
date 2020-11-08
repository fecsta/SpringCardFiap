package br.com.Spring36SCJCard.service.impl;


import br.com.Spring36SCJCard.dto.TransacaoDTO;
import br.com.Spring36SCJCard.entity.Aluno;
import br.com.Spring36SCJCard.entity.Transacao;
import br.com.Spring36SCJCard.repository.TransacaoRepository;
import br.com.Spring36SCJCard.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoServiceImpl  implements TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    @Override
    public List<TransacaoDTO> findAll() {
        List<Transacao> transacoes = this.repository.findAll();

        return transacoes.stream()
                .map(t -> new TransacaoDTO(t))
                .collect(Collectors.toList());
    }

    @Override
    public List<TransacaoDTO> findByAluno(Aluno aluno) {
        List<Transacao> transacoes = this.repository.findByAluno(aluno);

        return transacoes.stream()
                .map(t -> new TransacaoDTO(t))
                .collect(Collectors.toList());
    }

    @Override
    public TransacaoDTO create(TransacaoDTO transacaoDTO) {
        Transacao transacao = new Transacao(transacaoDTO);
        return saveAndGetTransacaoDTO(transacao);
    }

    @Override
    public void delete(Integer id) {
        this.repository.deleteById(id);
    }

    private TransacaoDTO saveAndGetTransacaoDTO(Transacao transacao) {
        Transacao transacaoSalva = this.repository.saveAndFlush(transacao);
        return new TransacaoDTO(transacaoSalva);
    }
}
