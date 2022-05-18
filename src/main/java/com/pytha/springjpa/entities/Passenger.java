package com.pytha.springjpa.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Passenger_info")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pId;
    private String name;
    private String email;
    private String source;
    private String destination;
    private String pickUpTime;
    private String arrivalTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date travelDate;
    private double fare;
}
