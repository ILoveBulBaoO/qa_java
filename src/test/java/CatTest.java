import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline mockFeline;

    private Cat cat;

    @Before
    public void initCat() {
        cat = new Cat(mockFeline);
    }

    // проверим, что метод возвращает "Мяу"
    @Test
    public void getSoundTest() {
        String actual = cat.getSound();
        String expected = "Мяу";
        assertEquals(expected, actual);
    }

    // проверили, что метод getFood() возвращает список "Животные", "Птицы", "Рыба"
    @Test
    public void checkGetFood() throws Exception {
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualList = cat.getFood();
        assertEquals(expectedList, actualList);
    }

}
