package todolist.my.test.panels.panelMain;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import todolist.my.test.Interfaces.Panelable;
import todolist.my.test.panels.PageObjects;

import static com.codeborne.selenide.Condition.text;


public class DonePanel extends PageObjects implements Panelable {

    @Override
    public ElementsCollection getList() {
        return doneList;
    }

    @Override
    public SelenideElement getByName(String toDoName) {
        return doneList.filter(text(toDoName)).shouldHaveSize(1).first();
    }

    public void deleteTodo(String name) {
        getByName(name).hover();
        getByName(name).$("img").click();
    }
}
