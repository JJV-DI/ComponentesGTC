package ComponentesGTC;

import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GuessFieldGTC extends HBox{
    
    private TextField textField;
    private Button button;
    private final SimpleStringProperty nombreBoton = new SimpleStringProperty();
    private ListView<String> listView;
    private ObservableList<String> sugerencias;
    private List<String> palabras;
    
    public GuessFieldGTC() {
        super();
        this.palabras = FXCollections.observableArrayList();
        this.textField = new TextField();
        this.button = new Button();
        this.button.textProperty().bind(nombreBoton);
        this.button.setCursor(Cursor.HAND);
        this.listView = new ListView<>();
        this.sugerencias = FXCollections.observableArrayList();
        listView.setVisible(false);
        listView.setPrefHeight(100);
        this.getChildren().addAll(new VBox(textField, listView), button);
        
        textField.addEventFilter(KeyEvent.KEY_RELEASED, event -> {
            String palabraSugerida = textField.getText();
            actualizarSugerencias(palabraSugerida);
        });
        
        listView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                String palabraSeleccionadaString = listView.getSelectionModel().getSelectedItem();
                if (palabraSeleccionadaString != null) {
                    textField.setText(palabraSeleccionadaString);
                    listView.setVisible(false);
                }
            }
        });
    }

    private void actualizarSugerencias(String palabraString) {
        sugerencias.clear();
        if (!palabraString.isEmpty()) {
            for (String palabra : palabras) {
                if (palabra.toLowerCase().contains(palabraString.toLowerCase())) {
                    sugerencias.add(palabra);
                }
            }
            listView.setItems(sugerencias);
            listView.setVisible(!sugerencias.isEmpty());
        } else {
            listView.setVisible(false);
        }
    }

    public TextField getTextField() {
        return textField;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public String getNombreBoton() {
        return nombreBoton.get();
    }

    public void setNombreBoton(String nombreBoton) {
        this.nombreBoton.set(nombreBoton);
    }

    public ListView<String> getListView() {
        return listView;
    }

    public void setListView(ListView<String> listView) {
        this.listView = listView;
    }

    public ObservableList<String> getSugerencias() {
        return sugerencias;
    }

    public void setSugerencias(ObservableList<String> sugerencias) {
        this.sugerencias = sugerencias;
    }

    public List<String> getPalabras() {
        return palabras;
    }

    public void setPalabras(List<String> palabras) {
        this.palabras = palabras;
    }
    
}
