package com.pytha.springjpa.service;

import com.pytha.springjpa.dto.BookingRequest;
import com.pytha.springjpa.dto.BookingResponse;
import com.pytha.springjpa.entities.Passenger;
import com.pytha.springjpa.entities.Payment_Info;
import com.pytha.springjpa.exception.InsuffientBalanceException;
import com.pytha.springjpa.repository.PassengerRepository;
import com.pytha.springjpa.repository.Payment_Info_Repository;
import com.pytha.springjpa.utility.PaymentGatewaySimulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingServiceImp implements BookingService{

    // call the repositories
    @Autowired
    private Payment_Info_Repository payment_info_repository;
    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public BookingResponse bookingTicket(BookingRequest bookingRequest) throws InsuffientBalanceException {
        //create bookingResponse object
        BookingResponse bookingResponse = null;
        Passenger passenger = passengerRepository.save(bookingRequest.getPassenger());
        //return passenger;

        //payment info
        Payment_Info payment_info = bookingRequest.getPayment_info();

        //simulate transaction failure due to insufficient balance in account;
        PaymentGatewaySimulator.validateFareBalanceCriteria(
                payment_info.getAccountNo(),
                payment_info.getTotalFare()
        );

        //set passenger id and fare
        payment_info.setPassengerId(passenger.getPId());
        payment_info.setTotalFare(passenger.getFare());

        //save the passenger info to db
        payment_info_repository.save(payment_info);

        bookingResponse = new BookingResponse();

        //set the status
        bookingResponse.setStatus("Successful");
        bookingResponse.setPassengerInfo(passenger);
        //take the first part of the UUID
        bookingResponse.setPnr(UUID.randomUUID().toString().split("-")[0]);
        bookingResponse.setTotalFare(passenger.getFare());

        return bookingResponse;


    }

    //Booking method

}
