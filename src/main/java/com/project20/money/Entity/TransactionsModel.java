package com.project20.money.Entity;

import javax.persistence.*;

@Entity
@Table(name = "transactions", catalog = "money")
public class TransactionsModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "trans_id")
  private Long id;

  @Column(name = "trans_value")
  private Long value;

  @Column(name = "trans_currency")
  private String currency_name;

  @Column(name = "trans_sell_or_buy")
  private String sell_buy_name;

  @Column(name = "trans_rate")
  private Float Rate;

  @Column(name = "trans_sum")
  private Float sum_name;


//  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//  @JoinColumn(name = "money_id")
//  private EntityMoney entityMoney;

//  public EntityMoney getEntityMoney() {
//    return entityMoney;
//  }
//
//  public void setEntityMoney(EntityMoney entityMoney) {
//    this.entityMoney = entityMoney;
//  }

  public TransactionsModel() {

  }

  public Float getRate() {
    return Rate;
  }

  public void setRate(Float rate) {
    Rate = rate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getValue() {
    return value;
  }

  public void setValue(Long value) {
    this.value = value;
  }

  public String getCurrency_name() {
    return currency_name;
  }

  public void setCurrency_name(String currency_name) {
    this.currency_name = currency_name;
  }

  public String getSell_buy_name() {
    return sell_buy_name;
  }

  public void setSell_buy_name(String sell_buy_name) {
    this.sell_buy_name = sell_buy_name;
  }

  public Float getSum_name() {
    return sum_name;
  }

  public void setSum_name(Float sum_name) {
    this.sum_name = sum_name;
  }
}
