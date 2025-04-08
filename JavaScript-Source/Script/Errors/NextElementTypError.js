/**
 * This class represents an error that is thrown when the program tries to set the next element of a list node,
 * but the provided value is not an instance of ListElement.
 *
 * @author Dennis Bauer
 * @version 1.0
 */

export class NextElementTypError extends Error {
  constructor() {
    super(
      "The next elment from one element has to be an instance from the class ListElement!"
    );
  }
}
