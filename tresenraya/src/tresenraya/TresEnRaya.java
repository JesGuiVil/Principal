package tresenraya;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TresEnRaya extends JFrame {
    private JButton[][] buttons;
    private char[][] board;
    private char currentPlayer;
    private boolean gameOver;

    public TresEnRaya() {
    	
        buttons = new JButton[3][3];
        board = new char[3][3];
        currentPlayer = 'X';
        gameOver = false;
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tres en Raya");
        setLayout(new BorderLayout());

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].setFocusPainted(false);

                final int row = i;
                final int col = j;

                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        onButtonClick(row, col);
                    }
                });

                gamePanel.add(buttons[i][j]);
            }
        }

        JButton resetButton = new JButton("Reiniciar");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        add(gamePanel, BorderLayout.CENTER);
        add(resetButton, BorderLayout.SOUTH);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void onButtonClick(int row, int col) {
        if (!gameOver && board[row][col] == '\0') {
            board[row][col] = currentPlayer;
            buttons[row][col].setText(Character.toString(currentPlayer));

            if (checkWin(currentPlayer)) {
                JOptionPane.showMessageDialog(this, currentPlayer + " gana!");
                gameOver = true;
            } else if (isBoardFull()) {
                JOptionPane.showMessageDialog(this, "Empate");
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                if (currentPlayer == 'O') {
                    makeMove();
                }
            }
        }
    }

    private void makeMove() {
        // Estrategia de la máquina: utiliza el algoritmo Minimax para tomar la mejor decisión
        int[] bestMove = minimax(board, 'O');
        onButtonClick(bestMove[0], bestMove[1]);
    }

    private int[] minimax(char[][] board, char player) {
        int[] bestMove = new int[]{-1, -1};
        int bestScore = (player == 'O') ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    board[i][j] = player;
                    int score = minimaxScore(board, 0, false);
                    board[i][j] = '\0';

                    if ((player == 'O' && score > bestScore) || (player == 'X' && score < bestScore)) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }

        return bestMove;
    }

    private int minimaxScore(char[][] board, int depth, boolean isMaximizing) {
        if (checkWin('O')) {
            return 1;
        }
        if (checkWin('X')) {
            return -1;
        }
        if (isBoardFull()) {
            return 0;
        }

        char player = (isMaximizing) ? 'O' : 'X';
        int bestScore = (isMaximizing) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    board[i][j] = player;
                    int score = minimaxScore(board, depth + 1, !isMaximizing);
                    board[i][j] = '\0';

                    if ((isMaximizing && score > bestScore) || (!isMaximizing && score < bestScore)) {
                        bestScore = score;
                    }
                }
            }
        }

        return bestScore;
    }

    private boolean checkWin(char player) {
        // Verificar filas y columnas
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // Verificar diagonales
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                board[i][j] = '\0';
            }
        }
        currentPlayer = 'X';
        gameOver = false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TresEnRaya();
            }
        });
    }
}
