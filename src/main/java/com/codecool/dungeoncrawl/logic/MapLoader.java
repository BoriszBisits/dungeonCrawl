package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.*;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case 'k':
                            cell.setType(CellType.KEY);
                            break;
                        case 'w':
                            cell.setType(CellType.SWORD);
                            break;

                        case 'g':
                            cell.setType(CellType.GATE);
                            break;
                        case 'h':
                            cell.setType(CellType.Health);
                            break;
                        case 't':
                            cell.setType(CellType.TRESURE);
                            break;
                        case 'p':
                            cell.setType(CellType.POTION);
                            break;
                        case 'n':
                            cell.setType(CellType.NOPOTION);
                            break;
                        case 'd':
                            cell.setType(CellType.FLOOR);
                            map.setDevil(new Devil(cell));
                            break;
                        case 'b':
                            cell.setType(CellType.FLOOR);
                            map.setBoss(new Boss(cell));
                            break;
                        case 'o':
                            cell.setType(CellType.OPENGATE);
                            break;
                        case 'c':
                            cell.setType(CellType.Bridge);
                            break;
                        case 'q':
                            cell.setType(CellType.FLOOR);
                            map.setSkull(new Skull(cell));
                            break;
                        case 'v':
                            cell.setType(CellType.WATER);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            new Skeleton(cell);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
