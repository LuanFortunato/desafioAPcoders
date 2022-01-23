package controller.bean;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import model.dao.UnidadeDAO;
import model.entity.Inquilino;
import model.entity.Unidade;
import utils.Mensagens;

@Named(value = "unidadeMB")
@RequestScoped
public class UnidadeMB {

    
    @Inject
    private UnidadeDAO unidadeDAO;
    
    private Integer id;
    private String identificação;
    private String condomínio;
    private String endereço;
    private Inquilino inquilino;
   
    public UnidadeMB() {
        inquilino = new Inquilino();
    }

    public String salvarUnidade() {
        if (getIdentificação().length() <= 0 || getCondomínio().length() < 1 || getEndereço().length() < 1 || getInquilino() == null) {
            
            Mensagens.exibeMensagem(FacesMessage.SEVERITY_ERROR, "Preenchimento incompleto!", "Verifique se todos os campos estão devidamente preenchidos");
            return "unidades?faces-redirect=true";
            
        } else {

            Unidade u = new Unidade();

            u.setIdentificação(identificação);
            u.setCondomínio(condomínio);
            u.setEndereço(endereço);
            u.setInquilino(inquilino);

            unidadeDAO.salvar(u);

            return "unidades?faces-redirect=true";
        }
    }
    
    public String removerUnidade(Unidade unidade){
        
        id = unidade.getId();
        Unidade u = unidadeDAO.getById(id);
        unidadeDAO.remover(u);
        
        return "unidades?faces-redirect=true";
    }
    
    
    public List<Unidade> getTodasUnidades(){ 
        return unidadeDAO.recuperarTodosRegistros("unidade.findAll");
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificação() {
        return identificação;
    }

    public void setIdentificação(String identificação) {
        this.identificação = identificação;
    }

    public String getCondomínio() {
        return condomínio;
    }

    public void setCondomínio(String condomínio) {
        this.condomínio = condomínio;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }
    
}
