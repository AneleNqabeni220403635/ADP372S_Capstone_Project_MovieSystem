package za.ac.cput.repository;
/*
    Hermanus J Neethling
    220526303
*/
import za.ac.cput.domain.Cinema;

import java.util.List;

public interface ICinemaRepository
{
    Cinema findById(String cinemaId);
    List<Cinema> findAll();
    void save(Cinema cinema);
    void update(Cinema cinema);
    void delete(String cinemaId);
}
