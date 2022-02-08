package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Radio {
    private int amountStation = 10;
    private int currentStation;
    private int currentVolume;

//    public Radio() {
//
//    }
//
//    public Radio(int amountStation) {
//        this.amountStation = amountStation;
//    }
//
//    public int getCurrentStation() {
//        return this.currentStation;
//    }
//
    public int setCurrentStation(int CurrentStation) {
        if (CurrentStation > amountStation - 1) {
            return 0;
        }
        if (CurrentStation < 0) {
            return 9;
        }
        return this.currentStation = CurrentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < 0) {
            return;
        }
        if (currentVolume > 100) {
            return;
        }

        this.currentVolume = currentVolume;
    }

    public void nextStation() {
        if (currentStation < amountStation - 1) {
            currentStation = currentStation + 1;
            return;
        } else {
            this.currentStation = 0;
        }
    }

    public void prevStation() {
        if (currentStation > 0) {
            currentStation = currentStation - 1;
            return;
        } else {
            this.currentStation = 9;
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
        if (currentVolume == 100) {
            currentVolume = 100;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
        if (currentVolume == 0) {
            currentVolume = 0;
        }
    }
}