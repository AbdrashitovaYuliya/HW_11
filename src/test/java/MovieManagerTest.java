import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.MoviesPoster.Movie;
import ru.netology.MoviesPoster.MovieManager;

public class MovieManagerTest {

    @Test
    public void shouldAddMovie() {
        MovieManager manager = createManager(10);

        Assertions.assertEquals(manager.findAll().length, 7);
    }


    @Test
    public void shouldFindLast() {
        MovieManager manager = createManager(1);
        Movie movie = manager.findLast()[0];
        Assertions.assertEquals(movie.getTitle(), "Номер один");

    }

    @Test
    public void shouldFindAll() {
        MovieManager manager = new MovieManager();
        manager.add(createMovie("Бладшот", "Боевик", 120L));
        manager.add(createMovie("Вперед", "Мультфильм", 90L));
        manager.add(createMovie("Отель 'Белград' ", "Комедия", 100L));
        manager.add(createMovie("Джентльмены", "Боевик", 120L));
        manager.add(createMovie("Человек-невидимка", "Ужасы", 90L));
        manager.add(createMovie("Тролли. Мировой тур", "Мультфильм", 90L));
        manager.add(createMovie("Номер один", "Комедия", 120L));
        manager.findAll();
    }

    private Movie createMovie(String title, String description, Long duration) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDescription(description);
        movie.setDuration(duration);
        return movie;
    }

    @Test
    public void shouldLimitLessThan10() {
        MovieManager manager = new MovieManager(2);
        Movie movie = manager.findLast()[0];

        Assertions.assertEquals(movie.getTitle(), "Номер один", "Тролли. Мировой тур");

    }

    @Test
    public void shouldMoreThanLimit() {
        MovieManager manager = new MovieManager(10);
        manager.findLast();
    }

    @Test
    public void shouldAddMovie10() {
        MovieManager manager = new MovieManager();
        manager.add(createMovie("Бладшот", "Боевик", 120L));
        manager.add(createMovie("Вперед", "Мультфильм", 90L));
        manager.add(createMovie("Отель 'Белград' ", "Комедия", 100L));
        manager.add(createMovie("Джентльмены", "Боевик", 120L));
        manager.add(createMovie("Человек-невидимка", "Ужасы", 90L));
        manager.add(createMovie("Тролли. Мировой тур", "Мультфильм", 90L));
        manager.add(createMovie("Номер один", "Комедия", 120L));
        manager.add(createMovie("Человек-невидимка2", "Ужасы", 90L));
        manager.add(createMovie("Тролли. Мировой тур2", "Мультфильм", 90L));
        manager.add(createMovie("Номер один2", "Комедия", 120L));
        Assertions.assertEquals(manager.findAll().length, 10);

    }


    private MovieManager createManager(int limit) {
        MovieManager manager = new MovieManager(limit);
        manager.add(createMovie("Бладшот", "Боевик", 120L));
        manager.add(createMovie("Вперед", "Мультфильм", 90L));
        manager.add(createMovie("Отель 'Белград' ", "Комедия", 100L));
        manager.add(createMovie("Джентльмены", "Боевик", 120L));
        manager.add(createMovie("Человек-невидимка", "Ужасы", 90L));
        manager.add(createMovie("Тролли. Мировой тур", "Мультфильм", 90L));
        manager.add(createMovie("Номер один", "Комедия", 120L));
        return manager;
    }

    @Test

    public void findAllResult() {

        Movie[] allMovie = new Movie[7];
        allMovie[0] = createMovie("Бладшот", "Боевик", 120L);
        allMovie[1] = createMovie("Вперед", "Мультфильм", 90L);
        allMovie[2] = createMovie("Отель 'Белград' ", "Комедия", 100L);
        allMovie[3] = createMovie("Джентльмены", "Боевик", 120L);
        allMovie[4] = createMovie("Человек-невидимка", "Ужасы", 90L);
        allMovie[5] = createMovie("Тролли. Мировой тур", "Мультфильм", 90L);
        allMovie[6] = createMovie("Номер один", "Комедия", 120L);

        MovieManager manager = new MovieManager();
        for (int i = 0; i < allMovie.length; i++) {
            manager.add(allMovie[i]);
        }

        Movie[] findAllResult = manager.findAll();
        for (int i = 0; i < findAllResult.length; i++) {

            Assertions.assertEquals(allMovie[i].getTitle(), findAllResult[i].getTitle());
        }

    }

    @Test

    public void findLastResult() {
        Movie[] allMovie = new Movie[7];
        allMovie[0] = createMovie("Бладшот", "Боевик", 120L);
        allMovie[1] = createMovie("Вперед", "Мультфильм", 90L);
        allMovie[2] = createMovie("Отель 'Белград' ", "Комедия", 100L);
        allMovie[3] = createMovie("Джентльмены", "Боевик", 120L);
        allMovie[4] = createMovie("Человек-невидимка", "Ужасы", 90L);
        allMovie[5] = createMovie("Тролли. Мировой тур", "Мультфильм", 90L);
        allMovie[6] = createMovie("Номер один", "Комедия", 120L);

        MovieManager manager = new MovieManager(3);
        for (int i = 0; i < allMovie.length; i++) {
            manager.add(allMovie[i]);
        }

        Movie[] findLastResult = manager.findLast();
        for (int i = 0; i < findLastResult.length; i++) {
            Assertions.assertEquals(allMovie[allMovie.length - 1 - i].getTitle(), findLastResult[i].getTitle());
        }
    }

}




