package todolist.my.test.tests;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import todolist.my.test.panels.panelMain.CreateTodo;
import todolist.my.test.panels.panelMain.ListPanel;
import todolist.my.test.panels.panelManager.List;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.AssertJUnit.assertTrue;

public class TestNewList extends BaseTest {

    @BeforeTest
    public void beforeTest() throws Throwable {
        initialize();
    }

    @Test
    public void createNewList(){
        page(List.class).create(DATA.getProperty("LIST_NAME"));
        assertTrue(page(List.class).getByName(DATA.getProperty("LIST_NAME")).isDisplayed());
    }

    @Test
    public void creatingNewTodoInMyList(){
        page(List.class).create(DATA.getProperty("LIST_NAME"));
        assertTrue(page(List.class).getByName(DATA.getProperty("LIST_NAME")).isDisplayed());
        page(CreateTodo.class).createNewTodo(DATA.getProperty("TODO_NAME_IN_MY_LIST"));
        assertTrue(page(ListPanel.class).getByName(DATA.getProperty("TODO_NAME_IN_MY_LIST")).isDisplayed());
        page(ListPanel.class).completeTodo(DATA.getProperty("TODO_NAME_IN_MY_LIST"));
        assertTrue(page(ListPanel.class).getByName(DATA.getProperty("TODO_NAME_IN_MY_LIST")).isDisplayed());
    }
}
