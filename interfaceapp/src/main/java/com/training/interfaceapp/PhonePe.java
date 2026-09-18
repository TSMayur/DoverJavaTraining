package com.training.interfaceapp;

public class PhonePe {

	public void makePayment(PaymentGateway paymentGateway) {
		paymentGateway.pay();
	}

}
