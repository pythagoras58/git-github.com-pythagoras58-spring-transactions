package com.pytha.springjpa.dto;

import com.pytha.springjpa.entities.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private String status;
    private double totalFare;
    private String pnr;
    private Passenger passengerInfo;
}
