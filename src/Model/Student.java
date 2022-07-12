package Model;

public class Student {
    private String stuid;
    private String StuName;
    private String Email;
    private String Contact;
    private String address;
    private String nic;

    public Student() {
    }

    public Student(String stuid, String stuName, String email, String contact, String address, String nic) {
        this.stuid = stuid;
        StuName = stuName;
        Email = email;
        Contact = contact;
        this.address = address;
        this.nic = nic;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuid='" + stuid + '\'' +
                ", StuName='" + StuName + '\'' +
                ", Email='" + Email + '\'' +
                ", Contact='" + Contact + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}
