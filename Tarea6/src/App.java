import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class App extends Application {
    private double totalGastado = 0;
    private double presupuesto = 0;
    private boolean presupuestoFijado = false;

    private final DecimalFormat formatoDinero = new DecimalFormat("#,##0.00");
    private final VBox listaGastos = new VBox(8);
    private final Label resultado = new Label();

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label titulo = new Label("Control de gastos del mes");
        titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #410CF0; -fx-padding: 10px;");

        Label textoPresupuesto = new Label("Presupuesto mensual");
        textoPresupuesto.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        TextField campoPresupuesto = new TextField();
        campoPresupuesto.setPromptText("Ingrese el presupuesto");

        Button fijar = new Button("Fijar");
        fijar.setStyle("-fx-background-color: #410CF0; -fx-text-fill: white; -fx-font-weight: bold;");
        fijar.setOnAction(e -> fijarPresupuesto(campoPresupuesto));

        HBox filaPresupuesto = new HBox(8, campoPresupuesto, fijar);
        filaPresupuesto.setAlignment(Pos.CENTER);
        HBox.setHgrow(campoPresupuesto, Priority.ALWAYS);

        Label textoGasto = new Label("Agregar un gasto");
        textoGasto.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        TextField campoDescripcion = new TextField();
        campoDescripcion.setPromptText("Descripcion del gasto");

        TextField campoMonto = new TextField();
        campoMonto.setPromptText("Monto (RD$)");

        ComboBox<String> categorias = new ComboBox<>();
        categorias.getItems().addAll("Comida", "Transporte", "Hogar", "Salud", "Ocio", "Servicios", "Otros");
        categorias.setValue("Comida");
        categorias.setMaxWidth(Double.MAX_VALUE);

        Button agregar = new Button("Agregar gasto");
        agregar.setStyle("-fx-background-color: #410CF0; -fx-text-fill: white; -fx-font-weight: bold;");
        agregar.setOnAction(e -> agregarGasto(campoDescripcion, campoMonto, categorias));
        campoMonto.setOnAction(e -> agregarGasto(campoDescripcion, campoMonto, categorias));

        resultado.setMaxWidth(Double.MAX_VALUE);
        resultado.setAlignment(Pos.CENTER);
        resultado.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-padding: 10px;");

        Label tituloLista = new Label("Gastos registrados");
        tituloLista.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        listaGastos.setFillWidth(true);
        Label sinGastos = new Label("Todavia no hay gastos.");
        sinGastos.setStyle("-fx-text-fill: gray; -fx-padding: 6px;");
        listaGastos.getChildren().add(sinGastos);

        VBox root = new VBox(12);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);
        root.setStyle("-fx-background-color: #F5F3FF;");
        root.getChildren().addAll(titulo, textoPresupuesto, filaPresupuesto, textoGasto, campoDescripcion, campoMonto, categorias, agregar, resultado, tituloLista, listaGastos);

        Scene scene = new Scene(root, 430, 650);
        stage.setTitle("Gastos del mes");
        stage.setScene(scene);
        stage.show();

        actualizarTotal();
    }

    private void fijarPresupuesto(TextField campoPresupuesto) {
        try {
            double nuevoPresupuesto = leerMonto(campoPresupuesto.getText());

            if (nuevoPresupuesto <= 0 || !Double.isFinite(nuevoPresupuesto)) {
                mostrarMensaje("Ingrese un presupuesto positivo.", "gray");
                return;
            }

            presupuesto = nuevoPresupuesto;
            presupuestoFijado = true;
            actualizarTotal();
        } catch (NumberFormatException ex) {
            mostrarMensaje("Ingrese un presupuesto valido.", "gray");
        }
    }

    private void agregarGasto(TextField campoDescripcion, TextField campoMonto,
                              ComboBox<String> categorias) {
        String descripcion = campoDescripcion.getText().trim();

        if (descripcion.isEmpty()) {
            mostrarMensaje("Ingrese una descripcion para el gasto.", "gray");
            return;
        }

        try {
            double monto = leerMonto(campoMonto.getText());

            if (monto <= 0 || !Double.isFinite(monto)) {
                mostrarMensaje("El monto debe ser un numero positivo.", "gray");
                return;
            }

            if (listaGastos.getChildren().size() == 1
                    && listaGastos.getChildren().get(0) instanceof Label) {
                listaGastos.getChildren().clear();
            }

            agregarFilaGasto(descripcion, monto, categorias.getValue());
            totalGastado += monto;
            campoDescripcion.clear();
            campoMonto.clear();
            campoDescripcion.requestFocus();
            actualizarTotal();
        } catch (NumberFormatException ex) {
            mostrarMensaje("Ingrese un monto valido y positivo.", "gray");
        }
    }

    private void agregarFilaGasto(String descripcion, double monto, String categoria) {
        Label detalle = new Label(descripcion + " - " + categoria);
        detalle.setStyle("-fx-font-size: 13px; -fx-font-weight: bold;");

        Label cantidad = new Label("RD$ " + formatoDinero.format(monto));
        cantidad.setStyle("-fx-font-size: 13px;");

        Button eliminar = new Button("X");
        eliminar.setStyle("-fx-background-color: #FEE2E2; -fx-text-fill: red; -fx-font-weight: bold;");

        Region espacio = new Region();
        HBox.setHgrow(espacio, Priority.ALWAYS);

        HBox fila = new HBox(8, detalle, espacio, cantidad, eliminar);
        fila.setAlignment(Pos.CENTER_LEFT);
        fila.setPadding(new Insets(8));
        fila.setStyle("-fx-background-color: white; -fx-background-radius: 6px;");
        HBox.setHgrow(detalle, Priority.ALWAYS);

        eliminar.setOnAction(e -> {
            listaGastos.getChildren().remove(fila);
            totalGastado -= monto;

            if (listaGastos.getChildren().isEmpty()) {
                Label sinGastos = new Label("Todavia no hay gastos.");
                sinGastos.setStyle("-fx-text-fill: gray; -fx-padding: 6px;");
                listaGastos.getChildren().add(sinGastos);
            }

            actualizarTotal();
        });

        listaGastos.getChildren().add(fila);
    }

    private void actualizarTotal() {
        if (!presupuestoFijado) {
            resultado.setText("Total gastado: RD$ " + formatoDinero.format(totalGastado)
                    + "\nFije un presupuesto para ver lo disponible.");
            resultado.setStyle("-fx-text-fill: green; -fx-font-size: 16px; -fx-font-weight: bold; -fx-padding: 10px;");
            return;
        }

        double disponible = presupuesto - totalGastado;
        double porcentajeUsado = totalGastado / presupuesto;
        String textoDisponible;

        if (disponible >= 0) {
            textoDisponible = "Disponible: RD$ " + formatoDinero.format(disponible);
        } else {
            textoDisponible = "Excedido por: RD$ " + formatoDinero.format(Math.abs(disponible));
        }

        String texto = "Total gastado: RD$ " + formatoDinero.format(totalGastado)
                + "\n" + textoDisponible;

        if (porcentajeUsado > 1) {
            resultado.setText(texto + "\n¡Presupuesto excedido!");
            resultado.setStyle("-fx-text-fill: red; -fx-font-size: 16px; -fx-font-weight: bold; -fx-padding: 10px;");
        } else if (porcentajeUsado >= 0.70) {
            resultado.setText(texto);
            resultado.setStyle("-fx-text-fill: #B8860B; -fx-font-size: 16px; -fx-font-weight: bold; -fx-padding: 10px;");
        } else {
            resultado.setText(texto);
            resultado.setStyle("-fx-text-fill: green; -fx-font-size: 16px; -fx-font-weight: bold; -fx-padding: 10px;");
        }
    }

    private double leerMonto(String texto) {
        String monto = texto.trim().replace("RD$", "").replace(",", "").replace(" ", "");
        return Double.parseDouble(monto);
    }

    private void mostrarMensaje(String mensaje, String color) {
        resultado.setText(mensaje);
        resultado.setStyle("-fx-text-fill: " + color
                + "; -fx-font-size: 16px; -fx-font-weight: bold; -fx-padding: 10px;");
    }
}
