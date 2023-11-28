package tresenraya;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase TresEnRaya: Implementa el juego Tres en Raya con interfaz gráfica.
 *
 * <p>El juego se juega en un tablero de 3x3, donde dos jugadores (o un jugador contra la máquina)
 * alternan turnos para colocar sus símbolos ('X' o 'O') en el tablero. El objetivo es lograr que
 * tres de sus símbolos estén en línea horizontal, vertical o diagonal.</p>
 *
 * <p>La interfaz de usuario incluye botones para realizar acciones como reiniciar el juego, reiniciar
 * la puntuación, cambiar el modo de juego, guardar y cargar partidas, y mostrar un manual de usuario.</p>
 *
 * <p>En el modo de juego contra la máquina, la computadora utiliza un algoritmo Minimax para tomar
 * decisiones óptimas.</p>
 *
 * <p>El juego permite guardar y cargar partidas en tres slots diferentes. La puntuación acumulada de
 * los jugadores se muestra en la interfaz.</p>
 *
 * <p>La interfaz también incluye un manual de usuario que proporciona instrucciones sobre cómo jugar y
 * detalles sobre la interfaz del juego.</p>
 *
 * <p>Esta clase extiende JFrame y utiliza componentes Swing para la interfaz gráfica.</p>
 *
 * @author [JesGuiVil]
 * @version 1.0
 */

public class TresEnRaya extends JFrame {
	private JButton[][] buttons;
	private char[][] board;
	private char currentPlayer;
	private boolean gameOver;
	private int winsPlayer1;
	private int winsPlayer2;
	private int ties;
	private boolean contraMaquina;
	private JLabel scoreLabel;
	private static final String MANUAL_TEXT = "<html>" +
	        "<div style='font-weight: normal;'>" +
	        "<b>Cómo Jugar:</b><br>" +
	        "&nbsp;&nbsp;1. <b>Modo de Juego:</b><br>" +
	        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull; Al iniciar el juego, se te preguntará contra quién deseas jugar: \"Contra la Máquina\" o \"Contra otro Jugador\". Selecciona tu preferencia.<br>" +
	        "&nbsp;&nbsp;2. <b>Tablero de Juego:</b><br>" +
	        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull; El tablero consta de 3 filas y 3 columnas.<br>" +
	        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull; Cada celda del tablero es un botón que puedes pulsar para hacer tu movimiento.<br>" +
	        "&nbsp;&nbsp;3. <b>Hacer un Movimiento:</b><br>" +
	        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull; Haz clic en una celda vacía del tablero para realizar tu movimiento.<br>" +
	        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull; El jugador actual se indica en la parte superior de la ventana.<br>" +
	        "&nbsp;&nbsp;4. <b>Ganar el Juego:</b><br>" +
	        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull; Gana el jugador que consiga colocar tres de sus símbolos en línea horizontal, vertical o diagonal.<br>" +
	        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull; Si el tablero se llena sin que ningún jugador gane, la partida termina en empate.<br><br>" +

	        "<b>Interfaz del Juego:</b><br>" +
	        "&nbsp;&nbsp;1. <b>Botones:</b><br>" +
	        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull; Reiniciar: Reinicia el juego sin reiniciar la puntuación acumulada.<br>" +
	        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull; Reiniciar Puntuación: Reinicia la puntuación acumulada de los jugadores.<br>" +
	        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull; Cambiar Modo: Cambia entre jugar contra la máquina y jugar contra otro jugador.<br>" +
	        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull; Guardar Partida: Guarda la partida y el marcador actual en uno de los tres slots disponibles.<br>" +
	        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull; Cargar Partida: Carga una partida guardada y su marcador desde uno de los tres slots.<br>" +
	        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull; Ayuda: Muestra este manual de usuario.<br>" +
	        "&nbsp;&nbsp;2. <b>Etiqueta de Puntuación:</b><br>" +
	        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&bull; Muestra la puntuación acumulada. \"Jugador uno\" = jugador humano (X), \"Máquina\" = computadora (O), y \"Jugador dos\" = segundo jugador humano (O).<br><br>" +

	        "<b>Consejos:</b><br>" +
	        "&nbsp;&nbsp;&bull; En el modo de juego contra la máquina, la computadora utiliza una estrategia basada en el algoritmo Minimax para tomar decisiones óptimas.<br><br>" +

	        "¡Diviértete jugando al Tres en Raya y que gane el mejor estratega!" +
	        "</div></html>";




	private static final String SAVE_FILE_PREFIX = "savegame";
	private static final int NUM_SLOTS = 3;

	
	/**
	 * Constructor de la clase TresEnRaya. Inicializa los atributos y solicita al usuario
	 * que elija el modo de juego al inicio del programa.
	 */
	public TresEnRaya() {
		buttons = new JButton[3][3];
		board = new char[3][3];
		currentPlayer = 'X';
		gameOver = false;
		winsPlayer1 = 0;
		winsPlayer2 = 0;
		ties = 0;
		initializeGameModeDialog();
		initializeUI();
	}
	
	/**
	 * Muestra un mensaje para selecionar el modo de juego inicial.
	 */
	public void initializeGameModeDialog() {
		Object[] options = {"Contra la Máquina", "Contra otro Jugador"};
		int result = JOptionPane.showOptionDialog(
				this,
				"¿Contra quién deseas jugar?",
				"Seleccionar Modo de Juego",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[0]);

		contraMaquina = (result == JOptionPane.YES_OPTION);
		currentPlayer = 'X'; 
	}

	/**
	 * Inicializa la interfaz de usuario y establece la disposición de los componentes.
	 */
	public void initializeUI() {
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

		// Botón para reiniciar la puntuación
		JButton resetScoreButton = new JButton("Reiniciar Puntuación");
		resetScoreButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetScore();
				updateScoreLabel();
			}
		});
		JButton cambiarModoButton = new JButton();
		if(contraMaquina) {
			cambiarModoButton.setText("Jugar contra otro jugador");
		}else {
			cambiarModoButton.setText("Jugar contra la Máquina");
		}
		cambiarModoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(contraMaquina) {
					cambiarModoButton.setText("Jugar contra la Máquina");
					contraMaquina=false;
				}else {
					cambiarModoButton.setText("Jugar contra otro jugador");
					contraMaquina=true;
				}
				resetGame();
				resetScore();
				updateScoreLabel();
			}
		});
		JButton guardarPartidaButton = new JButton("Guardar partida");
		guardarPartidaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveGame();
			}
		});

		JButton cargarPartidaButton = new JButton("Cargar partida");
		cargarPartidaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadGame();
			}
		});
		JButton ayudaButton = new JButton("Ayuda");
		ayudaButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        mostrarManual();
		    }
		});



		scoreLabel = new JLabel("Puntuación: Jugador uno " + winsPlayer1 + " - Máquina " + winsPlayer2 + " - Empates " + ties);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(resetButton);
		buttonPanel.add(resetScoreButton);
		buttonPanel.add(cambiarModoButton);
		buttonPanel.add(guardarPartidaButton);
		buttonPanel.add(cargarPartidaButton);
		buttonPanel.add(ayudaButton);

		add(gamePanel, BorderLayout.CENTER);
		add(scoreLabel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);

		setSize(780, 580);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * Maneja el evento de clic en un botón del tablero. Realiza las acciones correspondientes
	 * según el estado actual del juego y el jugador que hizo clic.
	 *
	 * @param row Fila del botón clicado.
	 * @param col Columna del botón clicado.
	 */
	public void onButtonClick(int row, int col) {
		if (!gameOver && board[row][col] == '\0') {
			board[row][col] = currentPlayer;

			// Cambiar color del texto según el jugador
			if (currentPlayer == 'X') {
				buttons[row][col].setForeground(Color.GREEN);
			} else {
				buttons[row][col].setForeground(Color.RED);
			}

			buttons[row][col].setText(Character.toString(currentPlayer));

			if (checkWin(currentPlayer)) {
				updateScore(currentPlayer);
				JOptionPane.showMessageDialog(this, currentPlayer + " gana!");
				updateScoreLabel();
				gameOver = true;
			} else if (isBoardFull()) {
				ties++;
				JOptionPane.showMessageDialog(this, "Empate");
				updateScoreLabel();
				gameOver = true;
			} else {
				currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

				// Después del movimiento del jugador, permitir que la máquina juegue su turno
				if (contraMaquina && !gameOver && currentPlayer == 'O') {
					makeMove();
				}
			}
		}
	}
	
	/**
	 * Realiza el movimiento de la máquina en el tablero utilizando el algoritmo Minimax.
	 */
	public void makeMove() {
		// Estrategia de la máquina: utiliza el algoritmo Minimax para tomar la mejor decisión
		int[] bestMove = minimax(board, 'O');
		onButtonClick(bestMove[0], bestMove[1]);
	}
	/**
	 * Calcula y devuelve el mejor movimiento posible utilizando el algoritmo Minimax.
	 *
	 * @param board Estado actual del tablero.
	 * @param player Jugador para el cual se está calculando el movimiento.
	 * @return Arreglo con las coordenadas del mejor movimiento [fila, columna].
	 */
	public int[] minimax(char[][] board, char player) {
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
	/**
	 * Calcula y devuelve el puntaje asociado con el estado actual del tablero utilizando el
	 * algoritmo Minimax en un enfoque de búsqueda en profundidad.
	 *
	 * @param board Estado actual del tablero.
	 * @param depth Profundidad actual en el árbol de búsqueda.
	 * @param isMaximizing Indica si es el turno de maximizar o minimizar.
	 * @return Puntaje asociado con el estado del tablero.
	 */
	public int minimaxScore(char[][] board, int depth, boolean isMaximizing) {
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
	/**
	 * Verifica si hay un ganador en el tablero para el jugador dado.
	 *
	 * @param player Jugador para el cual se está verificando la victoria.
	 * @return true si el jugador ha ganado, false en caso contrario.
	 */
	public boolean checkWin(char player) {
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
	
	/**
	 * Verifica si el tablero está lleno, lo que indica un empate.
	 *
	 * @return true si el tablero está lleno, false en caso contrario.
	 */
	public boolean isBoardFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '\0') {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Actualiza la puntuación acumulada según el jugador que ganó la partida actual.
	 *
	 * @param player Jugador que ganó la partida.
	 */
	public void updateScore(char player) {
		if (player == 'X') {
			winsPlayer1++;
		} else if (player == 'O') {
			winsPlayer2++;
		}
	}

	/**
	 * Actualiza la etiqueta de puntuación en la interfaz gráfica con la puntuación acumulada.
	 */
	public void updateScoreLabel() {
		String player1Label = "Jugador uno";
		String player2Label = "";
		if(contraMaquina) {
			player2Label="Máquina";
		}else {
			player2Label="Jugador dos";
		}
		scoreLabel.setText("Puntuación: " + player1Label + " " + winsPlayer1 + " - " + player2Label + " " + winsPlayer2 + " - Empates " + ties);
	}

	/**
	 * Reinicia el estado del juego, el tablero y la configuración del jugador actual.
	 */
	public void resetGame() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j].setText("");
				board[i][j] = '\0';
			}
		}
		currentPlayer = 'X';
		gameOver = false;
	}
	/**
	 * Reinicia la puntuación acumulada de los jugadores.
	 */
	public void resetScore() {
		winsPlayer1 = 0;
		winsPlayer2 = 0;
		ties = 0;
	}
	
	/**
	 * Guarda la partida y el marcador actual en uno de los tres slots disponibles.
	 */
	public void saveGame() {
        try {
            String slotNumber = JOptionPane.showInputDialog("Selecciona el slot para guardar (1-" + NUM_SLOTS + "):");
            int slot = Integer.parseInt(slotNumber);

            if (slot < 1 || slot > NUM_SLOTS) {
                JOptionPane.showMessageDialog(this, "Número de slot no válido.");
                return;
            }

            String saveFileName = SAVE_FILE_PREFIX + slot + ".dat";
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFileName));

            // Guardar el estado del juego
            oos.writeObject(board);
            oos.writeChar(currentPlayer);
            oos.writeBoolean(gameOver);
            oos.writeInt(winsPlayer1);
            oos.writeInt(winsPlayer2);
            oos.writeInt(ties);
            oos.writeBoolean(contraMaquina);

            oos.close();

            JOptionPane.showMessageDialog(this, "Partida guardada en el slot " + slot);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar la partida.");
        }
    }

	/**
	 * Carga una partida guardada y su marcador desde uno de los tres slots y actualiza la interfaz gráfica.
	 */
	public void loadGame() {
        try {
            String slotNumber = JOptionPane.showInputDialog("Selecciona el slot para cargar (1-" + NUM_SLOTS + "):");
            int slot = Integer.parseInt(slotNumber);

            if (slot < 1 || slot > NUM_SLOTS) {
                JOptionPane.showMessageDialog(this, "Número de slot no válido.");
                return;
            }
            
            String saveFileName = SAVE_FILE_PREFIX + slot + ".dat";
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFileName));

            // Cargar el estado del juego
            resetGame();
            board = (char[][]) ois.readObject();
            currentPlayer = ois.readChar();
            gameOver = ois.readBoolean();
            winsPlayer1 = ois.readInt();
            winsPlayer2 = ois.readInt();
            ties = ois.readInt();
            contraMaquina = ois.readBoolean();

            ois.close();

            // Actualizar la interfaz gráfica
            updateGameBoard();
            updateScoreLabel();
            JOptionPane.showMessageDialog(this, "Partida cargada desde el slot " + slot);
        } catch (IOException | ClassNotFoundException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar la partida.");
        }
    }
	
	/**
	 * Actualiza el estado de los botones en el tablero según el estado actual del juego.
	 */
	public void updateGameBoard() {
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (board[i][j] == '\0') {
	                buttons[i][j].setText("");  // Establecer el texto como vacío para las casillas vacías
	            } else {
	                buttons[i][j].setText(Character.toString(board[i][j]));
	                if (board[i][j] == 'X') {
	                    buttons[i][j].setForeground(Color.GREEN);
	                } else if (board[i][j] == 'O') {
	                    buttons[i][j].setForeground(Color.RED);
	                }
	            }
	        }
	    }
	}
	
	/**
	 * Muestra un cuadro de diálogo con el manual de usuario para explicar las reglas del juego
	 * y la interfaz de usuario.
	 */
	public void mostrarManual() {
	    JOptionPane.showMessageDialog(this, MANUAL_TEXT, "Manual de Usuario", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Método principal que inicia la aplicación.
	 *
	 * @param args Argumentos de la línea de comandos (no se utilizan en este caso).
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TresEnRaya();
			}
		});
	}
}