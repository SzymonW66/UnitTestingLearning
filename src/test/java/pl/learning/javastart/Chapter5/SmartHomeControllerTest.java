package pl.learning.javastart.Chapter5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(MockitoExtension.class)
class SmartHomeControllerTest {

    @Mock private HumiditySensor humiditySensor;
    @Mock private WateringController wateringController;
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldDisableWatering(){
        //given
        Mockito.when(humiditySensor.getHumidity()).thenReturn(50);
        //to poniżej może zostać zastąpiąne przez @InjectMocks
        // wtedy wygląda to tak
        // @IntejctMocks
        // private SmartHomeController smartHomeContoller;
        SmartHomeController smartHomeController = new SmartHomeController(humiditySensor, wateringController);

        //when
        smartHomeController.enableWateringIfNeeded();

        //then
        Mockito.verify(wateringController).disableWatering();

    }

    @Test
    void shouldEnableWatering(){
        //given
        Mockito.when(humiditySensor.getHumidity()).thenReturn(49);

        SmartHomeController smartHomeController = new SmartHomeController(humiditySensor, wateringController);

        //when
        smartHomeController.enableWateringIfNeeded();

        //then
        Mockito.verify(wateringController).disableWatering();

    }
}