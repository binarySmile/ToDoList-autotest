package com.github.binarySmile.todolistautotest.interfaces;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public interface Panel {

    ElementsCollection getList();

    SelenideElement getByName(String name);
}
