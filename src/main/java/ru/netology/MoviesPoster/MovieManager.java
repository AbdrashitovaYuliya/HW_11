package ru.netology.MoviesPoster;

public class MovieManager {

    private Movie[] movies = new Movie[0];
    private final int limit;

    public MovieManager() {
        limit = 10;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public void add(Movie movie) {
        Movie[] tmp = new Movie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }


    public Movie[] findAll() {
        return movies;
    }


    public Movie[] findLast() {
        Movie[] lastElement;
        if (limit < movies.length) {
            lastElement = new Movie[limit];
        } else {
            lastElement = new Movie[movies.length];
        }
        for (int i = 0; i < lastElement.length; i++) {
            lastElement[i] = movies[movies.length - 1 - i];
        }
        return lastElement;
    }


}
