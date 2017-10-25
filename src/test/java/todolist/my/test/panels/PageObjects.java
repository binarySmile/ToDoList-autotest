package todolist.my.test.panels;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class PageObjects {

    @FindBy(id = "newtodo")
    protected SelenideElement todoInput;

    @FindBy(xpath = "//ul[@id='mydonetodos']/li")
    protected ElementsCollection doneList;

    @FindBy(xpath = "//ul[@id='mytodos']//li")
    protected ElementsCollection todosList;

    @FindBy(id = "addlist")
    protected SelenideElement addNewTodoListButton;

    @FindBy(xpath = "//div[@id='lists']//li//li")
    protected ElementsCollection listManager;

    @FindBy(id = "updatebox")
    protected SelenideElement newNameInput;

    @FindBy(id = "adddivider")
    protected SelenideElement addNewCategoryButton;

    @FindBy(xpath = "//div[@id='lists']//li")
    protected ElementsCollection listCategory;
}
