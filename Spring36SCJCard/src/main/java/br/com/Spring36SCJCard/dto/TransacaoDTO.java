package br.com.Spring36SCJCard.dto;

import br.com.Spring36SCJCard.entity.Aluno;
import br.com.Spring36SCJCard.entity.Transacao;

import java.math.BigDecimal;

public class TransacaoDTO {

    public TransacaoDTO(Integer id, Aluno aluno, Autorizadora autorizadora, BigDecimal valor) {
        this.id = id;
        this.aluno = aluno;
        this.autorizadora = autorizadora;
        this.valor = valor;
    }

    private Integer id;
    private Aluno aluno;
    private Autorizadora autorizadora;
    private BigDecimal valor;

    public TransacaoDTO(Transacao transacao) {
        this.id = transacao.getId();
        this.aluno = transacao.getAluno();
        this.autorizadora = transacao.getAutorizadora();
        this.valor = transacao.getValor();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Autorizadora getAutorizadora() {
        return autorizadora;
    }

    public void setAutorizadora(Autorizadora autorizadora) {
        this.autorizadora = autorizadora;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Aluno: " + aluno.getNome() + " / Autorizadora: " + autorizadora + " / Valor: " + valor.toString();
    }
}
