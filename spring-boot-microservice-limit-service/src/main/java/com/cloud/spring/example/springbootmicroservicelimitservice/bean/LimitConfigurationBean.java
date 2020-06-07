package com.cloud.spring.example.springbootmicroservicelimitservice.bean;

public class LimitConfigurationBean {

	private int maximum;
	private int minimum;

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public LimitConfigurationBean() {
	}

	public LimitConfigurationBean(int maximum, int minimum) {
		this.maximum = maximum;
		this.minimum = minimum;
	}

	@Override
	public String toString() {
		return "LimitConfigurationBean [maximum=" + maximum + ", minimum=" + minimum + "]";
	}

}
