package ComponentesGTC;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class ContadorGTC extends HBox {

    private Label lblContador = new Label();
    private final SimpleIntegerProperty contador = new SimpleIntegerProperty();
    
    private ImageView imageViewIcon = new ImageView();
    private final SimpleObjectProperty<Image> icon = new SimpleObjectProperty<>();
    
    private final SimpleStringProperty type = new SimpleStringProperty();
    private FadeTransition fadeTransition;
    
    public ContadorGTC() {
        super();
        this.imageViewIcon.imageProperty().bind(icon);
        this.imageViewIcon.setFitWidth(30);
        this.imageViewIcon.setFitHeight(30);
        lblContador.textProperty().bind(contador.asString());
        this.getChildren().addAll(lblContador, imageViewIcon);
        this.setAlignment(Pos.CENTER);
        type.set("");
        contador.addListener((observable, oldValue, newValue) -> {
            updateBlinking();
        });
        setStyles();
    }
    
    private void setStyles() {
        lblContador.getStyleClass().add("label-contador");
    }

    private void updateBlinking() {
        if (fadeTransition != null) {
            fadeTransition.stop();
        }
        System.out.println("Tipo:" + type.get());
        switch (this.type.get()) {
            case "vidas" -> {
                if (contador.get() >= 20) {
                    imageViewIcon.setOpacity(1.0);
                } else {
                    startParpadeo(20 - contador.get());
                }
            }
            case "racha" -> {
                if (contador.get() <= 0) {
                    imageViewIcon.setOpacity(1.0);
                } else {
                    startParpadeo(contador.get());
                }
            }
            default -> {System.out.println("Tipo inicializado");}
        }
    }

    private void startParpadeo(int value) {
        int blinkSpeed = Math.max(1, value);
        Duration duration = Duration.millis(3000 / blinkSpeed);
        fadeTransition = new FadeTransition(duration, imageViewIcon);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(Timeline.INDEFINITE);
        fadeTransition.setAutoReverse(true);
        fadeTransition.setInterpolator(Interpolator.EASE_BOTH);
        fadeTransition.play();
    }

    public Label getLblContador() {
        return lblContador;
    }

    public void setLblContador(Label lblContador) {
        this.lblContador = lblContador;
    }

    public int getContador() {
        return contador.get();
    }

    public void setContador(int contador) {
        this.contador.set(contador);
    }

    public ImageView getImageViewIcon() {
        return imageViewIcon;
    }

    public void setImageViewIcon(ImageView imageViewIcon) {
        this.imageViewIcon = imageViewIcon;
    }

    public Image getIcon() {
        return icon.get();
    }

    public void setIcon(Image icon) {
        this.icon.set(icon);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }    
    
}