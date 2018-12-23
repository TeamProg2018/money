package com.project20.money.Controller;

import com.project20.money.Entity.EntityMoney;
import com.project20.money.Entity.TransactionsModel;
import com.project20.money.Repository.RepositoryMoney;
import com.project20.money.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ExchangeController {
  @Autowired
  RepositoryMoney repositoryMoney;
  @Autowired
  TransactionRepository transactionRepository;

  @GetMapping("/pg")
  public String getPage(Map<String, Object> model) {
//    model.put("transList", transactionRepository.findAll());
    return "page_1";
  }
  @PostMapping("/pg")
  public String postPage(@RequestParam(value = "addSum") Long sum,
                         @RequestParam(value = "whatDo") String action,
                         @RequestParam(value = "nameCurrency") String currency,
                         Map<String, Object> model) {
//    создал запас денег с курсами пока так - єто !!!КОСТЫЛЬ ...
    EntityMoney entityMoneyUSD = new EntityMoney(1L, "USD",
            10000L, 25f, 28f);
    EntityMoney entityMoneyEUR = new EntityMoney(2L, "EUR",
            10000L, 29f, 31f);
    EntityMoney entityMoneyUAH = new EntityMoney(3L, "UAH",
            10000L, 1f, 1f);
    repositoryMoney.save(entityMoneyUSD);
    repositoryMoney.save(entityMoneyEUR);
    repositoryMoney.save(entityMoneyUAH);
//    болванка курсов для проверки работы пока я их не смог (((
//    из базы мани по repositoryMoney дернуть...
    EntityMoney entityMoneyKOSTIL =new EntityMoney();

    if (currency.equals("USD")) {
      entityMoneyKOSTIL=entityMoneyUSD;
    }
    if (currency.equals("EUR")) {
      entityMoneyKOSTIL=entityMoneyEUR;
    }
    if (currency.equals("UAH")) {
      entityMoneyKOSTIL=entityMoneyUAH;
    }
//   модель транзакции - ВНОСИТ В ПОЛЯ сумму и выбраную валюту название
    TransactionsModel transactionsModel = getTransactionsModel(sum, currency);

//   НИЖЕ СЕКЦИИ ИФ : по нажатию одной из кнопок на странице проверяет какая нажата и что делать
//   @запроспараметра для name="whatDo" если после submit (нажатие)
//   получает value= напрмер "buy" = то нажата кнопка "купить" и он чета делает для купить
//    т.е. вот одно из <button type="submit" name="whatDo" value="buy"> Купить </button>

    if (action.equals("buy")) {
      transactionsModel.setSell_buy_name("buy");
      transactionsModel.setRate(entityMoneyKOSTIL.getBuyRate());
      transactionsModel.setSum_name(sum * entityMoneyKOSTIL.getBuyRate());
      transactionRepository.save(transactionsModel);
      model.put("transList", transactionsModel);

      entityMoneyKOSTIL.setAmount(entityMoneyKOSTIL.getAmount()-sum);
      repositoryMoney.save(entityMoneyKOSTIL);
    }

    if (action.equals("sell")) {
      transactionsModel.setSell_buy_name("Sell");
      transactionsModel.setRate(entityMoneyKOSTIL.getSellRate());
      transactionsModel.setSum_name(sum * entityMoneyKOSTIL.getSellRate());
      transactionRepository.save(transactionsModel);
      model.put("transList", transactionsModel);

      entityMoneyKOSTIL.setAmount(entityMoneyKOSTIL.getAmount()+sum);
      repositoryMoney.save(entityMoneyKOSTIL);

    }
//   показать все транзакции и баланс
    if (action.equals("show_trans")) {
      model.put("transList", transactionRepository.findAll());
      model.put("moneyList", repositoryMoney.findAll());
    }

    if (action.equals("show_bal")) {
      model.put("moneyList", repositoryMoney.findAll());
    }
    return "page_1";
  }

  // просто вынесено в отдельную функцию создание одинаковой для использования
  // в котроллере в if-ах части Транзакции -заполнение полей СКОЛЬКО и КАКАЯ ВАЛЮТА выбрана
  private TransactionsModel getTransactionsModel(@RequestParam("addSum") Long sum, @RequestParam("nameCurrency") String currency) {
    TransactionsModel transactionsModel = new TransactionsModel();
    transactionsModel.setValue(sum);
    transactionsModel.setCurrency_name(currency);
    return transactionsModel;
  }
}
