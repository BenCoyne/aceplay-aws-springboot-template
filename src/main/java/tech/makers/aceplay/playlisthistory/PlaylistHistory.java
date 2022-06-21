package tech.makers.aceplay.playlisthistory;

import java.time.Clock;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlaylistHistory {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name="playlist_id")
  private Long playlistId;

  @Column(name="track_id")
  private Long trackId;

  @Column(name="added_to_playlist", columnDefinition = "TIMESTAMP")
  private LocalDateTime addedToPlaylist;

  public PlaylistHistory() {}

  public PlaylistHistory(Long playlistId, Long trackId) {
    this.playlistId = playlistId;
    this.trackId = trackId;
    this.addedToPlaylist = LocalDateTime.now(Clock.systemUTC());
  }

  public PlaylistHistory(Long playlistId, Long trackId, Clock clock) {
    this.playlistId = playlistId;
    this.trackId = trackId;
    this.addedToPlaylist = LocalDateTime.now(clock);
  }

  public Long getPlaylistId() {
    return trackId;
  }

  public Long getTrackId() {
    return trackId;
  }

  public LocalDateTime getAddedToPlaylist() {
    return addedToPlaylist;
  }
}
