package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    /**
     * метод Создание таблицы User(ов)
     * должн быть реализован с помощью SQL
     * */
    @Override
    public void createUsersTable() {
         Session session = Util.sessionFactory().getCurrentSession();
         session.beginTransaction();

         session.createSQLQuery("CREATE TABLE IF NOT EXISTS users (id BIGINT(19) NOT NULL AUTO_INCREMENT," +
                         "name VARCHAR(40) NOT NULL, lastName VARCHAR(40) NOT NULL," + "age TINYINT(3) NOT NULL, PRIMARY KEY (id));").executeUpdate();

         session.getTransaction().commit();
         session.close();
    }

    /**
     * метод Удаление таблицы
     * должн быть реализован с помощью SQL
     * */
    @Override
    public void dropUsersTable() {
        Session session = Util.sessionFactory().getCurrentSession();
        session.beginTransaction();

        session.createSQLQuery("DROP TABLE IF EXISTS users;").executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    /**
     * метод Добавление 4 User(ов) в таблицу
     * */
    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.sessionFactory().getCurrentSession();
        session.beginTransaction();

        User user = new User(name, lastName, age);
        session.save(user);

        session.getTransaction().commit();
        session.close();

    }

    /**
     * метод удаления Юзера по id
     * */
    @Override
    public void removeUserById(long id) {
        Session session = Util.sessionFactory().getCurrentSession();
        session.beginTransaction();

        User user = session.get(User.class, id);
        session.delete(user);

        session.getTransaction().commit();
        session.close();
    }

    /**
     * метод Получение всех User из базы и вывод в консоль (должен быть переопределен toString в классе User)
     * */
    @Override
    public List<User> getAllUsers() {

        Session session = Util.sessionFactory().getCurrentSession();
        session.beginTransaction();

        List<User> allUsers = session.createQuery("FROM User").getResultList();

        session.getTransaction().commit();
        session.close();
        return allUsers;
    }

    /**
     * метод Очистка таблицы User(ов)
     * */
    @Override
    public void cleanUsersTable() {

        Session session = Util.sessionFactory().getCurrentSession();
        session.beginTransaction();

        session.createSQLQuery("TRUNCATE TABLE users;").executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}
