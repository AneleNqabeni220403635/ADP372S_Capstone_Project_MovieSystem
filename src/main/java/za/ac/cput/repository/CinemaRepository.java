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
    public Cinema findById(String cinemaId)
    {
        return cinemaMap.get(cinemaId);
    }

    @Override
    public List<Cinema> findAll()
    {
        return new ArrayList<>(cinemaMap.values());
    }

    @Override
    public void save(Cinema cinema)
    {
        cinemaMap.put(cinema.getCinemaId(), cinema);
    }

    @Override
    public void update(Cinema cinema)
    {
        cinemaMap.put(cinema.getCinemaId(), cinema);
    }

    @Override
    public void delete(String cinemaId)
    {
        cinemaMap.remove(cinemaId);
    }
}
