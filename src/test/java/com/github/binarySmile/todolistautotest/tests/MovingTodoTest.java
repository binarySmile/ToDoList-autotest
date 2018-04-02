package com.github.binarySmile.todolistautotest.tests;

import com.github.binarySmile.todolistautotest.core.BaseTest;
import com.github.binarySmile.todolistautotest.panels.panelCategory.Category;
import com.github.binarySmile.todolistautotest.panels.panelMain.CreateTodo;
import com.github.binarySmile.todolistautotest.panels.panelMain.ListPanel;
import com.github.binarySmile.todolistautotest.panels.panelManager.ListManagerPanel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class MovingTodoTest extends BaseTest {

    @Test
    public void movingTodoListToCategory() {
        page(ListManagerPanel.class).create(DATA.getProperty("LIST_NAME_TODO_MOVE"));
        assertTrue(page(ListManagerPanel.class).getByName(DATA.getProperty("LIST_NAME_TODO_MOVE")).isDisplayed());
        page(CreateTodo.class).create(DATA.getProperty("NAME_OF_MOVING_TODO"));
        assertTrue(page(ListPanel.class).getByName(DATA.getProperty("NAME_OF_MOVING_TODO")).isDisplayed());
        page(ListPanel.class).completeTodo(DATA.getProperty("NAME_OF_MOVING_TODO"));
        assertTrue(page(ListPanel.class).getByName(DATA.getProperty("NAME_OF_MOVING_TODO")).isDisplayed());
        page(Category.class).create(DATA.getProperty("CATEGORY"));
        assertTrue(page(Category.class).getByName(DATA.getProperty("CATEGORY")).isDisplayed());
        page(ListManagerPanel.class).movingTodo(DATA.getProperty("LIST_NAME_TODO_MOVE"), DATA.getProperty("CATEGORY"));
    }
}
