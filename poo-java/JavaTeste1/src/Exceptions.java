/**
 *
 * @author Marcus Coelho 05/07/2022
 */
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Exceptions {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        
        int[] vetor = {1, 2, 3}; // 1 = indice 0 | 2 = indice 1 | 3 = indice 2. //
        
        try{
        JOptionPane.showMessageDialog(null, vetor[5]); // forçando o erro, imprimir um indice inesistente.
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Aconteceu um erro");
        }finally{
            JOptionPane.showMessageDialog(null, "Marcus 07/2022 | Desenvolvedor de sistemas");
        }
    }
    
}
