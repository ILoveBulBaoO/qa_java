import com.example.Feline;
import com.example.LionAlex;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class LionAlexTest {
    @Mock
    Feline mockFeline;

    private LionAlex lionAlex;

    @Before
    public void initLion() {
        lionAlex = new LionAlex(mockFeline);
    }

    @Test
    // проверим вызов метода getPlaceOfLiving()
    public void checkGetPlaceOfLiving() {
        String expected = "Нью-Йоркский зоопарк";
        String actual = lionAlex.getPlaceOfLiving();
        assertEquals(expected, actual);
    }

    @Test
    // проверим метод getKittens()
    public void checkGetKittens() {
        int expected = 0;
        int actual = lionAlex.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    // проверим метод getFriends()
    public void checkGetFriends() {
        List<String> expected = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
        List<String> actual = lionAlex.getFriends();
        assertEquals(expected, actual);
    }
}
