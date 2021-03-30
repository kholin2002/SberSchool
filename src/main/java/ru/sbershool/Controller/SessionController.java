package ru.sbershool.Controller;

/**
 * Контроллер сеанса работы с клиентом
 */
public interface SessionController {

    /**
     * Примерный алгоритм:
     * <p>
     * Отобразить WelcomeView
     * Считать карту клиента через CardReader
     * todo: Ввод пин-кода через PinPad (не знаю, как с ним дальше работать)
     * Авторизовать клиента через AuthorizationService
     * Показать SessionView, ожидать ввод клиента
     * ...
     * Если клиент запрашивает баланс, вызвать BalanceController.execute(), вернуться к SessionView
     * ...
     * Если клиент уходит, вызвать Session.clear(), выплюнуть карту и показать GoodbyeView
     * Подождать 10 сек
     * Вернуться к первому шагу
     */
    void execute();
}
