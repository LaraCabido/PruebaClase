package Ejercicio1;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Controller {
    public ImageView imgFicha1;
    public ImageView imgFicha2;
    public TextArea taMensaje;
    public GridPane gpJuego;
    public Juego juego;

    public Button btNuevoJuego;

    public void initialize() {
        juego = new Juego();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                button.setOnAction(this::buttonClic); //asociar método
                gpJuego.add(button, j, i); // coordenas del layout grid columna fila
            }
        }
        if (juego.getTurno() == 1) {
            imgFicha2.setVisible(false);
            imgFicha1.setVisible(true);
        } else {
            imgFicha1.setVisible(false);
            imgFicha2.setVisible(true);
        }


    }

    private void buttonClic(ActionEvent actionEvent) {
        Button boton = (Button) (actionEvent.getTarget());
        int fila = gpJuego.getRowIndex(boton);
        int columna = gpJuego.getColumnIndex(boton);
        if (juego.posicionarFicha(fila, columna) == true) {
            asignarImagen_Button(fila, columna, boton);
            juego.setTurno();
            if (juego.getTurno() == 1) {
                imgFicha2.setVisible(false);
                imgFicha1.setVisible(true);
            } else {
                imgFicha1.setVisible(false);
                imgFicha2.setVisible(true);
            }
        } else {
            taMensaje.setText("Ya hay una ficha ahí");
        }

    }


    public void asignarImagen_Button(int i, int j, Button button) {
        Image image = new Image(getClass().getResourceAsStream("ficha" + juego.getTurno() + ".png"), 100, 100, false, false);
        ImageView imageView = new ImageView(image);
        button.setGraphic(imageView);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    public void NuevoJuego(ActionEvent actionEvent) {
        initialize();

    }
}
