package ru.kpfu.npp.math;

/**
 * Created by Фирюза on 15.03.14.
 */
public class MatrixArrayImpl implements Matrix {

    private int [][] matrix;
    private static final int MAX_ROWS = 30;
    private static final int MAX_COLUMNS = 30;

    public MatrixArrayImpl() {
        this.matrix = new int[30][];
        for (int i = 0; i < MAX_ROWS; i++) {
            this.matrix[i] = new int[MAX_COLUMNS];
        }
    }
    public int getValue(int row, int column) {
        if ((row < MAX_ROWS) || (column < MAX_COLUMNS)) {
            return this.matrix[row][column];
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
    public void setValue(int row, int column, int value) {
        if ((row < MAX_ROWS) || (column < MAX_COLUMNS)) {
            this.matrix[row][column] = value;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
    @Override
    public String toString() {
        String str = new String();
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLUMNS; j++) {
                str += matrix[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }

}
