package tictactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/**
 * Created by Taryn on 1/11/14.
 */
public class AI {
    private AIPlayer currentPlayer;
    private static final int WIN = 1;
    private static final int LOSE = -1;
    private static final int TIE = 0;
    private static final int NEG_INF = -999;
    private static final int POS_INF = 999;

    public AI(AIPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getAIMove(Board board) {
        Board testBoard = new Board();
        testBoard.setCells(board.getCells());
        int cellIndex = getBestMove(testBoard);
        return cellIndex;
    }

    public int getBestMove(Board board) {
        HashMap<Integer, Integer> rankedMoves = rankPossibleMoves(board);
        int bestMove = 0;
        int bestScore = NEG_INF;
        for (Map.Entry<Integer, Integer> entry : rankedMoves.entrySet()) {
            int cellID = entry.getKey();
            int score = entry.getValue();
            if (score > bestScore) {
                bestScore = score;
                bestMove = cellID;
            }
        }
        return bestMove;
    }

    private HashMap<Integer, Integer> rankPossibleMoves(Board board) {
        HashMap rankedMoves = new HashMap<Integer, Integer>();
        ArrayList<Integer> openCellsList = board.availableCellIndexes();
        for(Iterator<Integer> i = openCellsList.iterator(); i.hasNext(); ) {
            int cellIndex = i.next();
            int score = getMoveScore(board, currentPlayer, cellIndex);
            rankedMoves.put(cellIndex, score);
        }
        return rankedMoves;
    }

    private int getMoveScore(Board board, Player player, int cellID) {
        int depth = 0;
        player.addMarker(board, cellID);
        int bestScore = applyMinimax(board, player, cellID, depth, NEG_INF, POS_INF);
        board.removeMarker(cellID);
        return bestScore;
    }

    private int getScore(Board board, Player player) {
        if (board.winningGame(player.getMarker())) {
            return WIN;
        } else if (board.winningGame(player.getOpponent().getMarker())) {
            return LOSE;
        }
        return TIE;
    }

    private int applyMinimax(Board board, Player player, int cell, int depth, int alpha, int beta) {
        while (!board.gameOver()) {
            if (player == currentPlayer) {
                MaximizingPlayer maxPlayer = new MaximizingPlayer(player);
                alphaBeta(board, maxPlayer, depth, alpha, beta);
            } else {
                MinimizingPlayer minPlayer = new MinimizingPlayer(player);
                alphaBeta(board, minPlayer, depth, alpha, beta);
            }
        }
        return getScore(board, player);
    }

    private int alphaBeta(Board board, AlphaBetaPlayer player, int depth, int alpha, int beta) {
        ArrayList<Integer> openCellsList = board.availableCellIndexes();
        for(Iterator<Integer> i = openCellsList.iterator(); i.hasNext(); ) {
            int cellIndex = i.next();
            player.getOpponent().addMarker(board, cellIndex);
            int score = (applyMinimax(board, player.getOpponent(), cellIndex, depth++, alpha, beta) / depth);
            alpha = player.getAlpha(alpha, score);
            beta = player.getBeta(beta, score);
            board.removeMarker(cellIndex);
        }
        return player.returnBestScore(alpha, beta);
    }

    private interface AlphaBetaPlayer {
        public Player getOpponent();
        public String getMarker();

        public int getAlpha(int alpha, int score);
        public int getBeta(int beta, int score);
        public int returnBestScore(int alpha, int beta);
    }

    private class MinimizingPlayer implements AlphaBetaPlayer {
        private String marker;
        private Player opponent;

        private MinimizingPlayer(Player player) {
            super();
            String marker = player.getMarker();
            Player opponent = player.getOpponent();
        }

        @Override
        public Player getOpponent() {
            return opponent;
        }

        @Override
        public String getMarker() {
            return marker;
        }

        @Override
        public int getAlpha(int alpha, int score) {
            if (score > alpha) {
                return score;
            } else {
                return alpha;
            }
        }

        @Override
        public int getBeta(int beta, int score) {
            return beta;
        }

        public int returnBestScore(int alpha, int beta) {
            return alpha;
        }

    }

    private class MaximizingPlayer implements AlphaBetaPlayer {
        private String marker;
        private Player opponent;

        private MaximizingPlayer(Player player) {
            super();
            String marker = player.getMarker();
            Player opponent = player.getOpponent();
        }

        @Override
        public Player getOpponent() {
            return opponent;
        }

        @Override
        public String getMarker() {
            return marker;
        }

        public int getBeta(int beta, int score) {
            if (score < beta) {
                return score;
            } else {
                return beta;
            }
        }

        public int getAlpha(int alpha, int score) {
            return alpha;
        }

        public int returnBestScore(int alpha, int beta) {
            return beta;
        }
    }

}
