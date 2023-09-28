package info3.game;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {
    private static ConfigReader instance;
    private ConfigData config;

    private ConfigReader() {
        loadConfig();
    }

    public static ConfigReader getInstance() {
        if (instance == null) {
            synchronized (ConfigReader.class) {
                if (instance == null) {
                    instance = new ConfigReader();
                }
            }
        }
        return instance;
    }

    private void loadConfig() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("configJeu.json")) {
            config = gson.fromJson(reader, ConfigData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getRedPlayer() {
        return config.path + config.redplayer;
    }

    public String getBluePlayer() {
        return config.path + config.blueplayer;
    }

    public String getBat() {
        return config.path + config.bat;
    }

    public String getArrow() {
        return config.path + config.arrow;
    }

    public String getLooter() {
        return config.path + config.looter;
    }

    public String getSnake() {
        return config.path + config.snake;
    }

    public String getStone() {
        return config.path + config.stone;
    }

    public String getCoin() {
        return config.path + config.coin;
    }

    public String getBush() {
        return config.path + config.bush;
    }

    public String getDoor() {
        return config.path + config.door;
    }

    public String getWall() {
        return config.path + config.wall;
    }

    public String getFireball() {
        return config.path + config.fireball;
    }

    public String getShuriken() {
        return config.path + config.shuriken;
    }
    public String getHole() {
        return config.path + config.hole;
    }
//    public String getValue(String key) {
//        return config != null ? config.getValue(key) : null;
//    }

    public static void main(String[] args) {
        ConfigReader configReader = ConfigReader.getInstance();

        // Do something with the values
        System.out.println("Path: " + configReader.getArrow());
        System.out.println("Red Player: " + configReader.getRedPlayer());
        System.out.println("Blue Player: " + configReader.getBluePlayer());
        // ... continue printing the rest of the values
    }

    private static class ConfigData {
        private String path;
        private String redplayer;
        private String blueplayer;
        private String bat;
        private String arrow;
        private String looter;
        private String snake;
        private String stone;
        private String coin;
        private String bush;
        private String door;
        private String wall;
        private String fireball;
        private String shuriken; 
        private String hole;

        public String getValue(String key) {
            switch (key) {
                case "path":
                    return path;
                case "redplayer":
                    return redplayer;
                case "blueplayer":
                    return blueplayer;
                case "bat":
                    return bat;
                case "arrow":
                    return arrow;
                case "looter":
                    return looter;
                case "snake":
                    return snake;
                case "stone":
                    return stone;
                case "coin":
                    return coin;
                case "bush":
                    return bush;
                case "door":
                    return door;
                case "wall":
                    return wall;
                case "fireball":
                    return fireball;
                case "shuriken":
                    return shuriken; 
                case "hole": 
                	return hole;
                default:
                    return null;
            }
        }
    }
}
