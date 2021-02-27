package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Person;

public class PersonController {
    
    private final Person person;
    
    @FXML
    private Label lblGreeting;
    
    @FXML
    private Button btnShow;
    
    public PersonController(Person person) {
        this.person = person;
    }
    
    public void initialize(){
        lblGreeting.setText("");
        btnShow.setOnAction((actionEvent) -> {
            var salutation = this.person.getSalutation();
            lblGreeting.setText(salutation);
        });
    }
}
