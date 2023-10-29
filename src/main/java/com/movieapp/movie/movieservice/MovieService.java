package com.movieapp.movie.movieservice;

import com.movieapp.movie.model.Movie;
import com.movieapp.movie.model.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.util.List;

@Service
public class MovieService {

    @Value("${tmdb.api.key}")
    private String apiKey;


    @Value("${tmdb.api.url}")
    private String apiUrl;


    @Value("${tmdb.api.language}")
    private String language;

    @Autowired
    RestTemplate restTemplate;


    public MovieResponse fetchMovies(String type){

        String url = new UriTemplate(apiUrl + "{type}?api_key={apiKey}&language={language}")
                .expand(type,apiKey,language).toString();
        System.out.println("printing url"+url);
        ResponseEntity<MovieResponse> response = restTemplate.exchange(url, HttpMethod.GET,null,MovieResponse.class);
        return response.getBody();

    }

    public List<Movie> fetchUpcomingMovies() {
        String type = "upcoming";
        return  fetchMovies(type).getResults();
    }

    public List<Movie> fetchTopRated() {
        String type = "top_rated";
        return  fetchMovies(type).getResults();

    }

    public List<Movie> fetchPopularMovies() {
        String type = "popular";
        return  fetchMovies(type).getResults();

    }
}
