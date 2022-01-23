package controller.bean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "trocaTelaMB")
@RequestScoped
public class TrocaTelaMB {

    public TrocaTelaMB() {
    }
    
    public String getTelaInicial(){
        return "index?faces-redirect=true";
    }
    
    public String getInquilinos(){
        return "inquilinos?faces-redirect=true";
    }
    
    public String getDespesas(){
        return "despesas?faces-redirect=true";
    }
    
    public String getUnidades(){
        return "unidades?faces-redirect=true";
    }
    
    public String getCadastroInquilinos(){
        return "cadastroInquilinos?faces-redirect=true";
    }
    
    public String getCadastroUnidades(){
        return "cadastroUnidades?faces-redirect=true";
    }
    
    public String getCadastroDespesas(){
        return "cadastroDespesas?faces-redirect=true";
    }
    
}
