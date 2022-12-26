package task3;

public class ProxyImage implements MyImage{
    private final String filename;
    private RealImage realImage = null;
    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null){
            realImage = new RealImage(filename);
            realImage.display();
        } else{
            realImage.display();
        }
    }
}