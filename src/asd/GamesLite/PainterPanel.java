package asd.GamesLite;

import java.awt.*;
import javax.swing.*;

public class PainterPanel extends JPanel {

    /* ������ � ������ 1 ������ */
    private final int CELL_HEIGHT = 25;
    private final int CELL_WIDTH = 25;

    /* ����� �������� ������ */
    public void paint(Graphics graph) {
        if (Core.startGame) {
            for (int i = 0; i < Core.n; i++) {
                for (int j = 0; j < Core.m; j++) {
                    graph.setColor(Color.black);
                    graph.fillRect(CELL_WIDTH * j, CELL_HEIGHT * i, CELL_WIDTH, CELL_HEIGHT);
                }
            }
        }
    }
}
