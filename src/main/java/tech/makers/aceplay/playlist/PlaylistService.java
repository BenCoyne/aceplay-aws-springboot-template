package tech.makers.aceplay.playlist;

import java.time.Clock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {
  @Autowired private Clock clock;

  public Playlist create(Playlist playlist) {
    return new Playlist(playlist.getName(), playlist.getTracks(), clock);
  }
}
