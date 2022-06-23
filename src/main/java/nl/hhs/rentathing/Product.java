package nl.hhs.rentathing;

public class Product implements IDatabase{

    public String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
