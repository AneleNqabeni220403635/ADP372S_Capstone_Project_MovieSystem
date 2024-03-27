package za.ac.cput.domain;
/*Director.java
Director model class
Author: Lindiwe Magagula (222037881)
Date: 21 March 2024
 */

public class Director {
    private String directorId;
    private String name;
    private String gender;
    private String nationality;
    private String movieDirected;

    private Director() {
    }

    private Director(Builder builder) {
        this.directorId = builder.directorId;
        this.name = builder.name;
        this.gender = builder.gender;
        this.nationality = builder.nationality;
        this.movieDirected = builder.movieDirected;
    }
    public String getDirectorId(){
        return directorId;
    }
    public String getName(){
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public String getMovieDirected() {
        return movieDirected;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() !=o.getClass()) return false;
        if (!(o instanceof Director)) return false;
        Director director = (Director) o;

        return directorId.equals(director.directorId) &&
                name.equals(director.name) &&
                gender.equals(director.gender) &&
                nationality.equals(director.nationality) &&
                movieDirected.equals(director.movieDirected );
    }

    @Override
    public int hashCode(){
        return java.util.Objects.hash(directorId, name, gender, nationality, movieDirected);
    }

    @Override
    public String toString(){
        return "Director{" +
                "directorId='" + directorId + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", movieDirected='" + movieDirected +
                '}';
    }
    public static class Builder {
        private String directorId;
        private String name;
        private String gender;
        private String nationality;
        private String movieDirected;

        public Builder setDirectorId(String directorId){
            this.directorId = directorId;
            return this;
        }
        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setGender(String gender){
            this.gender = gender;
            return this;
        }
        public Builder setNationality(String nationality){
            this.nationality = nationality;
            return this;
        }
        public Builder setMovieDirected(String movieDirected){
            this.movieDirected = movieDirected;
            return this;
        }

        public Builder copy(Director e){
            this.directorId = e.directorId;
            this.name = e.name;
            this.gender = e.gender;
            this.nationality = e.nationality;
            this.movieDirected = e.movieDirected;
            return this;
        }
        public Director build() {
            return new Director(this);
        }
    }

}
