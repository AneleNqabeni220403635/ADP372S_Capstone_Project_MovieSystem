package za.ac.cput.repository;
/* Director.java
IDirectorRepository model class
Author: Lindiwe Magagula (222037881)
Date: 22 March 2024
 */

import za.ac.cput.domain.Director;

import java.util.Set;

public interface IDirectorRepository extends IRepository<Director, String> {
    Set<Director> getAll();
}


