package ru.sbershool.Device;

import ru.sbershool.Model.Card;

public interface CardReader {

    Card waitForCard();

    void ejectCard();
}
