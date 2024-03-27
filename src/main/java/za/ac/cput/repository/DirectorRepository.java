package za.ac.cput.repository;
/* Director.java
DirectorRepository model class
Author: Lindiwe Magagula (222037881)
Date: 22 March 2024
 */
import za.ac.cput.domain.Director;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class DirectorRepository implements IDirectorRepository {
    private static DirectorRepository repository = null;
    private static Map<String, Director> directorMap;

    private DirectorRepository(){
        directorMap = new HashMap<>();

        directorMap.put("1", new Director.Builder().setDirectorId("1").setName("Vin Diesel").setGender("Male").setNationality("American").setMovieDirected("Witch Hunter").build());
        directorMap.put("2", new Director.Builder().setDirectorId("2").setName("Kevin Hart").setGender("Male").setNationality("American").setMovieDirected("Man from Toronto").build());
        directorMap.put("3", new Director.Builder().setDirectorId("3").setName("Keanu Reeves").setGender("Male").setNationality("Canadian").setMovieDirected("The Matrix").build());
    }

    public static DirectorRepository getRepository(){
        if (repository == null){
            repository = new DirectorRepository();
        }
        return repository;
    }

    @Override
    public Director create(Director director){
        directorMap.put(director.getDirectorId(), director);
        return director;
    }
    @Override
    public Director read(String directorId) {
        return directorMap.get(directorId);
    }
    @Override
    public Director update(Director director){
        directorMap.put(director.getDirectorId(), director);
        return director;
    }
    @Override
    public void delete(String directorId){
        directorMap.remove(directorId);
    }
    @Override
    public Set<Director> getAll(){
        return new HashSet<>(directorMap.values());
    }

   }
