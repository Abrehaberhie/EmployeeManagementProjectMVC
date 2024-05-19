package com.binary.EmployManagement3.repository;

import com.binary.EmployManagement3.model.Comment;
import com.binary.EmployManagement3.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class CommentRepository {
    List<Comment> comments = new ArrayList<>();
    private  Integer idCount=1;
    public CommentRepository()
    {
        Comment commentObj = new Comment();
        commentObj.setGivenMessage("keep it up");
        commentObj.setMessageWriterName("robel");
        commentObj.setId(1);
        commentObj.setEmployeeId(1);

        Comment commentObj1 = new Comment();
        commentObj1.setGivenMessage("poor performance");
        commentObj1.setMessageWriterName("diana");
        commentObj1.setId(2);
        commentObj1.setEmployeeId(2);

        Comment commentObj2 = new Comment();
        commentObj2.setGivenMessage("fair work");
        commentObj2.setMessageWriterName("nikita");
        commentObj2.setId(3);
        commentObj2.setEmployeeId(3);

        Comment commentObj3 = new Comment();
        commentObj3.setGivenMessage("you need to work harder");
        commentObj3.setMessageWriterName("tomson");
        commentObj3.setId(4);
        commentObj3.setEmployeeId(4);

        comments.add(commentObj);
        comments.add(commentObj1);
        comments.add(commentObj2);
        comments.add(commentObj3);

    }
    public void addComment(int employId, Comment comment){
        comment.setEmployeeId( employId);
        comments.add(comment);
        idCount++;
    }
    public List<Comment> getAllCommentsByEmployeeId(int employeeId)
    {
       return comments.stream().filter(Employee->Employee.getEmployeeId()==employeeId).collect(Collectors.toList());

    }
    public void updateComment(Comment updatedComment)
    {
        for(int i=0;i<comments.size();i++)
        {
            if(comments.get(i).getId().equals(updatedComment.getId()))
            {
                comments.set(i,updatedComment);
                break;
            }
        }
    }

    public void deletCommentById(Integer id)
    {
        for(int i=0;i<comments.size();i++)
        {
            if(comments.get(i).getId()==id);
            {
                comments.remove(i);
                break;
            }
        }

    }

}
