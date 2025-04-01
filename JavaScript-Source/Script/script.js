"use strict";

import { LinkedList } from "./LinkedList.js";

const listContainer = document.getElementsByClassName("list-container")[0];
const outputLabel = document.getElementById("output");

const mainLinkedList = new LinkedList(listContainer);

// Buttons
document.getElementById("button-next").addEventListener("click", function () {
  mainLinkedList.next();
});

document.getElementById("button-append").addEventListener("click", function () {
  //const value = prompt("Welchen Wert soll dein neues Element haben?");

  mainLinkedList.append(Number(22));
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

let timeoutId;

const resetOutput = function (lElement) {
  if (timeoutId !== undefined) clearTimeout(timeoutId);

  timeoutId = setTimeout(() => {
    outputLabel.textContent = "...";
    if (lElement) lElement.resetVisibility();
  }, 5000);
};
