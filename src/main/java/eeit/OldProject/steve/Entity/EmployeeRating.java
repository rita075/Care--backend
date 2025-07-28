package eeit.OldProject.steve.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_rating")
public class EmployeeRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RatingId")
    private Long ratingId;

    @Column(name = "ArchivedDate")
    private LocalDateTime archivedDate;

    @Column(name = "Ratings")
    private Integer ratings;

    @Column(name = "Feedback", length = 150)
    private String feedback;

    @Column(name = "UserId")
    private Long userId;

    @Column(name = "CaregiverId")
    private Long caregiverId ;

    //pending discussion with Rita
    @Column(name = "PaymentId")
    private Long paymentId;
}

