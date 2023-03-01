package com.kata.cinema.base.init;

import com.kata.cinema.base.models.entity.Collection;
import com.kata.cinema.base.models.entity.*;
import com.kata.cinema.base.models.enums.Category;
import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.Privacy;
import com.kata.cinema.base.models.enums.RARS;
import com.kata.cinema.base.service.entity.*;
import com.kata.cinema.base.service.entity.impl.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Component
@ConditionalOnExpression("${app.initializer.runInitialize}")
public class DataInit {
    private final MovieService movieService;
    private final GenreService genreService;
    private final CollectionService collectionService;
    private final RoleService roleService;
    private final UserService userService;
    private final FolderMovieService folderMovieService;

    public DataInit(MovieService movieService, GenreService genreService, CollectionServiceImp collectionService,
                    RoleService roleService, UserService userService, FolderMovieService folderMovieService) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.collectionService = collectionService;
        this.roleService = roleService;
        this.userService = userService;
        this.folderMovieService = folderMovieService;
    }

    @PostConstruct
    public void init() {
        createGenre();
        createMovie();
        createCollection();
        createRole();
        createUser();
        createFolderMovie();
    }

    public void createGenre() {
        for (int i = 1; i <= 10; i++) {
            genreService.save(new Genre("Жанр" + i));
        }
    }

    public void createMovie() {
        for (int i = 1; i <= 100; i++) {
            Movie movie = new Movie();
            movie.setName("фильм" + i);
            movie.setDataRelease(LocalDate.ofEpochDay(ThreadLocalRandom.current()
                    .nextLong(LocalDate.of(1990, Month.JANUARY, 1).toEpochDay(),
                            LocalDate.now().toEpochDay())));
            movie.setDescription("описание фильма описание фильма описание фильма описание фильма описание фильма описание фильма описание фильма\n" +
                    "описание фильма описание фильма описание фильма описание фильма описание фильма описание фильма описание фильма\n" +
                    "описание фильма описание фильма описание фильма описание фильма описание фильма описание фильма описание фильма\n" +
                    "описание фильма описание фильма описание фильма описание фильма описание фильма описание фильма описание фильма");

            List<MPAA> mpaaList = Arrays.asList(MPAA.values());
            movie.setMpaa(mpaaList.get(new SecureRandom().nextInt(mpaaList.size())));

            List<RARS> rarsList = Arrays.asList(RARS.values());
            movie.setRars(rarsList.get(new SecureRandom().nextInt(rarsList.size())));

            List<Genre> genreList = new ArrayList<>(genreService.getAll());
            int randomSize = ThreadLocalRandom.current().nextInt(1, 4);
            Collections.shuffle(genreList);
            movie.setGenres(new HashSet<>(genreList.subList(genreList.size() - randomSize, genreList.size())));

            movieService.save(movie);
        }
    }

    public void createCollection() {
            for (int i = 1; i <= 20; i++) {
                boolean enable = !Arrays.asList(2, 6, 10, 14, 18).contains(i);
                Collection collection = new Collection("Коллекция" + i, enable);

                List<Movie> movieList = new ArrayList<>(movieService.getAll());
                int randomSize = ThreadLocalRandom.current().nextInt(5, 16);
                Collections.shuffle(movieList);
                collection.setMovies(new HashSet<>(movieList.subList(movieList.size() - randomSize, movieList.size())));

                collectionService.save(collection);
            }
    }

    public void createRole() {
        roleService.save(new Role("USER"));
        roleService.save(new Role("ADMIN"));
        roleService.save(new Role("PUBLICIST"));
    }

    public void createUser() {
        for (int i = 1; i <= 27; i++) {
            User user = new User();

            user.setEmail("email" + i + "@mail.ru");
            user.setFirstName("Имя" + i);
            user.setLastName("Фамилия" + i);
            user.setPassword("password");

            LocalDate localDate = LocalDate.ofEpochDay(
                    ThreadLocalRandom.current().nextLong(
                            LocalDate.of(1970, 1, 1).toEpochDay(),
                            LocalDate.of(2010, 12, 31).toEpochDay()
                    )
            );

            user.setBirthday(localDate);
            user.setAvatarUrl("/uploads/users/avatar/#" + i);

            Set<Role> roles = new HashSet<>(Collections.singleton(roleService.getByName("USER")));
            switch (i) {
                default -> user.setRoles(roles);
                case 26 -> {
                    roles.add(roleService.getByName("ADMIN"));
                    user.setRoles(roles);
                }
                case 27 -> {
                    roles.add(roleService.getByName("PUBLICIST"));
                    user.setRoles(roles);
                }
            }

            userService.save(user);
        }
    }

    public void createFolderMovie() {
        List<Movie> movieList = new ArrayList<>(movieService.getAll());
        for (int i = 1; i <= 27; i++) {
            for (int k = 0; k < 3; k++) {
                FolderMovie folderMovie = new FolderMovie();
                folderMovie.setUser(userService.getById((long) i));

                switch (k) {
                    case 0 -> {
                        folderMovie.setCategory(Category.WAITING_MOVIES);
                        folderMovie.setName(Category.WAITING_MOVIES.getTranslation());
                    }
                    case 1 -> {
                        folderMovie.setCategory(Category.FAVORITE_MOVIES);
                        folderMovie.setName(Category.FAVORITE_MOVIES.getTranslation());
                    }
                    case 2 -> {
                        folderMovie.setCategory(Category.VIEWED_MOVIES);
                        folderMovie.setName(Category.VIEWED_MOVIES.getTranslation());
                    }
                }

                folderMovie.setPrivacy(Privacy.PUBLIC);
                folderMovie.setDescription("описание описание описание описание описание описание описание описание ");

                Set<Movie> movies = new HashSet<>();
                int amount = new Random().nextInt(5,26);
                for (int j = 0; j < amount; j++) {
                    movies.add(movieList.get(new Random().nextInt(0, movieList.size())));
                }
                folderMovie.setMovies(movies);

                folderMovieService.save(folderMovie);
            }
        }
    }
}
