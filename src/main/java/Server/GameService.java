package Server;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameService {

    private List<Game> games = new ArrayList<>();
    private List<Move> moves = new ArrayList<>();

    GameService(){
        games.add(new Game(1));

        moves.add(new Move(2,2,"MOVE", "N",0));
        moves.add(new Move(2,3,"MOVE", "S",44));
        moves.add(new Move(2,2,"MOVE", "N",1));
        moves.add(new Move(2,3,"MOVE", "S",43));
        moves.add(new Move(2,2,"MOVE", "N",2));
        moves.add(new Move(2,3,"MOVE", "S",42));

        Game game = new Game(1);
        game.setMoves(moves);
        games.add(game);
    }

    //Game Requests

    @GetMapping
    public List<Game> getAllGames() {
        return games;
    }

    @GetMapping("/game/{id}/")
    public Game getGameById(@PathVariable(value = "id")int id){
        for (Game game : games) {
            if (game.getGameId() == id) {
                return game;
            }
        }
        return null;
    }

    @PostMapping("/game")
    public void createGame(@RequestBody Game g) {
        Game newGame = new Game(g.getMapId());
        games.add(newGame);
    }

    @PostMapping("/game/{gameId}/join")
    public void joinGame(@RequestBody Player p,@PathVariable(value = "gameId")int gameId) {
        for (Game game : games){
            if(game.getGameId()==gameId){
                Player newPlayer = Player.createPlayerId(p.getRobotId());
                List<Player> gamePlayer = game.getPlayers();
                gamePlayer.add(newPlayer);
                if(game.getPlayers().size()>1){
                    game.setStatus("STARTED");
                }
            }
        }

    }




    //Move Requests

    @GetMapping("/{id}/moves")
    public List<Move> getAllMoves(@PathVariable(value = "id")int GameId) {
        List<Move> gameMoves = new ArrayList<>();
        for (Game game : games){
            if (game.getGameId()==GameId){
                for (Move move : moves){
                    if (move.getGameId()==GameId){
                        gameMoves.add(move);
                    }
                }
            }
        }
        return gameMoves;
    }

    @PostMapping("/{gameId}/move/player/{playerId}/")
    public void createPlayerMove(@RequestBody Move m, @PathVariable(value = "gameId")int gameId, @PathVariable(value = "playerId")int playerId) {
        Move newMove = new Move(gameId, playerId, m.getMovementType(), m.getAlign(), m.getMapIndex());
        moves.add(newMove);
    }

    @GetMapping("/game/{gameId}/move/{moveId}/after")
    public List<Move> getAllMoves(@PathVariable(value = "gameId")int gameId, @PathVariable(value = "moveId")int moveId) {
        List<Move> gameMoves = new ArrayList<>();
        List<Move> movesAfter = new ArrayList<>();
        int index = -1;
        for (Game game : games) {
            if (game.getGameId() == gameId) {
                gameMoves = game.getMoves();
                break;
            }
        }
        boolean add = false;
        for (Move move : gameMoves) {
            if (move.getMoveId() == moveId) {
                add = true;
            }
            if (add) {
                index = gameMoves.indexOf(move);
            }
            if (index != -1){
                movesAfter.add(move);
            }
        }
        return movesAfter;
    }
}
