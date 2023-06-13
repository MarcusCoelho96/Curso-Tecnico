
package javaapplication3;

public class JavaApplication3 {

    public static void main(String[] args) {
      Carro carro = new Carro();
      Carro carro2 = new Carro();
      
      carro.setMarca("Honda");
      carro.setCor("Preto");
      carro.setAno(2020);
      
      carro2.setMarca("Fiat");
      carro2.setCor("Azul");
      carro2.setAno(2022);
      
        System.out.println(carro);
        System.out.println(carro2);
    }
    
}
