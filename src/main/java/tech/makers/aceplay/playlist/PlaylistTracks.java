package tech.makers.aceplay.playlist;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import tech.makers.aceplay.track.Track;

@Entity
@Table(name = "playlist_tracks")
public class PlaylistTracks implements Serializable {

    @EmbeddedId
    private PlaylistHistoryId id;

    @ManyToOne
    @MapsId("playlist_id") //This is the name of attr in EmployerDeliveryAgentPK class
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    @ManyToOne
    @MapsId("track_id")
    @JoinColumn(name = "track_id")
    private Track track;    
}