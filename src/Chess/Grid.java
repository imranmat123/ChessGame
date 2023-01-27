package Chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Grid extends JFrame {
    public JLabel[][] getGrid() {
        return grid;
    }

    private JLabel[][] grid;


    public Grid() {
        setTitle("Chess Board");
        setSize(800,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8,8));

        grid = new JLabel[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = new JLabel();
                grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(grid[i][j]);
            }
        }
        Pawn pawn = new Pawn(grid);
        pawn.setPosition(2,6);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int col = e.getX() / 100;
                int row = e.getY() / 100;
                try {
                    pawn.setPosition(row, col);

                } catch (ArrayIndexOutOfBoundsException ae) {
                    //show error message or do something else
                }
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int col = e.getX() / 100;
                int row = e.getY() / 100;
                try {
                    pawn.setPosition(row, col);
                } catch (ArrayIndexOutOfBoundsException ae) {
                    //show error message or do something else
                }
            }
        });



        setVisible(true);
    }


}
