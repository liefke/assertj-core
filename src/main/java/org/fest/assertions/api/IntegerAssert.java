/*
 * Created on Oct 17, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010 the original author or authors.
 */
package org.fest.assertions.api;

import org.fest.assertions.core.*;
import org.fest.assertions.description.Description;
import org.fest.assertions.internal.*;
import org.fest.util.VisibleForTesting;

/**
 * Assertion methods for integers. To create an instance of this class, use the factory methods
 * <code>{@link Assertions#assertThat(Integer)}</code> or <code>{@link Assertions#assertThat(int)}</code>.
 *
 * @author Yvonne Wang
 * @author David DIDIER
 * @author Ansgar Konermann
 * @author Alex Ruiz
 */
public class IntegerAssert implements Assert<Integer>, ComparableAssert<Integer>, NumberAssert<Integer> {

  @VisibleForTesting Objects objects = Objects.instance();
  @VisibleForTesting Comparables comparables = Comparables.instance();
  @VisibleForTesting Integers integers = Integers.instance();
  @VisibleForTesting Conditions conditions = Conditions.instance();

  @VisibleForTesting final Integer actual;
  @VisibleForTesting final WritableAssertionInfo info;

  protected IntegerAssert(Integer actual) {
    this.actual = actual;
    info = new WritableAssertionInfo();
  }

  /** {@inheritDoc} */
  public IntegerAssert as(String description) {
    return describedAs(description);
  }

  /** {@inheritDoc} */
  public IntegerAssert as(Description description) {
    return describedAs(description);
  }

  /** {@inheritDoc} */
  public IntegerAssert describedAs(String description) {
    info.description(description);
    return this;
  }

  /** {@inheritDoc} */
  public IntegerAssert describedAs(Description description) {
    info.description(description);
    return this;
  }

  /** {@inheritDoc} */
  public void isNull() {
    objects.assertNull(info, actual);
  }

  /** {@inheritDoc} */
  public IntegerAssert isNotNull() {
    objects.assertNotNull(info, actual);
    return this;
  }

  /** {@inheritDoc} */
  public IntegerAssert isEqualTo(Integer expected) {
    objects.assertEqual(info, actual, expected);
    return this;
  }

  /**
   * Verifies that the actual value is equal to the given one.
   * @param expected the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is not equal to the given one.
   */
  public IntegerAssert isEqualTo(int expected) {
    integers.assertEqual(info, actual, expected);
    return this;
  }

  /** {@inheritDoc} */
  public IntegerAssert isNotEqualTo(Integer other) {
    objects.assertNotEqual(info, actual, other);
    return this;
  }

  /**
   * Verifies that the actual value is not equal to the given one.
   * @param other the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is equal to the given one.
   */
  public IntegerAssert isNotEqualTo(int other) {
    integers.assertNotEqual(info, actual, other);
    return this;
  }

  /** {@inheritDoc} */
  public IntegerAssert isSameAs(Integer expected) {
    objects.assertSame(info, actual, expected);
    return this;
  }

  /** {@inheritDoc} */
  public IntegerAssert isNotSameAs(Integer other) {
    objects.assertNotSame(info, actual, other);
    return this;
  }

  /** {@inheritDoc} */
  public IntegerAssert isZero() {
    integers.assertIsZero(info, actual);
    return this;
  }

  /** {@inheritDoc} */
  public IntegerAssert isNotZero() {
    integers.assertIsNotZero(info, actual);
    return this;
  }

  /** {@inheritDoc} */
  public IntegerAssert isPositive() {
    integers.assertIsPositive(info, actual);
    return this;
  }

  /** {@inheritDoc} */
  public IntegerAssert isNegative() {
    integers.assertIsNegative(info, actual);
    return this;
  }

  /** {@inheritDoc} */
  public IntegerAssert isLessThan(Integer other) {
    comparables.assertLessThan(info, actual, other);
    return this;
  }

  /**
   * Verifies that the actual value is less than the given one.
   * @param other the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is equal to or greater than the given one.
   */
  public IntegerAssert isLessThan(int other) {
    integers.assertLessThan(info, actual, other);
    return this;
  }

  /** {@inheritDoc} */
  public IntegerAssert isLessThanOrEqualTo(Integer other) {
    comparables.assertLessThanOrEqualTo(info, actual, other);
    return this;
  }

  /**
   * Verifies that the actual value is less than or equal to the given one.
   * @param other the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is greater than the given one.
   */
  public IntegerAssert isLessThanOrEqualTo(int other) {
    integers.assertLessThanOrEqualTo(info, actual, other);
    return this;
  }

  /** {@inheritDoc} */
  public IntegerAssert isGreaterThan(Integer other) {
    comparables.assertGreaterThan(info, actual, other);
    return this;
  }

  /**
   * Verifies that the actual value is greater than the given one.
   * @param other the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is equal to or less than the given one.
   */
  public IntegerAssert isGreaterThan(int other) {
    integers.assertGreaterThan(info, actual, other);
    return this;
  }

  /** {@inheritDoc} */
  public IntegerAssert isGreaterThanOrEqualTo(Integer other) {
    comparables.assertGreaterThanOrEqualTo(info, actual, other);
    return this;
  }

  /**
   * Verifies that the actual value is greater than or equal to the given one.
   * @param other the given value to compare the actual value to.
   * @return {@code this} assertion object.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is less than the given one.
   */
  public IntegerAssert isGreaterThanOrEqualTo(int other) {
    integers.assertGreaterThanOrEqualTo(info, actual, other);
    return this;
  }

  /** {@inheritDoc} */
  public IntegerAssert satisfies(Condition<Integer> condition) {
    conditions.assertSatisfies(info, actual, condition);
    return this;
  }

  /** {@inheritDoc} */
  public IntegerAssert doesNotSatisfy(Condition<Integer> condition) {
    conditions.assertDoesNotSatisfy(info, actual, condition);
    return this;
  }

  /** {@inheritDoc} */
  public IntegerAssert is(Condition<Integer> condition) {
    return satisfies(condition);
  }

  /** {@inheritDoc} */
  public IntegerAssert isNot(Condition<Integer> condition) {
    return doesNotSatisfy(condition);
  }

  @VisibleForTesting final String descriptionText() {
    return info.descriptionText();
  }
}