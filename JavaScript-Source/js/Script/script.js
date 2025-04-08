"use strict";

import { LinkedList } from "./LinkedList.js";
import { ListElement } from "./ListElement.js";

// The div element that will contain all the list elements.
const listContainer = document.getElementsByClassName("list-container")[0];
// The label that will contain all the output displayed
const outputLabel = document.getElementById("output");

// Main list
const mainLinkedList = new LinkedList(listContainer);

// Event listeners for the buttons
document.getElementById("button-next").addEventListener("click", function () {
  mainLinkedList.next();
});

document.getElementById("button-append").addEventListener("click", function () {
  const value = prompt("Welchen Wert soll dein neues Element haben?");

  mainLinkedList.append(Number(value));
});

document
  .getElementById("button-setContent")
  .addEventListener("click", function () {
    const value = prompt("Welchen neuen Wert soll dein Element haben?");

    mainLinkedList.setContent(Number(value));
  });

document
  .getElementById("button-toFirst")
  .addEventListener("click", function () {
    mainLinkedList.toFirst();
  });

document.getElementById("button-insert").addEventListener("click", function () {
  const value = prompt("Welchen neuen Wert soll dein Element haben?");

  mainLinkedList.insert(Number(value));
});

document
  .getElementById("button-getContent")
  .addEventListener("click", function () {
    const lElement = mainLinkedList.getContent();

    if (lElement) {
      outputLabel.textContent = lElement.getValue();

      resetOutput(lElement);
    }
  });

document.getElementById("button-toLast").addEventListener("click", function () {
  mainLinkedList.toLast();
});

document.getElementById("button-remove").addEventListener("click", function () {
  mainLinkedList.remove();
});

document
  .getElementById("button-isEmpty")
  .addEventListener("click", function () {
    outputLabel.textContent = mainLinkedList.isEmpty();

    resetOutput();
  });

document
  .getElementById("button-hasCurrentAccess")
  .addEventListener("click", function () {
    outputLabel.textContent = mainLinkedList.hasCurrentAccess();

    resetOutput();
  });

// The current timeout ID. It is saved so the program can always clear it.
let timeoutId;

/**
 * This function controls the disappearance of the output label,
 * so that the output is not shown permanently.
 * @param {ListElement} lElement
 */
const resetOutput = function (lElement) {
  if (timeoutId !== undefined) clearTimeout(timeoutId);

  timeoutId = setTimeout(() => {
    outputLabel.textContent = "...";
    if (lElement) lElement.resetVisibility();
  }, 5000);
};
