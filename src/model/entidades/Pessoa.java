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
public class Pessoa implements Serializable {
    protected int id;
    protected String nome;
    
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public void exibir() {
        System.out.println("""
                           Id: %d
                           Nome: %s 
                           """.formatted(this.id, this.nome));
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
}