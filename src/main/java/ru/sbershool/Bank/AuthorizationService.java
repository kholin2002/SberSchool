package ru.sbershool.Bank;

import ru.sbershool.Model.BankClient;
import ru.sbershool.Model.Card;

/**
 * Авторизация клиента по карте
 */
public interface AuthorizationService {

    BankClient authorization(Card card);
}
