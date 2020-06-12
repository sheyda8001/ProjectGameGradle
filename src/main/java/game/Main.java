package game;

import configRelated.ConfigLoader;
import entities.player.Player;
import graphic.FramePanelInterface;
import graphic.entrancePages.entrancePage.EntrancePage;

public class Main {
    public static Player player;

    public static void main(String[] args) {
        Main program = new Main(args);
    }
    public static Player getPlayer() {
        return player;
    }

    public Main(String[] args){
        ConfigLoader urls =ConfigLoader.getInstance(getConfigFile(args));
        FramePanelInterface framePanelInterface=FramePanelInterface.getInstance();
        framePanelInterface.setPanel(new EntrancePage());
    }
    private String getConfigFile(String[] args){
        String configAddress = "default";
        if(args.length > 1){
            configAddress = args[1];
        }else{
            if(System.getenv("HEARTHSTONE_CONFIG")!= null && !System.getenv("HEARTHSTONE_CONFIG").isEmpty()){
                configAddress = System.getenv("HEARTHSTONE_CONFIG");
            }
        }
        return configAddress;
    }
}
