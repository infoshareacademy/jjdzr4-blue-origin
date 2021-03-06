package com.infoshareacademy.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = Rating.TABLE_NAME)
public class Rating {

    public static final String TABLE_NAME = "rating";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rating;
    private String comment;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="service_provider_id")
    private ServiceProvider serviceProvider;

    public Rating(int rating, String comment, ServiceProvider serviceProvider) {
        this.rating = rating;
        this.comment = comment;
        this.serviceProvider = serviceProvider;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "rating=" + rating +
                ", Comment='" + comment + '\'' +
                '}';
    }
}
