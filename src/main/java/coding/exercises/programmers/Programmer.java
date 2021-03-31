package coding.exercises.programmers;

import java.util.Objects;
import java.util.Set;

public class Programmer {
  private final String name;
  private final int age;
  private final int salary;
  private final Set<String> languages;

  public Programmer(String name, int age, int salary, Set<String> languages) {
    this.name = name;
    this.age = age;
    this.salary = salary;
    this.languages = languages;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getSalary() {
    return salary;
  }

  public Set<String> getLanguages() {
    return languages;
  }

  @Override
  public String toString() {
    return "Programmer{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", salary=" + salary +
        ", languages=" + languages +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Programmer that = (Programmer) o;
    return age == that.age && salary == that.salary && Objects.equals(name, that.name) && Objects.equals(languages, that.languages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, salary, languages);
  }
}
