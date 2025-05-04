package questao15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.testing.software.questao15.TvShow;
import com.testing.software.questao15.TvShowServiceImpl;

class TvShowServiceImplTest {
  private final TvShowServiceImpl service = new TvShowServiceImpl();

  @ParameterizedTest
  @CsvSource({
      "'\"BR\" \"Jornal Cultura\" 19:00 20:00', BR, Jornal Cultura, 19:00, 20:00",
      "'\"US\" \"Night News\" 21:30 22:00', US, Night News, 21:30, 22:00",
      "'\"FR\" \"Le Journal\" 18:15 19:00', FR, Le Journal, 18:15, 19:00",
      "'\"JP\" \"News Tokyo\" 07:00 08:00', JP, News Tokyo, 07:00, 08:00"
  })
  void testBuildTvShowFromInput(String input, String expectedRegion, String expectedName, String start, String end) {
    TvShow show = service.buildTvShowFromInput(input);

    assertEquals(expectedRegion, show.getRegion());
    assertEquals(expectedName, show.getName());
    assertEquals(LocalTime.parse(start), show.getBeginning());
    assertEquals(LocalTime.parse(end), show.getEnd());
  }
}
