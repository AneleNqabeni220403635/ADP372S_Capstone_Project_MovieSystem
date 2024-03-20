package za.ac.cput.domain;
/* Movie.java
Movie model class
Author: Anele Nqabeni (220403635)
Date: 17 March 2024
*/
public class Movie {
    private String id;
    private String title;
    private String director;
    private int releaseYear;
    private String genre;
    private int duration;

    private Movie(){}

    private Movie(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.director = builder.director;
        this.releaseYear = builder.releaseYear;
        this.genre = builder.genre;
        this.duration = builder.duration;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;

        return releaseYear == movie.releaseYear &&
                duration == movie.duration &&
                id.equals(movie.id) &&
                title.equals(movie.title) &&
                director.equals(movie.director) &&
                genre.equals(movie.genre);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, title, director,releaseYear, genre,duration);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                '}';
    }

    public static class Builder {
        private String id;
        private String title;
        private String director;
        private int releaseYear;
        private String genre;
        private int duration;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDirector(String director) {
            this.director = director;
            return this;
        }

        public Builder setReleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public Builder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }
        public Builder copy(Movie e){
            this.id = e.id;
            this.title = e.title;
            this.director = e.director;
            this.releaseYear = e.releaseYear;
            this.genre = e.genre;
            this.duration = e.duration;
            return this;
        }
        public Movie build() {
            return new Movie(this);
        }
    }
}
