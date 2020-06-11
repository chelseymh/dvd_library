package Classes;

public class Member {
    private String firstName, lastName, userName, residentialAddress, contactNumber;
    private int password;
    private Movie[] borrowedDVDs;
    private int borrowedDVDsCount;

    public Member() {
        firstName = new String("");
        lastName = new String("");
        userName = new String("");
        residentialAddress = new String("");
        contactNumber = new String("");
        password = 0;
        borrowedDVDs = null;
        borrowedDVDsCount = 0;
    }
    public Member(String firstName, String lastName, String userName, String residentialAddress,
                  String contactNumber, int password, Movie[] borrowedDVDs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.residentialAddress = residentialAddress;
        this.contactNumber = contactNumber;
        this.password = password;
        this.borrowedDVDs = borrowedDVDs;
        this.borrowedDVDsCount = 0;
    }
    public void PrintBorrowedDvds() {
        System.out.println("========= Movies currently borrowed by: " + getUserName() + " =========\n");
        for (int i = 0; i < borrowedDVDsCount; i++) {
            System.out.println("Movie Titled: " + borrowedDVDs[i].getMovieTitle() + ", Starring: " + borrowedDVDs[i].getStarring() +
                    ", Directed by: " + borrowedDVDs[i].getDirector() + ", Duration of: " + borrowedDVDs[i].getDuration() +
                    " minutes, Genre: " + borrowedDVDs[i].getGenre() + ", Classification: " + borrowedDVDs[i].getClassification() +
                    ", Released: " + borrowedDVDs[i].getReleaseDate() + "\n");
        }
    }

    @Override
    public String toString() {
        return(String.format(firstName, lastName));
    }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getUserName() { return userName; }
    public String getFullName() { return firstName + " " + lastName; }
    public String getResidentialAddress() { return residentialAddress; }
    public String getContactNumber() { return contactNumber; }
    public int getPassword() { return password; }
    public Movie[] getBorrowedDVDs() { return borrowedDVDs; }
    public void setBorrowedDVDs(Movie movie) { this.borrowedDVDs[borrowedDVDsCount] = movie; }
    public int getBorrowedDVDsCount() { return borrowedDVDsCount; }
    public void increaseBorrowedDVDsCount() { this.borrowedDVDsCount++; }
    public void decreaseBorrowedDVDsCount() { this.borrowedDVDsCount--; }
    public void nullifyBorrowedDVD(int count) { this.borrowedDVDs[count] = null; }
}
