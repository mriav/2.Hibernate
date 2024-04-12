package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

      private static final String URL = "jdbc:mysql://localhost:3306/bd_jdbs";
      private static final String USER = "root";
      private static final String PASSWORD = "root";

    public Util() {

    }

    public static Connection connection() throws SQLException {
          return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static SessionFactory sessionFactory() {

        Properties prop = new Properties();
        // Конфигурация для источника данных.
        prop.setProperty("connection.driver_class", "com.mysql.jdbs.Driver");
        prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/bd_hibernate");
        prop.setProperty("hibernate.connection.username", "root");
        prop.setProperty("hibernate.connection.password", "root");
        // Конфигурация hibernate.
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"); // указываем диалект, с какой БД необходимо работать хиберу.
        //prop.setProperty("hibernate.use_sql_comments", "true");
        prop.setProperty("hibernate.show_sql", "true");// что бы хибер показывал какие SQL запросы он делает.
        prop.setProperty("hibernate.format_sql", "true");
        //prop.setProperty("hibernate.hbm2ddl.auto", "update");

        prop.setProperty("hibernate.current_session_context_class", "thread");

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.setProperties(prop);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build(); {

        }

        return configuration.buildSessionFactory(serviceRegistry);
    }



}
