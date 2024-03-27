package za.ac.cput.factory;
/* Director.java
DirectorFactory model class
Author: Lindiwe Magagula (222037881)
Date: 21 March 2024
 */

import za.ac.cput.domain.Director;

public class DirectorFactory {

    public static Director createDirector(String directorId, String name, String gender, String nationality, String movieDirected){
        if ( directorId == null || directorId.trim().isEmpty() || name == null || name.trim().isEmpty() ||
                gender == null || gender.trim().isEmpty() || nationality == null || nationality.trim().isEmpty() ||
                movieDirected == null || movieDirected.trim().isEmpty()) {
            return null;
        }

        return new Director.Builder()
                .setDirectorId(directorId)
                .setName(name)
                .setGender(gender)
                .setNationality(nationality)
                .setMovieDirected(movieDirected)
                .build();
    }

}
