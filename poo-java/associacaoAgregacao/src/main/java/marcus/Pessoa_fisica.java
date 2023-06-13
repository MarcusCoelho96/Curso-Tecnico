/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marcus;

/**
 *
 * @author User
 */
public class Pessoa_fisica {
    
    private String nome;
    private String nascimento;
    private Contato contato;
    private Endereco endereco;

    public Pessoa_fisica() {
    }

    public Pessoa_fisica(String nome, String nascimento, Contato contato, Endereco endereco) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.contato = contato;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa_fisica{" + "nome=" + nome + ", nascimento=" + nascimento + ", contato=" + contato + ", endereco=" + endereco + '}';
    }

    
    
}
