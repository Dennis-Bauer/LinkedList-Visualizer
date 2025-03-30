import { NextElementTypError } from "./Errors/NextElementTypError.js";
import { ListElement } from "./ListElement.js";

export class LinkedList {
  #elments = [];
  #currentPositon;

  constructor(listContainer) {
    this.listContainer = listContainer;
  }

  next() {}

  append(value) {
    const newElement = new ListElement(value, this.#elments.at(-1));

    this.#addElement(newElement);

    this.#elments.push(newElement);
  }

  setContent(content) {}

  toFirst() {}

  insert(content) {}

  getContent() {}

  toLast() {}

  remove() {}

  isEmpty() {}

  hasCurrentAccess() {}

  #addElement(listElement) {
    if (listElement instanceof ListElement) {
      if (this.#elments.length !== 0) {
        this.listContainer.insertAdjacentHTML(
          "beforeend",
          `<div class="arrow">→</div>`
        );
      }

      listElement.addToDOM(this.listContainer);
    } else throw new NextElementTypError();
  }
}
