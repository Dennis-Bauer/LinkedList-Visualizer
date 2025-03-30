import { ContentTypError } from "./Errors/ContentTypError.js";
import { NextElementTypError } from "./Errors/NextElementTypError.js";

export class ListElement {
  divElement;
  #nextElement;

  constructor(value, nextElement = undefined) {
    if (typeof value === "number") this.value = value;
    else throw new ContentTypError();

    if (nextElement instanceof ListElement || nextElement === undefined) {
      this.#nextElement = nextElement;
    } else throw new NextElementTypError();
  }

  setContent(content) {
    if (typeof content === "number") {
      this.value = content;
      this.divElement.querySelector(".node").textContent = content;
    } else throw new ContentTypError();
  }

  setPointer(pointerName) {
    if (this.divElement !== undefined) {
      this.divElement.querySelector(".pointer").textContent = pointerName;
    }
  }

  addToDOM(parentElement) {
    parentElement.insertAdjacentHTML(
      "beforeend",
      `<div class="node-container">
            <div class="pointer"></div>
            <div class="node">${this.value}</div>
        </div>`
    );
    this.divElement = parentElement.lastElementChild;
  }

  getNextElement() {
    return this.#nextElement;
  }

  setNextElement(newNextElement) {
    if (newNextElement instanceof ListElement || newNextElement === undefined) {
      this.#nextElement = newNextElement;
    } else throw new NextElementTypError();
  }
}
