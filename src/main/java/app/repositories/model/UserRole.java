package app.repositories.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "USER_ROLES",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "USER_ID")})
public class UserRole {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @Basic
    @Column(name = "ROLE", nullable=false)
    private String role;

    public UserRole() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole)) return false;

        UserRole userRole = (UserRole) o;

        if (getId() != null ? !getId().equals(userRole.getId()) : userRole.getId() != null) return false;
        if (getUser() != null ? !getUser().equals(userRole.getUser()) : userRole.getUser() != null) return false;
        return getRole() != null ? getRole().equals(userRole.getRole()) : userRole.getRole() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
        return result;
    }

}
