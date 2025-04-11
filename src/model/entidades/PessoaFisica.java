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
public class PessoaFisica extends Pessoa implements Serializable {
    private int idade;
    private String cpf;
    
    public PessoaFisica(int id, String nome, int idade, String cpf) {
        super(id, nome);
        this.idade = idade;
        this.cpf = cpf;
    }
    
    @Override
    public void exibir() {
        System.out.println("""
                           Id: %d 
                           Nome: %s 
                           CPF: %s 
                           Idade: %d
                           """.formatted(this.id, this.nome, this.cpf, this.idade));
    }
    
    public int getIdade() {
        return this.idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}