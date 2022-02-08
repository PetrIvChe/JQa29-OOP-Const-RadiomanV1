package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();
    // Boundaries for station is -1, 0 , 1, 8, 9, 10

    @Test
    public void shouldReturnNextStation1IfCurrentStation0() {
        radio.setCurrentStation(0);
        radio.nextStation();
        int expected = 1;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNextStation2IfCurrentStation1() {
        radio.setCurrentStation(1);
        radio.nextStation();
        int expected = 2;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNextStation9IfCurrentStation8() {
        radio.setCurrentStation(8);
        radio.nextStation();
        int expected = 9;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNextStation0IfCurrentStation9() {
        radio.setCurrentStation(9);
        radio.nextStation();
        int expected = 0;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNextStation0IfCurrentStation10() {
        radio.setCurrentStation(10);
        radio.nextStation();
        int expected = 1;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldReturnNextStation1IfCurrentStationMinus1() {
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
        radio.setCurrentStation(currentStation);
        radio.nextStation();
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPrevious9IfCurrentStationIs0() {
        radio.setCurrentStation(0);
        radio.prevStation();
        int expected = 9;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPreviousStation0IfCurrentStationIs1() {
        radio.setCurrentStation(1);
        radio.prevStation();
        int expected = 0;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPreviousStation7IfCurrentStationIs8() {
        radio.setCurrentStation(8);
        radio.prevStation();
        int expected = 7;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldReturnPreviousStation8IfCurrentStationIs9() {
        radio.setCurrentStation(9);
        radio.prevStation();
        int expected = 8;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPreviousStation1IfCurrentStation9() {
        radio.setCurrentStation(10);
        radio.prevStation();
        int expected = 9;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }
    //Equivalence partitioning 5

    @Test
    public void shouldReturnPreviousStation4IfCurrentStationIs5() {
        radio.setCurrentStation(5);
        radio.prevStation();
        int expected = 4;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    //negative test
    @Test
    public void shouldReturnPreviousStation9IfCurrentStationIsMinus1() {
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
                    "Boundaries 99, 99 , 100",
                    "Boundaries 100, 100 , 100",
                    "Boundaries 101, 101,1",
                    "Equivalence partitioning 49 , 49, 50",
                    "Equivalence partitioning 50 , 50, 51",
                    "Negative test -1, -1 , 1",
                    "Unexpected entry data 500, 500, 1"
            }
    )

    public void ShouldReturnIncreaseVolumeIfCurrentVolumeI(String testName, int currentVolume, int expected) {
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
                    "Boundaries 99, 99 , 98",
                    "Boundaries 100, 100 , 99",
                    "Boundaries101, 101, 0",
                    "Equivalence partitioning 49 , 49, 48",
                    "Equivalence partitioning 50 , 50, 49",
                    "Negative -1, 0, 0",
                    "Unexpected 404, 404,0"

            }
    )
    public void shouldReturnDecreaseVolumeIfCurrentVolumeI(String testName, int currentVolume, int expected) {
        radio.setCurrentVolume(currentVolume);
        radio.decreaseVolume();
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

}