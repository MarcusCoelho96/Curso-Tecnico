
package marcus;

/**
 *
 * @author  MARCUS.VICTOR
 */
public class Contato {
    
    private String telefone;
    private String email;

    public Contato() {
        //construtor vazio
    }
    
    public Contato(String telefone){
        this.telefone = telefone; //email não é obrigatório
    }

    public Contato(String telefone, String email) {
        this(telefone);
        this.email = email;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato{" + "telefone=" + telefone + ", email=" + email + '}';
    }
    
     
}
