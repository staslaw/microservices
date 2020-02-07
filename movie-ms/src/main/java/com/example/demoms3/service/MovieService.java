package com.example.demoms3.service;

import com.example.demoms3.model.MovieInfo;
import com.example.demoms3.model.MovieSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MovieService {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private WebClient.Builder webClientBuilder;


    public MovieInfo getMovieInfo(String movieTitle) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=";
        String query = "&query=" + movieTitle.replace(" ", "+");

        MovieSearchResult searchResult = webClientBuilder.build()
                .get()
                .uri(url + apiKey + query)
                .retrieve()
                .bodyToMono(MovieSearchResult.class)
                .block();

        return searchResult.getResults().get(1);
    }

}
