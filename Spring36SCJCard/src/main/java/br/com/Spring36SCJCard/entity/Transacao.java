package br.com.Spring36SCJCard.entity;


import br.com.Spring36SCJCard.dto.Autorizadora;
import br.com.Spring36SCJCard.dto.TransacaoDTO;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.Valid;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "TB_TRANSACAO")
@EntityListeners(AuditingEntityListener.class)
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Valid
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @Column
    @Enumerated(EnumType.STRING)
    private Autorizadora autorizadora;

    @Column
    private BigDecimal valor;

    public Transacao() {

    }

    public Transacao(TransacaoDTO transacaoDTO) {
        this.aluno = transacaoDTO.getAluno();
        this.autorizadora = transacaoDTO.getAutorizadora();
        this.valor = transacaoDTO.getValor();
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
}
