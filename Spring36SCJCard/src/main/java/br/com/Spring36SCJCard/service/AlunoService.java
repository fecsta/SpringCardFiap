package br.com.Spring36SCJCard.service;

import br.com.Spring36SCJCard.dto.AlunoDTO;

import java.util.List;

public interface AlunoService {

    List<AlunoDTO> findAll();
    AlunoDTO findById(Integer id);
    AlunoDTO findByRm(Integer rm);
    List<AlunoDTO> findByNome(String nome);
    AlunoDTO create(AlunoDTO alunoDTO);
    AlunoDTO update(Integer id, AlunoDTO alunoDTO);
    void delete(Integer id);

}
