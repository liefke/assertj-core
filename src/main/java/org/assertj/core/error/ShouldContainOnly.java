package org.assertj.core.error;

import static org.assertj.core.util.Iterables.isNullOrEmpty;

import org.assertj.core.internal.*;

/**
 * Creates an error message indicating that an assertion that verifies a group of elements contains only a given set of
 * values and
 * nothing else failed. A group of elements can be a collection, an array or a {@code String}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 * @author Joel Costigliola
 */
public class ShouldContainOnly extends BasicErrorMessageFactory {

  /**
   * Creates a new </code>{@link ShouldContainOnly}</code>.
   * 
   * @param actual the actual value in the failed assertion.
   * @param expected values expected to be contained in {@code actual}.
   * @param notFound values in {@code expected} not found in {@code actual}.
   * @param notExpected values in {@code actual} that were not in {@code expected}.
   * @param comparisonStrategy the {@link ComparisonStrategy} used to evaluate assertion.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldContainOnly(Object actual, Object expected, Object notFound,
	                                                  Object notExpected,
	                                                  ComparisonStrategy comparisonStrategy) {
	return new ShouldContainOnly(actual, expected, notFound, notExpected, comparisonStrategy);
  }

  /**
   * Creates a new </code>{@link ShouldContainOnly}</code>.
   * 
   * @param actual the actual value in the failed assertion.
   * @param expected values expected to be contained in {@code actual}.
   * @param notFound values in {@code expected} not found in {@code actual}.
   * @param notExpected values in {@code actual} that were not in {@code expected}.
   * @param comparisonStrategy the {@link ComparisonStrategy} used to evaluate assertion.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldContainOnly(Object actual, Object expected, Object notFound,
	                                                  Iterable<?> notExpected, ComparisonStrategy comparisonStrategy) {
	if (isNullOrEmpty(notExpected)) return new ShouldContainOnly(actual, expected, notFound, comparisonStrategy);
	else return new ShouldContainOnly(actual, expected, notFound, notExpected, comparisonStrategy);
  }

  /**
   * Creates a new </code>{@link ShouldContainOnly}</code>.
   * 
   * @param actual the actual value in the failed assertion.
   * @param expected values expected to be contained in {@code actual}.
   * @param notFound values in {@code expected} not found in {@code actual}.
   * @param notExpected values in {@code actual} that were not in {@code expected}.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldContainOnly(Object actual, Object expected, Object notFound,
	                                                  Object notExpected) {
	return shouldContainOnly(actual, expected, notFound, notExpected, StandardComparisonStrategy.instance());
  }

  /**
   * Creates a new </code>{@link ShouldContainOnly}</code>.
   * 
   * @param actual the actual value in the failed assertion.
   * @param expected values expected to be contained in {@code actual}.
   * @param notFound values in {@code expected} not found in {@code actual}.
   * @param notExpected values in {@code actual} that were not in {@code expected}.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldContainOnly(Object actual, Object expected, Object notFound,
	                                                  Iterable<?> notExpected) {
	return shouldContainOnly(actual, expected, notFound, notExpected, StandardComparisonStrategy.instance());
  }

  private ShouldContainOnly(Object actual, Object expected, Object notFound, Object notExpected,
	                        ComparisonStrategy comparisonStrategy) {
	super("\n" +
	      "Expecting:\n" +
	      "  <%s>\n" +
	      "to contain only:\n" +
	      "  <%s>\n" +
	      "elements not found:\n" +
	      "  <%s>\n" +
	      "and elements not expected:\n" +
	      "  <%s>\n%s", actual,
	      expected, notFound, notExpected, comparisonStrategy);
  }

  private ShouldContainOnly(Object actual, Object expected, Object notFound, ComparisonStrategy comparisonStrategy) {
	super("\n" +
	      "Expecting:\n" +
	      "  <%s>\n" +
	      "to contain only:\n" +
	      "  <%s>\n" +
	      "but could not find the following elements:\n" +
	      "  <%s>\n%s",
	      actual, expected, notFound, comparisonStrategy);
  }

}
