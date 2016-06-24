package app.services;

import app.dto.UserDto;
import app.exceptions.EmailExistsException;
import app.repositories.AbstractUserDao;
import app.repositories.model.Role;
import app.repositories.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private AbstractUserDao abstractUserDao;

    @Override
    public User read(int id) {
        return abstractUserDao.read(id);
    }

    @Override
    public List<User> getAll() {
        return abstractUserDao.getAll();
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
        return abstractUserDao.update(id, user);
    }

    @Override
    public User delete(int id) {
        return abstractUserDao.delete(id);
    }


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
        return abstractUserDao.create(user);
    }

    private boolean emailExist(String email) {
        User user = abstractUserDao.findByEmail(email);
        return user != null;
    }


}