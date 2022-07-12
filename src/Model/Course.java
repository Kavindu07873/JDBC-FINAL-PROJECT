package Model;

public class Course {
    private String  id;
    private String name;
    private String cost;
    private String duration;
    private String sub_id;

    public Course() {
    }

    public Course(String id, String name, String cost, String duration, String sub_id) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.duration = duration;
        this.sub_id = sub_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cost='" + cost + '\'' +
                ", duration='" + duration + '\'' +
                ", sub_id='" + sub_id + '\'' +
                '}';
    }
}
