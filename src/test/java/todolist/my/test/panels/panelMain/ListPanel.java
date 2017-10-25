package todolist.my.test.panels.panelMain;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import todolist.my.test.Interfaces.Panelable;
import todolist.my.test.panels.PageObjects;

import static com.codeborne.selenide.Condition.text;


public class ListPanel extends PageObjects implements Panelable {

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
