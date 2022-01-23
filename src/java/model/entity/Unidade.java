package model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "unidade")
@NamedQueries({
    @NamedQuery(name = "unidade.findAll", query = "SELECT u FROM Unidade u")
})
public class Unidade implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column        
    private String identificação;
    
    @Column
    private String condomínio;
    
    @Column
    private String endereço;
    
    @ManyToOne
    @JoinColumn(name = "inquilino_id" , nullable = false)
    private Inquilino inquilino;
    
    
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
    
    @Override
    public String toString(){
        return identificação;
    }
    
    
}
