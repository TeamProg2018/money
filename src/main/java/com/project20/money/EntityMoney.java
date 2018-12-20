package com.project20.money;

import javax.persistence.*;

public class EntityMoney {


        @Id
        //коментимо наступний рядок і прописуємо конструктор для id, щоб потім запхати в id міжнародні коди наших валют
        //правильно я зрозумів? чи треба міняти strategy?
        @GeneratedValue(strategy = GenerationType.AUTO)  
        @Column(name = "curency_id")
        private Long id;

        @Column(name = "curency_name")
        private String name;

        @Column(name = "curency_amount")
        private Float amount;

        @Column(name = "buy_rate")
        private Float buyRate;

        @Column(name = "sell_rate")
        private Float sellRate;


        public EntityMoney() {
            this.name = name;
            this.amount = amount;
            this.buyRate = buyRate;
            this.sellRate = sellRate;
        }


        public void setId(Long id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAmount(Float amount) {
            this.amount = amount;
        }

        public void setBuyRate(Float buyRate) {
            this.buyRate = buyRate;
        }

        public void setSellRate(Float sellRate) {
            this.sellRate = sellRate;
        }



        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Float getAmount() {
            return amount;
        }

        public Float getBuyRate() {
            return buyRate;
        }

        public Float getSellRate() {
            return sellRate;
        }
}
