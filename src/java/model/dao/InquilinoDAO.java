package model.dao;

import javax.enterprise.context.Dependent;
import model.entity.Inquilino;

@Dependent
public class InquilinoDAO extends BaseDAO<Inquilino>{
    
    public Inquilino getById(Integer id)
    {
        return getEntityManager().find(Inquilino.class, id);
    }
}
