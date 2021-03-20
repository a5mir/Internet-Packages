package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class PersonController {

    @FXML
    private Button saveBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Button deleteBtn;

    @FXML
    private URL location;
    @FXML
    private ResourceBundle resources;

    @FXML
    private ToggleGroup speed;

    @FXML
    private ToggleGroup data;

    @FXML
    private ToggleGroup duration;

    @FXML
    private TextField fName;

    @FXML
    private TextField lName;

    @FXML
    private TextField adress;

    @FXML
    private Label error;

    ObservableList<Person> persons = FXCollections.<Person>observableArrayList();
    Person person;

    @FXML
    TableView<Person> tabela = new TableView<>();

    public PersonController() {
    }


    public boolean isValid() {
        boolean isValid = true;
        if (fName.getText() != null && fName.getText().isEmpty()) {
            isValid = false;
            error.setText("Fields can't be empty!!");
        }
        if (lName.getText() != null && lName.getText().isEmpty()) {
            isValid = false;
            error.setText("Fields can't be empty!!");
        }
        if (adress.getText() != null && adress.getText().isEmpty()) {
            isValid = false;
            error.setText("Fields can't be empty!!");
        }
        if (speed.getSelectedToggle() == null) {
            isValid = false;
            error.setText("Fields can't be empty!!");
        }
        if (duration.getSelectedToggle() == null) {
            isValid = false;
            error.setText("Fields can't be empty!!");
        }
        if (data.getSelectedToggle() == null) {
            isValid = false;
            error.setText("Fields can't be empty!!");
        }
        return isValid;
    }

    @FXML
    private void savePerson() throws NullPointerException {

        if (isValid()) {
            RadioButton rbspeed = (RadioButton) speed.getSelectedToggle();
            RadioButton rbdata = (RadioButton) data.getSelectedToggle();
            ToggleButton tbduration = (ToggleButton) duration.getSelectedToggle();

            persons = tabela.getItems();
            persons.add(new Person(rbspeed.getText(), rbdata.getText(), tbduration.getText(), fName.getText(), lName.getText(), adress.getText()));
            tabela.setItems(persons);
            error.setText("Added");
        }
    }

    @FXML
    private void clearPerson() {
        speed.selectToggle(null);
        data.selectToggle(null);
        duration.selectToggle(null);
        fName.setText(null);
        lName.setText(null);
        adress.setText(null);
        error.setText("Cleared");
    }

    @FXML
    private void deletePerson() {
        persons = tabela.getItems();
        int index = tabela.selectionModelProperty().getValue().getSelectedIndex();
        try {
            persons.remove(index);
            tabela.setItems(persons);
            error.setText("Deleted");
        } catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

    }

}
