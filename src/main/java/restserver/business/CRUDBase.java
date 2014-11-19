package restserver.business;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.jboss.logging.Logger;
import restserver.helper.CRUDManager;
import restserver.model.ModelBase;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;


public abstract class CRUDBase<T extends ModelBase> {


    @Inject
    private EntityManager em;

    @Inject
    private CRUDManager crudManager;

    @Inject
    protected transient Logger logger;

    protected Class<T> persistentClass;

    @PostConstruct
    @SuppressWarnings("unchecked")
    public void configPersistentClass() {
        try {
            persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        } catch (ClassCastException e) {
            // can be raised when DAO is inherited twice
            persistentClass = (Class<T>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
    }


    public abstract T novo();

    public T buscaPorId(Long id) {

        T entidade = null;
        entidade = em.find(persistentClass, id);
        if (entidade == null) {
            // throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return entidade;

    }

    public T incluir(T entidade) {
        configuraAtributosNovoRegistro(entidade);
        em.persist(entidade);
        em.flush();
        return entidade;
    }


    public T atualizar(T entidade) {
        em.merge(entidade);
        em.flush();
        return entidade;
    }


    public void remover(Long id) {

        T ent = em.find(persistentClass, id);
        em.remove(ent);
        em.flush();

    }

    @SuppressWarnings("unchecked")
    public List<T> buscaPorCriteria(Criterion... criterias) {
        Session s = em.unwrap(Session.class);
        Criteria crit = s.createCriteria(persistentClass);
        for (Criterion c : criterias) {
            crit.add(c);
        }
        return crit.list();
    }

    @SuppressWarnings("unchecked")
    public List<T> buscaPorCriteriaPaginada(int firstRecord, int maxRecords, Criterion... criterias) {
        Session s = em.unwrap(Session.class);
        Criteria crit = s.createCriteria(persistentClass);
        for (Criterion c : criterias) {
            crit.add(c);
        }
        crit.setFirstResult(firstRecord);
        crit.setMaxResults(maxRecords);
        return crit.list();
    }

    public List<T> consultaGenerica(String chaveDeConsulta, T entidade, int firstRecord, int maxRecords) {
        List<T> consulta = null;
        try {
            //consulta = consultaGenerica.consultaGenerica(chaveDeConsulta, entidade, firstRecord, maxRecords);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consulta;
    }

    protected void configuraAtributosNovoRegistro(T entidade) {

        try {

            Object nulo = null;

            Class<? extends Object> classeEntidade = entidade.getClass();

            Method setId = classeEntidade.getMethod("setId", Long.class);
            setId.setAccessible(true);
            setId.invoke(entidade, nulo);

            Method setVersion = classeEntidade.getMethod("setVersion", Integer.class);
            setVersion.setAccessible(true);
            setVersion.invoke(entidade, nulo);

        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }



    public Criteria getCriteria() {
        Session s = em.unwrap(Session.class);
        return s.createCriteria(persistentClass);
    }

    public Long contarRegistros() {
        Session s = em.unwrap(Session.class);
        Criteria crit = s.createCriteria(persistentClass);
        return (Long) crit.setProjection(Projections.rowCount()).uniqueResult();
    }

    public List<T> buscaTodos() {
        return buscaPorCriteria();
    }
}
