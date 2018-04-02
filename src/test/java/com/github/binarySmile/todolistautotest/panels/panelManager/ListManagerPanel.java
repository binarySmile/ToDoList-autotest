package com.github.binarySmile.todolistautotest.panels.panelManager;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.binarySmile.todolistautotest.core.PageObjects;
import com.github.binarySmile.todolistautotest.interfaces.Createable;
import com.github.binarySmile.todolistautotest.interfaces.Panel;
import com.github.binarySmile.todolistautotest.panels.panelCategory.Category;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class ListManagerPanel extends PageObjects implements Createable, Panel {

    @Override
    public void create(String listName) {
        addNewTodoListButton.click();
        newNameInput.val(listName).pressEnter();
    }

    @Override
    public ElementsCollection getList() {
        return listManager;
    }

    @Override
    public SelenideElement getByName(String listName) {
        return listManager.filter(text(listName)).shouldHaveSize(1).last();
    }

    public void movingTodo(String listName, String categoryName) {
        getByName(listName).dragAndDropTo(page(Category.class).getByName(categoryName));
    }
}



