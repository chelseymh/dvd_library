package MenuNav;

import Classes.Member;
import Classes.MemberCollection;
import Classes.Movie;
import Classes.MovieCollection;

public class MainMenu {
    MovieCollection b = new MovieCollection();
    public Boolean loggedIn;
    public Member memberLoggedIn;

    public void PrintMainMenu() {
        String mainMenText = ("\nWelcome to the community library!\n" +
                "======== Menu Selection ========\n" +
                "1.\t Staff Menu\n" +
                "2.\t Member Menu\n" +
                "0.\t Exit\n" +
                "================================\n");
        System.out.println(mainMenText);
    }
    public void DummyMembers() {
        Member janeSmith = new Member("Jane", "Smith", "janesmith", "44 Random Street", "0411111111", 1234, new Movie[10]);
        Member JohnSmith = new Member("John", "Smith", "johnsmith", "88 London Ave", "0411111111", 1234, new Movie[10]);
        Member emilyPower = new Member("Emily", "Power", "emilypower", "66 Bell Cresent", "0411111111", 1234, new Movie[10]);
        Member AudreyNiffenegger = new Member("Audrey", "Niffenegger", "audreyniffenegger", "123 Fake Street", "0402024421", 1234, new Movie[10]);
        Member MarkManson = new Member("Mark", "Manson", "markmanson", "U9/99 Cornell Court", "0411111111", 1234, new Movie[10]);
        MemberCollection.memberInstance.addMember(janeSmith);
        MemberCollection.memberInstance.addMember(JohnSmith);
        MemberCollection.memberInstance.addMember(emilyPower);
        MemberCollection.memberInstance.addMember(AudreyNiffenegger);
        MemberCollection.memberInstance.addMember(MarkManson);
    }
    public void DummyMovies() {
        Movie interstellarMovie = new Movie("Interstellar", "Matthew McConaughey", "Christopher Nolan",
                "SciFi", "M", 154, "09-07-14", 0);
        Movie annihilationMovie = new Movie("Annihilation", "Natalie Portman", "Alex Garland",
                "SciFi", "M", 128, "13-02-18", 0);
        Movie spaceOdysseyMovie = new Movie("2001 Space Odyssey", "Keir Dullea", "Stanley Kubrick",
                "SciFi", "M", 149, "02-05-68", 0);
        Movie pulpFictionMovie = new Movie("Pulp Fiction", "Tim Roth", "Quentin Tarantino",
                "Drama", "MA", 155, "24-11-94", 0);
        Movie princessBrideMovie = new Movie("Princess Bride", "Cary Elwes", "Rob Reiner",
                "Adventure", "PG", 158, "03-12-87", 0);
        Movie DonnieDarkoMovie = new Movie("Donnie Darko", "Jake Gyllenhaal", "Richard Kelly",
                "Drama", "M", 123, "17-10-02", 0);
        Movie ParasiteMovie = new Movie("Parasite", "Kang-ho Song", "Bong Joon Ho",
                "Thriller", "MA", 132, "30-05-19", 0);
        Movie NineteenSeventeenMovie = new Movie("1917", "Dean-Charles Chapman", "Sam Mendes",
                "Drama", "MA", 144, "16-01-20", 0);
        Movie JokerMovie = new Movie("Joker", "Joaquin Phoenix", "Todd Phillips",
                "Thriller", "MA", 162, "03-10-19", 0);
        Movie ShawshankRedemptionMovie = new Movie("Shawshank Redemption", "Tim Robbins", "Frank Darabont",
                "Drama", "MA", 122, "16-02-95", 0);
        Movie ForrestGumpMovie = new Movie("Forrest Gump", "Tom Hanks", "Robert Zemeckis",
                "Drama", "M", 142, "17-11-94", 0);
        Movie BladeRunnerMovie = new Movie("Blade Runner", "Harrison Ford", "Ridley Scott",
                "Action", "MA", 157, "16-12-82", 0);
        Movie AlienMovie = new Movie("Alien", "Sigourney Weaver", "Ridley Scott",
                "Sci-Fi", "MA", 177, "6-12-79", 0);
        Movie TerminatorMovie = new Movie("The Terminator", "Arnold Schwarzenegger", "James Cameron",
                "Sci-Fi", "R", 128, "20-12-84", 0);
        Movie StarWarsMovie = new Movie("Star Wars Episode VI", "Mark Hamil", "Richard Marquand",
                "Sci-Fi", "M", 137, "27-10-83", 0);
        Movie MarriageStoryMovie = new Movie("Marriage Story", "Adam Driver", "Noah Baumbach",
                "Drama", "M", 147, "06-12-19", 0);
        b.Insert(annihilationMovie);
        b.Insert(interstellarMovie);
        b.Insert(spaceOdysseyMovie);
        b.Insert(pulpFictionMovie);
        b.Insert(princessBrideMovie);
        b.Insert(DonnieDarkoMovie);
        b.Insert(ParasiteMovie);
        b.Insert(JokerMovie);
        b.Insert(NineteenSeventeenMovie);
        b.Insert(ShawshankRedemptionMovie);
        b.Insert(ForrestGumpMovie);
        b.Insert(BladeRunnerMovie);
        b.Insert(AlienMovie);
        b.Insert(TerminatorMovie);
        b.Insert(StarWarsMovie);
        b.Insert(MarriageStoryMovie);
    }
    public void StaffLogin() {
        String staffUsername = "staff";
        String staffPassword = "today123";
        String username, password;
        System.out.println("========== Please enter login details ==========\n");
        username = InputListener.readString("Enter staff username: \n");
        password = InputListener.readString("Enter staff password: \n");
        if (username.equals(staffUsername) && password.equals(staffPassword)) {
            loggedIn = true;
        } else {
            System.out.println("Staff login incorrect! Please use username: staff, password: today123");
            loggedIn = false;
        }
    }
    public void MemberLogin() {
        System.out.println("========== Please enter login details ==========\n");
        while (true) {
            String username = InputListener.readString("Enter member username: \n");
            int password = InputListener.readPassword("Enter member password: \n");
            for (Member m : MemberCollection.memberInstance.memberList) {
                if (m != null) {
                    if (username.equalsIgnoreCase(m.getUserName()) && password == m.getPassword()) {
                        loggedIn = true;
                        memberLoggedIn = m;
                        break;
                    }
                } else break;
            }
            if (!loggedIn) System.out.println("Invalid login details or user does not exist!");
            break;
        }
        return;
    }

    public void BuildMainMenu() {
        StaffMenu staffMenu = new StaffMenu();
        MemberMenu memberMenu = new MemberMenu();
        DummyMembers();
        DummyMovies();
        int selectionVal;
        do {
            loggedIn = false;
            PrintMainMenu();
            selectionVal = InputListener.scanInt("Please make a selection (1-2, or 0 to exit): ");
            switch (selectionVal) {
            case 1:
                StaffLogin();
                if (loggedIn) {
                    staffMenu.BuildStaffMenu(b);
                    break;
                } else {
                    break;
                }
            case 2:
                if (MemberCollection.memberInstance.memberCounter != 0) {
                    MemberLogin();
                    if (loggedIn) {
                        memberMenu.BuildMemberMenu(memberLoggedIn, b);
                        break;
                    } else {
                        break;
                    }
                } else {
                System.out.println("No Members currently in the database!");
                break;
            }
            case 0:
                System.out.println("Exit selected");
                break;
            default:
                System.out.println("Invalid selection");
            }
        } while (selectionVal != 0);
    }
}
