package Comment;

import java.util.Arrays;
import java.util.Scanner;

public class CommentTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int index= scanner.nextInt();
        Comment[]comments=new Comment[index];
        scanner.useDelimiter(";|\n");
        CommentByAuthor byAuthor= new CommentByAuthor();
        CommentByLikes byLikes=new CommentByLikes();

        for (int i = 0; i < comments.length; i++) {
            comments[i]=new Comment();
            comments[i].setAuthor(scanner.next());
            comments[i].setText(scanner.next());
            comments[i].setVolumeOfLike(scanner.nextInt());

        }


        Arrays.sort(comments);

        for (Comment comment : comments) {
            System.out.println(comment);
        }
        System.out.println();

        Arrays.sort(comments,byAuthor);

        for (Comment comment : comments) {
            System.out.println(comment);
        }





        }


    }


class Comment implements Comparable<Comment> {
    private String author;

    private String text;

    private int volumeOfLike;



    public Comment(String author, String text, int volumeOfLike) {
        this.author = author;
        this.text = text;
        this.volumeOfLike = volumeOfLike;
    }

    public Comment() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getVolumeOfLike() {
        return volumeOfLike;
    }

    public void setVolumeOfLike(int volumeOfLike) {
        this.volumeOfLike = volumeOfLike;
    }

    @Override
    public String toString() {
        return author + "#" + text + "#" + volumeOfLike;
    }

    @Override
    public int compareTo(Comment o) {
        if (volumeOfLike > o.volumeOfLike) return 1;
        if (volumeOfLike < o.volumeOfLike) return -1;

        return 0;
    }
}
