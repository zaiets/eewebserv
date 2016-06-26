package app.dto;


import app.validate.PasswordMatches;
import app.validate.ValidEmail;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@PasswordMatches
public class UserDto {
    @NotNull
    @NotEmpty
    private String login;
    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    private String surname;

    private String name;

    private String patronymic;

    public UserDto() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;

        UserDto userDto = (UserDto) o;

        if (getLogin() != null ? !getLogin().equals(userDto.getLogin()) : userDto.getLogin() != null) return false;
        if (getEmail() != null ? !getEmail().equals(userDto.getEmail()) : userDto.getEmail() != null) return false;
        if (getPassword() != null ? !getPassword().equals(userDto.getPassword()) : userDto.getPassword() != null)
            return false;
        if (getMatchingPassword() != null ? !getMatchingPassword().equals(userDto.getMatchingPassword()) : userDto.getMatchingPassword() != null)
            return false;
        if (getSurname() != null ? !getSurname().equals(userDto.getSurname()) : userDto.getSurname() != null)
            return false;
        if (getName() != null ? !getName().equals(userDto.getName()) : userDto.getName() != null) return false;
        return getPatronymic() != null ? getPatronymic().equals(userDto.getPatronymic()) : userDto.getPatronymic() == null;

    }

    @Override
    public int hashCode() {
        int result = getLogin() != null ? getLogin().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getMatchingPassword() != null ? getMatchingPassword().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPatronymic() != null ? getPatronymic().hashCode() : 0);
        return result;
    }
}
