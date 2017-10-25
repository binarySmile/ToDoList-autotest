package todolist.my.test.panels.panelCategory;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import todolist.my.test.Interfaces.Panelable;
import todolist.my.test.panels.PageObjects;
import todolist.my.test.Interfaces.Createable;

import static com.codeborne.selenide.Condition.text;

public class Category extends PageObjects implements Createable, Panelable {

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
        int initialCategorySize = listCategory.size();
        element.$(".delete").click();
        listCategory.shouldHave(CollectionCondition.size(6));
    }
}
