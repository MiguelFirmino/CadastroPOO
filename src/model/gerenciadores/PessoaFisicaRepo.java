/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.gerenciadores;

import model.entidades.PessoaFisica;

/**
 *
 * @author Miguel
 */
public class PessoaFisicaRepo extends PessoaRepo<PessoaFisica> {
    public PessoaFisicaRepo() {
        this.tipoPessoas = "Pessoas Físicas";
    }
    
    public void alterar(int id, PessoaFisica novaPessoa) {
        for (PessoaFisica pessoa : this.listaPessoa) {
            if (pessoa.getId() == novaPessoa.getId()) {
                pessoa.setNome(novaPessoa.getNome());
                pessoa.setIdade(novaPessoa.getIdade());
                pessoa.setCpf(novaPessoa.getCpf());
                break; // encerrar na primeira ocorrência
            }
        }
    }
}