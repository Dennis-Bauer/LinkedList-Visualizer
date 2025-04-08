import { ContentTypError } from "./Errors/ContentTypError.js";
import { NextElementTypError } from "./Errors/NextElementTypError.js";

/**
 * This class represents a single element in a linked list.
 * It stores a reference to the next element and the value of the current element.
 * Additionally, it handles its own graphical representation using a saved div element.
 *
 * @author Dennis Bauer
 * @version 1.0
 */

export class ListElement {
  divElement;
  isCurrent = false;
  #nextElement;
  #value;

  /**
   * The constructor initializes the list element with a value and an optional reference to the next element.
   * @param {number} value The numeric content of this list element. Throws an error if the value is not a number.
   * @param {ListElement} [nextElement] Optional reference to the next ListElement. Must be a ListElement instance or undefined.
   */
  constructor(value, nextElement = undefined) {
    if (typeof value === "number") this.#value = value;
    else throw new ContentTypError();

    if (nextElement instanceof ListElement || nextElement === undefined) {
      this.#nextElement = nextElement;
    } else throw new NextElementTypError();
  }

  /**
   * Updates the graphical pointer to indicate the current status of the node.
   * Each parameter is optional and defaults to false.
   * @param {boolean} [isCurrent=false] Whether this node is currently selected.
   * @param {boolean} [isFirst=false] Whether this node is the first in the list.
   * @param {boolean} [isLast=false] Whether this node is the last in the list.
   */
  setPointer(isCurrent = false, isFirst = false, isLast = false) {
    if (this.divElement) {
      this.divElement.querySelector(".pointer").textContent = [
        isCurrent ? "Current" : null,
        isFirst ? "First" : null,
        isLast ? "Last" : null,
      ]
        .filter(Boolean)
        .join("/");

      this.isCurrent = isCurrent;
      if (isCurrent) {
        this.divElement.querySelector(".node").textContent = this.#value;
        this.divElement.querySelector(".node").classList.add("currentVal");
      }
    }
  }

  /**
   * Adds this list element to the DOM at the specified position.
   * @param {ChildNode} parentElement The container (usually the list container) where this element will be added.
   * @param {ChildNode} beforeElement The element before which this element should be inserted. If undefined, the element is appended at the end.
   */
  addToDOM(parentElement, beforeElement) {
    const nodeString = `<div class="node-container">
            <div class="pointer"></div>
            <div class="node">X</div>
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

  /**
   * Resets the visibility of the content.
   * If this element is currently selected, the content is shown with a slight highlight.
   * Otherwise, the content is hidden and replaced with an "X".
   */
  resetVisibility() {
    if (this.divElement) {
      if (this.isCurrent)
        this.divElement.querySelector(".node").classList.add("currentVal");
      else {
        this.divElement.querySelector(".node").textContent = "X";
        this.divElement.querySelector(".node").classList.remove("currentVal");
      }
    }
  }

  /**
   * @returns The next element
   */
  getNextElement() {
    return this.#nextElement;
  }

  /**
   * Returns the current value of the element and updates its visual representation.
   * Visually indicates that the program has accessed the stored number by highlighting the node.
   * @returns The current numeric value of this list element.
   */
  getValue() {
    this.divElement.querySelector(".node").textContent = this.#value;
    this.divElement.querySelector(".node").classList.remove("currentVal");

    return this.#value;
  }

  /**
   * Sets the reference to the next list element in the chain.
   * Ensures that the new value is either another ListElement or undefined.
   * Throws an error if the provided value is of an invalid type.
   * @param {ListElement} newNextElement The element to be set as the next in the list.
   */
  setNextElement(newNextElement) {
    if (newNextElement instanceof ListElement || newNextElement === undefined) {
      this.#nextElement = newNextElement;
    } else throw new NextElementTypError();
  }

  /**
   * Sets the content of the element. Ensures that the new value is a number; otherwise, throws an error.
   * @param {number} content The new numeric value to be stored in this element.
   */
  setContent(content) {
    if (typeof content === "number") {
      this.value = content;
      this.divElement.querySelector(".node").textContent = content;
    } else throw new ContentTypError();
  }
}
