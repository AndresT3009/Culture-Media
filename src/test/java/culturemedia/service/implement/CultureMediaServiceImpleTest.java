package culturemedia.service.implement;

import culturemedia.exceptions.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.VideoReproductionRepository;
import culturemedia.services.CultureMediaService;
import culturemedia.services.implement.CultureMediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class CultureMediaServiceImpleTest {

    CultureMediaService cultureMediaService;
    VideoRepository mockVideoRepository;

    @BeforeEach
    void init(){
        mockVideoRepository = Mockito.mock(VideoRepository.class);
        cultureMediaService = new CultureMediaServiceImpl(mockVideoRepository,null);
    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        List<Video> expectedVideos = new ArrayList<>();
        expectedVideos.add(new Video("01", "La monja 2", "terror", 3.5));
        expectedVideos.add(new Video("02", "Duna 2", "ciencia ficción", 4.0));
        when(mockVideoRepository.findAll()).thenReturn(expectedVideos);
        List<Video> actualVideos = cultureMediaService.findAll();
        assertEquals(expectedVideos.size(), actualVideos.size());
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws VideoNotFoundException{
        when(mockVideoRepository.findAll()).thenReturn(Collections.emptyList());
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.findAll();
        });
    }
    @Test
    void when_FindByTittle_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws VideoNotFoundException{
        when(mockVideoRepository.find("Movie")).thenReturn(Collections.emptyList());
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.find("Movie");
        });

    }

    @Test
    void when_FindByTittle_videos_should_be_returned_successfully() throws VideoNotFoundException {
        Video video = new Video("01", "Duna", "Pelicula", 3.5);
        List<Video> videos = new ArrayList<>();
        videos.add(video);
        when(mockVideoRepository.find("Duna")).thenReturn(videos);
        mockVideoRepository.save(video);
        List<Video> foundVideos = cultureMediaService.find("Duna");
        assertEquals(1, foundVideos.size());
    }

    @Test
    void when_FindByDuration_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws VideoNotFoundException{
        when(mockVideoRepository.find(1.5, 2.0)).thenReturn(Collections.emptyList());
        assertThrows(VideoNotFoundException.class, () -> {
            cultureMediaService.find(1.5, 2.0);
        });
    }

    @Test
    void when_FindByDuration_videos_should_be_returned_successfully() throws VideoNotFoundException {
        Video video = new Video("01", "Duna", "Pelicula", 3.0);
        List<Video> videos = new ArrayList<>();
        videos.add(video);
        when(mockVideoRepository.find(2.5, 3.5)).thenReturn(videos);
        mockVideoRepository.save(video);
        List<Video> foundVideos = cultureMediaService.find(2.5, 3.5);
        assertEquals(1, foundVideos.size());
    }
}
