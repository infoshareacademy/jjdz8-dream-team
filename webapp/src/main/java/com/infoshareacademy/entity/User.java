package com.infoshareacademy.entity;

import com.infoshareacademy.domain.Role;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static com.infoshareacademy.entity.UserColumn.*;
import static com.infoshareacademy.entity.UserColumn.EMAIL;
import static com.infoshareacademy.entity.UserQuery.FIND_BY_EMAIL_QUERY;
import static com.infoshareacademy.entity.UserQuery.FIND_BY_NICKNAME_QUERY;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(
                name = FIND_BY_EMAIL_QUERY,
                query = "SELECT u from User u where u.email = :" + EMAIL
        ),
        @NamedQuery(
                name = FIND_BY_NICKNAME_QUERY,
                query = "SELECT u from User u where u.nickName = :" + NICKNAME
        )
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @NotNull
    private String nickName;

    @Basic
    @NotNull
    @Email
    private String email;

    @Basic
    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;

    @Basic
    @NotNull
    private String password;

    @Column(name = "date_of_registration")
    @CreationTimestamp
    private LocalDate dateOfRegistration;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Set<Subject> subjects = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

}