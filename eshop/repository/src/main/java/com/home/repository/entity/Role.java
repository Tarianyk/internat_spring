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
    @ManyToMany(cascade = CascadeType.ALL,
                fetch = FetchType.LAZY,
                mappedBy = "roles")
    private Set<User> users;
}

