package com.company.game;


public class Game {

    public static final Board board = new Board();
    private static final MoveReader moveReader = new MoveReader(board);

    public static void start() {
        board.resetBoard();

        moveReader.makeMove("e4");
        moveReader.makeMove("e5");
        moveReader.makeMove("Nf3");
        moveReader.makeMove("Nc6");
        moveReader.makeMove("d4");
        moveReader.makeMove("exd4");
        moveReader.makeMove("Nxd4");
        moveReader.makeMove("Nf6");
        moveReader.makeMove("Nxc6");
        moveReader.makeMove("bxc6");
        moveReader.makeMove("Nc3");
        moveReader.makeMove("Bb4");
        moveReader.makeMove("Bd2");
        moveReader.makeMove("Bxc3");
        moveReader.makeMove("Bxc3");
        moveReader.makeMove("Nxe4");
        moveReader.makeMove("Bxg7");
        moveReader.makeMove("Qe7");
        moveReader.makeMove("Bxh8");
        moveReader.makeMove("Nc3+");
        moveReader.makeMove("Qe2");
        moveReader.makeMove("Nxe2");
        moveReader.makeMove("Bxe2");
        moveReader.makeMove("Ba6");
        moveReader.makeMove("O-O-O");
        moveReader.makeMove("Bxe2");
        moveReader.makeMove("Rhe1");
        moveReader.makeMove("O-O-O");
        moveReader.makeMove("Rd2");
        moveReader.makeMove("Rxh8");
        moveReader.makeMove("Rdxe2");
        moveReader.makeMove("Qg5+");
        moveReader.makeMove("Kb1");
        moveReader.makeMove("Kb7");
        moveReader.makeMove("g3");
        moveReader.makeMove("Qb5");
        moveReader.makeMove("Re3");
        moveReader.makeMove("Rg8");
        moveReader.makeMove("Rb3");
        moveReader.makeMove("Rg5");
        moveReader.makeMove("Rxb5+");
        moveReader.makeMove("Rxb5");
        moveReader.makeMove("Re7");
        moveReader.makeMove("Rf5");
        moveReader.makeMove("Rxd7");
        moveReader.makeMove("Rxf2");
        moveReader.makeMove("a3");
        moveReader.makeMove("Rxh2");
        moveReader.makeMove("Rxf7");
        moveReader.makeMove("h5");
        moveReader.makeMove("Rh7");
        moveReader.makeMove("a5");
        moveReader.makeMove("Ka2");
        moveReader.makeMove("Kb6");
        moveReader.makeMove("c3");
        moveReader.makeMove("c5");
        moveReader.makeMove("Rh6+");
        moveReader.makeMove("c6");
        moveReader.makeMove("Kb3");
        moveReader.makeMove("Kb5");
        moveReader.makeMove("a4+");
        moveReader.makeMove("Kb6");
        moveReader.makeMove("Kc4");
        moveReader.makeMove("Rxb2");
        moveReader.makeMove("Rxh5");
        moveReader.makeMove("Ra2");
        moveReader.makeMove("Kb3");
        moveReader.makeMove("Rg2");
        moveReader.makeMove("Rg5");
        moveReader.makeMove("Rg1");
        moveReader.makeMove("Rg8");
        moveReader.makeMove("Rb1+");
        moveReader.makeMove("Kc4");
        moveReader.makeMove("Ra1");
        moveReader.makeMove("Kb3");
        moveReader.makeMove("Rb1+");
        moveReader.makeMove("Ka2");
        moveReader.makeMove("Rc1");
        moveReader.makeMove("Kb2");
        moveReader.makeMove("Rg1");
        moveReader.makeMove("g4");
        moveReader.makeMove("c4");
        moveReader.makeMove("g5");
        moveReader.makeMove("Rg2+");
        moveReader.makeMove("Ka3");
        moveReader.makeMove("Rc2");
        moveReader.makeMove("g6");
        moveReader.makeMove("Rxc3+");
        moveReader.makeMove("Kb2");
        moveReader.makeMove("Rg3");
        moveReader.makeMove("g7");
        moveReader.makeMove("c3+");
        moveReader.makeMove("Kc2");
        moveReader.makeMove("Kc5");
        moveReader.makeMove("Kb3");
        moveReader.makeMove("Kd4");
        moveReader.makeMove("Rd8+");
        moveReader.makeMove("Ke3");
        moveReader.makeMove("Re8+");
        moveReader.makeMove("Kd2");
        moveReader.makeMove("Rd8+");
        moveReader.makeMove("Kc1");
        moveReader.makeMove("Rc8");
        moveReader.makeMove("c2+");
        moveReader.makeMove("Ka2");
        moveReader.makeMove("Kd1");
        moveReader.makeMove("g8=Q");
        moveReader.makeMove("Rxg8");
        moveReader.makeMove("Rxg8");
        moveReader.makeMove("c1=Q");
        moveReader.makeMove("Rg1+");
        moveReader.makeMove("Kc2");
        moveReader.makeMove("Rxc1+");
        moveReader.makeMove("Kxc1");
        moveReader.makeMove("Kb3");
        moveReader.makeMove("Kd2");
        moveReader.makeMove("Kc4");
        moveReader.makeMove("Kc2");
        moveReader.makeMove("Kc5");
        moveReader.makeMove("Kb3");
        moveReader.makeMove("Kxc6");
        moveReader.makeMove("Kb4");
        moveReader.makeMove("Kb6");
        moveReader.makeMove("Kxa4");
        moveReader.makeMove("Kc5");
        moveReader.makeMove("Kb3");
        moveReader.makeMove("Kb5");
        moveReader.makeMove("Ka3");
        moveReader.makeMove("Kc4");
        moveReader.makeMove("Ka4");
        moveReader.makeMove("Kc3");
        moveReader.makeMove("Kb5");
        moveReader.makeMove("Kb2");
        moveReader.makeMove("Ka4");
        moveReader.makeMove("Ka2");
        moveReader.makeMove("Kb4");
        moveReader.makeMove("Kb2");
        moveReader.makeMove("a4");
        moveReader.makeMove("Ka2");
        moveReader.makeMove("a3");
        moveReader.makeMove("Ka1");
        moveReader.makeMove("Kb3");
        moveReader.makeMove("Kb1");
        moveReader.makeMove("Kb4");
        moveReader.makeMove("Ka1");
        moveReader.makeMove("Ka4");
        moveReader.makeMove("Kb1");
        moveReader.makeMove("Kb4");
        moveReader.makeMove("Ka2");
        moveReader.makeMove("Ka4");
        moveReader.makeMove("Ka1");
        moveReader.makeMove("Kb3");
        moveReader.makeMove("Kb1");
        moveReader.makeMove("a2+");
        moveReader.makeMove("Ka1");
        moveReader.makeMove("Kb4");


        moveReader.requestMove();

//        System.out.println(board.findFigureByPosition(new Position(A, 8)).possibleMoves());

    }
}
