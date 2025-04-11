/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entidades;

import java.io.Serializable;

/**
 *
 * @author Miguel
 */
public class PessoaJuridica extends Pessoa implements Serializable {
    private String cnpj;
    
    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }
    
    @Override
    public void exibir() {
        System.out.println("""
                           Id: %d
                           Nome: %s 
                           CNPJ: %s
                           """.formatted(this.id, this.nome, this.cnpj));
    }
    
    public String getCnpj() {
        return this.cnpj;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
