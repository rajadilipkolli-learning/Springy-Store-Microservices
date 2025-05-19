package com.siriusxi.ms.store.api.event;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public class Event<K, T> {

  private Type eventType;
  private K key;
  private T data;
  private LocalDateTime eventCreatedAt;

  public Event() {}

  public Event(Type eventType, K key, T data) {
    this.eventType = eventType;
    this.key = key;
    this.data = data;
    this.eventCreatedAt = now();
  }

  public Event(Type eventType, K key, T data, LocalDateTime eventCreatedAt) {
    this.eventType = eventType;
    this.key = key;
    this.data = data;
    this.eventCreatedAt = eventCreatedAt;
  }

  public Type getEventType() {
    return eventType;
  }

  public void setEventType(Type eventType) {
    this.eventType = eventType;
  }

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public LocalDateTime getEventCreatedAt() {
    return eventCreatedAt;
  }

  public void setEventCreatedAt(LocalDateTime eventCreatedAt) {
    this.eventCreatedAt = eventCreatedAt;
  }

  @Override
  public String toString() {
    return "Event{" +
        "eventType=" + eventType +
        ", key=" + key +
        ", data=" + data +
        ", eventCreatedAt=" + eventCreatedAt +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Event<?, ?> event = (Event<?, ?>) o;
    return eventType == event.eventType &&
        java.util.Objects.equals(key, event.key) &&
        java.util.Objects.equals(data, event.data) &&
        java.util.Objects.equals(eventCreatedAt, event.eventCreatedAt);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(eventType, key, data, eventCreatedAt);
  }

  public enum Type {
    CREATE,
    DELETE
  }
}
