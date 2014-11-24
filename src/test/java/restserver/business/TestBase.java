package restserver.business;

import org.flywaydb.core.Flyway;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.formatter.Formatters;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Classe responsável por criar o arquivo de teste e setar conexão com o banco para migrações do teste
 */
public abstract class TestBase {
    private static final boolean PRINT_DEPLOYMENT_STRUCTURE = false;

    static {
        // Desabilita o log do FlyWay
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
    }

    /**
     * Cria o pacote war que será feito deploy no servidor para teste Adiciona bibliotecas necessárias e pacotes dos fontes
     *
     * @return Pacote a ser feito deploy para teste
     */
    @Deployment
    public static WebArchive createDeployment() {
        WebArchive retorno = ShrinkWrap.create(WebArchive.class, "teste.war")
                                       .addClass(FlywayIntegratorTest.class)
                                       .addAsLibraries(Maven.resolver()
                                                            .loadPomFromFile("pom.xml")
                                                            .resolve("mysql:mysql-connector-java",
                                                                     "org.flywaydb:flyway-core",
                                                                     "org.apache.commons:commons-lang3",
                                                                     "org.apache.commons:commons-math3",
                                                                     "commons-beanutils:commons-beanutils",
                                                                     "org.jboss.logging:jboss-logging",
                                                                     "org.hibernate:hibernate-search-orm")
                                                            .withTransitivity()
                                                            .asFile())
                                       .addPackages(true, "restserver")
                                       .addAsResource("db/migration/", "db/migration/")
                                       .addAsResource("db/testdata/", "db/testdata/")
                                       .addAsResource("META-INF/services/org.hibernate.integrator.spi.IntegratorTest",
                                                      "META-INF/services/org.hibernate.integrator.spi.Integrator")
                                       .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                                       .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        if (PRINT_DEPLOYMENT_STRUCTURE) {
            System.out.println(retorno.toString(Formatters.VERBOSE));
        }
        return retorno;
    }

    @BeforeClass
    public static final void populateDBTestDataAll() {
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/restserverschema", "signum", "123");
        flyway.setLocations("db.db.testdata.all.migration", "db.testdata.all");
        flyway.setOutOfOrder(true);
        flyway.migrate();
    }

    @AfterClass
    public static final void clearDB() {
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/restserverschema", "signum", "123");
        flyway.clean();
    }

    public static void populateDB(String... testData) {
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/restserverschema", "signum", "123");
        String[] location = new String[testData.length + 2];
        location[0] = "db.db.testdata.all.migration";
        location[1] = "db.testdata.all";
        for (int i = 2; i < location.length; i++) {
            location[i] = String.format("db.testdata.%s", testData[i - 2]);
        }
        flyway.setLocations(location);
        flyway.setOutOfOrder(true);
        flyway.migrate();
    }
}
