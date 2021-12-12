package clean.code.chess.requirements;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;
    private boolean firstMove = true;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    public void Move(MovementType movementType, int newX, int newY) {
        if (chessBoard == null) {
            System.out.println("Pawn is not on the board!");
            return;
        }
        if(!this.chessBoard.IsLegalBoardPosition(newX, newY)) {
            System.out.println("Move position invalid!");
        }
        switch (pieceColor) {
            case BLACK -> moveBlack(newX, newY);
            case WHITE -> moveWhite(newX, newY);
        }
    }
    private void moveBlack(int newX, int newY) {
        if (newY != this.getYCoordinate()) {
            return;
        }
        if (firstMove) {
            if (newX == xCoordinate - 1
                || newX == xCoordinate - 2) {
                modifyBoard(this, newX, newY);
                setXCoordinate(newX);
                setFirstMove(false);
            }
        } else {
            if (newX == xCoordinate - 1) {
                setXCoordinate(newX);
            }
        }
    }
    private void moveWhite (int newX, int newY) {
        if (newY != this.getYCoordinate()) {
            return;
        }
        if (firstMove) {
            if (newX == xCoordinate + 1
                || newX == xCoordinate + 2) {
                modifyBoard(this, newX, newY);
                setXCoordinate(newX);
                setFirstMove(false);
            }
        } else {
            if (newX == xCoordinate + 1) {
                setXCoordinate(newX);
            }
        }
    }

    private void modifyBoard (Pawn pawn, int newX, int newY) {
        if(chessBoard.removePiece(pawn.getXCoordinate(), pawn.getYCoordinate())) {
            chessBoard.Add(pawn, newX, newY, pawn.getPieceColor());
        }
    }
    @Override
    public String toString() {
        return CurrentPositionAsString();
    }

    protected String CurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
