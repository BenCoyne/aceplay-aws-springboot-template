package tech.makers.aceplay.playlist;

import com.fasterxml.jackson.annotation.JsonGetter;

import tech.makers.aceplay.playlisttracks.PlaylistTracks;
import tech.makers.aceplay.track.Track;

import javax.persistence.*;
import java.util.Set;

// https://www.youtube.com/watch?v=vreyOZxdb5Y&t=448s
@Entity
public class Playlist {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "playlist")
  private Set<PlaylistTracks> tracks;

  public Playlist() {}

  public Playlist(String name) {
    this(name, null);
  }

  public Playlist(String name, Set<PlaylistTracks> tracks) {
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
  public Set<PlaylistTracks> getTracks() {
    if (null == tracks) {
      return Set.of();
    }
    return tracks;
  }

  @Override
  public String toString() {
    return String.format("Playlist[id=%d name='%s']", id, name);
  }
}
