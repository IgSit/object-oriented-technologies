package model;

import java.io.ByteArrayInputStream;
import java.util.UUID;

import javafx.beans.property.*;
import javafx.scene.image.Image;


public class Photo {

    private final StringProperty name;

    private final SimpleObjectProperty<Image> photoData;

    public Photo(String extension, byte[] photoData) {
        this.photoData = new SimpleObjectProperty<>(new Image(new ByteArrayInputStream(photoData)));
        this.name = new SimpleStringProperty(UUID.randomUUID() + "." + extension);
    }

    public String getName() {
        return name.getName();
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public Image getPhotoData() {
        return photoData.getValue();
    }

    public ReadOnlyObjectProperty<Image> getPhotoDataProperty() {
        return photoData;
    }
}
