package todolist.my.test.tests;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import todolist.my.test.panels.panelMain.CreateTodo;
import todolist.my.test.panels.panelMain.DonePanel;
import todolist.my.test.panels.panelMain.ListPanel;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.AssertJUnit.assertTrue;

public class TestTodoPanel extends BaseTest {

    @BeforeTest
    public void beforeTest() throws Throwable {
        initialize();
    }

    @Test
    public void todoCreate(){
        page(CreateTodo.class).createNewTodo(DATA.getProperty("TODO_NAME"));
        assertTrue(page(ListPanel.class).getByName(DATA.getProperty("TODO_NAME")).isDisplayed());
    }

    @Test
    public void completeTodo(){
        page(CreateTodo.class).createNewTodo(DATA.getProperty("TODO_NAME"));
        assertTrue(page(ListPanel.class).getByName(DATA.getProperty("TODO_NAME")).isDisplayed());
        page(ListPanel.class).completeTodo(DATA.getProperty("TODO_NAME"));
        assertTrue(page(DonePanel.class).getByName(DATA.getProperty("TODO_NAME")).isDisplayed());
    }

    @Test
    public void deleteTodo(){
        page(CreateTodo.class).createNewTodo(DATA.getProperty("TODO_NAME"));
        assertTrue(page(ListPanel.class).getByName(DATA.getProperty("TODO_NAME")).isDisplayed());
        page(ListPanel.class).completeTodo(DATA.getProperty("TODO_NAME"));
        assertTrue(page(DonePanel.class).getByName(DATA.getProperty("TODO_NAME")).isDisplayed());
        page(DonePanel.class).deleteTodo(DATA.getProperty("TODO_NAME"));
        assertTrue(page(DonePanel.class).getList().isEmpty());
    }
}