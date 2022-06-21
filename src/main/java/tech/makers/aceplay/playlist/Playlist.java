package tech.makers.aceplay.playlist;

import com.fasterxml.jackson.annotation.JsonGetter;
import tech.makers.aceplay.track.Track;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Set;

// https://www.youtube.com/watch?v=vreyOZxdb5Y&t=448s
@Entity
public class Playlist {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @ManyToMany(fetch = FetchType.EAGER)
  private Set<Track> tracks;

  @Column(name="created_at", columnDefinition = "TIMESTAMP")
  private LocalDateTime createdAt;

  public Playlist() {}

  public Playlist(String name) {
    this(name, null);
  }

  public Playlist(String name, Set<Track> tracks) {
    this.name = name;
    this.tracks = tracks;
    this.createdAt = LocalDateTime.now(Clock.systemUTC());
  }

  public Playlist(String name, Set<Track> tracks, Clock clock) {
    this.name = name;
    this.tracks = tracks;
    this.createdAt = LocalDateTime.now(clock);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  @JsonGetter("tracks")
  public Set<Track> getTracks() {
    if (null == tracks) {
      return Set.of();
    }
    return tracks;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  @Override
  public String toString() {
    return String.format("Playlist[id=%d name='%s']", id, name);
  }
}
