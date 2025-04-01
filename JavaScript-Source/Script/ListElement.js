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

  setPointer(isCurrent = false, isFirst = false, isLast = false) {
    if (this.divElement) {
      this.divElement.querySelector(".pointer").textContent = [
        isCurrent ? "Current" : null,
        isFirst ? "First" : null,
        isLast ? "Last" : null,
      ]
        .filter(Boolean)
        .join("/");
    }
  }

  addToDOM(parentElement, beforeElement) {
    const nodeString = `<div class="node-container">
            <div class="pointer"></div>
            <div class="node">${this.value}</div>
        </div>`;

    const template = document.createElement("template");
    template.innerHTML = nodeString.trim();
    const newNode = template.content.firstChild;

    if (beforeElement) {
      parentElement.insertBefore(newNode, beforeElement);
    } else {
      parentElement.appendChild(newNode);
    }

    this.divElement = newNode;
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
