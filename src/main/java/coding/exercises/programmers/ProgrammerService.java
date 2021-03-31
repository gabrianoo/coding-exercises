package coding.exercises.programmers;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface ProgrammerService {

  /**
   * Task: I want to obtain any programmer that knows a specified language
   */
  Optional<Programmer> findSomeoneWhoKnowsLanguage(String language);

  /**
   * Task: I want to get all languages that are covered by all programmers
   */
  Set<String> allLanguagesCoveredByProgrammers();

  /**
   * Task: I want to know sum of all programmers' salaries
   */
  Integer sumOfAllSalaries();

  /**
   * Task: I want a method that would provide a data structure that gives me a possibility
   * to obtain all the programmers that know a language that I will specify
   *
   * @return key-value collection of languages and programmers that know them
   */
  Map<String, Set<Programmer>> programmersByLanguage();
}
