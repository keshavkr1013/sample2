package LLDQuestions.MyBookMyShow;

import LLDQuestions.MyBookMyShow.enums.*;

import java.util.*;
public class Theatre {
    City city;
    List<Screen> screens;
    String address;
    List<Show> shows;
    public City getCity()
    {
        return city;
    }
    public void setCity(City city)
    {
        this.city = city;
    }
    public List<Screen> getScreens()
    {
        return screens;
    }
    public void setScreens(List<Screen> screens)
    {
        this.screens = screens;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public List<Show> getShows()
    {
        return shows;
    }
    public void setShows(List<Show> shows)
    {
        this.shows = shows;
    }

}
