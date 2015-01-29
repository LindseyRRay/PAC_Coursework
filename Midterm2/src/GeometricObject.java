/**
 * Created by lrraymond13 on 11/23/14.
 */
public class GeometricObject {
    private String color;
    private boolean filled;

    public GeometricObject() {
        color = "WHITE";
    }
    public GeometricObject(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color= color;
    }
    public boolean isFilled(){
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public String toString() {
        return "color is "+color+"\n"+"filled = "+filled;
    }

}
