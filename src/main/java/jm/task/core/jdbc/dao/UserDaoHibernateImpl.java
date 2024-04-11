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

    }

    /**
     * метод Удаление таблицы
     * должн быть реализован с помощью SQL
     * */
    @Override
    public void dropUsersTable() {

    }

    /**
     * метод Добавление 4 User(ов) в таблицу
     * */
    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    /**
     * метод удаления Юзера по id
     * */
    @Override
    public void removeUserById(long id) {

    }

    /**
     * метод Получение всех User из базы и вывод в консоль (должен быть переопределен toString в классе User)
     * */
    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        Session session = Util.sessionFactory().getCurrentSession();
        return allUsers;
    }

    /**
     * метод Очистка таблицы User(ов)
     * */
    @Override
    public void cleanUsersTable() {

    }
}
