package tech.makers.aceplay.playlist;

import com.fasterxml.jackson.annotation.JsonGetter;
import tech.makers.aceplay.track.Track;

import javax.persistence.*;

import org.hibernate.annotations.Formula;
import org.springframework.core.annotation.Order;

import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.Set;

// https://www.youtube.com/watch?v=vreyOZxdb5Y&t=448s
@Entity
public class Playlist {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @ManyToMany(fetch = FetchType.EAGER)
  // @Formula("select p.name, ph.playlist_id, ph.track_id, t.id, t.title, t.artist, t.public_url, ph.added_to_playlist from playlist as p inner join playlist_history as ph on p.id = ph.playlist_id inner join track as t on t.id = ph.track_id order by ph.added_to_playlist asc;")
  
  private SortedSet<Track> tracks;

  public Playlist() {}

  public Playlist(String name) {
    this(name, null);
  }

  public Playlist(String name, SortedSet<Track> tracks) {
    this.name = name;
    this.tracks = tracks;
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
  public SortedSet<Track> getTracks() {
    if (null == tracks) {
      return Collections.<Track>emptySortedSet();
    }
    return tracks;
  }

  @Override
  public String toString() {
    return String.format("Playlist[id=%d name='%s']", id, name);
  }
}
