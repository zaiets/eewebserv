package springmvcauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import springmvcauth.dto.UserDto;
import springmvcauth.exceptions.EmailExistsException;
import springmvcauth.model.User;
import springmvcauth.service.UserService;

import javax.validation.Valid;

@RestController
public class BasicRESTController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount
            (@ModelAttribute("user") @Valid UserDto userDto,
             BindingResult result, WebRequest request, Errors errors) {
        User registered = new User();
        if (!result.hasErrors()) {
            registered = createUserAccount(userDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", userDto);
        }
        else {
            return new ModelAndView("successRegister", "user", userDto);
        }
    }

    private User createUserAccount(UserDto newUser, BindingResult result) {
        User registered = null;
        try {
            registered = userService.registerNewUserAccount(newUser);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    }

}

