package com.binary.EmployManagement3.service;

import com.binary.EmployManagement3.model.Comment;
import com.binary.EmployManagement3.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    public List<Comment> getAllCommentsByEmployeeId(int employeeId){
        return commentRepository.getAllCommentsByEmployeeId(employeeId);
    }
    public void updatingComment(Comment updatedComent)
    {
        commentRepository.updateComment(updatedComent);
    }
    public void deletComment(Integer id)
    {
        commentRepository.deletCommentById(id);
    }
    public void addComment(Integer id, Comment comment)
    {
        commentRepository.addComment(id, comment);
    }


    }




