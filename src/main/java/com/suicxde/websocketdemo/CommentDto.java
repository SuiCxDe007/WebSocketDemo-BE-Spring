package com.suicxde.websocketdemo;

import lombok.Data;

@Data
public class CommentDto {

    private String comment;
    private String assignmentId;
    private String courseId;
    private String studentId;
    private String submissionId;

}
