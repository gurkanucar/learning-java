package org.gucardev.parametrizedtest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.gucardev.parametrizedtest.exceptionTypes.AlreadyExistsException;
import org.gucardev.parametrizedtest.exceptionTypes.CouldNotCompletedException;
import org.gucardev.parametrizedtest.exceptionTypes.ErrorType;
import org.gucardev.parametrizedtest.exceptionTypes.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MainTest {

  protected Main main;

  @BeforeEach
  void setUp() {
    main = new Main();
  }

  private static Stream<Arguments> provideTestScenarios() {
    return Stream.of(
        Arguments.of(NotFoundException.class, ErrorType.NOT_FOUND),
        Arguments.of(AlreadyExistsException.class, ErrorType.ALREADY_EXISTS),
        Arguments.of(CouldNotCompletedException.class, ErrorType.COULD_NOT_COMPLETED));
  }

  @ParameterizedTest
  @MethodSource("provideTestScenarios")
  void doSomethingAndThrowError_givenExceptionType_throwException(
      Class<? extends RuntimeException> exceptionClass, ErrorType errorType) {

    assertThrows(exceptionClass, () -> main.doSomethingAndThrowError(errorType));
  }
}
