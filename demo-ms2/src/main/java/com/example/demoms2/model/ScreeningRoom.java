package com.example.demoms2.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
public class ScreeningRoom {
    @NotBlank
    private String name;
    @NotNull @Min(1)
    private Long numberOfSeats;
    @NotNull @Min(1)
    private Long screenSurfaceM2;

    //annotations like @NotNull or @NotBlank doesn't work in embedded object

    public ScreeningRoom() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Long getScreenSurfaceM2() {
        return screenSurfaceM2;
    }

    public void setScreenSurfaceM2(Long screenSurfaceM2) {
        this.screenSurfaceM2 = screenSurfaceM2;
    }
}
