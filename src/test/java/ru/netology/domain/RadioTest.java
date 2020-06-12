package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();

    @Test
    public void shouldSetDefaultNumberOfStations() {
        int expected = 10;
        assertEquals(10, radio.getMaxStation());
    }

    @Test
    public void shouldSetNumberOfStation() {
        radio.setMaxStation(20);
        assertEquals(20, radio.getMaxStation());
    }

    @Test
    public void shouldSetValidStation() {
        radio.setMaxStation(20);
        radio.setMinStation(0);
        radio.setCurrentStation(16);
        assertEquals(16, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetNoValidStation() {
        radio.setMaxStation(20);
        radio.setMinStation(0);
        radio.setCurrentStation(500);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetMinusStation() {
        radio.setMaxStation(20);
        radio.setMinStation(0);
        radio.setCurrentStation(-16);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchNextStation() {
        radio.setMaxStation(20);
        radio.setMinStation(0);
        radio.setCurrentStation(3);
        radio.setNextStation();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchPrevStation() {
        radio.setMaxStation(20);
        radio.setMinStation(0);
        radio.setCurrentStation(7);
        radio.setPrevStation();
        assertEquals(6, radio.getCurrentStation());;
    }

    @Test
    public void shouldSwitchMaxStation() {
        radio.setMaxStation(20);
        radio.setMinStation(0);
        radio.setCurrentStation(20);
        radio.setNextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchMinStation() {
        radio.setMaxStation(20);
        radio.setMinStation(0);
        radio.setCurrentStation(0);
        radio.setPrevStation();
        assertEquals(20, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetNoValidVolume() {
        radio.setMaxVolume(100);
        radio.setMinVolume(0);
        radio.setCurrentVolume(101);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetMinusVolume() {
        radio.setMaxVolume(100);
        radio.setMinVolume(0);
        radio.setCurrentVolume(-16);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolume() {
        radio.setMaxVolume(100);
        radio.setMinVolume(0);
        radio.setCurrentVolume(54);
        radio.increaseCurrentVolume();
        assertEquals(55, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        radio.setMaxVolume(100);
        radio.setMinVolume(0);
        radio.setCurrentVolume(78);
        radio.decreaseCurrentVolume();
        assertEquals(77, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeOverMax() {
        radio.setMaxVolume(100);
        radio.setMinVolume(0);
        radio.setCurrentVolume(100);
        radio.increaseCurrentVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeUnderMin() {
        Radio radio = new Radio();
        radio.setMaxVolume(100);
        radio.setMinVolume(0);
        radio.setCurrentVolume(0);
        radio.decreaseCurrentVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}






