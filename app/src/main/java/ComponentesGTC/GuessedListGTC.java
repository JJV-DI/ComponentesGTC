package ComponentesGTC;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GuessedListGTC extends VBox{
    
    private ObservableList<String> palabrasIncorrectas;

    public GuessedListGTC() {
        super();
        palabrasIncorrectas = FXCollections.observableArrayList();
    }
    
    public void sumarSugerenciaIncorrecta(String sugerencia) {
        HBox hbox = new HBox(new Label(sugerencia));
        hbox.setPrefWidth(this.getWidth());
        this.getChildren().add(hbox);
    }
    
    
}
