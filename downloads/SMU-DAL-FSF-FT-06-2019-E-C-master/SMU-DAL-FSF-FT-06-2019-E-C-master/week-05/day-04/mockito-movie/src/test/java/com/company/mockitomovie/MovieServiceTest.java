package com.company.mockitomovie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {
    @Mock
    MovieRepository movieRepoMock;

    @InjectMocks
    MovieService movieService = new MovieService(movieRepoMock);

    Movie movie1;
    Movie movie2;
    Movie movie3;

    List<Movie> movieList;

    @Before
    public void setUp() {
        movie1 = new Movie("Jurassic Park", 1994);
        movie2 = new Movie("Jurassic Park II", 1997);
        movie3 = new Movie("A Walk in the Park", 2011);

        movieList = Arrays.asList(movie1, movie2, movie3);
    }

    @Test
    public void testMoviesFromMovieList() {
        List<Movie> expectedList = Arrays.asList(movie1, movie2);
        when(movieRepoMock.getUserMovieList(1)).thenReturn(movieList);
        assertEquals(expectedList, movieService.searchMyMovie(1, "Jur"));
    }

}
