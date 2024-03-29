/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package onealot;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import javax.naming.InitialContext;
import java.awt.*;
import java.util.Properties;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        App a =new App();
        a.config();
    }

    public SessionFactory config(){
            Configuration cfg = new Configuration();

        SessionFactory sessionFactory=null;
        try {
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.URL, "jdbc:postgresql://localhost/paranoia");
            settings.put(Environment.USER, "postgres");
            settings.put(Environment.PASS, "");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            settings.put(Environment.SHOW_SQL, "True");
            settings.put(Environment.FORMAT_SQL, "True");
            settings.put(Environment.HBM2DDL_AUTO,"create-drop");

            cfg.setProperties(settings);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

            cfg.addAnnotatedClass(GrandOrdinateur.class);
            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("");
            System.out.println(" DB connection failed , halting now");
            System.out.println("");
            System.exit(-1);
        }

        return sessionFactory;
    }
}
// https://www.atomikos.com/Documentation/HibernateThreeStandalone
// https://youtu.be/SJaLBX2Yv5o
// https://dzone.com/articles/hibernate-5-java-configuration-example
// https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
