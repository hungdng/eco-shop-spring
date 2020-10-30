package com.hung.ecoshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NaturalId
    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min = 3)
    private String password;

    @NotEmpty
    @Size(max = 200)
    private String name;

    @NotEmpty
    @Size(max = 20)
    private String phone;

    @NotEmpty
    private String address;

    @NotNull
    private boolean active;

    @NotEmpty
    @Size(max = 20)
    private String role = "ROLE_CUSTOMER";

}

