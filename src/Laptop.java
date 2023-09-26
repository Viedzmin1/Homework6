public class Laptop {
    private String name;
    private Integer ram;
    private Integer ssd;
    private String operationSystem;
    private String color;

    public Laptop(String name, Integer ram, Integer ssd, String operationSystem, String color) {
        this.name = name;
        this.ram = ram;
        this.ssd = ssd;
        this.operationSystem = operationSystem;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Название: " + name  + "\nОперативная память:" + ram + "\nОбъем жесткого диска:" + ssd
                + "\nОперационная система: " + operationSystem + "\nЦвет:" + color;
    }

    public String getName() {
        return name;
    }

    public Integer getRam() {
        return ram;
    }

    public Integer getSsd() {
        return ssd;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public String getColor() {
        return color;
    }

}
