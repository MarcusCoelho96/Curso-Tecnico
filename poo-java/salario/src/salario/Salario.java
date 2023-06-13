/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package salario;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class Salario {
    static Scanner ler = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            //variaveis de controle
        int escolha = 0;
        int cont = 0;
            //criando a lista
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
       
       // Funcionario f1 = new Funcionario("Marcos", "Web Dev", 2800);
       // Funcionario f2 = new Funcionario("John", "Web Design", 2800);
       // Funcionario f3 = new Funcionario("Cabral", "Web Segurança", 4000);
       
       do{
           //cadastrando so valores da classe
            System.out.println("nome?");
            String nome = ler.next();
            
            System.out.println("cargo?");
            String cargo = ler.next();
            
            System.out.println("salario?");
            double salario = ler.nextDouble();
            //criando o objeto
            Funcionario f = new Funcionario(nome, cargo, salario);
            //adicionando na lista com indice começando em '0'
            lista.add(f);
            
            System.out.println(" use um --> '99' para inserir mais um funcionario");
            escolha = ler.nextInt();
            //para ter controle sobre o tamanho da LISTA. mas poderia usar o 'lista.size();
            cont = cont + 1;
       }while(escolha == 99);
            //imprimir lista
       for(int i = 0; i < cont; i ++){
           System.out.println(lista.get(i));
       }
            //ou
       System.out.println(lista);
            //em caso de erro
    }catch(Exception e){
    System.out.println("Voce deve inserir um numero inteiro");
    }   
    }
    
}
