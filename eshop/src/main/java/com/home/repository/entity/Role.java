package com.home.repository.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String roleId;
    @Column(name = "name")
    private String name;
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            targetEntity = User.class)
    private Set<User> users;
}
