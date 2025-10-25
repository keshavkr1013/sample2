package LLDQuestions.MyBookMyShow;

import java.util.ArrayList;
import java.util.*;
import LLDQuestions.MyBookMyShow.enums.*;

public class TheatreController {
    Map<City, List<Theatre>> cityVsTheatres;
    List<Theatre> allTheatres;
    TheatreController()
    {
        cityVsTheatres = new HashMap<>();
        allTheatres = new ArrayList<>();
    }
    public void addTheatre(City city, Theatre theatre)
    {
        allTheatres.add(theatre);
        if(cityVsTheatres.get(city)==null)
        {
            cityVsTheatres.put(city, new ArrayList<>());
        }
        cityVsTheatres.get(city).add(theatre);
    }
    public Map<Theatre, List<Show>> getAllShows(City city, Movie movie)
    {
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();
        if(cityVsTheatres.get(city) == null)
            return theatreVsShows;
        for(Theatre theatre: cityVsTheatres.get(city))
        {
            List<Show> allShows = theatre.getShows();
            List<Show> filteredShows = new ArrayList<>();
            if(allShows == null)
                continue;
            for(Show show: allShows)
            {
                if(show.getMovie().getMovieName().equals(movie.getMovieName()))
                    filteredShows.add(show);
            }
            if(filteredShows.size()>0)
                theatreVsShows.put(theatre, filteredShows);
        }
        return theatreVsShows;
    }

}
