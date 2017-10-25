package todolist.my.test.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import todolist.my.test.panels.panelCategory.Category;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.AssertJUnit.assertTrue;

public class TestCategoryPanel extends BaseTest {

    @BeforeTest
    public void beforeTest() throws Throwable {
        initialize();
    }

    @Test
    public void createCategory() {
        page(Category.class).create(DATA.getProperty("CATEGORY_NAME"));
        assertTrue(page(Category.class).getByName(DATA.getProperty("CATEGORY_NAME")).isDisplayed());
    }

    @Test
    public void deleteCategory() {
        page(Category.class).create(DATA.getProperty("CATEGORY_NAME"));
        assertTrue(page(Category.class).getByName(DATA.getProperty("CATEGORY_NAME")).isDisplayed());
        page(Category.class).deleteCategory(DATA.getProperty("CATEGORY_NAME"));
    }
}
