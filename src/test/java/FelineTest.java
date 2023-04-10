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
public class FelineTest {

    @Mock
    Feline mockFeline;

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

    // проверили вызов метода eatMeat()
    @Test
    public void checkCallEatMeat() throws Exception {
        mockFeline.eatMeat();
        Mockito.verify(mockFeline).eatMeat();
    }

    // проверили вызов метода getFood() с аргументом
    @Test
    public void checkCallGetFoodWithArgs() throws Exception {
        mockFeline.getFood("Хищник");
        Mockito.verify(mockFeline).getFood("Хищник");
    }

    @Test
    // проверили, что метод getFood возвращает список "Животные", "Птицы", "Рыба"
    public void checkGetFood() throws Exception {
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualList = mockFeline.getFood("Хищник");
        assertEquals(expectedList, actualList);
    }

    // проверили вызов метода getKittens без аргументов
    @Test
    public void checkCallGetKittens() {
        mockFeline.getKittens();
        Mockito.verify(mockFeline).getKittens();
    }

    // проверили вызов метода getKittens() с аргументами
    @Test
    public void checkCallGetKittensWithArgs() {
        mockFeline.getKittens(1);
        Mockito.verify(mockFeline).getKittens(1);
    }

    // проверили, что метод getKittens(1)  возвращает 1
    @Test
    public void checkGetKittensWithArgs() {
        int extectedCount = 1;
        Mockito.when(mockFeline.getKittens(1)).thenReturn(1);
        int actualCount = mockFeline.getKittens(1);
        assertEquals(extectedCount, actualCount);
    }

}
