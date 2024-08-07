package com.wedasoft.javafxspringbootmavenapp.views;

import com.wedasoft.javafxspringbootmavenapp.persistence.todo.TodoRepository;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class DialogController {

    private final TodoRepository todoRepository;
    private final Application jfxApplication;
    private final HostServices hostServices;
    private final Application.Parameters parameters;

    @FXML
    private Label springBeanValueLabel;
    @FXML
    private Label jfxAppValueLabel;

    public void init() {
        springBeanValueLabel.setText(String.valueOf(todoRepository.count()));
        jfxAppValueLabel.setText(String.format("""
                        From Jfx Application: %s
                        From HostServices: %s
                        From Parameters: %s""",
                jfxApplication.getHostServices().getDocumentBase(),
                hostServices.getDocumentBase(),
                parameters.getRaw()));
    }

}
