package com.example.demo;

import jakarta.annotation.Nonnull;
import lombok.Data;

public class AppDTO {
    @Nonnull
    private String fName;
    @Nonnull
    private String lName;

    @Nonnull
    public String getFName() {
        return fName;
    }

    public void setfName(@Nonnull String fName) {
        this.fName = fName;
    }

    @Nonnull
    public String getLName() {
        return lName;
    }

    public void setlName(@Nonnull String lName) {
        this.lName = lName;
    }
}
