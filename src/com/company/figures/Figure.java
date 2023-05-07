package com.company.figures;

import com.company.Game;
import com.company.core.Position;
import com.company.core.exceptions.OccupiedSquareException;
import com.company.figures.figure_impls.Bishop;
import com.company.figures.figure_impls.King;
import com.company.figures.figure_impls.Queen;
import com.company.figures.figure_impls.Rook;

import java.util.List;
import java.util.Objects;

public abstract class Figure {

    public Position position;

    public char figureChar;
    public final boolean isWhite;

    protected Figure(Position position, boolean isWhite) {
        this.position = position;
        this.isWhite = isWhite;
    }


    /** isn't needed for Rook, Bishop and Queen, because their combinedMoves() function handles it */
    protected final void removeOccupiedCells(List<Position> possibleMoves) {
        possibleMoves.removeIf(position -> {
            Figure figureAtPos = Game.board.getFigureByPosition(position);
            return figureAtPos != null && figureAtPos.position.equals(position) && figureAtPos.isWhite == Figure.this.isWhite;
        });
    }


    public abstract List<Position> possibleMoves();

    /** King should check controlled squares in order to exclude them
     *  with this not with possibleMoves() because some squares may be
     *  covered by the king itself
     *
     *  Example: Ke3, Re2
     *
     *  The only difference between implementations of this and possibleMoves()
     *  is that this ignores the opposite color king as a piece
     * */
    public abstract List<Position> controlSquares();

    /**
     * returns the Figure by which this is pinned, null if this isn't pinned
     * */
    public Figure isPinned() {
        King myKing = Game.board.getKing(this.isWhite);
        Bishop bishopCheck = new Bishop(myKing.position, isWhite);
        Rook rookCheck = new Rook(myKing.position, isWhite);
        Game.board.removeFigure(this);
        for(Position p : bishopCheck.controlSquares()) {
            Figure f = Game.board.getFigureByPosition(p);
            if(f != null && f.isWhite != this.isWhite && (f instanceof Bishop || f instanceof Queen)) {
                if(f instanceof Queen && f.position.x != myKing.position.x && f.position.y != myKing.position.y){
                    try {
                        Game.board.addFigure(this);
                    } catch (OccupiedSquareException ignore) {
                    }
                    return f;
                }
                return f;
            }
        }
        for(Position p : rookCheck.controlSquares()) {
            Figure f = Game.board.getFigureByPosition(p);
            if(f != null && f.isWhite != this.isWhite && (f instanceof Rook || f instanceof Queen)) {
                if(f instanceof Queen && (f.position.x == myKing.position.x || f.position.y == myKing.position.y)) {
                    try {
                        Game.board.addFigure(this);
                    } catch (OccupiedSquareException ignore) {}
                    return f;
                }
                return f;
            }
        }
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return figureChar == figure.figureChar && isWhite == figure.isWhite && position.equals(figure.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, figureChar, isWhite);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(isWhite) {
            sb.append("White ");
        } else {
            sb.append("Black ");
        }

        sb
          .append(this.getClass().getSimpleName())
          .append(" at square ")
          .append(position);

        return sb.toString();
    }
}
