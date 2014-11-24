package restserver;

import org.flywaydb.core.Flyway;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;
import org.jboss.logging.Logger;

/**
 * Classe responsável pela migração do banco quando o hibernate é iniciado
 */
public class FlywayIntegrator implements Integrator {

    public static final Logger logger = Logger.getLogger("FlywayIntegrator");

    @Override
    public void integrate(final Configuration configuration,
                          final SessionFactoryImplementor sessionFactoryImplementor,
                          final SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {

        logger.info("Iniciando migração do FlyWay");

        final Flyway flyway = new Flyway();
        try {
            flyway.setDataSource("jdbc:mysql://localhost:3306/restserverschema", "signum", "123");
            flyway.migrate();
        } catch (Exception e) {
            logger.fatal("Erro na migração:", e);
        }
        logger.info("Migração finalizada");
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
