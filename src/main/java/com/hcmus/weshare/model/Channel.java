package com.hcmus.weshare.model;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "channels")
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Data
public class Channel {

    @Id
    @GeneratedValue
    private final int id;

    @NotNull
    @Column(name = "owner_id")
    private final String ownerId;

    @NotNull
    @Column(name = "person_id")
    private final String personId;

}
