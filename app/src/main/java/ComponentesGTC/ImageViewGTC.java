package ComponentesGTC;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.ImageView;
import javafx.scene.effect.GaussianBlur;

public class ImageViewGTC extends ImageView {
    private final SimpleDoubleProperty blurFactor = new SimpleDoubleProperty();
    private GaussianBlur gaussianBlur;
    
    public ImageViewGTC() {
        super();
        setPreserveRatio(true);
        setSmooth(true);
        gaussianBlur = new GaussianBlur();
        setEffect(gaussianBlur);
        gaussianBlur.radiusProperty().bind(blurFactor);
    }
    
    public void decrecerBlur() {
        if (blurFactor.get() > 1) {
            blurFactor.set(blurFactor.get() - 2);
        }
    }
    
    public double getBlurFactor() {
        return blurFactor.get();
    }
    
    public void setBlurFactor(double value) {
        blurFactor.set(value);
    }
}