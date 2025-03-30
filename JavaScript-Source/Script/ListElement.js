import { ContentTypError } from "./Errors/ContentTypError.js";

export class ListElement {
  divElement;

  constructor(value) {
    if (typeof value === "number") this.value = value;
    else throw new ContentTypError();
  }

  addPointer(pointerName) {
    if (this.divElement !== undefined) {
      this.divElement.querySelector(".pointer").textContent = pointerName;
    }
  }

  setContent(content) {
    if (typeof content === "number") {
      this.value = content;
      this.divElement.querySelector(".node").textContent = content;
    } else throw new ContentTypError();
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
}
