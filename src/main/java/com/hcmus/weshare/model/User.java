package com.hcmus.weshare.model;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Data
public class User {

    @Id
    private final String id;

    @NotNull
    @Column(name = "email")
    private final String email;

    @Column(name = "display_name")
    private final String displayName;

    @Column(name = "dob")
    private final String dob;

    @Column(name = "gender")
    private final String gender;

    @NotNull
    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private final boolean isDeleted;

    @NotNull
    @Column(name = "status_code", columnDefinition = "int default 1")
    private final int statusCode = 1;

}
