package com.github.binarySmile.todolistautotest.panels.panelMain;

import com.github.binarySmile.todolistautotest.core.PageObjects;
import com.github.binarySmile.todolistautotest.interfaces.Createable;

public class CreateTodo extends PageObjects implements Createable {

    @Override
    public void create(String newTodoName) {
        todoInput.val(newTodoName).pressEnter();
    }
}

