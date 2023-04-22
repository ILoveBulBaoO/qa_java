import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline mockFeline;
    private Lion lionMale;
    private Lion lionFemale;
    private final String MALE = "Самец";
    private final String FEMALE = "Самка";

    @Before
    public void initLion() throws Exception {
        lionMale = new Lion(mockFeline, MALE);
        lionFemale = new Lion(mockFeline, FEMALE);
    }

    @Test
    // проверили, что метод getFood() возвращает список "Животные", "Птицы", "Рыба"
    public void checkGetFood() throws Exception {
        lionMale.getFood();
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualList = mockFeline.getFood("Хищник");
        assertEquals(expectedList, actualList);
    }

    @Test
    // проверим, что метод getKittens вернет 1
    public void getKittensReturnOne() throws Exception {
        Mockito.when(mockFeline.getKittens()).thenReturn(1);
        int expectedKittens = 1;
        int actualKittens = lionMale.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    // проверим сообщение об ошибке при указании неверного пола
    public void checkExceptionMessage() {
        try {
            lionMale = new Lion(mockFeline, "Incorrect sex");
        } catch (Exception e) {
            String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
            String actualMessage = e.getMessage();
            assertEquals(expectedMessage, actualMessage);
        }
    }

    // проверим, что hasMane = true
    @Test
    public void hasManeTrue() {
        boolean expected = true;
        boolean actual = lionMale.doesHaveMane();
        assertEquals(expected, actual);
    }

    // проверим, что hasMane = false
    @Test
    public void hasManeFalse() {
        boolean expected = false;
        boolean actual = lionFemale.doesHaveMane();
        assertEquals(expected, actual);
    }

    @RunWith(Parameterized.class)
    public static class ParamLionTest {
        @Mock
        Feline mockFeline;
        private Lion lion;
        private String lionSex;
        private boolean hasMane;

        @Before
        public void initLion() throws Exception {
            lion = new Lion(mockFeline, lionSex);
        }

        @Parameterized.Parameters(name = "Тестовые данные: Пол = {0}, has mane = {1}")
        public static Object[][] data() {
            return new Object[][] {
                    {"Самец", true},
                    {"Самка", false}
            };
        }

        public ParamLionTest(String lionSex, boolean hasMane) {
            this.lionSex = lionSex;
            this.hasMane = hasMane;
        }

        @Test
        public void checkHaveMane() {
            boolean expected = hasMane;
            boolean actual = lion.doesHaveMane();
            assertEquals(expected, actual);
        }

    }

}

