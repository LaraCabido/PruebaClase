package Ejercicio1;

public class Juego {
    private int[][] panel = new int[3][3];
    private int fichasColocadas;
    private int turno;

    public Juego() {
        turno = ((int) (Math.random() * 2) + 1);
    }

    public int[][] getPanel() {
        return panel;
    }

    public int getFichasColocadas() {
        return fichasColocadas;
    }

    public int getTurno() {
        return turno;
    }

    public int setTurno() {
        if (turno == 1) {
            return turno = 2;
        } else
            return turno = 1;

    }

    public boolean posicionarFicha(int fila, int columna) {
        if (panel[fila][columna] == 0) {
            panel[fila][columna] = turno;
            fichasColocadas += 1;
        }else{
            return false;
        }
        return true;
    }

   /* private boolean comprobarColumna(int turno) {
        int uno = 0;
        int dos = 0;
        boolean comprobar;
        for (int i = 0; i <= panel.length; i++) {
            for (int j = 0; j <= 3; j++) {
                if (panel[i][j] == 1) {
                    uno += 1;
                } else if (panel[i][j] == 2) {
                    dos += 1;
                }
            }
        }
    }*/

}
