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
@Table(name = "despesa")
@NamedQueries({
    @NamedQuery(name = "despesa.findAll", query = "SELECT d FROM Despesa d")
})
public class Despesa implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column        
    private String descrição;
    
    @Column
    private String tipo_despesa;
    
    @Column
    private Double valor;
    
    @Column        
    private String vencimento_fatura;
    
    @Column        
    private String status_pagamento;
    
    @ManyToOne
    @JoinColumn(name = "unidade_id" , nullable = false)
    private Unidade unidade;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getTipo_despesa() {
        return tipo_despesa;
    }

    public void setTipo_despesa(String tipo_despesa) {
        this.tipo_despesa = tipo_despesa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getVencimento_fatura() {
        return vencimento_fatura;
    }

    public void setVencimento_fatura(String vencimento_fatura) {
        this.vencimento_fatura = vencimento_fatura;
    }

    public String getStatus_pagamento() {
        return status_pagamento;
    }

    public void setStatus_pagamento(String status_pagamento) {
        this.status_pagamento = status_pagamento;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade= unidade;
    }
    
    
    
}
