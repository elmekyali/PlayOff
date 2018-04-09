package parsers;

import com.training.Team;
import javafx.util.Pair;

public class DefaultParser implements Parser {
    @Override
    public Pair<Team, Team> matchParser(String match, String separator) {
        Team winner = new Team(match.split(separator)[0] , 1);
        Team looser = new Team(match.split(separator)[1] , 0);
        return new Pair<>(winner , looser);
    }
}
