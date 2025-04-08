import { ContentTypError } from "./Errors/ContentTypError.js";
import { NextElementTypError } from "./Errors/NextElementTypError.js";
import { ListElement } from "./ListElement.js";

/**
 * This class represents the entire list itself.
 * It contains the methods that the user can trigger via the buttons on the screen.
 * It controls the list and, as a result, also manages the graphical appearance.
 *
 * @author Dennis Bauer
 * @version 1.0
 */

export class LinkedList {
  #elements = [];

  // Current pointer
  #current = undefined;
  #currentArrayPos = -1;

  // First/Last pointer
  #last = undefined;
  #first = undefined;

  /**
   * This is the constructor. It sets the list container, which holds the entire list.
   * @param {Element} listContainer The container that should hold all current and future list elements.
   */
  constructor(listContainer) {
    this.listContainer = listContainer;
  }

  /**
   * Append adds a new element at the end of the list.
   * @param {Number} content The new element which gets added to the list.
   */
  append(content) {
    const newElement = new ListElement(content, undefined);
    if (this.#elements.at(-1) !== undefined)
      this.#elements.at(-1).setNextElement(newElement);

    this.#addElement(newElement, this.#elements.length);

    if (this.#elements.length === 0) {
      this.#first = newElement;
      this.#last = newElement;
    } else if (this.#elements.length === 1) {
      this.#elements.at(0).setPointer(false, true, false);

      this.#last = newElement;
    } else {
      this.#elements.at(-1).setPointer(this.#last === this.#current);
      this.#last = newElement;
    }

    newElement.setPointer(false, this.#elements.length === 0, true);

    this.#elements.push(newElement);
  }

  /**
   * Inserts a new element on the right side of the current pointer.
   * If the current pointer is undefined, the method does nothing.
   * @param {Number} content The new element to be added to the list.
   */
  insert(content) {
    if (this.#current) {
      if (this.#current === this.#last) {
        this.append(content);
      }

      const newElement = new ListElement(
        content,
        this.#current.getNextElement()
      );

      this.#current.setNextElement(newElement);

      console.log(this.#currentArrayPos);

      this.#addElement(newElement, this.#currentArrayPos + 1);

      this.#elements.splice(this.#currentArrayPos, 0, newElement);
      console.dir(this.#elements);
    }
  }

  /**
   * Sets the content of the current element.
   * If the current element is undefined, the method does nothing.
   * @param {Number} content The new content that replaces the old one.
   */
  setContent(content) {
    if (typeof content === "number") {
      if (this.#current) {
        this.#current.setContent(content);
      }
    } else throw new ContentTypError();
  }

  /**
   * Removes the current element.
   * If the current element is null, the method does nothing.
   */
  remove() {
    if (this.#current) {
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

  /**
   * This method moves the current pointer to the next element in the list.
   * If the current element is undefined, nothing happens.
   * If the current element is the last one, the current pointer is reset to undefined.
   */
  next() {
    if (this.#current) {
      this.#current.setPointer();

      this.#current.resetVisibility();

      this.#last.setPointer(false, false, true);

      this.#first.setPointer(
        false,
        true,
        this.#current === this.#first && this.#current === this.#last
      );

      this.#current = this.#current.getNextElement();

      if (!this.#current) {
        this.#currentArrayPos = -1;
      } else {
        this.#current.setPointer(true, false, this.#current === this.#last);

        this.#currentArrayPos++;
      }
    }
  }

  /**
   * Sets the current pointer to the first element.
   * If there is no first element, the method does nothing.
   */
  toFirst() {
    if (this.#first === this.#last) {
      this.#first?.setPointer(true, true, true);
      return;
    }

    if (this.#current) {
      if (this.#current === this.#last)
        this.#last.setPointer(false, false, true);
      else this.#current.setPointer();

      this.#current.resetVisibility();
    }

    this.#current = this.#first;

    if (this.#current) {
      this.#elements.at(0).setPointer(true, true, false);

      this.#currentArrayPos = 0;
    } else this.#currentArrayPos = -1;
  }

  /**
   * Sets the current pointer to the last element.
   * If there is no last element, the method does nothing.
   */
  toLast() {
    if (this.#first === this.#last) {
      this.#first?.setPointer(true, true, true);
      return;
    }

    if (this.#current) {
      if (this.#current === this.#first)
        this.#first.setPointer(false, true, false);
      else this.#current.setPointer();

      this.#current.resetVisibility();
    }

    this.#current = this.#last;

    if (this.#current) {
      this.#elements.at(-1).setPointer(true, false, true);

      this.#currentArrayPos = this.#elements.length - 1;
    } else this.#currentArrayPos = -1;
  }

  /**
   * Returns the list element that the current pointer is pointing to.
   * It also activates the visual mechanism in the list, where the current element (if it exists)
   * is highlighted with a lighter number, so the user knows which element the computer is currently focused on.
   * @return Returns the current list element, or "Null" if the element is undefined.
   */
  getContent() {
    if (this.#current) {
      return this.#current;
    } else return "Null";
  }

  /**
   * Returns whether the list is empty.
   * @return Returns true if there is a first and last element, otherwise false.
   */
  isEmpty() {
    return (
      this.#first === undefined &&
      this.#last === undefined &&
      this.#current === undefined
    );
  }

  /**
   * Returns whether the current element is accessible.
   * @return Returns true if current is not undefined, otherwise false.
   */
  hasCurrentAccess() {
    return this.#current !== undefined;
  }

  /**
   * This method controls where a new element is added visually.
   * It also handles the functionality when the list is empty and the new element becomes the first one.
   * @param {ListElement} listElement The list element to be added to the list.
   * @param {Number} pos The position at which the list element should be added.
   */
  #addElement(listElement, pos = this.#elements.length) {
    if (!(listElement instanceof ListElement)) {
      throw new NextElementTypError();
    }
    if (pos < 0 || pos > this.#elements.length) {
      throw new RangeError(
        "The position of a new node has to be positive and within bounds!"
      );
    }

    if (this.#elements.length === 0) {
      listElement.addToDOM(this.listContainer);
    } else {
      const arrow = document.createElement("div");
      arrow.classList.add("arrow");
      arrow.textContent = "→";

      const referenceElement = this.#elements.at(pos)?.divElement || null;

      if (pos >= this.#elements.length - 1) {
        this.listContainer.insertBefore(arrow, referenceElement);
        listElement.addToDOM(this.listContainer, referenceElement);
      } else {
        listElement.addToDOM(this.listContainer, referenceElement);
        this.listContainer.insertBefore(arrow, referenceElement);
      }
    }
  }
}
