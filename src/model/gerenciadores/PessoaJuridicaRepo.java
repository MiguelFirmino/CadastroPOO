/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.gerenciadores;

import model.entidades.PessoaJuridica;

/**
 *
 * @author Miguel
 */
public class PessoaJuridicaRepo extends PessoaRepo<PessoaJuridica> {
    public PessoaJuridicaRepo() {
        this.tipoPessoas = "Pessoas Jurídicas";
    }
    
    public void alterar(int id, PessoaJuridica novaPessoa) {
        for (PessoaJuridica pessoa : this.listaPessoa) {
            if (pessoa.getId() == novaPessoa.getId()) {
                pessoa.setNome(novaPessoa.getNome());
                pessoa.setCnpj(novaPessoa.getCnpj());
            }
            break; // encerrar na primeira ocorrência
        }
    }
}
