package br.com.Spring36SCJCard.entity;


import br.com.Spring36SCJCard.dto.AlunoDTO;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "TB_ALUNO")
@EntityListeners(AuditingEntityListener.class)
public class Aluno {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer rm;

    @Column
    private String nome;

    @Column
    private String codigoCurso;

    public Aluno(AlunoDTO alunoDTO){
        this.id = alunoDTO.getId();
        this.rm = alunoDTO.getRm();
        this.nome = alunoDTO.getNome();
        this.codigoCurso = alunoDTO.getCodigocurso();
    }

    public Aluno() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRm() {
        return rm;
    }

    public void setRm(Integer rm) {
        this.rm = rm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }
}
