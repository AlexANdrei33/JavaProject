package clean.code.chess.requirements;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;
    private Integer blackPawns = 0;
    private Integer whitePawns = 0;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH + 1][MAX_BOARD_HEIGHT + 1];
    }

    public void Add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if(pawn.getChessBoard() != null) {
            System.out.println("Piece is already on the board!\n");
            return;
        }
        if(IsLegalBoardPosition(xCoordinate, yCoordinate)
            && colorPosition(xCoordinate, pieceColor)) {
            pieces[xCoordinate][yCoordinate] = pawn;
            pawn.setChessBoard(this);
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            addedPawn(pieceColor);
        } else {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }

    }

    private void addedPawn(PieceColor pieceColor) {
        switch (pieceColor) {
            case BLACK -> blackPawns++;
            case WHITE -> whitePawns++;
        }
    }

    private boolean colorPosition (int x, PieceColor color) {
        switch (color) {
            case BLACK -> {
                return x == 6;
            }
            case WHITE -> {
                return x == 1;
            }
            default -> {
                return false;
            }
        }
    }
    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return validPosition(xCoordinate, yCoordinate)
                && freePosition(xCoordinate, yCoordinate)
                && numberOfPawns();
    }
    public boolean validPosition(int x, int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }

    public boolean freePosition(int x, int y) {
        return pieces[x][y] == null;
    }

    private boolean numberOfPawns() {
        return blackPawns <= 8 && whitePawns <= 8;
    }

    public boolean removePiece(int x, int y) {
        if (validPosition(x, y) && !freePosition(x, y)) {
            pieces[x][y] = null;
            return true;
        } else {
            System.out.println("No piece on this position/Invalid position.\n");
            return false;
        }
    }
}
