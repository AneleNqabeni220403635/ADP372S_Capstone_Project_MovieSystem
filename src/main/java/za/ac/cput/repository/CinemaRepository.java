package za.ac.cput.repository;
/*
    Hermanus J Neethling
    220526303
*/
import java.util.List;
import za.ac.cput.domain.Cinema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CinemaRepository implements ICinemaRepository {

    private static CinemaRepository instance;
    private Map<String, Cinema> cinemaMap;

    public CinemaRepository()
    {
        cinemaMap = new HashMap<>();
    }

    public static synchronized CinemaRepository getInstance()
    {
        if (instance == null)
        {
            instance = new CinemaRepository();
        }
        return instance;
    }

    @Override
    public List<Cinema> findAll()
    {
        return new ArrayList<>(cinemaMap.values());
    }

    @Override
    public Cinema create(Cinema cinema) {
        cinemaMap.put(cinema.getCinemaId(), cinema);
        return cinema;
    }

    @Override
    public Cinema read(String cinemaId)
    {
        return cinemaMap.get(cinemaId);
    }

    @Override
    public Cinema update(Cinema cinema)
    {
        cinemaMap.put(cinema.getCinemaId(), cinema);
        return cinema;
    }

    @Override
    public boolean delete(String cinemaId)
    {
        cinemaMap.remove(cinemaId);
        return true;
    }
}
