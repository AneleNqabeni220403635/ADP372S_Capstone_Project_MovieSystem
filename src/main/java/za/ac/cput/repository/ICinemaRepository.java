package za.ac.cput.repository;
/*
    Hermanus J Neethling
    220526303
*/
import za.ac.cput.domain.Cinema;
import java.util.List;

public interface ICinemaRepository extends IRepository<Cinema, String>
{
    List<Cinema> findAll();
}
