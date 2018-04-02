package com.github.binarySmile.todolistautotest.tests;

import com.github.binarySmile.todolistautotest.core.BaseTest;
import com.github.binarySmile.todolistautotest.panels.panelMain.CreateTodo;
import com.github.binarySmile.todolistautotest.panels.panelMain.ListPanel;
import com.github.binarySmile.todolistautotest.panels.panelManager.ListManagerPanel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;


public class NewListTest extends BaseTest {

    @Test
    public void createNewList() {
        page(ListManagerPanel.class).create(DATA.getProperty("LIST_NAME"));
        assertTrue(page(ListManagerPanel.class).getByName(DATA.getProperty("LIST_NAME")).isDisplayed());
    }

    @Test
    public void creatingNewTodoInMyList() {
        page(ListManagerPanel.class).create(DATA.getProperty("LIST_NAME"));
        assertTrue(page(ListManagerPanel.class).getByName(DATA.getProperty("LIST_NAME")).isDisplayed());
        page(CreateTodo.class).create(DATA.getProperty("TODO_NAME_IN_MY_LIST"));
        assertTrue(page(ListPanel.class).getByName(DATA.getProperty("TODO_NAME_IN_MY_LIST")).isDisplayed());
        page(ListPanel.class).completeTodo(DATA.getProperty("TODO_NAME_IN_MY_LIST"));
        assertTrue(page(ListPanel.class).getByName(DATA.getProperty("TODO_NAME_IN_MY_LIST")).isDisplayed());
    }
}
