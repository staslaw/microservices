package com.example.demoms2.model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "cinemas")
public class Cinema {
    @Id @GeneratedValue
    private Long id;
    @NotBlank
    @Column(name="cinema_name")
    private String name;
    @Embedded
    @NotNull
    private Address address;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city", column=@Column(name="corresponding_city")),
            @AttributeOverride(name="street", column=@Column(name="corresponding_street")),
            @AttributeOverride(name="postCode", column=@Column(name="corresponding_postCode"))})
    private Address correspondingAddress;
    @ElementCollection
    @GenericGenerator(name="increment-gen", strategy="increment")
    @CollectionId(columns={@Column(name="room_id")}, generator="increment-gen", type=@Type(type="long"))
    @JoinTable(name="cinema_room", joinColumns=@JoinColumn(name="cinema_id"))
    @NotEmpty
    private Collection<ScreeningRoom> screeningRooms = new HashSet<>();

    public Cinema() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getCorrespondingAddress() {
        return correspondingAddress;
    }

    public void setCorrespondingAddress(Address correspondingAddress) {
        this.correspondingAddress = correspondingAddress;
    }

    public Collection<ScreeningRoom> getScreeningRooms() {
        return screeningRooms;
    }

    public void setScreeningRooms(Collection<ScreeningRoom> screeningRooms) {
        this.screeningRooms = screeningRooms;
    }
}
