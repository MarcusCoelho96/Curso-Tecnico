/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salario;

/**
 *
 * @author User
 */
public class Funcionario {
    
    private double salario;

    public Funcionario() {
    }
    
    public Funcionario(double salario){
        this.salario = salario;
    }

    Funcionario(String nome, String cargo, double salario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public Double somar(Double salario, Double divida){
        Double soma = this.salario - divida;
        return soma;
    }
    public Double somar(Double salario, Double divida, Double premio){
        Double soma = this.salario - divida + premio;
        return soma;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "salario=" + salario + '}';
    }

    
    
    
}
