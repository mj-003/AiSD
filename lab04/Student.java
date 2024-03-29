public class Student {
    private String firstName;
    private String lastName;
    private String pesel;
    private String index;
    private double averageGrade;
    private int yearOfStudy;

    public Student(String firstName, String lastName, String pesel, String index, double averageGrade, int yearOfStudy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.index = index;
        this.averageGrade = averageGrade;
        this.yearOfStudy = yearOfStudy;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName ;
    }

    public void setLastName(String secondName) {
        this.lastName = secondName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + pesel + " " + index + " " + averageGrade + " " + yearOfStudy;
    }
}
