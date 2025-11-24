import com.fasterxml.jackson.annotation.JacksonAnnotation;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private int id;
    private String name;
    private int height;

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

}