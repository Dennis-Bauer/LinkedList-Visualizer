import { ContentTypError } from "./Errors/ContentTypError.js";
import { NextElementTypError } from "./Errors/NextElementTypError.js";
import { ListElement } from "./ListElement.js";

export class LinkedList {
  #elements = [];

  // Pointer
  #current = undefined;
  #currentArrayPos = -1;

  #last = undefined;
  #first = undefined;

  constructor(listContainer) {
    this.listContainer = listContainer;
  }

  next() {
    if (this.#current !== undefined) {
      if (this.#current === this.#first) this.#first.setPointer("First");
      else if (this.#current === this.#last) this.#last.setPointer("Last");
      else this.#current.setPointer("");

      this.#current = this.#current.getNextElement();

      if (this.#current === undefined) {
        this.#currentArrayPos = -1;
        return false;
      } else {
        if (this.#current === this.#last)
          this.#current.setPointer("Last/Current");
        else this.#current.setPointer("Current");
        this.#currentArrayPos++;
        return true;
      }
    } else return false;
  }

  append(content) {
    const newElement = new ListElement(content, undefined);
    if (this.#elements.at(-1) !== undefined)
      this.#elements.at(-1).setNextElement(newElement);

    this.#addElement(newElement);

    if (this.#elements.length === 0) {
      newElement.setPointer("First/Last");
      this.#first = newElement;
      this.#last = newElement;
    } else if (this.#elements.length === 1) {
      this.#elements.at(0).setPointer("First");

      newElement.setPointer("Last");
      this.#last = newElement;
    } else {
      this.#elements.at(-1).setPointer("");
      newElement.setPointer("Last");
      this.#last = newElement;
    }

    this.#elements.push(newElement);
  }

  setContent(content) {
    if (typeof content === "number") {
      if (this.#current !== undefined) {
        this.#current.setContent(content);
      }
    } else throw new ContentTypError();
  }

  toFirst() {
    if (this.#current !== undefined) {
      if (this.#current === this.#last) this.#last.setPointer("Last");
      else this.#current.setPointer("");
    }

    this.#current = this.#first;

    if (this.#current !== undefined) {
      this.#elements.at(0).setPointer("First/Current");

      this.#currentArrayPos = 0;
    } else this.#currentArrayPos = -1;
  }

  insert(content) {}

  getContent() {
    if (this.#current !== undefined) {
      return this.#current.value;
    } else return "Null";
  }

  toLast() {
    if (this.#current !== undefined) {
      if (this.#current === this.#first) this.#first.setPointer("First");
      else this.#current.setPointer("");
    }

    this.#current = this.#last;

    if (this.#current !== undefined) {
      this.#elements.at(-1).setPointer("Last/Current");

      this.#currentArrayPos = this.#elements.length - 1;
    } else this.#currentArrayPos = -1;
  }

  remove() {}

  isEmpty() {
    return (
      this.#first === undefined &&
      this.#last === undefined &&
      this.#current === undefined
    );
  }

  hasCurrentAccess() {
    return this.#current !== undefined;
  }

  #addElement(listElement) {
    if (listElement instanceof ListElement) {
      if (this.#elements.length !== 0) {
        this.listContainer.insertAdjacentHTML(
          "beforeend",
          `<div class="arrow">→</div>`
        );
      }

      listElement.addToDOM(this.listContainer);
    } else throw new NextElementTypError();
  }
}
