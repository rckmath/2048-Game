package com.engcomp2019.core;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author erick / rckmath
 */
public class Engine {

    private int[][] gameBoard; // Board do jogo
    private int boardSize; // Tamanho da board

    /**
     * Construtor inicializando nossa board
     *
     * @param bSizeOp Tamanho da board, 1 para 3x3 e qualquer para 4x4
     */
    public Engine(int bSizeOp) {
        if (bSizeOp == 1) {
            this.boardSize = 3;
            this.gameBoard = new int[3][3];
        } else {
            this.boardSize = 4;
            this.gameBoard = new int[4][4];
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
        int flag;
        int[] vetPos = new int[boardSize];  // Vetor utilizado para guardar posicoes
        int contVet;                    // que nao podem ser movidas novamente

        for (int i = 0; i < boardSize; i++) {
            contVet = 0;
            // Zerar o vetor de posicoes 
            for (int z = 0; z < boardSize; z++) {
                vetPos[z] = 0;
            }
            for (int v = 0; v < boardSize-1; v++) {
                for (int j = boardSize-1; j > 0; j--) {
                    flag = 0;

                    // Se for igual, soma/junta
                    if ((gameBoard[i][j]) == (gameBoard[i][j - 1])) {
                        for (int k = 0; k < boardSize; k++) {
                            if (vetPos[k] == j) {   // Verifica se ja foi feita uma soma
                                flag = 1;           // na mesma posicao
                            }
                        }
                        if (flag == 0) {
                            gameBoard[i][j] = (gameBoard[i][j]) * 2;	// Junta/soma
                            gameBoard[i][j - 1] = 0;	// Zera o outro
                            vetPos[contVet] = j;   // Guarda a posicao para nao juntar novamente
                            contVet++;
                        }
                    }

                    // Se for vazio, passa para a direita
                    if (((gameBoard[i][j]) == 0) && ((gameBoard[i][j - 1]) != 0)) {
                        gameBoard[i][j] = gameBoard[i][j - 1];  // Passa pro lado direito
                        gameBoard[i][j - 1] = 0;    // Zera o outro
                        // Setar valor no bloco grafico
                    }
                }
            }
        }
    }

    public void moveLeft() {
        int flag = 0;
        int[] vetPos = new int[boardSize];  // Vetor utilizado para guardar posicoes
        int contVet = 0;                    // que nao podem ser movidas novamente

        for (int i = 0; i < boardSize; i++) {
            contVet = 0;
            // Zerar o vetor de posicoes 
            for (int z = 0; z < boardSize; z++) {
                vetPos[z] = 0;
            }
            for (int v = 0; v < boardSize-1; v++) {
                for (int j = 0; j < boardSize-1; j++) {
                    flag = 0;

                    // Se for igual, soma/junta
                    if ((gameBoard[i][j]) == (gameBoard[i][j + 1])) {
                        for (int k = 0; k < boardSize; k++) {
                            if (vetPos[k] == j) {
                                flag = 1;
                            }
                        }
                        if (flag == 0) {
                            gameBoard[i][j] = (gameBoard[i][j]) * 2;    // Junta/soma
                            gameBoard[i][j + 1] = 0;    // Zera o outro
                            vetPos[contVet] = j;    // Guarda a posicao para nao juntar novamente
                            contVet++;
                        }
                    }

                    // Se for vazio, passa para a esquerda
                    if (((gameBoard[i][j]) == 0) && ((gameBoard[i][j + 1]) != 0)) {
                        gameBoard[i][j] = gameBoard[i][j + 1];  // Passa pro lado esquerdo
                        gameBoard[i][j + 1] = 0;    // Zera o outro
                        //  Setar valor no bloco grafico
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
                for (int i = 0; i < boardSize-1; i++) {
                    flag = 0;
                    // Se for igual, soma
                    if ((gameBoard[i][j]) == (gameBoard[i + 1][j])) {
                        if (flag0 == 1) {
                            flag = 1;
                        }
                        if (flag1 == 1) {   // Verifica se ja foi feita a soma
                            flag = 1;       // em alguma posicao repetida
                        }
                        if (flag2 == 1) {   
                            flag = 1;
                        }
                        if (flag3 == 1) {
                            flag = 1;
                        }

                        if (flag == 0) {
                            gameBoard[i][j] = (gameBoard[i][j]) * 2;	// Junta/soma
                            gameBoard[i + 1][j] = 0;	// Zera o outro
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
                    if (((gameBoard[i][j]) == 0) && ((gameBoard[i + 1][j]) != 0)) {
                        gameBoard[i][j] = gameBoard[i + 1][j];  // Passa pra cima
                        gameBoard[i + 1][j] = 0;    // Zera o outro
                    }
                }
            }
        }
    }

    public void moveDown() {
        int flag = 0, flag0 = 0, flag1 = 0, flag2 = 0, flag3 = 0;

        for (int j = 0; j < boardSize; j++) {
            // Zerar as flags
            flag0 = 0;  // Cada flag eh utilizada
            flag1 = 0;  // para verificar se ja¡ foi feita
            flag2 = 0;  // a juncao naquela posicao
            flag3 = 0;
            for (int v = 0; v < boardSize; v++) {
                for (int i = 0; i < boardSize-1; i++) {
                    flag = 0;
                    // Se for igual, soma
                    if ((gameBoard[i][j]) == (gameBoard[i + 1][j])) {
                        if (flag0 == 1) {
                            flag = 1;
                        }
                        if (flag1 == 1) {     // Verifica se ja foi feita a soma
                            flag = 1;         // em alguma posicao repetida
                        }
                        if (flag2 == 1) {
                            flag = 1;
                        }
                        if (flag3 == 1) {
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
}
