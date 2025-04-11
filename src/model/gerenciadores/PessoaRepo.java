/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.gerenciadores;

import model.entidades.Pessoa;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.File;

/**
 *
 * @author Miguel
 * @param <T>
 * Classe genérica para diferentes tipos de pessoa
 */
public class PessoaRepo<T extends Pessoa> {
    protected ArrayList<T> listaPessoa = new ArrayList<T>();
    protected String tipoPessoas;
    
    public PessoaRepo() {
        // tipo genérico
        this.tipoPessoas = "pessoas";
    }
    
    public void exibirTodos() {
        for (T pessoa : this.listaPessoa) {
            pessoa.exibir();
        }
    }
    
    public void persistir(String nomeArquivo) { 
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(this.listaPessoa);
            System.out.println("Lista de " + this.tipoPessoas + " salva com sucesso!");
        } catch(IOException exception) {
            System.out.printf("Erro ao salvar lista de %s: %s%n", this.tipoPessoas, exception.getMessage());
        }
    }
    
    public void recuperar(String nomeArquivo) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            ArrayList<T> dados = (ArrayList<T>) ois.readObject();
            this.listaPessoa = dados;
            System.out.println("Lista de " + this.tipoPessoas + " recuperada com sucesso!");
        } catch(IOException | ClassNotFoundException exception) {
            System.out.printf("Erro ao recuperar lista de %s: %s%n", this.tipoPessoas, exception.getMessage());
        }
    }
    
    public void inserir(T pessoa) {
        this.listaPessoa.add(pessoa);
        System.out.println("Inserida nova pessoa com sucesso!");
    }
        
    public void excluir(int id) {
        this.listaPessoa.removeIf(person -> person.getId() == id);
        System.out.println("Excluída pessoa com sucesso!");
    }
    
    public T obter(int id) {
        for (T pessoa : this.listaPessoa) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        System.out.println("Não há nenhuma ocorrência de: " + id + "!");
        return null;
    }
    
    public ArrayList<T> obterTodos() {
        return this.listaPessoa;
    }
}