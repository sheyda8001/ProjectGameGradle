package configRelated;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ConfigLoader {
    private static ConfigLoader loader;
    private String addressName;
    private HashMap<String, Configs> addressess;
    private static String defaultAddress = "resources\\configFiles\\MainConfigFile";
    private HashMap<String, Configs> collections;
    private HashMap<String, Configs> menu;
    private HashMap<String, Configs> mainFrame;
    private HashMap<String, Configs> play;
    private HashMap<String, Configs> store;
    private HashMap<String, Configs> status;
    private HashMap<String, Configs> propeties;
    private HashMap<String, Configs> panel;

    private ConfigLoader(String address) {
        initialize(address);
    }

    public static ConfigLoader getInstance() {
        return getInstance("default");
    }

    private void initialize(String address) {
        FileReader reader;
        addressName = "RESOURCE_URL";
        mainFrame = new HashMap<>();
        menu = new HashMap<>();
        addressess = new HashMap<>();
        store = new HashMap<>();
        status = new HashMap<>();
        play = new HashMap<>();
        propeties = new HashMap<>();
        collections = new HashMap<>();
        panel = new HashMap<>();

        try {
            Configs addresses = new Configs();
            reader = new FileReader(address);
            addresses.load(reader);
            this.addressess.put(addressName, addresses);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("main config file doesn't exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadProperties();
    }

    private void loadProperties() {
        Set<Entry<Object, Object>> entries = addressess.get("RESOURCE_URL").entrySet();
        for (Entry entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        for (Entry<Object, Object> entry : entries) {
            String adrs = (String) entry.getValue();
            String key = (String) entry.getKey();
            String lowerCase = key.toLowerCase();
            if (!lowerCase.contains("url")) {
                Configs property = new Configs();
                try {
                    File test = new File(adrs);
                    System.out.println(test.getAbsolutePath());
                    FileReader reader = new FileReader(test);
                    property.load(reader);

                } catch (FileNotFoundException e) {
                    System.out.println(entry.getKey() + " file doesn't exist");
                    e.printStackTrace();
                } catch (IOException e) {
                    System.out.println(entry.getKey() + " load failed");
                    e.printStackTrace();
                }

                if (lowerCase.contains("play")) {
                    System.out.println("play added : " + key);
                    play.put(key, property);
                } else if (lowerCase.contains("status")) {
                    System.out.println("status added : " + key);
                    status.put(key, property);
                } else if (lowerCase.contains("collection")) {
                    System.out.println("collections added : " + key);
                    collections.put(key, property);

                }else if (lowerCase.contains("store")) {
                    System.out.println("store added : " + key);
                    store.put(key, property);
                }else if (lowerCase.contains("menu")) {
                    System.out.println("menu added : " + key);
                    menu.put(key, property);
                }else if (lowerCase.contains("frame")) {
                    System.out.println("main frame added : " + key);
                    mainFrame.put(key, property);
                }else if(lowerCase.contains("panel")){
                    System.out.println("panel added : " + key);
                    panel.put(key, property);
                }
                else
                    propeties.put(key, property);
            }
        }
        System.out.println("loading finished! ");
    }

    public static ConfigLoader getInstance(String address) {
        if (loader == null) {
            if (address.equals("default")) {
                address = defaultAddress;
            }
            loader = new ConfigLoader(address);
        }
        return loader;
    }



    public String getAddress(String type, String resource_url) {
        return addressess.get(type).getProperty(resource_url);
    }

    public String getAddress(String resource_url) {
        return getAddress(addressName, resource_url);
    }

    protected Configs getFrameProperties(String name) {
        return mainFrame.get(name);
    }
    protected Configs getPanelProperties(String name) {
        return panel.get(name);
    }
    protected Configs getStoreProperties(String name) {
        return store.get(name);
    }
    protected Configs getCollectionProperties(String name) {
        return collections.get(name);
    }
    protected Configs getMenuProperties(String name) {
        return menu.get(name);
    }
    protected Configs getStatusProperties(String name) {
        return status.get(name);
    }
    protected Configs getPlayProperties(String name) {
        return play.get(name);
    }
}