package com.hellocodeclub.tictactoe;

public class GameResolver {

    public static GameState calculateGameState(int[][] board, Board.Cell position){

        int gamePiece = board[position.row][position.col];
        if (gamePiece == 0) return GameState.IN_PROGRESS;
        // DOWN DIRECTION
        boolean isCellOutOfBoard = (position.row-1 < 0);
        if (!isCellOutOfBoard && (board[position.row-1][position.col] == gamePiece)){
            isCellOutOfBoard = (position.row-2<0);
            if(!isCellOutOfBoard && (board[position.row-2][position.col] == gamePiece)){
                return gamePiece==1?GameState.X_WON:GameState.O_WON;
            }
        }
        // RIGHT UP DIRECTION
        isCellOutOfBoard = (position.row-1<0) || (position.col+1>board[0].length-1);
        if ( !isCellOutOfBoard && (board[position.row-1][position.col+1] == gamePiece)){
            isCellOutOfBoard = (position.row-2<0) || (position.col+2>board[0].length-1);
            if(!isCellOutOfBoard && (board[position.row-2][position.col+2] == gamePiece)){
                return gamePiece==1?GameState.X_WON:GameState.O_WON;
            }
        }

        // RIGHT DIRECTION
        isCellOutOfBoard = (position.col+1>board[0].length-1);
        if ( !isCellOutOfBoard && (board[position.row][position.col+1] == gamePiece)){
            isCellOutOfBoard = (position.col+2>board[0].length-1);
            if(!isCellOutOfBoard && (board[position.row][position.col+2] == gamePiece)){
                return gamePiece==1?GameState.X_WON:GameState.O_WON;
            }
        }

        // RIGHT DOWN DIRECTION
        isCellOutOfBoard =position.row+1>board.length-1 || (position.col+1>board[0].length-1);
        if ( !isCellOutOfBoard && (board[position.row+1][position.col+1] == gamePiece)){
            isCellOutOfBoard = position.row+2>board.length-1 || (position.col+2>board[0].length-1);
            if(!isCellOutOfBoard && (board[position.row+2][position.col+2] == gamePiece)){
                return gamePiece==1?GameState.X_WON:GameState.O_WON;
            }
        }

        // DOWN DIRECTION
        isCellOutOfBoard =position.row+1>board.length-1;
        if ( !isCellOutOfBoard && (board[position.row+1][position.col] == gamePiece)){
            isCellOutOfBoard = position.row+2>board.length-1;
            if(!isCellOutOfBoard && (board[position.row+2][position.col] == gamePiece)){
                return gamePiece==1?GameState.X_WON:GameState.O_WON;
            }
        }

        // LEFT DOWN DIRECTION
        isCellOutOfBoard =position.row+1>board.length-1 || (position.col-1<0);
        if ( !isCellOutOfBoard && (board[position.row+1][position.col] == gamePiece)){
            isCellOutOfBoard =position.row+2>board.length-1 || (position.col-2<0);
            if(!isCellOutOfBoard && (board[position.row+2][position.col-2] == gamePiece)){
                return gamePiece==1?GameState.X_WON:GameState.O_WON;
            }
        }

        // LEFT DIRECTION
        isCellOutOfBoard = (position.col-1<0);
        if ( !isCellOutOfBoard && (board[position.row][position.col-1] == gamePiece)){
            isCellOutOfBoard =(position.col-2<0);
            if(!isCellOutOfBoard && (board[position.row][position.col-2] == gamePiece)){
                return gamePiece==1?GameState.X_WON:GameState.O_WON;
            }
        }

        // LEFT UP DIRECTION
        isCellOutOfBoard = (position.row-1<0) || (position.col-1<0);
        if ( !isCellOutOfBoard && (board[position.row-1][position.col-1] == gamePiece)){
            isCellOutOfBoard = (position.row-2<0) || (position.col-2<0);
            if(!isCellOutOfBoard && (board[position.row-2][position.col-2] == gamePiece)){
                return gamePiece==1?GameState.X_WON:GameState.O_WON;
            }
        }

        return GameState.IN_PROGRESS;
    }

    public static GameState resolve(int[][] board) {
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                GameState gameState = calculateGameState(board,new Board.Cell(row,col));
                if(gameState!=GameState.IN_PROGRESS){
                    return gameState;
                }
            }
        }

        return GameState.IN_PROGRESS;
    }

    public enum GameState{
        IN_PROGRESS,X_WON,O_WON;
    }
}
