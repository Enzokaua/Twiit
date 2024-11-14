package ek.app.social.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "TB_TWEETS")
@Getter
@Setter
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "tweet_id")
    private Long tweetId;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    private String content;

    @CreationTimestamp
    private Instant creationTimestamp;

}
