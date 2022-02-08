package ru.netology.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    // Boundaries for station is -1, 0 , 1, 8, 9, 10

    @Test
    public void shouldReturnNextStation1IfCurrentStation0() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.nextStation();
        int expected = 1;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNextStation2IfCurrentStation1() {
        Radio radio = new Radio();
        radio.setCurrentStation(1);
        radio.nextStation();
        int expected = 2;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNextStation9IfCurrentStation8() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);
        radio.nextStation();
        int expected = 9;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNextStation0IfCurrentStation9() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.nextStation();
        int expected = 0;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNextStation0IfCurrentStation10() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);
        radio.nextStation();
        int expected = 1;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldReturnNextStation1IfCurrentStationMinus1() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        radio.nextStation();
        int expected = 1;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Boundaries -1, -1 , 1",
                    "Boundaries 0, 0 , 1",
                    "Boundaries 1, 1 , 2",
                    "Boundaries 8, 8 , 9",
                    "Boundaries 9, 9 , 0",
                    "Boundaries 10, 10 , 1",
                    "Equivalence partitioning 4 , 4, 5",
                    "Equivalence partitioning 5 , 5, 6"
            }
    )

    public void shouldReturnNextStation(String testName, int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);
        radio.nextStation();
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPrevious9IfCurrentStationIs0() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prevStation();
        int expected = 9;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPreviousStation0IfCurrentStationIs1() {
        Radio radio = new Radio();
        radio.setCurrentStation(1);
        radio.prevStation();
        int expected = 0;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPreviousStation7IfCurrentStationIs8() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);
        radio.prevStation();
        int expected = 7;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldReturnPreviousStation8IfCurrentStationIs9() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.prevStation();
        int expected = 8;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPreviousStation1IfCurrentStation9() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);
        radio.prevStation();
        int expected = 9;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }
    //Equivalence partitioning 5

    @Test
    public void shouldReturnPreviousStation4IfCurrentStationIs5() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.prevStation();
        int expected = 4;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    //negative test
    @Test
    public void shouldReturnPreviousStation9IfCurrentStationIsMinus1() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        radio.prevStation();
        int expected = 9;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource(
            value = {
                    "Boundaries -1, -1 , 9",
                    "Boundaries 0, 0 , 9",
                    "Boundaries 1, 1 , 0",
                    "Boundaries 8, 8 , 7",
                    "Boundaries 9, 9 , 8",
                    "Boundaries 10, 10 , 9",
                    "Equivalence partitioning 4 , 4, 3",
                    "Equivalence partitioning 5 , 5, 4"
            }
    )
    public void shouldReturnPrevStation(String testName, int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);
        radio.prevStation();
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Boundaries 0, 0 , 1",
                    "Boundaries 1, 1 , 2",
                    "Boundaries 9, 9 , 10",
                    "Boundaries 10, 10 , 10",
                    "Boundaries11, 11,1",
                    "Equivalence partitioning 4 , 4, 5",
                    "Equivalence partitioning 5 , 5, 6",
                    "Negative test -1, -1 , 1",
            }
    )

    public void ShouldReturnIncreaseVolumeIfCurrentVolumeI(String testName, int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "Boundaries 0, 0 , 0",
                    "Boundaries 1, 1 , 0",
                    "Boundaries 9, 9 , 8",
                    "Boundaries 10, 10 , 9",
                    "Boundaries11, 11, 0",
                    "Equivalence partitioning 4 , 4, 3",
                    "Equivalence partitioning 5 , 5, 4",
                    "Negative -1, 0, 0"

            }
    )
    public void shouldReturnDecreaseVolumeIfCurrentVolumeI(String testName, int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);
        radio.decreaseVolume();
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

}