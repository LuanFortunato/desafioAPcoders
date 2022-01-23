package model.dao;

import javax.enterprise.context.Dependent;
import model.entity.Unidade;

@Dependent
public class UnidadeDAO extends BaseDAO<Unidade>{
    
    public Unidade getById(Integer id)
    {
        return getEntityManager().find(Unidade.class, id);
    }
}
