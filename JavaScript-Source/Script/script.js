"use strict";

import { LinkedList } from "./LinkedList.js";
import { ListElement } from "./ListElement.js";

const listContainer = document.getElementsByClassName("list-container")[0];
const currentLabel = document.getElementById("current-null");
const outputLabel = document.getElementById("output");

const mainLinkedList = new LinkedList(listContainer);

// Buttons
document.getElementById("button-next").addEventListener("click", function () {
  currentLabel.textContent = mainLinkedList.next() ? "______" : "Null";
});

document.getElementById("button-append").addEventListener("click", function () {
  //const value = prompt("Welchen Wert soll dein neues Element haben?");

  mainLinkedList.append(Number(12));
});

document
  .getElementById("button-setContent")
  .addEventListener("click", function () {
    //const value = prompt("Welchen neuen Wert soll dein Element haben?");

    mainLinkedList.setContent(Number(88));
  });

document
  .getElementById("button-toFirst")
  .addEventListener("click", function () {
    mainLinkedList.toFirst();
  });

document.getElementById("button-insert").addEventListener("click", function () {
  console.log("Button Click");
});

document
  .getElementById("button-getContent")
  .addEventListener("click", function () {
    outputLabel.textContent = mainLinkedList.getContent();

    resetOutput();
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

const resetOutput = function () {
  if (timeoutId !== undefined) clearTimeout(timeoutId);

  timeoutId = setTimeout(() => (outputLabel.textContent = "..."), 5000);
};
