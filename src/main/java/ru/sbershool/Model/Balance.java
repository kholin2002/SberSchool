package ru.sbershool.Model;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Модель запроса баланса по карте
 */
public interface Balance {

    BigDecimal getBalance();

    Currency getCurrency();
}
