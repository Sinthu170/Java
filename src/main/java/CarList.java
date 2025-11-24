import java.util.List;

public class CarList {

    private List<Auto> autos;

    // Standard-Konstruktor für Jackson
    public CarList() {}

    // Konstruktor mit Liste
    public CarList(List<Auto> autos) {
        this.autos = autos;
    }

    // Getter / Setter
    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    @Override
    public String toString() {
        return autos.toString();
    }
}