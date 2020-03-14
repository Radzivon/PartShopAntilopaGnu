package by.radzivon.partshop.user;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.util.List;

@Slf4j
@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public User save(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
        log.info("Singer saved with id: " + user.getId());

        return user;
    }

    @Override
    public User getUserByLogin(String name) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void deleteUserByLogin(String login) {

    }

    @Override
    public void delete(Long id) {

    }
}
