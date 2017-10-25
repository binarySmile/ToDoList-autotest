package todolist.my.test.Interfaces;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public interface Panelable {

  ElementsCollection getList();

  SelenideElement getByName(String name);
}
