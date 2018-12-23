package com.project20.money.Controller;


import com.project20.money.Entity.MyCurrency;
import com.project20.money.Entity.MyQuotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;

@Controller
public class ControllerMoney {

    @GetMapping("/mp")
    public String getMoneyPage()
    {
        return "page_1" ;
    }
    @PostMapping("/sum")
    public String sum(@RequestParam String price,
                      @RequestParam String name_1,
                      @RequestParam String name_2,
                      Map<String,Object> model){

        MyCurrency myCurrency=new MyCurrency();
        MyQuotation myQuotation=new MyQuotation();

        myCurrency.setPrice(Float.parseFloat(price));
        myCurrency.setName(name_1);

        String a="";
        Float b=1.0f;
        if (name_1.equals("USD")){
            if(name_2.equals("USD")){
                a="ERROR";
            }
            if (name_2.equals("EUR")){
                b=myCurrency.getPrice()*myQuotation.usd_eur;
                a="EUR";
                System.out.println("ERO");

            }
            if(name_2.equals("UAH")){
                b=myCurrency.getPrice()*myQuotation.usd_uah;
                a="UAH";
                System.out.println("UAH");
            }
        }
        if(name_1.equals("EUR")){
            if(name_2.equals("USD")){
                a="USD";
                b=myCurrency.getPrice()*myQuotation.eur_usd;
                System.out.println("USD");

            }
            if(name_2.equals("UAH")){
                a="UAH";
                b=myCurrency.getPrice()*myQuotation.eur_uah;
                System.out.println("UAH");

            }
            if (name_2.equals("EUR")){
                a="ERROR";
            }
        }

        if(name_1.equals("UAH")){
            if(name_2.equals("USD")){
                a="USD";
                b=myCurrency.getPrice()*myQuotation.uah_usd;
            }
            if (name_2.equals("EUR")){
                a="EUR";
                b=myCurrency.getPrice()*myQuotation.uah_eur;
            }
            if (name_2.equals("UAH")){
                a="ERROR";
            }
        }
        model.put("key",a);
        if(b!=1){
            model.put("key_1",b);
        }
        return "page_1";
    }

}
