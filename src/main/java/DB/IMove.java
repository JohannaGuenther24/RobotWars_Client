package DB;

public interface IMove {

    //Liefert eine Liste aller Bewegungen, von einem bestimmten Spiel, nach der Bewegung.  /api/games/game/{id}/move/{moveId}/after
    void getMovesAfter(String gameId, String moveId);

    //Alle Bewegungen von einer Karte zurückgeben; /api/games/game/{id}{move
    void getAllGameMoves(int gameId);
}
