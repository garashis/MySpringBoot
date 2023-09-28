package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

@Data
public class DTO {
    @Getter(onMethod = @__(@JsonSerialize(using = PriceSerializer.class)))
    //@NumberFormat(style = NumberFormat.Style.CURRENCY)

    private Double price;
    /*@JsonSerialize(using = PriceSerializer.class)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

     */
}
