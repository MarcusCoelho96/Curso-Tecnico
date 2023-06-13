
package javaapplication4;

public class JavaApplication4 {

    public static void main(String[] args) {
        
        double a, b, c;
        
        a = 100;
        b = 200;
  
        
        Calculadora conta = new Calculadora();

            System.out.println(a + " + " + b + " = " + (int) conta.somar(a, b));
            System.out.println(a + " - " + b + " = " + (int) conta.subtrair(b, a));
            System.out.println(a + " x " + b + " = " + (int) conta.multiplicar(b, a));
            System.out.println(a + " / " + b + " = " + (int) conta.dividir(b, a));
        
    }
    
}
