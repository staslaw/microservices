package com.example.demoms3.api;

import com.example.demoms3.model.MovieInfo;
import com.example.demoms3.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping
@RestController
public class MovieController {

//    @Value("${api.key}")
//    private String apiKey;
//
//    @Autowired
//    private RestTemplate restTemplate;

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/{movieTitle}")
    public MovieInfo getMovieInfo(@PathVariable("movieTitle") String movieTitle) {
        return movieService.getMovieInfo(movieTitle);
    }

//    @RequestMapping("/{movieId}")
//    public MovieInfo getMovieInfo(@PathVariable("movieId") String movieId) {
//        MovieInfo movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/550?api_key=" +  apiKey, MovieInfo.class);
//        return movieSummary;

//    }

}
