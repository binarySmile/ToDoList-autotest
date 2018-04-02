package com.github.binarySmile.todolistautotest.panels.panelMain;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.binarySmile.todolistautotest.core.PageObjects;
import com.github.binarySmile.todolistautotest.interfaces.Panel;

import static com.codeborne.selenide.Condition.text;

public class ListPanel extends PageObjects implements Panel {

    @Override
    public ElementsCollection getList() {
        return todosList;
    }

    @Override
    public SelenideElement getByName(String todoName) {
        return todosList.filter(text(todoName)).shouldHaveSize(1).last();
    }

    public void completeTodo(String todoName) {
        getByName(todoName).$("input").click();
    }
}
