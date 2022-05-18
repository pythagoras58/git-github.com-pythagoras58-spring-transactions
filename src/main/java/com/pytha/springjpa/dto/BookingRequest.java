package com.pytha.springjpa.dto;

import com.pytha.springjpa.entities.Passenger;
import com.pytha.springjpa.entities.Payment_Info;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {

    private Payment_Info payment_info;
    private Passenger passenger;
}
