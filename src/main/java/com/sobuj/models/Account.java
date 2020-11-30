package com.sobuj.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String photo;
    private String phone;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private ShoppingCart shoppingCart;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",joinColumns = {
            @JoinColumn(name = "user_id",referencedColumnName = "id")
    },inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private Set<Role> roles;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "account",cascade = CascadeType.ALL)
    private Set<VerifyAccount> verifyAccounts;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_address",joinColumns = {
            @JoinColumn(name = "user_id",referencedColumnName = "id")
    },inverseJoinColumns = @JoinColumn(name = "address_id",referencedColumnName = "id"))
    private Set<Address> address;

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<VerifyAccount> getVerifyAccounts() {
        return verifyAccounts;
    }

    public void setVerifyAccounts(Set<VerifyAccount> verifyAccounts) {
        this.verifyAccounts = verifyAccounts;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Set<Role> addRole(Role role){
        if (roles==null)
            roles=new HashSet<>();
        roles.add(role);
        return roles;
    }

    public Set<Address> addAddress(Address add){
        if (address==null)
            address=new HashSet<>();
        address.add(add);
        return address;
    }
}
