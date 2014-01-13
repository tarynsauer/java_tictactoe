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
        HashMap<Integer, Double> rankedMoves = rankPossibleMoves(board);
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

    private HashMap<Integer, Double> rankPossibleMoves(Board board) {
        HashMap rankedMoves = new HashMap<Integer, Double>();
        ArrayList<Integer> openCellsList = board.availableCellIndexes();
        for(int cellIndex : openCellsList) {
            double score = getMoveScore(board, currentPlayer, cellIndex);
            rankedMoves.put(cellIndex, score);
        }
//        System.out.println(rankedMoves);
        return rankedMoves;
    }

    private Double getMoveScore(Board board, Player player, int cellID) {
        double depth = 0.0;
        player.addTestMarker(board, cellID);
        double bestScore = applyMinimax(board, player, depth);
        board.removeMarker(cellID);
//        System.out.println(bestScore);
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

    private double applyMinimax(Board board, Player player, double depth) {
        if (board.gameOver()) {
            return getScore(board);
        }

        if (player.getMarker().equals(currentPlayer.getMarker())) {
            ArrayList<Double> minimaxScores = minimax(board, player, depth);
            double min = Collections.min(minimaxScores);
            return min;
        } else {
            ArrayList<Double> minimaxScores = minimax(board, player, depth);
            double max = Collections.max(minimaxScores);
            return max;
        }
    }

    private ArrayList<Double> minimax(Board board, Player player, double depth) {
        ArrayList<Double> bestScore = new ArrayList<Double>();
        ArrayList<Integer> openCells = board.availableCellIndexes();
        for (int cellIndex : openCells) {
            player.getOpponent().addTestMarker(board, cellIndex);
            double score = applyMinimax(board, player.getOpponent(), depth++) / depth;
            board.removeMarker(cellIndex);
            bestScore.add(score);
        }
        return bestScore;
    }

}
