package com.paypal.kafka.consumerclient.dto;

import lombok.Data;

@Data
public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
