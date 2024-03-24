package com.wedasoft.javafxspringbootmavenapp.views;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UiController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private final HostServices hostServices; // TODO: WORKS, BUT DISPLAYS AN ERROR IN THE EDITOR, WTH.

    @FXML
    public Label label;
    @FXML
    public Button button;

    @FXML
    public void initialize() {
        this.button.setOnAction(e -> this.label.setText(this.hostServices.getDocumentBase()));
    }

}
