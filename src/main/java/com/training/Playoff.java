package com.training;

import javafx.util.Pair;
import parsers.DefaultParser;
import parsers.Parser;
import presenter.DefaultPresenter;
import presenter.Presenter;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Playoff {



    Map<String , Integer> teams = new LinkedHashMap<>();
    List<String>          sortedTeams;
    Parser parser = new DefaultParser();
    Presenter presenter = new DefaultPresenter();

    public Playoff(String[] qualificationsResults) {
        for (String qualificationsResult : qualificationsResults) {
            Pair<Team , Team> match = parser.matchParser(qualificationsResult , " ");
            String winnerName     = match.getKey().getTeamName();
            int    newWinnerScore = match.getKey().getScore();
            String looserName     = match.getValue().getTeamName();
            int    newLooserScore = match.getValue().getScore();
            teams.put(winnerName , (teams.get(winnerName) == null ? 0 : teams.get(winnerName)) + newWinnerScore);
            teams.put(looserName , (teams.get(looserName) == null ? 0 : teams.get(looserName)) + newLooserScore);
        }

        sortedTeams =
                teams.entrySet().stream().
                        sorted(Entry.comparingByValue(Comparator.reverseOrder())).
                        limit(4).
                        map(Entry::getKey).
                        collect(Collectors.toList());

    }

    public String[] layout() {
        return presenter.expectedPlayoffPresenter(sortedTeams);
    }
}
