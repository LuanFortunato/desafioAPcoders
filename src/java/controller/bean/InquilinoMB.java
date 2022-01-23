package controller.bean;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import model.dao.InquilinoDAO;
import model.entity.Inquilino;
import utils.Mensagens;

@Named(value = "inquilinoMB")
@RequestScoped
public class InquilinoMB {

    @Inject
    private InquilinoDAO inquilinoDAO;

    private Integer id;
    private String nome;
    private Integer idade;
    private String sexo;
    private String telefone;
    private String email;

    public InquilinoMB() {
    }

    public String salvarInquilino() {
        if (getNome().length() <= 0 || getIdade() <= 0 || getSexo().length() < 1 || getTelefone().length() < 1 || getEmail().length() <= 1) {
            
            Mensagens.exibeMensagem(FacesMessage.SEVERITY_ERROR, "Preenchimento incompleto!", "Verifique se todos os campos estão devidamente preenchidos");
            return "inquilinos?faces-redirect=true";
            
        } else {

            Inquilino i = new Inquilino();

            i.setNome(getNome());
            i.setIdade(getIdade());
            i.setSexo(getSexo());
            i.setTelefone(getTelefone());
            i.setEmail(getEmail());

            inquilinoDAO.salvar(i);

            return "inquilinos?faces-redirect=true";
        }
    }
    
    public String removerInquilino(Inquilino inquilino){
        
        id = inquilino.getId();
        Inquilino i = inquilinoDAO.getById(id);
        inquilinoDAO.remover(i);
        
        return "unidades?faces-redirect=true";
    }
    
    
    public List<Inquilino> getTodosInquilinos(){ 
        return inquilinoDAO.recuperarTodosRegistros("inquilino.findAll");
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
}
