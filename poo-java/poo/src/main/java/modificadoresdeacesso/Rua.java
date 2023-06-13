package modificadoresdeacesso;
/**
 *
 * @author User
 */
public class Rua {
    
    private String nome;
    private int[] casas;
    
    public Rua() {
         
    }
    
    public Rua(String nome, int[] casas) {
        this.nome = nome;
        this.casas = casas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int[] getCasas() {
        return casas;
    }

    public void setCasas(int[] casas) {
        this.casas = casas;
    }

    public void imprimir(){
        System.out.println("Rua: " + this.nome);
        for(int i = 0; i < casas.length; i ++){
            System.out.println("casa: " + casas[i]);
        }
    }

    @Override
    public String toString() {
        return "Rua{" + "nome=" + nome + ", casas=" + casas + '}';
    }
    
    

}
