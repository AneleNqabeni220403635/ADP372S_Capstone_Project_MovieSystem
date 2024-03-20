package za.ac.cput.repository;
/* IRepository.java
IRepository model class
Author: Anele Nqabeni (220403635)
Date: 18 March 2024
*/
public interface IRepository <T, ID>{
    T create(T t);

    T read(ID id);

    T update(T t);

    void delete(ID id);

}

