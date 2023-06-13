
package marcus;

/**
 *
 * @author  MARCUS.VICTOR
 */
public class Endereco {
    
   private String cep;
   private String rua;
   private String casa;
   private String bairro;
   private String cidade;
   private String complemento;

    public Endereco() {
        //construtor vazio
    }
    
    public Endereco(String rua, String casa, String bairro, String cidade) { //cep e complemento não são obrigatórios
        this.rua = rua;
        this.casa = casa;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Endereco(String cep, String rua, String casa, String bairro, String cidade, String complemento) {
        this(rua, casa, bairro, cidade); //a chamada de um construtor dentro do outro tem que estar na primeira linha
        this.cep = cep;
        this.complemento = complemento;
    }
   
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Endereco{" + "cep=" + cep + ", rua=" + rua + ", casa=" + casa + ", bairro=" + bairro + ", cidade=" + cidade + ", complemento=" + complemento + '}';
    }
   
   
    
}
