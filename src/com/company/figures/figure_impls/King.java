package com.company.figures.figure_impls;

import com.company.core.Move;
import com.company.game.Game;
import com.company.core.BoardLetters;
import com.company.core.MoveInfo;
import com.company.core.Position;
import com.company.core.exceptions.IllegalSquareException;
import com.company.figures.Figure;

import java.util.*;

import static com.company.core.BoardLetters.*;

public class King extends Figure {

    private boolean castleable = true;

    public King(Position position, boolean isWhite) {
        super(position, isWhite);

        if(isWhite) {
            figureChar = '♚';
        }
        else {
            figureChar = '♔';
        }
    }

    public MoveInfo castle(boolean shortSide) {
        if(!castleable) return new MoveInfo(null, false, false);
        if(shortSide) {
            if(isWhite) {
                if(Game.board.getFigureByPosition(new Position(F, 1)) == null && Game.board.getFigureByPosition(new Position(BoardLetters.G, 1)) == null) {
                    Figure rook = Game.board.getFigureByPosition(new Position(H, 1));
                    if(rook == null) return new MoveInfo(null, false, false);
                    MoveInfo isRookCastleable = ((Rook) rook).castle(true);
                    if(isRookCastleable.isLegal()) {
                        Position to = new Position(G, 1);
                        Game.board.onMove(new Move(position, to, this, null));
                        position = to;
                        return new MoveInfo(position, false, true);
                    }
                }
            } else {
                if(Game.board.getFigureByPosition(new Position(F, 8)) == null && Game.board.getFigureByPosition(new Position(BoardLetters.G, 8)) == null) {
                    Figure rook = Game.board.getFigureByPosition(new Position(H, 8));
                    if(rook == null) return new MoveInfo(null, false, false);
                    MoveInfo isRookCastleable = ((Rook) rook).castle(true);
                    if(isRookCastleable.isLegal()) {
                        Position to = new Position(G, 8);
                        Game.board.onMove(new Move(position, to, this, null));
                        position = to;
                        return new MoveInfo(position, false, true);
                    }
                }
            }
        } else {
            if(isWhite) {
                if (Game.board.getFigureByPosition(new Position(B, 1)) == null && Game.board.getFigureByPosition(new Position(C, 1)) == null && Game.board.getFigureByPosition(new Position(D, 1)) == null) {
                    Figure rook = Game.board.getFigureByPosition(new Position(A, 1));
                    if (rook == null) return new MoveInfo(null, false, false);
                    MoveInfo isRookCastleable = ((Rook) rook).castle(false);
                    if (isRookCastleable.isLegal()) {
                        Position to = new Position(C, 1);
                        Game.board.onMove(new Move(position, to, this, null));
                        position = to;
                        return new MoveInfo(position, false, true);
                    }
                }
            } else {
                if (Game.board.getFigureByPosition(new Position(B, 8)) == null && Game.board.getFigureByPosition(new Position(C, 8)) == null && Game.board.getFigureByPosition(new Position(D, 8)) == null) {
                    Figure rook = Game.board.getFigureByPosition(new Position(A, 1));
                    if (rook == null) return new MoveInfo(null, false, false);
                    MoveInfo isRookCastleable = ((Rook) rook).castle(false);
                    if (isRookCastleable.isLegal()) {
                        Position to = new Position(C, 8);
                        Game.board.onMove(new Move(position, to, this, null));
                        position = to;
                        return new MoveInfo(position, false, true);
                    }
                }
            }
        }
        return new MoveInfo(null, false, false);
    }

    @Override
    public MoveInfo move(Position newPosition) {
        castleable = false;
        return super.move(newPosition);
    }

    @Override
    public List<Position> possibleMoves() {
        List<Position> possibleMoves = combinedMoves();

        this.removeOccupiedCells(possibleMoves);
        this.removeUnderCheckCells(possibleMoves);

        return possibleMoves;
    }


    protected void removeUnderCheckCells(List<Position> possibleMoves) {
        /*
            The copy of Game.board.figures is needed because combinedMoves(),
            which is needed to reduce duplicate code for possibleMoves() and
            controlSquares(), calls isPinned() method, which determines whether the
            piece is pinned by removing it from the figures list, but the piece
            that is pinned can also block the King from coming to a specific
            square. And the other reason of copying the list is that otherwise it
            would throw ConcurrentModificationException because Game.board.figures
            would be modified by the isPinned() method while here a for-each loop is
            iterating over it.
         */
        var figuresListCopy = new ArrayList<>(Game.board.figures);
        for(Figure f : figuresListCopy) {
            if(f.isWhite != this.isWhite) {
                possibleMoves.removeAll(f.controlSquares());
            }
        }
    }

    @Override
    public List<Position> controlSquares() {
        return combinedMoves();
    }

    private List<Position> combinedMoves() {
        ArrayList<Position> possibleMoves = new ArrayList<>();
        try { // 1
            possibleMoves.add(new Position(position.x-1, position.y));
        } catch (IllegalSquareException ignore) {}
        try { // 2
            possibleMoves.add(new Position(position.x-1, position.y-1));
        } catch (IllegalSquareException ignore) {}
        try { // 3
            possibleMoves.add(new Position(position.x-1, position.y+1));
        } catch (IllegalSquareException ignore) {}
        try { // 4
            possibleMoves.add(new Position(position.x+1, position.y));
        } catch (IllegalSquareException ignore) {}
        try { // 5
            possibleMoves.add(new Position(position.x+1, position.y-1));
        } catch (IllegalSquareException ignore) {}
        try { // 6
            possibleMoves.add(new Position(position.x+1, position.y+1));
        } catch (IllegalSquareException ignore) {}
        try { // 7
            possibleMoves.add(new Position(position.x, position.y+1));
        } catch (IllegalSquareException ignore) {}
        try { // 8
            possibleMoves.add(new Position(position.x, position.y-1));
        } catch (IllegalSquareException ignore) {}
        return possibleMoves;
    }

    public List<Figure> checkers() {
        List<Figure> checkers = new LinkedList<>(); // only additions occur
        Bishop bishopCheck = new Bishop(this.position, isWhite);
        Rook rookCheck = new Rook(this.position, isWhite);
        for(Position p : bishopCheck.controlSquares()) {
            Figure f = Game.board.getFigureByPosition(p);
            if(f != null && f.isWhite != this.isWhite && (f instanceof Bishop || f instanceof Queen)) {
                if(f instanceof Queen && f.position.x != this.position.x && f.position.y != this.position.y){
                    checkers.add(f);
                }
                checkers.add(f);
            }
        }
        for(Position p : rookCheck.controlSquares()) {
            Figure f = Game.board.getFigureByPosition(p);
            if(f != null && f.isWhite != this.isWhite && (f instanceof Rook || f instanceof Queen)) {
                if(f instanceof Queen && (f.position.x == this.position.x || f.position.y == this.position.y)) {
                    checkers.add(f);
                }
                checkers.add(f);
            }
        }
        return new ArrayList<>(new HashSet<>(checkers)); // removes repetitions
    }

    public List<Position> possibleCovers() {
        var checkers = checkers();
        if(checkers.isEmpty()) {
            throw new UnsupportedOperationException("King (" + isWhite + ") is not under a check, but possible covers was requested");
        } else if(checkers.size() > 1) {
            return Collections.emptyList();
        }
        var checker = checkers.get(0);
        Figure coversFinder;
        if (checker instanceof Rook) coversFinder = new Rook(this.position, isWhite);
        else if (checker instanceof Bishop) coversFinder = new Bishop(this.position, isWhite);
        else if (checker instanceof Queen) {
            if(checker.position.x != this.position.x || checker.position.y != this.position.y) {
                coversFinder = new Bishop(this.position, isWhite);
            } else {
                coversFinder = new Rook(this.position, isWhite);
            }
        }
        else return Collections.emptyList(); // Knight and Pawn case, their checks cannot be covered

        List<Position> possibleCovers = new LinkedList<>();
        List<Position> checkerMoves = checker.possibleMoves();
        for(Position cover : coversFinder.possibleMoves()) {
            if (checkerMoves.contains(cover)) {
                possibleCovers.add(cover);
            }
        }
        return possibleCovers;
    }
}
