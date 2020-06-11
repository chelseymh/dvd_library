package Classes;

public class MovieCollection {
    public Node root;
    private Movie[] topTenListingArray;
    private int index;
    public void BinaryTree() {
        root = null;
    }
    public class Node {
        Node left;
        Node right;
        Movie movie;

        Node(Movie movie) {
            left = null;
            right = null;
            this.movie = movie;
        }
    }
    public Boolean IsEmpty() {
        if (root == null) return true;
        else return false;
    }
    public void InOrderTraverse() {
        InOrderTraverse(root);
    }
    private void InOrderTraverse(Node node) {
        if(node != null)
        {
            InOrderTraverse(node.left);
            System.out.println("Movie Titled: " + node.movie.getMovieTitle() + ", Starring: " + node.movie.getStarring() +
                            ", Directed by: " + node.movie.getDirector() + ", Duration of: " + node.movie.getDuration() +
                            " minutes, Genre: " + node.movie.getGenre() + ", Classification: " + node.movie.getClassification() +
                            ", Released: " + node.movie.getReleaseDate() + ", Times borrowed: " + node.movie.getTimesBorrowed() +
                            ", Copies: " + node.movie.getCopies() +"\n");
            InOrderTraverse(node.right);
        }
    }
    public void InOrderTraverseAvailable() {
        InOrderTraverseAvailable(root);
    }
    private void InOrderTraverseAvailable(Node node) {
        if(node != null)
        {
            if (node.movie.getCopies() >= 1) {
                InOrderTraverseAvailable(node.left);
                System.out.println("Movie Titled: " + node.movie.getMovieTitle() + ", Starring: " + node.movie.getStarring() +
                        ", Directed by: " + node.movie.getDirector() + ", Duration of: " + node.movie.getDuration() +
                        " minutes, Genre: " + node.movie.getGenre() + ", Classification: " + node.movie.getClassification() +
                        ", Released: " + node.movie.getReleaseDate() + ", Times borrowed: " + node.movie.getTimesBorrowed() +
                        ", Copies: " + node.movie.getCopies() +"\n");
                InOrderTraverseAvailable(node.right);
            }
        }
    }
    public Boolean Search(String movie) {
        return Search(movie, root);
    }
    private Boolean Search(String movie, Node r) {
        if(r != null)
        {
            if(movie.equalsIgnoreCase(r.movie.getMovieTitle()))
                return true;
            else
            if(movie.compareTo(r.movie.getMovieTitle()) < 0 )
                return Search(movie, r.left);
            else
                return Search(movie, r.right);
        }
        else
            return false;
    }
    public Movie SearchMovies(String movie, Node r) {
        if (r != null) {
            if(movie.equalsIgnoreCase(r.movie.getMovieTitle())) {
                return r.movie;
            }
            else if (movie.compareTo(r.movie.getMovieTitle()) < 0) {
                return SearchMovies(movie, r.left);
            } else {
                return SearchMovies(movie, r.right);
            }
        }
        else {
            return null;
        }
    }
    public void Insert(Movie movie) {
        if (root == null) {
            root = new Node(movie);
        } else {
            Insert(movie, root);
        }
    }
    private void Insert(Movie movie, Node ptr) {
        if (movie.getMovieTitle().compareTo(ptr.movie.getMovieTitle()) < 0) {
            if (ptr.left == null) {
                ptr.left = new Node(movie);
                return;
            } else {
                Insert(movie, ptr.left);
            }
        }
        else if (movie.getMovieTitle().compareTo(ptr.movie.getMovieTitle()) == 0) {
            ptr.movie.addCopy();
        }
        else {
            if (ptr.right == null) {
                ptr.right = new Node(movie);
            } else {
                Insert(movie, ptr.right);
            }
        }
    }
    public void Delete(Movie movie) {
        Node ptr = root;
        Node parent = null;
        while((ptr != null) && (movie.getMovieTitle().compareTo(ptr.movie.getMovieTitle()) != 0)) {
            parent = ptr;
            if (movie.getMovieTitle().compareTo(ptr.movie.getMovieTitle()) < 0) {
                ptr = ptr.left;
            } else if (movie.getMovieTitle().compareTo(ptr.movie.getMovieTitle()) == 0) {
                movie.removeCopy();
            } else {
                ptr = ptr.right;
            }
        }
        if (ptr != null) {
            if ((ptr.left != null) && (ptr.right != null)) {
                if (ptr.left.right == null) {
                    ptr.movie = ptr.left.movie;
                    ptr.left = ptr.left.left;
                } else {
                    Node p = ptr.left;
                    Node pp = ptr;
                    while (p.right != null) {
                        pp = p;
                        p = p.right;
                    }
                    ptr.movie = p.movie;
                    pp.right = p.left;
                }
            }
            else {
                Node c;
                if (ptr.left != null) {
                    c = ptr.left;
                } else {
                    c = ptr.right;
                }
                if (ptr == root) {
                    root = c;
                } else {
                    if (ptr == parent.left) {
                        parent.left = c;
                    } else {
                        parent.right = c;
                    }
                }
            }
        }
    }
    public void GetTopTen(Node root) {
        index = 0;
        int numberOfMoviesCurrently = BSTCountRecursive(root);
        topTenListingArray = new Movie[numberOfMoviesCurrently];
        System.out.println("========== Top Ten Most Borrowed DVDs ==========\n");
        TransformToArray(root);
        InsertionSort(topTenListingArray);
        for (int i = 0; i < 10; i++) {
            if (topTenListingArray[i] != null) System.out.println(topTenListingArray[i].getMovieTitle()
                    + ", Borrowed:" + topTenListingArray[i].getTimesBorrowed());
        }
        System.out.println("\n");
    }
    private void InsertionSort(Movie[] orderableArray) {
        int n = orderableArray.length;
        for (int i = 1; i < n; i++) {
            Movie key = orderableArray[i];
            int j = i - 1;
            while (j >= 0 && orderableArray[j].getTimesBorrowed() < key.getTimesBorrowed()) {
                orderableArray[j + 1] = orderableArray[j];
                j = j - 1;
            }
            orderableArray[j + 1] = key;
        }
    }
    private void TransformToArray(Node root) {
        if (root == null) {
            return;
        } else {
            TransformToArray(root.left);
            topTenListingArray[index++] = root.movie;
            TransformToArray(root.right);
        }
    }
    private int BSTCountRecursive(Node root) {
        int count = 1;
        if (root == null) {
            return 0;
        } else {
            count += BSTCountRecursive(root.left);
            count += BSTCountRecursive(root.right);
            return count;
        }
    }
}
