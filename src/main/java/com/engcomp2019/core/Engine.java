package com.engcomp2019.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author erick / rckmath
 */
public abstract class Engine {

    private int[][] gameBoard; // Board do jogo
    private int boardSize; // Tamanho da board
    private ImageIcon imgTileDef;
    private final HashMap<Integer, ImageIcon> imgTiles = new HashMap<>();

    /**
     * Construtor inicializando nossa board
     *
     * @param bSizeOp Tamanho da board, 1 para 3x3 e qualquer para 4x4
     */
    public Engine(int bSizeOp) {
        // Define o tamanho da gameBoard
        if (bSizeOp == 1) {
            this.boardSize = 3;
            this.gameBoard = new int[3][3];
        } else {
            this.boardSize = 4;
            this.gameBoard = new int[4][4];
        }
        Integer tileNum = 2;
        for (int i = 0; i < 11; i++) {
            imgTiles.put(tileNum, new ImageIcon("imgs/tiles/gifs/" + tileNum + ".gif"));
            tileNum *= 2;
        }
    }

    /* METODOS */
    // Getters and setters
    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(int[][] board) {
        this.gameBoard = board;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public ImageIcon getImgTileDef() {
        return imgTileDef;
    }

    public void setImgTileDef(ImageIcon imgTileDef) {
        this.imgTileDef = imgTileDef;
    }

    // Outros
    // Printa a matriz (para fins de debug)
    public void printGameBoard() {
        for (int[] b : gameBoard) {
            System.out.println(Arrays.toString(b));
        }
        System.out.println();
    }

    // Gera um numero numa tile livre aleatoria
    public void tileSpawn() {
        ArrayList<int[]> emptySpaces = new ArrayList<>();
        try {
            // Percorrendo nossa matriz e guardando a posicao dos espacos em branco
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    if (gameBoard[i][j] == 0) {
                        int[] pos = {i, j};
                        emptySpaces.add(pos);
                    }
                }
            }
            // Se houver espacos vazios, prossegue com a geracao
            if (!emptySpaces.isEmpty()) {
                // Gerando prox. numero a spawnar
                int x = (int) (Math.random() * ((10 - 0) + 1));
                if (x < 2) {
                    x = 4;
                } else {
                    x = 2;
                }
                // Sorteando indice onde o numero gerado sera posto
                int index;
                index = (int) (Math.random() * ((emptySpaces.size() - 0)));
                int[] pos = emptySpaces.get(index);
                gameBoard[pos[0]][pos[1]] = x;
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
        }
    }

    // Funcoes de movimentos
    public void moveRight() {
        int flag = 0, flag0 = 0, flag1 = 0, flag2 = 0, flag3 = 0;

        for (int i = 0; i < boardSize; i++) {
            // Zerar as flags
            flag0 = 0;  // Cada flag eh utilizada
            flag1 = 0;  // para verificar se ja¡ foi feita
            flag2 = 0;  // a juncao naquela posicao
            flag3 = 0;
            for (int v = 0; v < boardSize - 1; v++) {

                for (int j = boardSize - 1; j > 0; j--) {
                    flag = 0;
                    // Se for igual, soma

                    if ((gameBoard[i][j]) == (gameBoard[i][j - 1])) {
                        if (j == 0 && flag0 == 1) {
                            flag = 1;
                        }
                        if (j == 1 && flag1 == 1) {     // Verifica se ja foi feita a soma
                            flag = 1;                   // em alguma posicao repetida
                        }
                        if (j == 2 && flag2 == 1) {
                            flag = 1;
                        }
                        if (j == 3 && flag3 == 1) {
                            flag = 1;
                        }

                        if (flag == 0) {

                            gameBoard[i][j] = (gameBoard[i][j]) * 2;	// Junta/soma
                            gameBoard[i][j - 1] = 0;	// Zera o outro
                            /* Ve em qual posicao ja foi feita uma juncao
                            para nao repeti-la novamente */
                            if (j == 0) {
                                flag0 = 1;
                            }
                            if (j == 1) {
                                flag1 = 1;
                            }
                            if (j == 2) {
                                flag2 = 1;
                            }
                            if (j == 3) {
                                flag3 = 1;
                            }
                        }
                    }

                    // Se for vazio, passa para cima
                    if (((gameBoard[i][j]) == 0) && ((gameBoard[i][j - 1]) != 0)) {
                        gameBoard[i][j] = gameBoard[i][j - 1];  // Passa pra cima
                        gameBoard[i][j - 1] = 0;    // Zera o outro
                    }
                }
            }
        }
    }

    public void moveLeft() {
        int flag = 0, flag0 = 0, flag1 = 0, flag2 = 0, flag3 = 0;

        for (int i = 0; i < boardSize; i++) {
            // Zerar as flags
            flag0 = 0;  // Cada flag eh utilizada
            flag1 = 0;  // para verificar se ja¡ foi feita
            flag2 = 0;  // a juncao naquela posicao
            flag3 = 0;
            for (int v = 0; v < boardSize - 1; v++) {

                for (int j = 0; j < boardSize - 1; j++) {
                    flag = 0;
                    // Se for igual, soma

                    if ((gameBoard[i][j]) == (gameBoard[i][j + 1])) {
                        if (j == 0 && flag0 == 1) {
                            flag = 1;
                        }
                        if (j == 1 && flag1 == 1) {     // Verifica se ja foi feita a soma
                            flag = 1;                   // em alguma posicao repetida
                        }
                        if (j == 2 && flag2 == 1) {
                            flag = 1;
                        }
                        if (j == 3 && flag3 == 1) {
                            flag = 1;
                        }

                        if (flag == 0) {

                            gameBoard[i][j] = (gameBoard[i][j]) * 2;	// Junta/soma
                            gameBoard[i][j + 1] = 0;	// Zera o outro
                            /* Ve em qual posicao ja foi feita uma juncao
                            para nao repeti-la novamente */
                            if (j == 0) {
                                flag0 = 1;
                            }
                            if (j == 1) {
                                flag1 = 1;
                            }
                            if (j == 2) {
                                flag2 = 1;
                            }
                            if (j == 3) {
                                flag3 = 1;
                            }
                        }
                    }

                    // Se for vazio, passa para cima
                    if (((gameBoard[i][j]) == 0) && ((gameBoard[i][j + 1]) != 0)) {
                        gameBoard[i][j] = gameBoard[i][j + 1];  // Passa pra cima
                        gameBoard[i][j + 1] = 0;    // Zera o outro
                    }
                }
            }
        }
    }

    public void moveUp() {
        int flag = 0, flag0 = 0, flag1 = 0, flag2 = 0, flag3 = 0;

        for (int j = 0; j < boardSize; j++) {
            // Zerar as flags
            flag0 = 0;  // Cada flag eh utilizada
            flag1 = 0;  // para verificar se ja¡ foi feita
            flag2 = 0;  // a juncao naquela posicao
            flag3 = 0;
            for (int v = 0; v < boardSize; v++) {

                for (int i = boardSize - 1; i > 0; i--) {
                    flag = 0;
                    // Se for igual, soma

                    if ((gameBoard[i][j]) == (gameBoard[i - 1][j])) {
                        if (i == 0 && flag0 == 1) {
                            flag = 1;
                        }
                        if (i == 1 && flag1 == 1) {     // Verifica se ja foi feita a soma
                            flag = 1;                    // em alguma posicao repetida
                        }
                        if (i == 2 && flag2 == 1) {
                            flag = 1;
                        }
                        if (i == 3 && flag3 == 1) {
                            flag = 1;
                        }

                        if (flag == 0) {

                            gameBoard[i - 1][j] = (gameBoard[i - 1][j]) * 2;	// Junta/soma
                            gameBoard[i][j] = 0;	// Zera o outro
                            /* Ve em qual posicao ja foi feita uma juncao
                            para nao repeti-la novamente */
                            if (i == 0) {
                                flag0 = 1;
                            }
                            if (i == 1) {
                                flag1 = 1;
                            }
                            if (i == 2) {
                                flag2 = 1;
                            }
                            if (i == 3) {
                                flag3 = 1;
                            }
                        }
                    }

                    // Se for vazio, passa para cima
                    if (((gameBoard[i - 1][j]) == 0) && ((gameBoard[i][j]) != 0)) {
                        gameBoard[i - 1][j] = gameBoard[i][j];  // Passa pra cima
                        gameBoard[i][j] = 0;    // Zera o outro
                    }
                }
            }
        }
    }

    public void moveDown() {
        int flag = 0, flag0 = 0, flag1 = 0, flag2 = 0, flag3 = 0;

        for (int j = 0; j < boardSize; j++) {
            // Zerar as flags
            flag = 0;
            flag0 = 0;  // Cada flag eh utilizada
            flag1 = 0;  // para verificar se ja¡ foi feita
            flag2 = 0;  // a juncao naquela posicao
            flag3 = 0;
            for (int v = 0; v < boardSize; v++) {
                flag = 0;
                for (int i = 0; i < boardSize - 1; i++) {
                    flag = 0;
                    // Se for igual, soma

                    if ((gameBoard[i][j]) == (gameBoard[i + 1][j])) {
                        if (i == 0 && flag0 == 1) {
                        }
                        if (i == 2 &&flag2 == 1) {
                            flag = 1;
                        }
                        if (i == 3 && flag3 == 1) {
                            flag = 1;
                        }

                        if (flag == 0) {
           
                            gameBoard[i+1][j] = (gameBoard[i+1][j]) * 2;    // Junta/soma
                            gameBoard[i][j] = 0;    // Zera o outro
                            flag = 1;
                        }
                        if (i == 1 && flag1 == 1) {     // Verifica se ja foi feita a soma
                            flag = 1;                   // em alguma posicao repetida
                        }
                        if (i == 2 && flag2 == 1) {
                            flag = 1;
                        }
                        if (i == 3 && flag3 == 1) {
                            flag = 1;
                        }

                        if (flag == 0) {

                            gameBoard[i + 1][j] = (gameBoard[i + 1][j]) * 2;    // Junta/soma
                            gameBoard[i][j] = 0;    // Zera o outro
                            /* Salva em qual posicao ja¡ foi feita uma juncao
                            para nao repeti-la novamente */
                            if (i == 0) {
                                flag0 = 1;
                            }
                            if (i == 1) {
                                flag1 = 1;
                            }
                            if (i == 2) {
                                flag2 = 1;
                            }
                            if (i == 3) {
                                flag3 = 1;
                            }
                        }
                    }

                    // Se for vazio, passa pra baixo
                    if (((gameBoard[i + 1][j]) == 0) && ((gameBoard[i][j]) != 0)) {
                        gameBoard[i + 1][j] = gameBoard[i][j];  // Passa pra baixo
                        gameBoard[i][j] = 0;    // Zera o outro
                    }
                }
            }
        }
    }

    public ImageIcon getTileImg(int i, int j) {
        int val = getGameBoardValue(i, j);

        if (val == 0) {
            return imgTileDef;
        } else {
            imgTiles.get(val).getImage().flush();
            return imgTiles.get(val);
        }
    }

    public abstract int getGameBoardValue(int i, int j);

    public abstract void restart(JFrame pPreviousFrame);
}
