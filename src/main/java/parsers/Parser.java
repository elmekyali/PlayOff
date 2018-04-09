package parsers;

import com.training.Team;
import javafx.util.Pair;

public interface Parser {
    Pair<Team , Team> matchParser (String match , String separator);
}
