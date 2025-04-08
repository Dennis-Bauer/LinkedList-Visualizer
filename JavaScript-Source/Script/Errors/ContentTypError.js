/**
 * This class represents an error that is thrown when the program tries to set the content of a list node,
 * but the provided value is not a number.
 *
 * @author Dennis Bauer
 * @version 1.0
 */

export class ContentTypError extends Error {
  constructor() {
    super("It's only possbile to add numbers to your list!");
  }
}
