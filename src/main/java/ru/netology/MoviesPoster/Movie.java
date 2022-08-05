package ru.netology.MoviesPoster;

import lombok.Data;

@Data
public class Movie {
    private String title;
    private String description;
    private Long duration; // in minutes
}
