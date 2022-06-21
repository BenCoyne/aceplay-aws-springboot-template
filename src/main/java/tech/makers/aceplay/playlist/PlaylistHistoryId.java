package tech.makers.aceplay.playlist;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PlaylistHistoryId implements Serializable {

    @Column(name = "playlist_id")
    private Long playlistId;

    @Column(name = "track_id")
    private Long trackId;

    @Column(name = "date_added_to_playlist")
    private LocalDateTime dateAddedToPlaylist;
}