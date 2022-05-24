package campus.valence.demineur;

import java.util.HashSet;
import java.util.Set;

import campus.valence.demineur.Case.*;


public class Demineur {

    public static Demineur create(int bombCount, int boardSize) {
        Case[][] board = new Case[boardSize][boardSize];

        // set de bombes, aux positions aléatoires,
        Set<Case>bombSet = new HashSet<>();

        // Tant que le set n'a pas atteint la longueur voulue (bombcount), j'ajoute une instance de case axu coordonnées aléatoires
        while(bombSet.size()<bombCount){
            int x = (int) ((Math.random()*(boardSize)));
            int y = (int) ((Math.random()*(boardSize)));
            bombSet.add( new BombCase(x,y));
        }


        // mettre les bombes sur la board
        for (Case bomb:bombSet) {
            board[bomb.getX()][bomb.getY()]=bomb;
        }

        System.out.println("bombSet -> " + bombSet);

        return new Demineur(board);
    }

    private Case[][] board;

    protected Demineur(Case[][] board) {
        this.board = board;
    }

    String boardAsString() {
        return "";
    }

    public Case[][] getBoard() {
        return board;
    }

    public int countBombsAround(int x, int y) {
        throw new RuntimeException("To be implemented");
    }
}
