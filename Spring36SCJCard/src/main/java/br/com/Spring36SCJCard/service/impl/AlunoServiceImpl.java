package br.com.Spring36SCJCard.service.impl;

import br.com.Spring36SCJCard.dto.AlunoDTO;
import br.com.Spring36SCJCard.entity.Aluno;
import br.com.Spring36SCJCard.repository.AlunoRepository;
import br.com.Spring36SCJCard.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public List<AlunoDTO> findAll() {
        List<Aluno> alunoList;

        alunoList = alunoRepository.findAll();

        return alunoList
                .stream()
                .map(AlunoDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public AlunoDTO findById(Integer id) {

        return saveAndGetAlunoDTO(getAluno(id));
    }

    @Override
    public AlunoDTO findByRm(Integer rm) {

        return new AlunoDTO(this.alunoRepository.findByRm(rm));
    }

    @Override
    public List<AlunoDTO> findByNome(String nome) {
        List<Aluno> alunoList;

        alunoList = alunoRepository.findByNome(nome);

        return alunoList
                .stream()
                .map(AlunoDTO::new)
                .collect(Collectors.toList());
    }

    private Aluno getAluno(Integer id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public AlunoDTO create(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno(alunoDTO);

        return saveAndGetAlunoDTO(aluno);
    }

    @Override
    public AlunoDTO update(Integer id, AlunoDTO alunoDTO) {
        Aluno aluno =  getAluno(id);

        aluno.setNome(alunoDTO.getNome());
        aluno.setRm(alunoDTO.getRm());
        aluno.setCodigoCurso(alunoDTO.getCodigocurso());

        return saveAndGetAlunoDTO(aluno);
    }

    private AlunoDTO saveAndGetAlunoDTO(Aluno aluno) {
        Aluno savedAluno = alunoRepository.save(aluno);
        return new AlunoDTO(savedAluno);
    }

    @Override
    public void delete(Integer id) {
        Aluno aluno = getAluno(id);
        alunoRepository.delete(aluno);
    }
}
