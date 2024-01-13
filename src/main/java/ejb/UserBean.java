package ejb;

import datatypes.UserDto;
import entities.User;
import entities.UserGroup;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UserBean {

    @PersistenceContext
    EntityManager entityManager;
    @Inject
    PasswordBean passwordBean;

    private Logger logger = Logger.getLogger(UserBean.class.getName());

    public UserDto getUser(String username, String password){
        try{
            logger.info("password");
            String queryString = "SELECT u FROM User u WHERE u.userName = :username AND u.password = :pass";
            TypedQuery<User> query = entityManager.createQuery(queryString,User.class);
            query.setParameter("username",username);
            query.setParameter("pass",password);
            User res = query.getSingleResult();

            return new UserDto(res.getUserID(),res.getUserName(),res.getFirstName(),res.getLastName(),res.getEmail(),res.getAddress());

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
    private User findUserByUsername(String username){
        User user = (User) entityManager
                .createQuery("SELECT u from User u where u.userName = :username")
                .setParameter("username",username)
                .getSingleResult();
        return user;
    }
    public UserDto findUserDataByUsername(String username){
        User user = findUserByUsername(username);
        return new UserDto(user.getUserID(),user.getUserName(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getAddress());
    }
    public List<UserDto> findAllUsers(){
        try {
            TypedQuery<User> typedQuerry = entityManager.createQuery("SELECT u FROM User u", User.class);
            List<User> users = typedQuerry.getResultList();
            return copyUsersToDto(users);
        }
        catch (Exception ex){
            throw new EJBException(ex);
        }
    }

    private List<UserDto> copyUsersToDto(List<User>users){
        List<UserDto> list = new ArrayList<>();
        for(User user : users){
            UserDto temp = new UserDto(user.getUserID(),user.getUserName(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getAddress());
            list.add(temp);
        }
        return list;

    }
    public void deleteUser(Long userId){
       try {
           User user = entityManager.find(User.class,userId);
           entityManager.remove(user);
       }
       catch (Exception ex){
           throw new EJBException(ex);
       }
    }

    public UserDto getUserById(Long id){
        try {
            TypedQuery<User> typedQuerry = entityManager.createQuery("SELECT u FROM User u WHERE u.userID=:id", User.class).setParameter("id",id);
            User user = typedQuerry.getSingleResult();
            return new UserDto(user.getUserID(),user.getUserName(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getAddress());
        }
        catch (Exception ex){
            throw new EJBException(ex);
        }
    }
    public void assignGroupsToUser(Long userId, Collection<String> groups){
        try {
            User user = entityManager.find(User.class, userId);
            deleteRolesForUser(user.getUserName());

            for(String group:groups) {
                UserGroup userGroup=new UserGroup();
                userGroup.setUsername(user.getUserName());
                userGroup.setRole(group);
                entityManager.persist(userGroup);
            }
        }
        catch (Exception ex){
            throw new EJBException(ex);
        }
    }
   private List<UserGroup> getRolesForUser(String userName){
        try {
            TypedQuery<UserGroup> typedQuerry = entityManager.createQuery("SELECT g FROM UserGroup g WHERE g.username=:username", UserGroup.class).setParameter("username",userName);
            List<UserGroup> users = typedQuerry.getResultList();
            return users;
        }
        catch (Exception ex){
            throw new EJBException(ex);
        }
    }
    public void deleteRolesForUser(String userName){
        List<UserGroup> roles = getRolesForUser(userName);
        for(UserGroup userGroup : roles)
            entityManager.remove(userGroup);
    }
    public String formatRoles(String userName){
        List<UserGroup> userGroups = getRolesForUser(userName);
        if (userGroups == null || userGroups.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder(userGroups.get(0).getRole());
        for (int i = 1; i < userGroups.size(); i++) {
            result.append(',').append(userGroups.get(i).getRole());
        }

        return result.toString();
    }
}
