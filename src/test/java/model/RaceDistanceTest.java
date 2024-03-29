package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static validation.ErrorMessage.COUNT_NOT_MINUS;

import model.domain.RaceDistance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceDistanceTest {

    private RaceDistance raceDistance;
    private final String distanceImage = "--";

    @BeforeEach
    void setRaceDistance(){
        int distanceCount = 2;
        raceDistance = new RaceDistance(distanceCount);
    }
    @Test
    void RaceDistance_생성_정상(){
        assertThat(raceDistance.getImageWithBars()).isEqualTo(distanceImage);
    }

    @Test
    void RaceDistance_plus_정상(){
        String distanceImagePlus = "---";

        assertThat(raceDistance.getImageWithBars()).isEqualTo(distanceImage);

        raceDistance.plus();

        assertThat(raceDistance.getImageWithBars()).isEqualTo(distanceImagePlus);
    }

    @Test
    void RaceDistance_비정상_음수_예외출력(){
        assertThatThrownBy(() -> new RaceDistance(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(COUNT_NOT_MINUS.getMessage());
    }
}