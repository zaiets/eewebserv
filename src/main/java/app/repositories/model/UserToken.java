package app.repositories.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER_ROLES",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "USER_ID")})
public class UserToken {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @Basic
    @Column(name = "LAST_USED")
    private LocalDateTime dateTime;
    @Basic
    @Column(name = "TOKEN")
    private String token;
    @Basic
    @Column(name = "INFO")
    private String info;

    public UserToken() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserToken)) return false;

        UserToken userToken = (UserToken) o;

        if (getId() != null ? !getId().equals(userToken.getId()) : userToken.getId() != null) return false;
        if (getUser() != null ? !getUser().equals(userToken.getUser()) : userToken.getUser() != null) return false;
        if (getDateTime() != null ? !getDateTime().equals(userToken.getDateTime()) : userToken.getDateTime() != null)
            return false;
        if (getToken() != null ? !getToken().equals(userToken.getToken()) : userToken.getToken() != null) return false;
        return getInfo() != null ? getInfo().equals(userToken.getInfo()) : userToken.getInfo() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getDateTime() != null ? getDateTime().hashCode() : 0);
        result = 31 * result + (getToken() != null ? getToken().hashCode() : 0);
        result = 31 * result + (getInfo() != null ? getInfo().hashCode() : 0);
        return result;
    }
}
