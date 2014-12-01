package restserver;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Singleton
@Startup
public class DataBaseIndex {

    @Inject
    private EntityManager entityManager;

    @Inject
    private transient Logger logger;

    @PostConstruct
    public void indexaBaseDeDados() {
        try {


            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

            fullTextEntityManager.createIndexer().startAndWait();

            logger.info(" Base de dados indexada para pesquisa com Hibernate-Search ");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
