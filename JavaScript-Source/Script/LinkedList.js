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
      this.#current.setPointer();

      this.#last.setPointer(false, false, true);

      this.#first.setPointer(
        false,
        true,
        this.#current === this.#first && this.#current === this.#last
      );

      this.#current = this.#current.getNextElement();

      if (this.#current === undefined) {
        this.#currentArrayPos = -1;
        return false;
      } else {
        this.#current.setPointer(true, false, this.#current === this.#last);

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
      this.#first = newElement;
      this.#last = newElement;
    } else if (this.#elements.length === 1) {
      this.#elements.at(0).setPointer(false, true, false);

      this.#last = newElement;
    } else {
      this.#elements.at(-1).setPointer();
      this.#last = newElement;
    }

    newElement.setPointer(false, this.#elements.length === 0, true);

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
    if (this.#first === this.#last) {
      this.#first.setPointer(true, true, true);
      return;
    }

    if (this.#current !== undefined) {
      if (this.#current === this.#last)
        this.#last.setPointer(false, false, true);
      else this.#current.setPointer();
    }

    this.#current = this.#first;

    if (this.#current !== undefined) {
      this.#elements.at(0).setPointer(true, true, false);

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
    if (this.#first === this.#last) {
      this.#first.setPointer(true, true, true);
      return;
    }

    if (this.#current !== undefined) {
      if (this.#current === this.#first)
        this.#first.setPointer(false, true, false);
      else this.#current.setPointer();
    }

    this.#current = this.#last;

    if (this.#current !== undefined) {
      this.#elements.at(-1).setPointer(true, false, true);

      this.#currentArrayPos = this.#elements.length - 1;
    } else this.#currentArrayPos = -1;
  }

  remove() {
    if (this.#current !== undefined) {
      // Visual
      if (this.#current !== this.#last)
        this.listContainer.removeChild(
          this.#current.divElement.nextElementSibling
        );
      this.listContainer.removeChild(this.#current.divElement);

      const beforeCur = this.#elements[this.#currentArrayPos - 1];
      const afterCur = this.#current.getNextElement();

      this.#elements = this.#elements.filter((val) => val !== this.#current);

      if (!beforeCur && !afterCur) {
        this.listContainer.innerHTML = "";
        this.#currentArrayPos = -1;

        this.#current = undefined;
        this.#first = undefined;
        this.#last = undefined;
        return;
      } else if (!beforeCur) {
        afterCur.setPointer(true, true, afterCur === this.#last);

        this.#first = afterCur;
        this.#current = afterCur;
      } else if (!afterCur) {
        beforeCur.setPointer(false, beforeCur === this.#first, true);

        this.listContainer.removeChild(beforeCur.divElement.nextElementSibling);

        this.#last = beforeCur;
        beforeCur.setNextElement(undefined);
        this.#current = undefined;
        this.#currentArrayPos = -1;
      } else {
        this.#current = afterCur;

        beforeCur.setNextElement(afterCur);

        afterCur.setPointer(
          true,
          this.#current === this.#first,
          this.#current === this.#last
        );
      }
    }
  }

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
