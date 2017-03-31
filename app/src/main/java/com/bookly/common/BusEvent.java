package com.bookly.common;

/**
 * Created by cyn on 03/31/2017.
 */

public class BusEvent<T> {

  private T payload;

  public T getPayload() {
    return payload;
  }

  public void setPayload(T payload) {
    this.payload = payload;
  }
}
