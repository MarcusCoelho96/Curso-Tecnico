
package marcus;

/**
 *
 * @author  MARCUS.VICTOR
 */
public class Funcionario extends Pessoa_fisica {
    
    private Departamento departamento;
    
    

    public Funcionario() {
    }

    public Funcionario(Departamento departamento) {
        this.departamento = departamento;
    }
    
    public String vender(){
        return "Metodo vender, ok!";
    }
    
}
