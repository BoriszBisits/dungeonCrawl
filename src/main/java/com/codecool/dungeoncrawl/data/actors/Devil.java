package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.ui.UI;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Devil extends Actor {

    private Random random = new Random();
    private Timer timer;
    private Movement movement;

    public Devil(Cell cell) {
        super(cell, 30, 5);
        timer = new Timer();
        movement = new Movement();


    }









    public void devilMove() {

        int randomNumber = random.nextInt(4);
        if(cell!=null) {
            switch (randomNumber) {
                case 0:
                    cell = movement.moveUp(cell, this);
                    break;

                case 1:
                    cell = movement.moveDown(cell, this);
                    break;

                case 2:
                    cell = movement.moveLeft(cell, this);
                    break;

                case 3:
                    cell = movement.moveRight(cell, this);
                    break;
            }
        }
    }




    public void moveDvil() {
        devilMove();
    }

    @Override
    public String getTileName() {
        return "devil";
    }
}
