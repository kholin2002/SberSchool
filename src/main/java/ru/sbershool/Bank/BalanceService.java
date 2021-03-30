package ru.sbershool.Bank;

import ru.sbershool.Model.Balance;
import ru.sbershool.Model.BankClient;
import ru.sbershool.Model.Card;

public interface BalanceService {

    Balance getBalance(BankClient client, Card card);
}
