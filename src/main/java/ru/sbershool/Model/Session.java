package ru.sbershool.Model;

/**
 * Модель сеанса работы с клиентом
 */
public interface Session {

    Card getCard();

    BankClient getClient();

    /**
     * Очистить параметры сеанса
     */
    void clear();
}
