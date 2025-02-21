package ComponentesGTC;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HintButtonGTC extends VBox{

    private Button btnPista;
    
    private final SimpleStringProperty nombreBoton = new SimpleStringProperty();
    
    private ImageView imageView;
    
    private final SimpleObjectProperty<Image> pistaIcono = new SimpleObjectProperty<>();
    
    private TextArea textArea;
    
    private final SimpleStringProperty textoPista = new SimpleStringProperty();
      
    public HintButtonGTC() {
        super();
        btnPista = new Button();
        this.btnPista.setCursor(Cursor.HAND);
        btnPista.textProperty().bind(nombreBoton);
        imageView = new ImageView();
        imageView.imageProperty().bind(pistaIcono);
        btnPista.setGraphic(imageView);
        textArea = new TextArea();
        textArea.textProperty().bind(textoPista);
        textArea.setEditable(false);
        getChildren().addAll(new HBox(btnPista, new Label("Pistas:")), textArea);
    }

    public Button getBtnPista() {
        return btnPista;
    }

    public void setBtnPista(Button btnPista) {
        this.btnPista = btnPista;
    }

    public String getNombreBoton() {
        return nombreBoton.get();
    }

    public void setNombreBoton(String nombreBoton) {
        this.nombreBoton.set(nombreBoton);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Image getPistaIcono() {
        return pistaIcono.get();
    }

    public void setPistaIcono(Image pistaIcono) {
        this.pistaIcono.set(pistaIcono);
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    public String getTextoPista() {
        return textoPista.get();
    }

    public void setTextoPista(String textoPista) {
        this.textoPista.set(textoPista);
    }
    
    
    
    
    
}
