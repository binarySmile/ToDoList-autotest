package todolist.my.test.panels.panelManager;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import todolist.my.test.panels.PageObjects;
import todolist.my.test.Interfaces.Createable;
import todolist.my.test.Interfaces.Panelable;
import todolist.my.test.panels.panelCategory.Category;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class List extends PageObjects implements Createable, Panelable {

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



