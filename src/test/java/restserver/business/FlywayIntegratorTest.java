package restserver.business;

import org.flywaydb.core.Flyway;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;
import org.jboss.logging.Logger;

/**
 * Classe responsável pela criação das tabelas no banco de testes.
 */
public class FlywayIntegratorTest implements Integrator {

    public static final Logger logger = Logger.getLogger("FLYWAY");

    @Override
    public void integrate(final Configuration configuration,
                          final SessionFactoryImplementor sessionFactoryImplementor,
                          final SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {
        logger.info("Iniciando criação das tabelas.");
        final Flyway flyway = new Flyway();
        try {
            flyway.setDataSource("jdbc:mysql://localhost:3306/restserverschema", "signum", "123");
            flyway.setLocations("db.db.testdata.all.migration");
            flyway.clean();
            flyway.migrate();
        } catch (Exception e) {
            logger.fatal("Erro durante a criação das tabelas:", e);
        }
        logger.info("Criação das tabelas realizadas com sucesso.");
    }

    @Override
    public void integrate(final MetadataImplementor metadataImplementor,
                          final SessionFactoryImplementor sessionFactoryImplementor,
                          final SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {
        //no-op
    }

    @Override
    public void disintegrate(final SessionFactoryImplementor sessionFactoryImplementor,
                             final SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {
        //no-op
    }
}
