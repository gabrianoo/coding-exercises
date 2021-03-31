package coding.exercises.programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ExampleProgrammerServiceTest {

  Programmer susan = new Programmer("Susan", 29, 1300, Set.of("JS", "C#"));
  Programmer eddie = new Programmer("Eddie", 20, 1000, Set.of("Java"));
  Programmer jake = new Programmer("Jake", 25, 2500, Set.of("Java", "Python"));
  Programmer roland = new Programmer("Roland", 46, 3800, Set.of("Python"));

  List<Programmer> programmers = List.of(susan, eddie, jake, roland);

  ExampleProgrammerService sut = new ExampleProgrammerService(programmers);

  @Test
  void findSomeoneWhoKnowsLanguage_whenOneProgrammerKnowsLanguage_shouldReturnHim() {
    String testLanguage = "C#";
    assertThat(sut.findSomeoneWhoKnowsLanguage(testLanguage))
        .contains(susan);
  }

  @Test
  void findSomeoneWhoKnowsLanguage_whenMultipleProgrammersKnowLanguage_shouldReturnAnyOfThem() {
    String testLanguage = "Java";
    assertThat(sut.findSomeoneWhoKnowsLanguage(testLanguage))
        .hasValueSatisfying(programmer ->
            assertThat(programmer.getLanguages()).contains(testLanguage));
  }

  @Test
  void findSomeoneWhoKnowsLanguage_whenNoOneKnowsLanguage_shouldReturnEmpty() {
    String testLanguage = "Go";
    assertThat(sut.findSomeoneWhoKnowsLanguage(testLanguage))
        .isEmpty();
  }

  @Test
  void allLanguagesCoveredByProgrammers() {
    assertThat(sut.allLanguagesCoveredByProgrammers())
        .containsExactlyInAnyOrder("Java", "C#", "JS", "Python");
  }

  @Test
  void sumOfAllSalaries() {
    assertThat(sut.sumOfAllSalaries())
        .isEqualTo(8600);
  }

  @Test
  void programmersByLanguage() {
    Map<String, Set<Programmer>> expected = Map.of(
        "Java", Set.of(eddie, jake),
        "JS", Set.of(susan),
        "C#", Set.of(susan),
        "Python", Set.of(jake, roland)
    );
    Map<String, Set<Programmer>> result = sut.programmersByLanguage();
    assertThat(result)
        .containsAllEntriesOf(expected);
  }
}