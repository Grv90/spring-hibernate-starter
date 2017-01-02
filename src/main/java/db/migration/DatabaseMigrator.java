package db.migration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.learn.boot.PersistenceContext;

/*
 *  @version     1.0, 31-Dec-2016
 *  @author gaurav
*/
@SpringBootApplication
@Import({ PersistenceContext.class })
public class DatabaseMigrator {
    private static final String LIQUIBASE_CHANGE_LOG_VALUE = "classpath:/db/changelog/db.changelog-master.xml";
    private static final String LIQUIBASE_CHANGE_LOG = "liquibase.changeLog";
    private static final String MIGRATION_SERVER_PORT_VALUE = "8111";
    private static final String MIGRATION_SERVER_PORT = "server.port";


    
    
    public static void main(String[] args) {
        System.setProperty(MIGRATION_SERVER_PORT, MIGRATION_SERVER_PORT_VALUE);
        System.setProperty(LIQUIBASE_CHANGE_LOG, LIQUIBASE_CHANGE_LOG_VALUE);
        SpringApplication app = new SpringApplication(DatabaseMigrator.class);
        ConfigurableApplicationContext ctx = app.run(args);
        ctx.close();
    }

    

}
