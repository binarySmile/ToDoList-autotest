package com.github.binarySmile.todolistautotest.panels.panelMain;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.binarySmile.todolistautotest.core.PageObjects;
import com.github.binarySmile.todolistautotest.interfaces.Panel;

import static com.codeborne.selenide.Condition.text;

public class DonePanel extends PageObjects implements Panel {

    @Override
    public ElementsCollection getList() {

        return doneList.shouldHaveSize(0);
    }

    @Override
    public SelenideElement getByName(String toDoName) {
        return doneList.filter(text(toDoName)).shouldHaveSize(1).first();
    }

    public void deleteTodo(String name) {
        getByName(name).hover();
        getByName(name).$(".delete").click();
    }
}
