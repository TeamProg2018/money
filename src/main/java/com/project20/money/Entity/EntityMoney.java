package com.project20.money.Entity;

import javax.persistence.*;

@Entity

//створив базу даних "money", прописав там USD, EUR, UAH, створи в себе бд і після клонування
//чи там будуть якісь записи ???
@Table(name = "currency_table", catalog = "money")
public class EntityMoney {

    @Id
    //коментимо наступний рядок і прописуємо конструктор для id, щоб потім запхати в id міжнародні коди наших валют
    //правильно я зрозумів? чи треба міняти strategy?

    //да, а анотація Id забезпечить його унікальність, як мінімум потрібно спробувати
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "currency_id")
    private Long id;

    @Column(name = "currency_name")
    private String name;

    @Column(name = "currency_amount")
    private Long amount;

    @Column(name = "buy_rate")
    private Float buyRate;

    @Column(name = "sell_rate")
    private Float sellRate;

    //привязка транзакции

//    @OneToOne( mappedBy = "entityMoney",
//            fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private TransactionsModel transactionsModel;


    //добавив дефолтний конструктор
    public EntityMoney() {
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Float getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(Float buyRate) {
        this.buyRate = buyRate;
    }

    public Float getSellRate() {
        return sellRate;
    }

    public void setSellRate(Float sellRate) {
        this.sellRate = sellRate;
    }

    public EntityMoney(Long id, String name, Long amount, Float buyRate, Float sellRate) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
    }

    //    public TransactionsModel getTransactionsModel() {
//        return transactionsModel;
//    }
//
//    public void setTransactionsModel(TransactionsModel transactionsModel) {
//        this.transactionsModel = transactionsModel;
//    }
}




