package todolist.my.test.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import todolist.my.test.panels.panelCategory.Category;
import todolist.my.test.panels.panelMain.CreateTodo;
import todolist.my.test.panels.panelMain.ListPanel;
import todolist.my.test.panels.panelManager.List;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.AssertJUnit.assertTrue;

public class MovingTodo extends BaseTest {

    @BeforeTest
    public void beforeTest() throws Throwable {
        initialize();
    }

    @Test
    public void momingTodoListToCategory() {
        page(List.class).create(DATA.getProperty("LIST_NAME_TODO_MOVE"));
        assertTrue(page(List.class).getByName(DATA.getProperty("LIST_NAME_TODO_MOVE")).isDisplayed());
        page(CreateTodo.class).createNewTodo(DATA.getProperty("NAME_OF_MOVING_TODO"));
        assertTrue(page(ListPanel.class).getByName(DATA.getProperty("NAME_OF_MOVING_TODO")).isDisplayed());
        page(ListPanel.class).completeTodo(DATA.getProperty("NAME_OF_MOVING_TODO"));
        assertTrue(page(ListPanel.class).getByName(DATA.getProperty("NAME_OF_MOVING_TODO")).isDisplayed());
        page(Category.class).create(DATA.getProperty("CATEGORY"));
        assertTrue(page(Category.class).getByName(DATA.getProperty("CATEGORY")).isDisplayed());
        page(List.class).movingTodo(DATA.getProperty("LIST_NAME_TODO_MOVE"), DATA.getProperty("CATEGORY"));
    }
}
