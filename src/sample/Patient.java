package sample;

public class Patient {

    private String name, address, doa, dob, parts;
    private int count, id;


    public Patient(String name, String address, String doa, String dob, String parts, int count, int id) {
        this.name = name;
        this.address = address;
        this.doa = doa;
        this.dob = dob;
        this.parts = parts;
        this.count = count;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDoa() {
        return doa;
    }

    public void setDoa(String doa) {
        this.doa = doa;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getParts() {
        return parts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
