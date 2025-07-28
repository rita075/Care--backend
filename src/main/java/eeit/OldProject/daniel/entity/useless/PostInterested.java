package eeit.OldProject.daniel.entity.useless;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import eeit.OldProject.daniel.entity.post.Post;
import eeit.OldProject.steve.Entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"user","post"})
@Entity
@Table(name = "post_interested", schema = "final")
public class PostInterested {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PostInterestedId")
    private Long postInterestedId;

    @Column(name = "IsInterested")
    private Boolean isInterested;

    @Column(name = "InterestedAt")
    private LocalDateTime interestedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    @JsonIgnoreProperties("interestedPosts")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PostId")
    @JsonIgnoreProperties("interested")
    private Post post;
}
