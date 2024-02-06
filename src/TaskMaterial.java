public class TaskMaterial {
    public static void main(String[] args) {

        int v =5;

        System.out.println(v);
    }
}
class Material {
    private String name;
    private int density;

    public Material(String name, int density) {
        this.name = name;
        this.density = density;
    }

    public String getName() {
        return name;
    }

    public int getDensity() {
        return density;
    }
}

class Thing{
    private String name;
    private Material material;
    private double volume;

    public Thing(String name, Material material, double volume) {
        this.name = name;
        this.material = material;
        this.volume = volume;
    }

    public Thing() {
    }

    double getMass(){
        return volume*material.getDensity();
    }

    void show(){
        System.out.println(name+";"+material.getName()+";"+material.getDensity()+";"+volume+getMass());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}