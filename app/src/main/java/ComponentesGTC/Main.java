package ComponentesGTC;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        //CONTADOR
        
        ContadorGTC contadorGTC = new ContadorGTC();
        contadorGTC.setType("vidas");
        contadorGTC.setContador(19);
        contadorGTC.setIcon(new Image("https://www.giantbomb.com/a/uploads/scale_medium/0/4054/471099-42_razor.jpg"));
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(contadorGTC, 200, 200));
        stage1.show();
        
        
        //GUESSFIELD
        GuessFieldGTC guessFieldGTC = new GuessFieldGTC();
        guessFieldGTC.setNombreBoton("Probar");
        guessFieldGTC.setPalabras(List.of("Hola", "Adios"));
        Stage stage2 = new Stage();
        stage2.setScene(new Scene(guessFieldGTC, 200, 200));
        stage2.show();
        
        
        //GUESSEDLIST
        
        GuessedListGTC guessedListGTC = new GuessedListGTC();
        guessedListGTC.sumarSugerenciaIncorrecta("Pito");
        guessedListGTC.sumarSugerenciaIncorrecta("AArbol");
        guessedListGTC.sumarSugerenciaIncorrecta("Paco");
        Stage stage3 = new Stage();
        stage3.setScene(new Scene(guessedListGTC, 200, 200));
        stage3.show();
        
        
        //HINTBUTTON
        
        HintButtonGTC hintButtonGTC = new HintButtonGTC();
        hintButtonGTC.setNombreBoton("Pistilla");
        hintButtonGTC.setPistaIcono(new Image("https://www.giantbomb.com/a/uploads/scale_medium/0/4054/471099-42_razor.jpg"));
        hintButtonGTC.setTextoPista("DLKAMWLDMALWMDLMAWMDKLAMWD");
        Stage stage4 = new Stage();
        stage4.setScene(new Scene(hintButtonGTC, 400, 400));
        stage4.show();
        
        
        //IMAGEVIEW
        
        ImageViewGTC imageViewGTC = new ImageViewGTC();
        imageViewGTC.setImage(new Image("https://www.giantbomb.com/a/uploads/scale_medium/0/4054/471099-42_razor.jpg"));
        imageViewGTC.setBlurFactor(20);
        Stage stage5 = new Stage();
        stage5.setScene(new Scene(new StackPane(imageViewGTC), 200, 200));
        stage5.show();
        
    }
}