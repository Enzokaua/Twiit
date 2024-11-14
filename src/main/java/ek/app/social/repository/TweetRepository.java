package ek.app.social.repository;

import ek.app.social.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
}