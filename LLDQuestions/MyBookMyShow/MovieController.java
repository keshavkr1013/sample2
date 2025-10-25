package LLDQuestions.MyBookMyShow;
import LLDQuestions.MyBookMyShow.enums.*;
import java.util.*;

public class MovieController {
    Map<City, List<Movie>> cityVsMovies;
    List<Movie> allMovies;
    MovieController()
    {
        cityVsMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }
    public void addMovie(Movie movie, City city)
    {
        allMovies.add(movie);
        if(cityVsMovies.get(city) == null)
        {
            cityVsMovies.put(city, new ArrayList<>());
        }
        cityVsMovies.get(city).add(movie);
    }

    //This uses allMovies variable
    public Movie getMovieByName(String movieName)
    {
        for(Movie movie: allMovies)
        {
            if(movie.getMovieName().equals(movieName))
                return movie;
        }
        return null;
    }
    public List<Movie> getMoviesByCity(City city)
    {
        return cityVsMovies.get(city);
    }

}
