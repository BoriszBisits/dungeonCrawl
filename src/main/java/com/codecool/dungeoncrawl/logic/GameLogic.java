package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.Skeleton;

public class GameLogic {
    public void setMap(GameMap map) {
        this.map = map;
    }

    private GameMap map;

    public GameLogic() {
        this.map = MapLoader.loadMap();
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {

    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }

    public String getPlayerSword() {
        return Integer.toString(map.getPlayer().getSword());
    }

    public String getPlayerKey() {
        return Integer.toString(map.getPlayer().getKey());
    }
    public String getPlayerTresure() {
        return Integer.toString(map.getPlayer().getTresure());
    }
    public String getPlayerPotion() {
        return Integer.toString(map.getPlayer().getPotion());
    }


    public GameMap getMap() {
        return map;
    }
}
