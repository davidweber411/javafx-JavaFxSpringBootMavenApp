package com.wedasoft.javafxspringbootmavenapp.views;

import com.wedasoft.javafxspringbootmavenapp.persistence.hobby.Todo;
import com.wedasoft.javafxspringbootmavenapp.persistence.hobby.TodoRepository;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UiController {

    private final TodoRepository todoRepository;

    @FXML
    public ListView<Todo> todosListView;
    @FXML
    public TextField todoTf;

    @FXML
    public void initialize() {
        todosListView.setItems(FXCollections.observableArrayList(todoRepository.findAll()));
    }

    public void onExitMenuItemClick() {
        Platform.exit();
        System.exit(0);
    }

    public void onAddTodoBtnClick() {
        todoRepository.save(new Todo(null, todoTf.getText()));
        updateTodosListView();
    }

    public void onDeleteAllTodosBtnClick() {
        todoRepository.deleteAll();
        updateTodosListView();
    }

    private void updateTodosListView() {
        todosListView.setItems(FXCollections.observableArrayList(todoRepository.findAll()));
    }

}
