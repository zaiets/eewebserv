package app.services;

import app.dto.UserDto;
import app.exceptions.EmailExistsException;
import app.entities.IUserDao;
import app.entities.model.Role;
import app.entities.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User read(int id) {
        return userDao.read(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User update(int id, UserDto userDto, Role role) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setEmail(userDto.getEmail());
        user.setSurname(userDto.getSurname());
        user.setName(userDto.getName());
        user.setPatronymic(userDto.getPatronymic());
        user.setPassword(userDto.getPassword());
        user.setRole(role);
        user.setPatronymic(userDto.getPatronymic());
        return userDao.update(id, user);
    }

    @Override
    public User delete(int id) {
        return userDao.delete(id);
    }

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto userDto) throws EmailExistsException {
        if (emailExist(userDto.getEmail())) {
            throw new EmailExistsException("There is an account with that email adress: " + 
              userDto.getEmail());
        }
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setEmail(userDto.getEmail());
        user.setSurname(userDto.getSurname());
        user.setName(userDto.getName());
        user.setPatronymic(userDto.getPatronymic());
        user.setPassword(userDto.getPassword());
        user.setRole(Role.USER);
        return userDao.create(user);
    }

    public User findByEmail (String email) {
        return userDao.findByEmail(email);
    }

    private boolean emailExist(String email) {
        User user = userDao.findByEmail(email);
        return user != null;
    }


}