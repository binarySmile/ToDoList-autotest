package com.github.binarySmile.todolistautotest.tests;

import com.github.binarySmile.todolistautotest.core.BaseTest;
import com.github.binarySmile.todolistautotest.panels.panelMain.CreateTodo;
import com.github.binarySmile.todolistautotest.panels.panelMain.DonePanel;
import com.github.binarySmile.todolistautotest.panels.panelMain.ListPanel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class TodoPanelTest extends BaseTest {

    @Test
    public void todoCreate() {
        page(CreateTodo.class).create(DATA.getProperty("TODO_NAME"));
        assertTrue(page(ListPanel.class).getByName(DATA.getProperty("TODO_NAME")).isDisplayed());
    }

    @Test
    public void completeTodo() {
        page(CreateTodo.class).create(DATA.getProperty("TODO_NAME"));
        assertTrue(page(ListPanel.class).getByName(DATA.getProperty("TODO_NAME")).isDisplayed());
        page(ListPanel.class).completeTodo(DATA.getProperty("TODO_NAME"));
        assertTrue(page(DonePanel.class).getByName(DATA.getProperty("TODO_NAME")).isDisplayed());
    }

    @Test
    public void deleteTodo() {
        page(CreateTodo.class).create(DATA.getProperty("TODO_NAME"));
        assertTrue(page(ListPanel.class).getByName(DATA.getProperty("TODO_NAME")).isDisplayed());
        page(ListPanel.class).completeTodo(DATA.getProperty("TODO_NAME"));
        assertTrue(page(DonePanel.class).getByName(DATA.getProperty("TODO_NAME")).isDisplayed());
        page(DonePanel.class).deleteTodo(DATA.getProperty("TODO_NAME"));
        assertTrue(page(DonePanel.class).getList().isEmpty());
    }
}