package tictactoe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static tictactoe.TictactoeConstants.O_MARKER;
import static tictactoe.TictactoeConstants.X_MARKER;

/**
 * Created by Taryn on 1/11/14.
 */
public class AI {
    private String currentPlayer;
    private static final int WIN = 1;
    private static final int LOSE = -1;
    private static final int TIE = 0;
    private static final double NEG_INF = -999;
    private static final double POS_INF = 999;

    public AI(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getAIMove(Board board) {
        Board testBoard = new Board(board.getRows());
        testBoard.setCells(board.getCells());
        return getBestMove(testBoard);
    }

    public int getBestMove(Board board) {
        Map<Integer, Double> rankedMoves = rankPossibleMoves(board);
        int bestMove = 0;
        double bestScore = NEG_INF;
        for (Map.Entry<Integer, Double> cell : rankedMoves.entrySet()) {
            int cellID = cell.getKey();
            double score = cell.getValue();
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

    private Double getMoveScore(Board board, String playerMarker, int cellID) {
        addPlayerMarker(board, cellID);
        double bestScore = applyMinimax(board, playerMarker, 0, NEG_INF, POS_INF);
        board.removeMarker(cellID);
        return bestScore;
    }

    private int getScore(Board board) {
        if (board.winningGame(currentPlayer)) {
            return WIN;
        } else if (board.winningGame(opponent(currentPlayer))) {
            return LOSE;
        }
        return TIE;
    }

    private double applyMinimax(Board board, String playerMarker, double depth, double alpha, double beta) {
        while (!board.gameOver() && (depth < maxDepth(board))) {
            if (playerMarker.equals(currentPlayer)) {
                MaximizingScore maxScore = new MaximizingScore(playerMarker);
                return alphabeta(board, maxScore, depth, alpha, beta);
            } else {
                MinimizingScore minScore = new MinimizingScore(playerMarker);
                return alphabeta(board, minScore, depth, alpha, beta);
            }
        }
        return getScore(board);
    }

    private double alphabeta(Board board, AlphaBeta alphaBeta, double depth, double alpha, double beta) {
        ArrayList<Integer> openCells = board.availableCellIndexes();

        for (int cellIndex : openCells) {
            alphaBeta.addOpponentMarker(board, cellIndex);
            double score = applyMinimax(board, alphaBeta.getOpponentMarker(), depth++, alpha, beta) / depth;
            alpha = alphaBeta.getAlpha(alpha, score);
            beta = alphaBeta.getBeta(beta, score);
            board.removeMarker(cellIndex);
            if (alpha >= beta) {
                return alphaBeta.returnBestScore(alpha, beta);
            }
        }

        return alphaBeta.returnBestScore(alpha, beta);
    }

    private void addPlayerMarker(Board board, int cellIndex) {
        board.getCells()[cellIndex] = currentPlayer;
    }

    private String opponent(String marker) {
        if (marker.equals(X_MARKER)) {
            return O_MARKER;
        } else {
            return X_MARKER;
        }
    }

    private int maxDepth(Board board) {
        return 10 - board.getRows();
    }

}