package MenuNav;

import Classes.Member;
import Classes.Movie;
import Classes.MovieCollection;

public class MemberMenu {
    public void PrintMemberMenu(Member member) {
        String mainMenText = ("========== " + member.getFullName() + "'s Member Menu ==========\n" +
                "1.\t Display all movies available to borrow\n" +
                "2.\t Borrow a DVD\n" +
                "3.\t Return a DVD\n" +
                "4.\t List current borrowed DVDs\n" +
                "5.\t List top 10 most borrowed movies\n" +
                "0.\t Log out & return to main menu\n" +
                "================================\n");
        System.out.println(mainMenText);
    }
    public void DisplayAllMovies(MovieCollection b) {
        System.out.println("========== All movies available in the database ==========\n");
        b.InOrderTraverseAvailable();
    }
    public void BorrowMovie(Member member, MovieCollection b) {
        String movieToBorrow;
        System.out.println("========= Borrowing a movie =========\n");
        System.out.println("All movies currently in the database...\n");
        DisplayAllMovies(b);
        while (true) {
            movieToBorrow = InputListener.readString("Please enter the movie title to borrow (exact spelling and case required): \n");
            if (b.Search(movieToBorrow)) {
                Movie movieObjectToBorrow = b.SearchMovies(movieToBorrow, b.root);
                if (movieObjectToBorrow.getCopies() >= 1) {
                    if (member.getBorrowedDVDsCount() != member.getBorrowedDVDs().length) {
                        member.setBorrowedDVDs(movieObjectToBorrow);
                        member.increaseBorrowedDVDsCount();
                        movieObjectToBorrow.setTimesBorrowed();
                        movieObjectToBorrow.removeCopy();
                        System.out.println("Movie has successfully been borrowed. Enjoy!");
                        ListCurrentBorrowedMovies(member);
                        break;
                    }
                } else {
                    System.out.println("Movie is already rented, please select another!");
                }
            } else {
                System.out.println("Movie does not exist. Please try again...");
            }
        }
    }
    public void ReturnMovie(Member member, MovieCollection b) {
        String movieToReturn;
        System.out.println("========= Returning a movie =========\n");
        ListCurrentBorrowedMovies(member);
        while (true) {
            movieToReturn = InputListener.readString("Please enter the movie title to return (exact spelling and case required): \n");
            if (b.Search(movieToReturn)) {
                Movie moveObjectToReturn = b.SearchMovies(movieToReturn, b.root);
                for (int i = 0; i < member.getBorrowedDVDsCount(); i++) {
                    if (member.getBorrowedDVDs()[i].getMovieTitle().compareTo(moveObjectToReturn.getMovieTitle()) == 0) {
                        member.nullifyBorrowedDVD(i);
                        for (int j = 0; j < member.getBorrowedDVDsCount(); j++) {
                            member.getBorrowedDVDs()[i] = member.getBorrowedDVDs()[i+1];
                        }
                        member.decreaseBorrowedDVDsCount();
                    }
                }
                moveObjectToReturn.addCopy();
                System.out.println("Movie has been successfully returned. Thank you! \n");
                ListCurrentBorrowedMovies(member);
                break;
            } else {
                System.out.println("Movie does not exist. Please try again...");
            }
        }
    }
    public void ListCurrentBorrowedMovies(Member member) {
        member.PrintBorrowedDvds();
    }
    public void TopTenMostBorrowed(MovieCollection b) {
        b.GetTopTen(b.root);
    }
    public void BuildMemberMenu(Member member, MovieCollection b) {
        int selectionVal;
        do {
            PrintMemberMenu(member);
            selectionVal = InputListener.scanInt("Please make a selection (1-5, or 0 to return to the main menu): ");
            switch (selectionVal) {
            case 1: // Display all movies
                DisplayAllMovies(b);
                break;
            case 2: // Borrow a movie DVD
                BorrowMovie(member, b);
                break;
            case 3: // Return a movie DVD
                ReturnMovie(member, b);
                break;
            case 4: // List current borrow movie DVDs
                ListCurrentBorrowedMovies(member);
                break;
            case 5: // List top 10 most borrowed movies
                TopTenMostBorrowed(b);
                break;
            case 0:
                System.out.println("Exit selected");
                break;
            default:
                System.out.println("Invalid selection");
                break; // This break is not really necessary
            }
        } while (selectionVal != 0);
    }
}
