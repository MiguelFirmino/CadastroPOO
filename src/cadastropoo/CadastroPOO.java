/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.util.Scanner;
import model.gerenciadores.PessoaFisicaRepo;
import model.gerenciadores.PessoaJuridicaRepo;
import model.entidades.PessoaFisica;
import model.entidades.PessoaJuridica;

/**
 *
 * @author Miguel
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nomeRegistro = "data/dados.bin";
                
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        
        // int id, String nome, int idade, String cpf
        PessoaFisica pessoa1 = new PessoaFisica(1, "Miguel", 2, "11111111111");
        PessoaFisica pessoa2 = new PessoaFisica(2, "João", 26, "22222222222");
        
        repo1.inserir(pessoa1);
        repo1.inserir(pessoa2);
        
        repo1.persistir(nomeRegistro);
        
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        
        repo2.recuperar(nomeRegistro);
        
        repo2.exibirTodos();
        
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        
        // int id, String nome, String cnpj
        PessoaJuridica pessoa3 = new PessoaJuridica(3, "Binance", "1024");
        PessoaJuridica pessoa4 = new PessoaJuridica(4, "Almanac", "2048");
        
        repo3.inserir(pessoa3);
        repo3.inserir(pessoa4);
        
        repo3.persistir(nomeRegistro);
        
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        
        repo4.recuperar(nomeRegistro);
        
        repo4.exibirTodos();
        
        Scanner scanner = new Scanner(System.in);
        boolean estaRodando = true;
        while(estaRodando) {
            // Opções do Usuário
            System.out.println("""
                   ========================
                   1 - Incluir Pessoa
                   2 - Alterar Pessoa
                   3 - Excluir Pessoa
                   4 - Buscar pelo Id
                   5 - Exibir Todos
                   6 - Persistir Dados
                   7 - Recuperar Dados
                   0 - Finalizar Programa
                   ========================
                   """);
            
            int escolha = scanner.nextInt();
            
            switch(escolha){
                case 1: { // Incluir Pessoa
                    String tipoPessoa = escolherTipoPessoa(scanner);
                    
                    System.out.print("Insira o ID da pessoa: ");
                    int id = scanner.nextInt();
                    
                    System.out.print("Insira o nome da pessoa: ");
                    String nome = scanner.next();
                    
                    if (tipoPessoa.equals("F")) {
                        System.out.print("Insira a idade da pessoa: ");
                        int idade = scanner.nextInt();
                        
                        System.out.print("Insira o cpf da pessoa: ");
                        String cpf = scanner.next();
                        
                        repo1.inserir(new PessoaFisica(id, nome, idade, cpf));
                    } else {
                        System.out.print("Insira o cnpj da pessoa: ");
                        String cnpj = scanner.next();
                        
                        repo3.inserir(new PessoaJuridica(id, nome, cnpj));
                    }
                    break;
                }
                case 2: { // Alterar Pessoa
                    String tipoPessoa = escolherTipoPessoa(scanner);
                    
                    System.out.print("Insira o ID da pessoa: ");
                    int id = scanner.nextInt();
                    
                    if (tipoPessoa.equals("F")) {
                        repo1.obter(id).exibir();
                        
                        System.out.print("Insira o nome da pessoa: ");
                        String nome = scanner.next();
                        
                        System.out.print("Insira a idade da pessoa: ");
                        int idade = scanner.nextInt();
                        
                        System.out.print("Insira o cpf da pessoa: ");
                        String cpf = scanner.next();
                        
                        PessoaFisica novaPessoa = new PessoaFisica(id, nome, idade, cpf);
                        repo1.alterar(id, novaPessoa);
                    } else {
                        repo3.obter(id).exibir();
                        
                        System.out.print("Insira o nome da pessoa: ");
                        String nome = scanner.next();
                        
                        System.out.print("Insira o cnpj da pessoa: ");
                        String cnpj = scanner.next();
                        
                        PessoaJuridica novaPessoa = new PessoaJuridica(id, nome, cnpj);
                        repo3.alterar(id, novaPessoa);
                    }
                    break;
                }
                case 3: { // Excluir Pessoa
                    String tipoPessoa = escolherTipoPessoa(scanner);
                    
                    System.out.print("Insira o ID da pessoa a ser excluída: ");
                    int id = scanner.nextInt();
                    
                    if (tipoPessoa.equals("F")) {
                        repo1.excluir(id);
                    } else {
                        repo3.excluir(id);
                    }
                    break;
                }
                case 4: { // Buscar pelo ID
                    String tipoPessoa = escolherTipoPessoa(scanner);
                    
                    System.out.print("Insira o ID da pessoa: ");
                    int id = scanner.nextInt();
                    
                    if (tipoPessoa.equals("F")) {
                        repo1.obter(id).exibir();
                    } else {
                        repo3.obter(id).exibir();
                    }
                    break;
                }
                case 5: { // Exibir Todos
                    String tipoPessoa = escolherTipoPessoa(scanner);
                    
                    if (tipoPessoa.equals("F")) {
                        repo1.exibirTodos();
                    } else {
                        repo3.exibirTodos();
                    }
                    break;
                }
                case 6: { // Persistir Dados
                    System.out.print("Insira o nome do arquivo a ser salvo: ");
                    String prefixo = scanner.next();
                    
                    repo1.persistir("data/" + prefixo + ".fisica.bin");
                    repo3.persistir("data/" + prefixo + ".juridica.bin");
                    break;
                }
                case 7: { // Recuperar Dados
                    System.out.print("Insira o nome do arquivo a ser recuperado: ");
                    String prefixo = scanner.next();
                    
                    repo1.recuperar("data/" + prefixo + ".fisica.bin");
                    repo3.recuperar("data/" + prefixo + ".juridica.bin");
                    break;
                }
                case 0: { // Finalizar Programa
                    System.out.print("Programa encerrado.");
                    estaRodando = false;
                    break;
                }
            }
        }
        
        // scanner.close();
    }
    
    public static String escolherTipoPessoa(Scanner scanner) {
        String tipoPessoa = "";
        
        while(true) {
            System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
            tipoPessoa = scanner.next();
            
            if (tipoPessoa.equals("F") || tipoPessoa.equals("J")) {
                break;
            }
            
            System.out.println("Escolha uma opção válida");
        }
        
        return tipoPessoa;
    }
}