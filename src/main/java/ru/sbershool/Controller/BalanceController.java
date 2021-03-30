package ru.sbershool.Controller;

import ru.sbershool.Model.BankClient;
import ru.sbershool.Model.Card;

public interface BalanceController {

    /**
     * Получить баланс по карте через BalanceService, отобразить BalanceView
     *
     * @param client Идентификатор клиента
     * @param card   Идентификатор карты клиента
     */
    void execute(BankClient client, Card card);
}
