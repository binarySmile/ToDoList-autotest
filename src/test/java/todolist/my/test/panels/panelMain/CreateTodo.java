package todolist.my.test.panels.panelMain;


import todolist.my.test.Interfaces.Createable;
import todolist.my.test.panels.PageObjects;


public class CreateTodo extends PageObjects implements Createable {

    @Override
    public void create(String newTodoName) {
        todoInput.val(newTodoName).pressEnter();
    }
}

