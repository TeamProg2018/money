package com.project20.money;

import javax.persistence.*;

public class EntityMoney {


        @Id
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


        public Float getAmount() {
            return amount;
        }

        public Float getBuyRate() {
            return buyRate;
        }public Float getSellRate() {
            return sellRate;
        }public Float getName() {
            return name;
        }public Float getAmount() {
            return amount;
        }

}
