package tech.makers.aceplay.playlist;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.data.annotation.CreatedDate;

@Embeddable
public class PlaylistHistoryId implements Serializable {

    @Column(name = "playlist_id")
    private Long playlistId;

    @Column(name = "track_id")
    private Long trackId;

    @Column(name = "date_added_to_playlist", columnDefinition = "TIMESTAMP")
    @CreatedDate
    private LocalDateTime dateAddedToPlaylist;
}