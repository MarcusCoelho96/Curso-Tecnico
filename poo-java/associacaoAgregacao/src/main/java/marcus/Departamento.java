
package marcus;

import java.util.ArrayList;

/**
 *
 * @author  MARCUS.VICTOR
 */
public class Departamento {
    
    private String nomeDepartamento;
    private ArrayList<Funcionario> funcionarios;

    public Departamento() {
    }
    
    public Departamento(String nomeDepartamento){
        this.nomeDepartamento = nomeDepartamento;
    }
    
    public Departamento(String nomeDepartamento, ArrayList<Funcionario> funcionarios) {
        this.nomeDepartamento = nomeDepartamento;
        this.funcionarios = funcionarios;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void addFuncionarios(Funcionario funcionario){
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        for(int i = 0; i < funcionarios.size(); i ++){
        funcionarios.add(funcionario);
        }
    }
    
    @Override
    public String toString() {
        return "Departamento{" + "nomeDepartamento=" + nomeDepartamento + ", funcionarios=" + funcionarios + '}';
    }  
}
