package Server;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameService {

    private List<Game> games = new ArrayList<>();

    GameService(){
        games.add(new Game(1,2));
    }

    @GetMapping
    public List<Game> getAllGames() {
        return games;
    }

    @GetMapping("/{id}/")
    public Game getRobotById(@PathVariable(value = "id")int id){
        for (Game game : games) {
            if (game.getGameId() == id) {
                return game;
            }
        }
        return null;
    }


    @PostMapping("/game")
    public void createGame(@RequestBody Game g) {
        Game newGame = new Game(g.getMapId(), g.getRobotId());
        games.add(newGame);
    }
}
