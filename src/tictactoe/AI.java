package tictactoe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Taryn on 1/11/14.
 */
public class AI {
    private AIPlayer currentPlayer;
    private static final int WIN = 1;
    private static final int LOSE = -1;
    private static final int TIE = 0;
    private static final double NEG_INF = -999;
    private static final double POS_INF = 999;

    public AI(AIPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getAIMove(Board board) {
        Board testBoard = new Board(3);
        testBoard.setCells(board.getCells());
        return getBestMove(testBoard);
    }

    public int getBestMove(Board board) {
        Map<Integer, Double> rankedMoves = rankPossibleMoves(board);
        int bestMove = 0;
        double bestScore = NEG_INF;
        for (Map.Entry<Integer, Double> entry : rankedMoves.entrySet()) {
            int cellID = entry.getKey();
            double score = entry.getValue();
            if (score > bestScore) {
                bestScore = score;
                bestMove = cellID;
            }
        }
        return bestMove;
    }

    private Map<Integer, Double> rankPossibleMoves(Board board) {
        Map<Integer, Double> rankedMoves = new HashMap<Integer, Double>();
        ArrayList<Integer> openCellsList = board.availableCellIndexes();
        for(int cellIndex : openCellsList) {
            double score = getMoveScore(board, currentPlayer, cellIndex);
            rankedMoves.put(cellIndex, score);
        }
        return rankedMoves;
    }

    private Double getMoveScore(Board board, Player player, int cellID) {
        player.addTestMarker(board, cellID);
        double bestScore = applyMinimax(board, player, 0.0, NEG_INF, POS_INF);
        board.removeMarker(cellID);
        return bestScore;
    }

    private int getScore(Board board) {
        if (board.winningGame(currentPlayer.getMarker())) {
            return WIN;
        } else if (board.winningGame(currentPlayer.getOpponent().getMarker())) {
            return LOSE;
        }
        return TIE;
    }

    private double alphabeta(Board board, AbstractAlphaBeta player, double depth, double alpha, double beta) {
        ArrayList<Integer> openCells = board.availableCellIndexes();
        for (int cellIndex : openCells) {
            player.getOpponent().addTestMarker(board, cellIndex);
            double score = applyMinimax(board, player.getOpponent(), depth++, alpha, beta) / depth;
            alpha = player.getAlpha(alpha, score);
            beta = player.getBeta(beta, score);
            board.removeMarker(cellIndex);
            if (alpha >= beta) {
                return player.returnBestScore(alpha, beta);
            }

        }
        return player.returnBestScore(alpha, beta);
    }

    private double applyMinimax(Board board, Player player, double depth, double alpha, double beta) {
        while (!board.gameOver()) {

            if (player.getMarker().equals(currentPlayer.getMarker())) {
                MaximizingPlayer maxPlayer = new MaximizingPlayer(player);
                return alphabeta(board, maxPlayer, depth, alpha, beta);
            } else {
                MinimizingPlayer minPlayer = new MinimizingPlayer(player);
                return alphabeta(board, minPlayer, depth, alpha, beta);
            }
        }
        return getScore(board);
    }

}
