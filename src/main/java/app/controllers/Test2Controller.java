package app.controllers;

import app.repositories.AbstractUserDao;
import app.repositories.AbstractUserRoleDao;
import app.repositories.model.User;
import app.repositories.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test2Controller {

    @Autowired
    private AbstractUserRoleDao abstractUserRoleDao;

    @Autowired
    private AbstractUserDao abstractUserDao;

    @RequestMapping(value = "/1")
    public void test1() {
        System.out.println("~~~~~~~~~~~~~~~~~~");
        User user = new User();
        user.setLogin("tester");
        user.setPassword("111");
        user.setId(abstractUserDao.create(user));
        UserRole role = new UserRole();
        role.setRole("ADMIN");
        role.setUser(user);
        abstractUserRoleDao.create(role);
        System.out.println(abstractUserDao.read(1));
    }

    @RequestMapping(value = "/2", method = RequestMethod.GET)
    public void test2() {
        System.out.println("test 2");
    }
}

