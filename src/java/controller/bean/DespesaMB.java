package controller.bean;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import model.dao.DespesaDAO;
import model.entity.Despesa;
import model.entity.Unidade;
import utils.Mensagens;

@Named(value = "despesaMB")
@RequestScoped
public class DespesaMB {

    @Inject
    private DespesaDAO despesaDAO;

    private Integer id;
    private String descrição;
    private String tipo_despesa;
    private Double valor;
    private String vencimento_fatura;
    private String status_pagamento;
    private Unidade unidade;
    private List<Despesa> despesaFilterList;

    public DespesaMB() {
        unidade = new Unidade();
    }

    public String salvarDespesa() {
        if (getDescrição().length() <= 0 || getStatus_pagamento().length() < 1 || getTipo_despesa().length() < 1 || getVencimento_fatura().length() < 1 || getUnidade() == null) {

            Mensagens.exibeMensagem(FacesMessage.SEVERITY_ERROR, "Preenchimento incompleto!", "Verifique se todos os campos estão devidamente preenchidos");
            return "despesas?faces-redirect=true";

        } else {

            Despesa d = new Despesa();

            if (id != null) {
                d = despesaDAO.getById(getId());
            }

            d.setDescrição(descrição);
            d.setTipo_despesa(tipo_despesa);
            d.setValor(valor);
            d.setVencimento_fatura(vencimento_fatura);
            d.setStatus_pagamento(status_pagamento);
            d.setUnidade(unidade);

            despesaDAO.salvar(d);

            return "despesas?faces-redirect=true";
        }
    }

    public void editarDespesa(Despesa despesa) {

        descrição = despesa.getDescrição();
        valor = despesa.getValor();
        vencimento_fatura = despesa.getVencimento_fatura();
        status_pagamento = despesa.getStatus_pagamento();
        tipo_despesa = despesa.getTipo_despesa();
        unidade = despesa.getUnidade();
        id = despesa.getId();

    }

    public String removerDespesa(Despesa despesa) {

        id = despesa.getId();
        Despesa d = despesaDAO.getById(id);
        despesaDAO.remover(d);

        return "despesas?faces-redirect=true";
    }

    public List<Despesa> getTodasDespesas() {
        return despesaDAO.recuperarTodosRegistros("despesa.findAll");

    }

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
        this.unidade = unidade;
    }

    public List<Despesa> getDespesaFilterList() {
        return despesaFilterList;
    }

    public void setDespesaFilterList(List<Despesa> despesaFilterList) {
        this.despesaFilterList = despesaFilterList;
    }
}
