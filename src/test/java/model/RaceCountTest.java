package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static validation.ErrorMessage.COUNT_NOT_MINUS;
import static validation.ErrorMessage.RACE_COUNT_NO_OVER_1000;

import model.domain.RaceCount;
import org.junit.jupiter.api.Test;

class RaceCountTest {

    @Test
    void RaceCount_정상생성(){
        int normalCount = 10;
        RaceCount raceCount = new RaceCount(normalCount);
        assertThat(raceCount.value()).isEqualTo(normalCount);
    }

    @Test
    void RaceCount_음수_예외출력(){
        int minusCount = -1;
        assertThatThrownBy(() -> new RaceCount(minusCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(COUNT_NOT_MINUS.getMessage());
    }

    @Test
    void RaceCount_너무높은수_1000초과_예외출력(){
        int overThousand = 1001;
        assertThatThrownBy(() -> new RaceCount(overThousand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RACE_COUNT_NO_OVER_1000.getMessage());
    }
}