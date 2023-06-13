
package com.mycompany.sobrecarga;

/**
 *
 * @author User
 */
public class mainFuncionario {
    public static void main(String[] args) {
           
        Funcionario f = new Funcionario(2000, 1000, 2400);

        System.out.println(f.toString());
        System.out.println(f.somar(f.getSalario(), f.getDivida(), f.getPremio()));

        System.out.println(f.somar(f.getSalario(), f.getDivida()));

        
        

    }
    
}
