package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KnightTest {

    @Test
    public void knightCanMoveInLShapeMannerTwoByOne() {

        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, 1)));
    }

    @Test
    public void knightCannotAttackAlly() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, knight);

        Piece allyPawn = new Pawn(PlayerColour.WHITE);
        Coordinates allyPawnCoords = coords.plus(-1, -2);
        board.placePiece(allyPawnCoords, allyPawn);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, allyPawnCoords));
    }

    @Test
    public void knightCannotMoveOffBoardLeft() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(5, 0);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, -1)));
    }

    @Test
    public void knightCannotMoveOffBoardRight() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(5, 7);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, 2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, 1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, 1)));
    }

    @Test
    public void knightCannotMoveOffBoardAbove() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(5, 0);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-1, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(1, -2)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(-2, -1)));
        assertThat(moves).doesNotContain(new Move(coords, coords.plus(2, -1)));
    }
}
