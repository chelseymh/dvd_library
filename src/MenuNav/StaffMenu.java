package MenuNav;

import Classes.Member;
import Classes.MemberCollection;
import Classes.Movie;
import Classes.MovieCollection;

public class StaffMenu {
    public void AddMovie(MovieCollection b) {
        String movieTitle, starring, director, genre, classification, releaseDate;
        int duration;
        System.out.println("========= Adding a DVD =========\n");
        movieTitle = InputListener.readString("Please enter the title of the movie: \n");
        starring = InputListener.readString("Please enter who stars in the movie: \n");
        director = InputListener.readString("Who directed the movie: \n");
        genre = InputListener.readGenre("What genre is the movie (Drama, Adventure, Family, " +
                "Action, Sci-Fi, Comedy, Animated, Thriller, or Other): \n");
        classification = InputListener.readClassification("What is the classification (G, PG, M, MA): \n");
        duration = InputListener.scanInt("What is the duration of the movie in minutes: \n");
        releaseDate = InputListener.readDate("When was the movie released (DD-MM-YY): \n");
        Movie movie = new Movie(movieTitle, starring, director, genre, classification, duration, releaseDate, 0);
        b.Insert(movie);
        System.out.println("Movie added to the database... \n");
        System.out.println("Movies currently in the database... \n");
        b.InOrderTraverse();
    }
    public void RemoveMovie(MovieCollection b) {
        String movieToRemove;
        System.out.println("======== Removing a DVD ========\n");
        b.InOrderTraverse();
        while (true) {
            movieToRemove = InputListener.readString("Please select a DVD to remove using the movie title (exact spelling and case required): \n");
            if (b.Search(movieToRemove)) {
                Movie movieObjectToRemove = b.SearchMovies(movieToRemove, b.root);
                b.Delete(movieObjectToRemove);
                System.out.println("Movie has been successfully deleted!");
                b.InOrderTraverse();
                break;
            } else {
                System.out.println("Movie does not exist. Please try again...");
            }
        }
        System.out.println("Movie removed from the database... \n");
    }
    public void RegisterNewMember() {
        String firstName, lastName, residentialAddress, contactNumber;
        int password;
        System.out.println("========= Adding a member =========\n");
        firstName = InputListener.readString("Please enter member's first name: \n");
        lastName = InputListener.readString("Please enter member's last name: \n");
        residentialAddress = InputListener.readString("Please enter member's residential address: \n");
        contactNumber = InputListener.readString("Please enter member's contact number: \n");
        password = InputListener.readPassword("Please enter member's pass code (4 numerical digits): \n");
        Member member = new Member(firstName, lastName, firstName + lastName, residentialAddress, contactNumber, password, new Movie[10]);
        MemberCollection.memberInstance.addMember(member);
        System.out.println("Member added to the database... \n");
        System.out.println("Members currently in the database... \n");
        MemberCollection.memberInstance.printAllMembers();
    }
    public void FindRegisteredUser() {
        String fullName;
        Boolean found = false;
        System.out.println("========= Finding a member =========\n");
        while (true) {
            fullName = InputListener.readString("Enter member's full name to find their contact number: \n");
            for (Member m: MemberCollection.memberInstance.memberList) {
                if (m != null) {
                    if (m.getFullName().equalsIgnoreCase(fullName)) {
                        System.out.println("Member: " + m.getFullName()
                                + ", Contact number: " + m.getContactNumber());
                        found = true;
                        break;
                    }
                } else break;
            }
            if (!found) System.out.println("Unable to find user.");
            break;
        }
    }
    public void PrintStaffMenu() {
        String mainMenText = ("========== Staff Menu ==========\n" +
                "1.\t Add a new movie DVD\n" +
                "2.\t Remove a movie DVD\n" +
                "3.\t Register a new Member\n" +
                "4.\t Find a registered phone number using Member's full name\n" +
                "0.\t Log out & return to main menu\n" +
                "================================\n");
        System.out.println(mainMenText);
    }
    public void BuildStaffMenu(MovieCollection b) {
        int selectionVal;
        do {
            PrintStaffMenu();
            selectionVal = InputListener.scanInt("Please make a selection (1-4, or 0 to return to the main menu): ");
            switch (selectionVal) {
            case 1: //Add a movie
                AddMovie(b);
                break;
            case 2: // Remove a movie
                RemoveMovie(b);
                break;
            case 3: // Register new member
                RegisterNewMember();
                break;
            case 4: // Find a registered Member by phone number
                FindRegisteredUser();
                break;
            case 0:
                System.out.println("Staff: Exit selected");
                break;
            default:
                System.out.println("Invalid selection");
                break;
            }
        } while (selectionVal != 0);
    }
}