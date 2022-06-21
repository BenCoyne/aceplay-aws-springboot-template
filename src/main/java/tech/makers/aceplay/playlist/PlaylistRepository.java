package tech.makers.aceplay.playlist;

import java.util.SortedSet;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// https://www.youtube.com/watch?v=vreyOZxdb5Y&t=343s
public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
  Playlist findFirstByOrderByIdAsc();

  // @Query(value="select p.id, p.name, ph.playlist_id, ph.track_id, t.id, t.title, t.artist, t.public_url, ph.added_to_playlist from playlist as p inner join playlist_history as ph on p.id = ph.playlist_id inner join track as t on t.id = ph.track_id order by ph.added_to_playlist asc;", nativeQuery=true)
  // Iterable<Playlist> findAllSortByTrackDateAdded();
}
