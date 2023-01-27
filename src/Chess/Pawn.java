package Chess;

import javax.swing.*;
import java.awt.*;
public class Pawn extends JFrame {
    private JLabel[][] grid;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    private int row;
    private int col;
    private ImageIcon icon;

    int[] position = getPosition();


    public Pawn(JLabel[][] grid) {
        this.grid = grid;
        ImageIcon rawIcon = new ImageIcon(getClass().getResource("/chess/whitePawn.jpg"));
        Image image = rawIcon.getImage();
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
    }

    public void setPosition(int row, int col) {
        if (row < 0 || row >= 8 || col < 0 || col>= 8) {
            throw new IllegalArgumentException("Invalid position, x and y must be between 0 and 7.");
        }
        // Remove the image from the last position of the pawn
        grid[this.row][this.col].setIcon(null);
        this.row = row;
        this.col = col;
        grid[row][col].setIcon(icon);
        grid[row][col].setHorizontalAlignment(JLabel.CENTER);
        grid[row][col].setVerticalAlignment(JLabel.CENTER);
    }
    public int[] getPosition(){
        int[] position = {row,col};
        return position;
    }

}
