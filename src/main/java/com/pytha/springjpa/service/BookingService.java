package com.pytha.springjpa.service;

import com.pytha.springjpa.dto.BookingRequest;
import com.pytha.springjpa.dto.BookingResponse;
import com.pytha.springjpa.exception.InsuffientBalanceException;

public interface BookingService {
    public BookingResponse bookingTicket(BookingRequest bookingRequest) throws InsuffientBalanceException;
}
