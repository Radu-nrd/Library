package ejb;

import Utility.Utils;
import datatypes.UserDetails;
import entities.User;
import entities.UserGroup;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UserBean {

    @PersistenceContext
    EntityManager entityManager;
    @Inject
    PasswordBean passwordBean;

    private Logger logger = Logger.getLogger(UserBean.class.getName());

    public UserDetails getUser(String username,String password){
        try{
            logger.info("password");
            String queryString = "SELECT u FROM User u WHERE u.userName = :username AND u.password = :pass";
            TypedQuery<User> query = entityManager.createQuery(queryString,User.class);
            query.setParameter("username",username);
            query.setParameter("pass",password);
            User res = query.getSingleResult();

            return new UserDetails(res.getUserID(),res.getUserName(),res.getFirstName(),res.getLastName(),res.getEmail(),res.getAddress());

        }
        catch (Exception ex){
            //throw new EJBException(ex);
            return null;
        }
    }
    public void createUser(String username,String password,String firstName,String lastName,String address,String email){
        User user = new User();
        user.setUserName(username);
        user.setPassword(passwordBean.convertToSha256(password));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);
        user.setEmail(email);

        entityManager.persist(user);

        UserGroup userGroup = new UserGroup();
        userGroup.setUsername(username);
        userGroup.setRole("READ_BOOKS");

        entityManager.persist(userGroup);

    }
}
