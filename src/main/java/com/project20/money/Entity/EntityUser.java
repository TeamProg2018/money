package com.project20.money.Entity;

import javax.persistence.*;

@Entity
@Table(name = "table_user", catalog = "money")

public class
EntityUser
{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_phone")
    private String phone;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private EntityMoney entityMoney;


    public EntityUser() {
    }

    public EntityUser(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public EntityMoney getEntityMoney() {
        return entityMoney;
    }

    public void setEntityMoney(EntityMoney entityMoney) {
        this.entityMoney = entityMoney;
    }
}
