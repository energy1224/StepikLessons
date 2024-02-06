package Comment;

import java.util.Comparator;

public class CommentByLikes implements Comparator<Comment> {
    @Override
    public int compare(Comment o1, Comment o2) {
        Integer i= o1.getVolumeOfLike();
        Integer i1= o1.getVolumeOfLike();

        return  i1.compareTo(i);
    }
}
