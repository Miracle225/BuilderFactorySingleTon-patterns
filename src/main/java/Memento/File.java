package Memento;

import java.util.ArrayList;
import java.util.List;

public class File {
    private List<Save> save = new ArrayList<>();

    public void saveAuto(Save save) {
        this.save.add(save);
    }

    public Save CancelAction() {
        this.save.remove(save.size() - 1);
        return this.save.get(save.size() - 1);
    }

    @Override
    public String toString() {
        return "File{" +
                "save=" + save +
                '}';
    }
}
