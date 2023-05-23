public class Notebook {
    private String serialNumber;
    private String color;
    private String brand;
    private String model;
    private String os;
    private int hdd;
    private int ram;
    private Double price;

    // Ниже геттеры и сеттеры
    public void setBrand(String nameBrand) {
        this.brand = nameBrand;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setModel(String nameModel) {
        this.model = nameModel;
    }

    public String getModel() {
        return this.model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOs() {
        return this.os;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getRam() {
        return this.ram;
    }

    public void setHdd(Integer hdd) {
        this.hdd = hdd;
    }

    public Integer getHdd() {
        return this.hdd;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }

    // Пустой конструктур
    public Notebook() {
        this.brand = "No name";
        this.model = "No model";
        this.os = "free";
        this.ram = 0;
        this.hdd = 0;
        this.serialNumber = "no number";
        this.color = "no color";
        this.price = 0.0;
    }

    // Перегрузка конструктора с параметрами
    public Notebook(String brand, String model, Integer ram, Integer hdd, String os, String color, String serialNumber, Double price) {
        this.brand = brand;
        this.model = model;
        this.os = os;
        this.ram = ram;
        this.hdd = hdd;
        this.serialNumber = serialNumber;
        this.color = color;
        this.price = price;
    }

    // Переопределение метода для вывода на печать экземпляра ноутбука
    @Override
    public String toString() {
        return String.format("Brand: %s, model name: %s, ram: %d GB, HDD: %d GB, OS: %s, color: %s, serial: %s, price: %.2f", 
        this.brand, this.model, this.ram, this.hdd, this.os, this.color, this.serialNumber, this.price);
    }
}
