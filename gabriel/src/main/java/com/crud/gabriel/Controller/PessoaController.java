package com.crud.gabriel.Controller;

import com.crud.gabriel.entity.Endereco;
import com.crud.gabriel.entity.Pessoa;
import com.crud.gabriel.repository.PessoaRepository;
import com.crud.gabriel.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Pessoa> listarTodasPessoas() {
        return pessoaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        try {
            if (pessoa.getEnderecos() != null) {
                for (Endereco enderecos : pessoa.getEnderecos()) {
                    enderecos.setPessoa(pessoa);
                }
            }

            if (pessoa.getEnderecos() == null) {
                pessoa.setEnderecos(new ArrayList<>());
            }

            Pessoa pessoaSalva = pessoaRepository.save(pessoa);
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Optional<Pessoa> pessoaExistente = pessoaRepository.findById(id);
        if (pessoaExistente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Pessoa pessoaAtualizada = pessoaExistente.get();
        pessoaAtualizada.setNome(pessoa.getNome());
        pessoaAtualizada.setIdade(pessoa.getIdade());

        if (pessoa.getEnderecos() != null) {
            for (Endereco endereco : pessoa.getEnderecos()) {
                endereco.setPessoa(pessoaAtualizada);
            }
            enderecoRepository.saveAll(pessoa.getEnderecos());
        }

        pessoaRepository.save(pessoaAtualizada);
        return new ResponseEntity<>(pessoaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPessoa(@PathVariable Long id) {
        Optional<Pessoa> pessoaExistente = pessoaRepository.findById(id);
        if (pessoaExistente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        pessoaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/idade")
    public ResponseEntity<Object> mostrarIdade(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            return new ResponseEntity<>(pessoa.get().getIdade(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
