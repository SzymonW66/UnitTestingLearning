package pl.learning.javastart.Chapter8.ex1;

import java.time.ZonedDateTime;

public class Signup {
    private Long userId;
    private Long courseId;
    private ZonedDateTime from;
    private ZonedDateTime to;

    public Signup() {
    }

    public Signup(Long userId, Long courseId, ZonedDateTime from, ZonedDateTime to) {
        this.userId = userId;
        this.courseId = courseId;
        this.from = from;
        this.to = to;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public ZonedDateTime getFrom() {
        return from;
    }

    public void setFrom(ZonedDateTime from) {
        this.from = from;
    }

    public ZonedDateTime getTo() {
        return to;
    }

    public void setTo(ZonedDateTime to) {
        this.to = to;
    }
}
