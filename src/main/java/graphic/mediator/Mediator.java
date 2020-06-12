package graphic.mediator;

import graphic.Components;
import graphic.mainPanel.MainPanel;

public interface Mediator {
//    void addNewNote(Note note);
//    void deleteNote();
//    void getInfoFromList(Note note);
//    void saveChanges();
//    void markNote();
//    void clear();
//    void sendToFilter(ListModel listModel);
//    void setElementsList(ListModel list);
     void registerComponent(Components component);
//    void hideElements(boolean flag);
    void createGUI(MainPanel panel);
}
