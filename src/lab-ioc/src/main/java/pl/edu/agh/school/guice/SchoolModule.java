package pl.edu.agh.school.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import pl.edu.agh.school.annotations.Classes;
import pl.edu.agh.school.annotations.Teachers;
import pl.edu.agh.school.persistence.ISerializablePersistenceManager;
import pl.edu.agh.school.persistence.SerializablePersistenceManager;

public class SchoolModule extends AbstractModule {
    @Provides
    public ISerializablePersistenceManager provideISerializablePersistenceManager(SerializablePersistenceManager manager) {
        return manager;
    }

    @Provides
    @Teachers
    protected static String provideTeachersStorageFileName() {
        return "teachers.dat";
    }

    @Provides
    @Classes
    protected static String provideClassStorageFileName() {
        return "classes.dat";
    }
}
