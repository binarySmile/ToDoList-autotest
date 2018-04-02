package com.github.binarySmile.todolistautotest.panels.panelCategory;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.binarySmile.todolistautotest.core.PageObjects;
import com.github.binarySmile.todolistautotest.interfaces.Createable;
import com.github.binarySmile.todolistautotest.interfaces.Panel;

import static com.codeborne.selenide.Condition.text;

public class Category extends PageObjects implements Createable, Panel {

    @Override
    public void create(String categoryName) {
        addNewCategoryButton.click();
        newNameInput.val(categoryName).pressEnter();
    }

    @Override
    public ElementsCollection getList() {
        return listCategory;
    }

    @Override
    public SelenideElement getByName(String listName) {
        return listCategory.filter(text(listName)).shouldHaveSize(1).last();
    }

    public void deleteCategory(String categoryName) {
        SelenideElement element = getByName(categoryName);
        deleteCategory(element.hover());
    }

    public void deleteCategory(SelenideElement element) {
        element.$(".delete").click();
        listCategory.shouldHave(CollectionCondition.size(6));
    }
}
