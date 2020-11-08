package br.com.Spring36SCJCard.dto;

import br.com.Spring36SCJCard.entity.Aluno;

public class AlunoDTO {

    private Integer id;
    private String nome;
    private Integer rm;
    private String codigocurso;

    public AlunoDTO() {
    }

    public AlunoDTO(Aluno aluno){
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.rm = aluno.getRm();
        this.codigocurso = aluno.getCodigoCurso();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getRm() {
        return rm;
    }

    public void setRm(Integer rm) {
        this.rm = rm;
    }

    public String getCodigocurso() {
        return codigocurso;
    }

    public void setCodigocurso(String codigocurso) {
        this.codigocurso = codigocurso;
    }




}
