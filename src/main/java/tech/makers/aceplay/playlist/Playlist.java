package tech.makers.aceplay.playlist;

import com.fasterxml.jackson.annotation.JsonGetter;

import tech.makers.aceplay.playlisttracks.PlaylistTracks;

import java.util.Collections;
import java.util.List;

import javax.persistence.*;

// https://www.youtube.com/watch?v=vreyOZxdb5Y&t=448s
@Entity
public class Playlist {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "playlist")
  @OrderBy(value = "dateAdded")
  private List<PlaylistTracks> tracks;

  public Playlist() {}

  public Playlist(String name) {
    this(name, null);
  }

  public Playlist(String name, List<PlaylistTracks> tracks) {
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
  public List<PlaylistTracks> getTracks() {
    if (null == tracks) {
      return Collections.<PlaylistTracks>emptyList();
    }
    return tracks;
  }

  @Override
  public String toString() {
    return String.format("Playlist[id=%d name='%s']", id, name);
  }
}
