package coding.exercises.programmers;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ExampleProgrammerService implements ProgrammerService {

  private Collection<Programmer> programmers;

  public ExampleProgrammerService(Collection<Programmer> programmers) {
    this.programmers = programmers;
  }

  @Override
  public Optional<Programmer> findSomeoneWhoKnowsLanguage(String language) {
    return programmers.stream()
        .filter(p -> p.getLanguages().contains(language))
        .findAny();
  }

  @Override
  public Set<String> allLanguagesCoveredByProgrammers() {
    return programmers.stream()
        .map(Programmer::getLanguages)
        .flatMap(Collection::stream)
        .collect(Collectors.toSet());
  }

  @Override
  public Integer sumOfAllSalaries() {
    return programmers.stream()
        .map(Programmer::getSalary)
        .reduce(0, Integer::sum);
  }

  @Override
  public Map<String, Set<Programmer>> programmersByLanguage() {
    return allLanguagesCoveredByProgrammers()
        .stream()
        .collect(Collectors.toMap(language -> language, this::allWhoKnowsLanguage));
  }

  private Set<Programmer> allWhoKnowsLanguage(String language) {
    return programmers
        .stream()
        .filter(p -> p.getLanguages().contains(language))
        .collect(Collectors.toSet());
  }
}
