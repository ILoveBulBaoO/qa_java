import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private Feline feline;

    @Before
    public void initFeline() {
        feline = new Feline();
    }

    // проверим, что метод возвращает "Хищник"
    @Test
    public void getFamilyTest() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    // проверили, что метод getFood возвращает список "Животные", "Птицы", "Рыба"
    public void checkGetFood() throws Exception {
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        feline.eatMeat();
        List<String> actualList = feline.getFood("Хищник");
        assertEquals(expectedList, actualList);
    }

    // проверили, что метод getKittens(8)  возвращает 8
    @Test
    public void checkGetKittensWithArgs() {
        int expectedCount = 8;
        int actualCount = feline.getKittens(8);
        assertEquals(expectedCount, actualCount);
    }

    // проверили, что метод getKittens() возвращает 1
    @Test
    public void checkGetKittens() {
        int expectedCount = 1;
        int actualCount = feline.getKittens();
        assertEquals(expectedCount, actualCount);
    }

}
