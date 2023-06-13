/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sobrecarga;
/**
 *
 * @author User
 */
public class Funcionario {
    
    private double salario;
    private double divida;
    private double premio;

    public Funcionario() {
    }
    
    public Funcionario(double salario){
        this.salario = salario;
    }

    public Funcionario(double salario, double divida, double premio) {
        this.salario = salario;
        this.divida = divida;
        this.premio = premio;
    }

    
    
    
    public double getDivida() {
        return divida;
    }

    public void setDivida(double divida) {
        this.divida = divida;
    }

    public double getPremio() {
        return premio;
    }

    /**
     *
     * @param salario
     */
    public void setPremio(double premio) {
        this.premio = premio;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public String somar(Double salario, Double divida){
        Double soma = salario - divida;
        return "Salario" + salario + " - " + "divida" + divida + "= " + soma ;
    }
    public String somar(Double salario, Double divida, Double premio){
        Double soma = salario - divida + premio;
        return "Salario" + salario + " - " + "divida" + divida + "+ " + premio + "= " + "soma " + soma;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "salario=" + salario + "divida = " + divida + "premio = " + premio + '}';
    }


    
    
    
}
