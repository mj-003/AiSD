class Student implements Comparable<Student> {
    private int id;
    private String firstName;
    private String lastName;

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.id, o.id);
    }
}
