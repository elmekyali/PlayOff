package presenter;

import com.training.Team;
import javafx.util.Pair;
import parsers.Parser;

import java.util.List;

public class DefaultPresenter implements Presenter {

    @Override
    public String[] expectedPlayoffPresenter(List<String> teams) {
        String[] result = new String[2];
        result[0] = teams.get(0) + " vs " + teams.get(3);
        result[1] = teams.get(1) + " vs " + teams.get(2);
        return result;
    }
}
