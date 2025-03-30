export class NextElementTypError extends Error {
  constructor() {
    super(
      "The next elment from one element has to be an instance from the class ListElement!"
    );
  }
}
