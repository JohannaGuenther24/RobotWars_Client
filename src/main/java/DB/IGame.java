package DB;

public interface IGame {

    //Ein bestimmten Spiel zurückgeben per ID; /api/games/game/{id}
    void getGameById(int id);

    //Neues Spiel erstellen; /api/games/game
    void createGame(int mapId);

    //Spiel joinen
    void joinGame(int gameId, int robotId);
}
