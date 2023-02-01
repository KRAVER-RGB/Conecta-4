package com.example.conecta4;

public class MoveProvider {

    private Board boardInstance;
    private WinnerData winnerData;

    private int cord1X4Winner = 0;
    private int cord1y4Winner = 0;
    private int cord2X4Winner = 0;
    private int cord2y4Winner = 0;
    private int cord3X4Winner = 0;
    private int cord3y4Winner = 0;
    private int cord4X4Winner = 0;
    private int cord4y4Winner = 0;

    MoveProvider(Board boardInstance){
        this.boardInstance = boardInstance;
        fillBoardByFirst();
    }

    private void fillBoardByFirst(){
        for (int i = 0; i< 7 ; i++){
            for (int j = 0; j<6; j++){
                boardInstance.getTableBoard()[i][j] = TokenTypes.NEUTRAL;
            }
        }
    }

    public Move generateMove(Move moveParameters){
        Move newMove = new Move();
        int cordYNewMove = getCordYForNewMove(moveParameters.getCordX());
        TokenTypes actualTokenType = boardInstance.getTableBoard()[moveParameters.getCordX()][cordYNewMove];
        if (actualTokenType != TokenTypes.NEUTRAL || cordYNewMove == -1) {
            newMove.setAnImpossibleMove(true);
        } else {
            boardInstance.getTableBoard()[moveParameters.getCordX()][cordYNewMove] = moveParameters.getPlayer().getTokenType();
            newMove = new Move(moveParameters.getCordX(),cordYNewMove,moveParameters.getPlayer());
            newMove.setAnImpossibleMove(false);
            if (isAWinner(moveParameters.getCordX(), cordYNewMove, moveParameters.getPlayer().getTokenType())){
                newMove.setAWinner(true);
                winnerData = new WinnerData(
                        cord1X4Winner,
                        cord1y4Winner,
                        cord2X4Winner,
                        cord2y4Winner,
                        cord3X4Winner,
                        cord3y4Winner,
                        cord4X4Winner,
                        cord4y4Winner
                );
                newMove.setWinnerData(winnerData);
            }
        }
        return newMove;
    }

    private int getCordYForNewMove(int cordX){
        int cordY = -1;
        for (int y = 0; y<6; y++){
            if (boardInstance.getTableBoard()[cordX][y] == TokenTypes.NEUTRAL){
                cordY = y;
                break;
            }
        }
        return cordY;
    }

    private boolean isAWinner(int cordX, int cordY, TokenTypes playerTokenType){
        return isHorizontalWin(cordX,cordY,playerTokenType) || isVerticalWin(cordX,cordY,playerTokenType) || isDiagonallLeftWin(cordX,cordY,playerTokenType)
                || isDiagonalRightWin(cordX,cordY,playerTokenType);

    }

    private boolean isRightWin(int cordX, int cordY, TokenTypes playerTokenType){
        boolean win = false;
        int numberOfEvaluations = evaluateRightWin(cordX, cordY, playerTokenType, 0);
        if (numberOfEvaluations == 3){
            win = true;
            cord1X4Winner = cordX;
            cord1y4Winner = cordY;
            cord2X4Winner = cordX + 1;
            cord2y4Winner = cordY;
            cord3X4Winner = cordX + 2;
            cord3y4Winner = cordY;
            cord4X4Winner = cordX + 3;
            cord4y4Winner = cordY;
        }
        return win;
    }

    private boolean isLeftWin(int cordX, int cordY, TokenTypes playerTokenType){
        boolean win = false;
        int numberOfEvaluations = evaluateLeftWin(cordX, cordY, playerTokenType, 0);
        if (numberOfEvaluations == 3){
            win = true;
            cord1X4Winner = cordX;
            cord1y4Winner = cordY;
            cord2X4Winner = cordX - 1;
            cord2y4Winner = cordY;
            cord3X4Winner = cordX - 2;
            cord3y4Winner = cordY;
            cord4X4Winner = cordX - 3;
            cord4y4Winner = cordY;
        }
        return win;
    }

    private boolean isTopWin(int cordX, int cordY, TokenTypes playerTokenType){
        boolean win = false;
        int numberOfEvaluations = evaluateTopWin(cordX, cordY, playerTokenType, 0);
        if (numberOfEvaluations == 3){
            win = true;
            cord1X4Winner = cordX;
            cord1y4Winner = cordY;
            cord2X4Winner = cordX;
            cord2y4Winner = cordY + 1;
            cord3X4Winner = cordX;
            cord3y4Winner = cordY + 2;
            cord4X4Winner = cordX;
            cord4y4Winner = cordY + 3;
        }
        return win;
    }

    private boolean isBottomWin(int cordX, int cordY, TokenTypes playerTokenType){
        boolean win = false;
        int numberOfEvaluations = evaluateBottomWin(cordX, cordY, playerTokenType, 0);
        if (numberOfEvaluations == 3){
            win = true;
            cord1X4Winner = cordX;
            cord1y4Winner = cordY;
            cord2X4Winner = cordX;
            cord2y4Winner = cordY - 1;
            cord3X4Winner = cordX;
            cord3y4Winner = cordY - 2;
            cord4X4Winner = cordX;
            cord4y4Winner = cordY - 3;
        }
        return win;
    }

    private boolean isTopRightWin(int cordX, int cordY, TokenTypes playerTokenType){
        boolean win = false;
        int numberOfEvaluations = evaluateRightTopWin(cordX, cordY, playerTokenType, 0);
        if (numberOfEvaluations == 3){
            win = true;
            cord1X4Winner = cordX;
            cord1y4Winner = cordY;
            cord2X4Winner = cordX + 1;
            cord2y4Winner = cordY + 1;
            cord3X4Winner = cordX + 2;
            cord3y4Winner = cordY + 2;
            cord4X4Winner = cordX + 3;
            cord4y4Winner = cordY + 3;
        }
        return win;
    }

    private boolean isTopLeftWin(int cordX, int cordY, TokenTypes playerTokenType){
        boolean win = false;
        int numberOfEvaluations = evaluateLeftTopWin(cordX, cordY, playerTokenType, 0);
        if (numberOfEvaluations == 3){
            win = true;
            cord1X4Winner = cordX;
            cord1y4Winner = cordY;
            cord2X4Winner = cordX - 1;
            cord2y4Winner = cordY + 1;
            cord3X4Winner = cordX - 2;
            cord3y4Winner = cordY + 2;
            cord4X4Winner = cordX - 3;
            cord4y4Winner = cordY + 3;
        }
        return win;
    }

    private boolean isBottomRightWin(int cordX, int cordY, TokenTypes playerTokenType){
        boolean win = false;
        int numberOfEvaluations = evaluateRightBottomWin(cordX, cordY, playerTokenType, 0);
        if (numberOfEvaluations == 3){
            win = true;
            cord1X4Winner = cordX;
            cord1y4Winner = cordY;
            cord2X4Winner = cordX + 1;
            cord2y4Winner = cordY - 1;
            cord3X4Winner = cordX + 2;
            cord3y4Winner = cordY - 2;
            cord4X4Winner = cordX + 3;
            cord4y4Winner = cordY - 3;
        }
        return win;
    }

    private boolean isBottomLeftWin(int cordX, int cordY, TokenTypes playerTokenType){
        boolean win = false;
        int numberOfEvaluations = evaluateLeftBottomWin(cordX, cordY, playerTokenType, 0);
        if (numberOfEvaluations == 3){
            win = true;
            cord1X4Winner = cordX;
            cord1y4Winner = cordY;
            cord2X4Winner = cordX - 1;
            cord2y4Winner = cordY - 1;
            cord3X4Winner = cordX - 2;
            cord3y4Winner = cordY - 2;
            cord4X4Winner = cordX - 3;
            cord4y4Winner = cordY - 3;
        }
        return win;
    }


    private boolean isHorizontalWin(int cordX, int cordY, TokenTypes playerTokenType){
        int horizontalRightEvaluations = evaluateRightWin(cordX,cordY,playerTokenType,0);
        int horizontalLeftEvaluations = evaluateLeftWin(cordX,cordY,playerTokenType,0);
        switch (horizontalRightEvaluations){
            case 0:
                if (horizontalLeftEvaluations == 3){
                    cord1X4Winner = cordX;
                    cord1y4Winner = cordY;
                    cord2X4Winner = cordX - 1;
                    cord2y4Winner = cordY;
                    cord3X4Winner = cordX - 2;
                    cord3y4Winner = cordY;
                    cord4X4Winner = cordX - 3;
                    cord4y4Winner = cordY;
                    return true;
                }
                break;

            case 1:
                if (horizontalLeftEvaluations >= 2){
                    cord1X4Winner = cordX;
                    cord1y4Winner = cordY;
                    cord2X4Winner = cordX + 1;
                    cord2y4Winner = cordY;
                    cord3X4Winner = cordX - 1;
                    cord3y4Winner = cordY;
                    cord4X4Winner = cordX - 2;
                    cord4y4Winner = cordY;
                    return true;
                }
                break;

            case 2:

                if (horizontalLeftEvaluations >= 1){
                    cord1X4Winner = cordX;
                    cord1y4Winner = cordY;
                    cord2X4Winner = cordX + 1;
                    cord2y4Winner = cordY;
                    cord3X4Winner = cordX + 2;
                    cord3y4Winner = cordY;
                    cord4X4Winner = cordX - 1;
                    cord4y4Winner = cordY;
                    return true;
                }

                break;

            case 3:

                cord1X4Winner = cordX;
                cord1y4Winner = cordY;
                cord2X4Winner = cordX + 1;
                cord2y4Winner = cordY;
                cord3X4Winner = cordX + 2;
                cord3y4Winner = cordY;
                cord4X4Winner = cordX + 3;
                cord4y4Winner = cordY;
                return true;

            default:
                break;
        }
        return false;
    }

    private boolean isVerticalWin(int cordX, int cordY, TokenTypes playerTokenType){
        int topEvaluations = evaluateTopWin(cordX,cordY,playerTokenType,0);
        int bottomEvaluations = evaluateBottomWin(cordX,cordY,playerTokenType,0);

        switch (topEvaluations) {

            case 0:

                if (bottomEvaluations == 3) {
                    cord1X4Winner = cordX;
                    cord1y4Winner = cordY;
                    cord2X4Winner = cordX;
                    cord2y4Winner = cordY - 1;
                    cord3X4Winner = cordX;
                    cord3y4Winner = cordY - 2;
                    cord4X4Winner = cordX;
                    cord4y4Winner = cordY - 3;
                    return true;
                }

                break;

            case 1:

                if (bottomEvaluations >= 2){
                    cord1X4Winner = cordX;
                    cord1y4Winner = cordY;
                    cord2X4Winner = cordX;
                    cord2y4Winner = cordY + 1;
                    cord3X4Winner = cordX;
                    cord3y4Winner = cordY - 1;
                    cord4X4Winner = cordX;
                    cord4y4Winner = cordY - 2;
                    return true;
                }

                break;

            case 2:

                if (bottomEvaluations >= 1){
                    cord1X4Winner = cordX;
                    cord1y4Winner = cordY;
                    cord2X4Winner = cordX;
                    cord2y4Winner = cordY + 1;
                    cord3X4Winner = cordX;
                    cord3y4Winner = cordY + 2;
                    cord4X4Winner = cordX;
                    cord4y4Winner = cordY - 1;
                    return true;
                }

                break;

            case 3:

                cord1X4Winner = cordX;
                cord1y4Winner = cordY;
                cord2X4Winner = cordX;
                cord2y4Winner = cordY + 1;
                cord3X4Winner = cordX;
                cord3y4Winner = cordY + 2;
                cord4X4Winner = cordX;
                cord4y4Winner = cordY + 3;
                return true;

            default:
                break;
        }
        return false;
    }

    private boolean isDiagonalRightWin(int cordX, int cordY, TokenTypes playerTokenType){

        int evaluateRightTopWin = evaluateRightTopWin(cordX,cordY,playerTokenType,0);
        int evaluateLeftBottom = evaluateLeftBottomWin(cordX,cordY,playerTokenType,0);

        switch (evaluateRightTopWin){

            case 0:

                if (evaluateLeftBottom == 3) {
                    cord1X4Winner = cordX;
                    cord1y4Winner = cordY;
                    cord2X4Winner = cordX - 1;
                    cord2y4Winner = cordY - 1;
                    cord3X4Winner = cordX - 2;
                    cord3y4Winner = cordY - 2;
                    cord4X4Winner = cordX - 3;
                    cord4y4Winner = cordY - 3;
                    return true;
                }

                break;

            case 1:


                if (evaluateLeftBottom >= 2) {
                    cord1X4Winner = cordX;
                    cord1y4Winner = cordY;
                    cord2X4Winner = cordX + 1;
                    cord2y4Winner = cordY + 1;
                    cord3X4Winner = cordX - 1;
                    cord3y4Winner = cordY - 1;
                    cord4X4Winner = cordX - 2;
                    cord4y4Winner = cordY - 2;
                    return true;
                }

                break;

            case 2:


                if (evaluateLeftBottom >= 1) {
                    cord1X4Winner = cordX;
                    cord1y4Winner = cordY;
                    cord2X4Winner = cordX + 1;
                    cord2y4Winner = cordY + 1;
                    cord3X4Winner = cordX + 2;
                    cord3y4Winner = cordY + 2;
                    cord4X4Winner = cordX - 1;
                    cord4y4Winner = cordY - 1;
                    return true;
                }

                break;

            case 3:

                cord1X4Winner = cordX;
                cord1y4Winner = cordY;
                cord2X4Winner = cordX + 1;
                cord2y4Winner = cordY + 1;
                cord3X4Winner = cordX + 2;
                cord3y4Winner = cordY + 2;
                cord4X4Winner = cordX + 3;
                cord4y4Winner = cordY + 3;
                return true;


            default:

                break;
        }


        return false;
    }

    private boolean isDiagonallLeftWin(int cordX, int cordY, TokenTypes playerTokenType){

        int evaluateLeftTopWin = evaluateLeftTopWin(cordX,cordY,playerTokenType,0);
        int evaluateRightBottom = evaluateRightBottomWin(cordX,cordY,playerTokenType,0);

        switch (evaluateLeftTopWin){

            case 0:

                if (evaluateRightBottom == 3) {
                    cord1X4Winner = cordX;
                    cord1y4Winner = cordY;
                    cord2X4Winner = cordX + 1;
                    cord2y4Winner = cordY - 1;
                    cord3X4Winner = cordX + 2;
                    cord3y4Winner = cordY - 2;
                    cord4X4Winner = cordX + 3;
                    cord4y4Winner = cordY - 3;
                    return true;
                }

                break;

            case 1:


                if (evaluateRightBottom >= 2) {
                    cord1X4Winner = cordX;
                    cord1y4Winner = cordY;
                    cord2X4Winner = cordX - 1;
                    cord2y4Winner = cordY + 1;
                    cord3X4Winner = cordX + 1;
                    cord3y4Winner = cordY - 1;
                    cord4X4Winner = cordX + 2;
                    cord4y4Winner = cordY - 2;
                    return true;
                }

                break;

            case 2:


                if (evaluateRightBottom >= 1) {
                    cord1X4Winner = cordX;
                    cord1y4Winner = cordY;
                    cord2X4Winner = cordX - 1;
                    cord2y4Winner = cordY + 1;
                    cord3X4Winner = cordX - 2;
                    cord3y4Winner = cordY + 2;
                    cord4X4Winner = cordX + 1;
                    cord4y4Winner = cordY - 1;
                    return true;
                }

                break;

            case 3:

                cord1X4Winner = cordX;
                cord1y4Winner = cordY;
                cord2X4Winner = cordX - 1;
                cord2y4Winner = cordY + 1;
                cord3X4Winner = cordX - 2;
                cord3y4Winner = cordY + 2;
                cord4X4Winner = cordX - 3;
                cord4y4Winner = cordY + 3;
                return true;


            default:

                break;
        }

        return false;
    }

    private int evaluateRightWin(int cordX, int cordY, TokenTypes playerTokenType, int evaluationPosition){
        int numberOfEvaluations = 0;
        if (isTokenRight(cordX)){
            if (isRightTokenSameTokenType(cordX,cordY,playerTokenType)){
                if(evaluationPosition < 3) numberOfEvaluations = 1 + evaluateRightWin(cordX + 1, cordY, playerTokenType, (evaluationPosition + 1));
                else numberOfEvaluations = 1;
            }
        }
        return numberOfEvaluations;
    }

    private int evaluateLeftWin(int cordX, int cordY, TokenTypes playerTokenType, int evaluationPosition){
        int numberOfEvaluations = 0;
        if (isTokenLeft(cordX)){
            if (isLeftTokenSameTokenType(cordX,cordY,playerTokenType)){
                if(evaluationPosition < 3) numberOfEvaluations = 1 + evaluateLeftWin(cordX - 1, cordY, playerTokenType, (evaluationPosition + 1));
                else numberOfEvaluations = 1;
            }
        }
        return numberOfEvaluations;
    }



    private int evaluateTopWin(int cordX, int cordY, TokenTypes playerTokenType, int evaluationPosition){
        int numberOfEvaluations = 0;
        if (isTokenTop(cordY)){
            if (isTopTokenSameTokenType(cordX,cordY,playerTokenType)){
                if(evaluationPosition < 3) numberOfEvaluations = 1 + evaluateTopWin(cordX, cordY + 1 , playerTokenType, (evaluationPosition + 1));
                else numberOfEvaluations = 1;
            }
        }
        return numberOfEvaluations;
    }

    private int evaluateBottomWin(int cordX, int cordY, TokenTypes playerTokenType, int evaluationPosition){
        int numberOfEvaluations = 0;
        if (isTokenBottom(cordY)){
            if (isBottomTokenSameTokenType(cordX,cordY,playerTokenType)){
                if(evaluationPosition < 3) numberOfEvaluations = 1 + evaluateBottomWin(cordX, cordY - 1 , playerTokenType, (evaluationPosition + 1));
                else numberOfEvaluations = 1;
            }
        }
        return numberOfEvaluations;
    }

    private int evaluateRightTopWin(int cordX, int cordY, TokenTypes playerTokenType, int evaluationPosition){
        int numberOfEvaluations = 0;
        if (isTokenTopRight(cordX,cordY)){
            if (isTopRightTokenSameTokenType(cordX,cordY,playerTokenType)){
                if(evaluationPosition < 3) numberOfEvaluations = 1 + evaluateRightTopWin(cordX + 1 , cordY + 1 , playerTokenType, (evaluationPosition + 1));
                else numberOfEvaluations = 1;
            }
        }
        return numberOfEvaluations;
    }

    private int evaluateLeftTopWin(int cordX, int cordY, TokenTypes playerTokenType, int evaluationPosition){
        int numberOfEvaluations = 0;
        if (isTokenTopLeft(cordX,cordY)){
            if (isTopLeftTokenSameTokenType(cordX,cordY,playerTokenType)){
                if(evaluationPosition < 3) numberOfEvaluations = 1 + evaluateLeftTopWin(cordX - 1 , cordY + 1 , playerTokenType, (evaluationPosition + 1));
                else numberOfEvaluations = 1;
            }
        }
        return numberOfEvaluations;
    }

    private int evaluateRightBottomWin(int cordX, int cordY, TokenTypes playerTokenType, int evaluationPosition){
        int numberOfEvaluations = 0;
        if (isTokenBottomRight(cordX,cordY)){
            if (isBottomRightTokenSameTokenType(cordX,cordY,playerTokenType)){
                if(evaluationPosition < 3) numberOfEvaluations = 1 + evaluateRightBottomWin(cordX + 1 , cordY - 1 , playerTokenType, (evaluationPosition + 1));
                else numberOfEvaluations = 1;
            }
        }
        return numberOfEvaluations;
    }

    private int evaluateLeftBottomWin(int cordX, int cordY, TokenTypes playerTokenType, int evaluationPosition){
        int numberOfEvaluations = 0;
        if (isTokenBottomLeft(cordX,cordY)){
            if (isBottomLeftTokenSameTokenType(cordX,cordY,playerTokenType)){
                if(evaluationPosition < 3) numberOfEvaluations = 1 + evaluateLeftBottomWin(cordX - 1 , cordY - 1 , playerTokenType, (evaluationPosition + 1));
                else numberOfEvaluations = 1;
            }
        }
        return numberOfEvaluations;
    }


    private boolean isLeftTokenSameTokenType(int cordX,int cordY, TokenTypes playerTokenType){
        TokenTypes leftTokenType = boardInstance.getTableBoard()[cordX - 1][cordY];
        return (leftTokenType == playerTokenType);
    }

    private boolean isRightTokenSameTokenType(int cordX,int cordY, TokenTypes playerTokenType){
        TokenTypes leftTokenType = boardInstance.getTableBoard()[cordX + 1][cordY];
        return (leftTokenType == playerTokenType);
    }

    private boolean isTopTokenSameTokenType(int cordX,int cordY, TokenTypes playerTokenType){
        TokenTypes leftTokenType = boardInstance.getTableBoard()[cordX][cordY + 1];
        return (leftTokenType == playerTokenType);
    }

    private boolean isBottomTokenSameTokenType(int cordX,int cordY, TokenTypes playerTokenType){
        TokenTypes leftTokenType = boardInstance.getTableBoard()[cordX][cordY - 1];
        return (leftTokenType == playerTokenType);
    }

    private boolean isTopRightTokenSameTokenType(int cordX,int cordY, TokenTypes playerTokenType){
        TokenTypes leftTokenType = boardInstance.getTableBoard()[cordX + 1][cordY + 1];
        return (leftTokenType == playerTokenType);
    }

    private boolean isTopLeftTokenSameTokenType(int cordX,int cordY, TokenTypes playerTokenType){
        TokenTypes leftTokenType = boardInstance.getTableBoard()[cordX - 1][cordY + 1];
        return (leftTokenType == playerTokenType);
    }

    private boolean isBottomRightTokenSameTokenType(int cordX,int cordY, TokenTypes playerTokenType){
        TokenTypes leftTokenType = boardInstance.getTableBoard()[cordX + 1][cordY - 1];
        return (leftTokenType == playerTokenType);
    }

    private boolean isBottomLeftTokenSameTokenType(int cordX,int cordY, TokenTypes playerTokenType){
        TokenTypes leftTokenType = boardInstance.getTableBoard()[cordX - 1][cordY - 1];
        return (leftTokenType == playerTokenType);
    }

    private boolean isTokenLeft(int cordX){
        return ((cordX - 1)>=0);
    }

    private boolean isTokenRight(int cordX){
        return ((cordX + 1)<7);
    }

    public boolean isTokenTop(int cordY){
        return ((cordY + 1)<6);
    }

    public boolean isTokenBottom(int cordY){
        return ((cordY - 1)>=0);
    }

    public boolean isTokenTopRight(int cordX, int cordY){
        return isTokenRight(cordX)&&isTokenTop(cordY);
    }

    public boolean isTokenTopLeft(int cordX, int cordY){
        return isTokenLeft(cordX)&&isTokenTop(cordY);
    }

    public boolean isTokenBottomRight(int cordX, int cordY){
        return isTokenRight(cordX)&&isTokenBottom(cordY);
    }

    public boolean isTokenBottomLeft(int cordX, int cordY){
        return isTokenLeft(cordX)&&isTokenBottom(cordY);
    }

}
