import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HolaMundoFX extends Application {

    @Override
    public void start(Stage ventana) {
        Label mensaje = new Label("Hola Mundo");
        Button boton = new Button("Haz click aca");

        boton.setOnAction(e -> {
            mensaje.setText("Hola, Leopoldo");
        });

        VBox caja = new VBox(10);
        caja.getChildren().add(mensaje);
        caja.getChildren().add(boton);

        Scene escena = new Scene(caja, 300, 200);

        ventana.setTitle("Mi primer programa con JavaFX");
        ventana.setScene(escena);
        ventana.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}




