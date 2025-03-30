"use strict";

import { LinkedList } from "./LinkedList.js";
import { ListElement } from "./ListElement.js";

const currentPointerHtml = `<div class="pointer">Current</div>`;
const firstPointerHtml = `<div class="pointer">First</div>`;
const lastPointerHtml = `<div class="pointer">Last</div>`;
const arrow = `<div class="arrow">→</div>`;

const listContainer = document.getElementsByClassName("list-container")[0];
const currentLabel = document.getElementById("current-null");
const outputLabel = document.getElementById("output");

//listContainer.insertAdjacentHTML("beforeend", arrow);

const e = new ListElement(2);

// Buttons
document.getElementById("button-next").addEventListener("click", function () {
  console.log("Button Click");
});

document.getElementById("button-append").addEventListener("click", function () {
  console.log("Button Click");
});

document
  .getElementById("button-setContent")
  .addEventListener("click", function () {
    console.log("Button Click");
  });

document
  .getElementById("button-toFirst")
  .addEventListener("click", function () {
    console.log("Button Click");
  });

document.getElementById("button-insert").addEventListener("click", function () {
  console.log("Button Click");
});

document
  .getElementById("button-getContent")
  .addEventListener("click", function () {
    console.log("Button Click");
  });

document.getElementById("button-toLast").addEventListener("click", function () {
  console.log("Button Click");
});

document.getElementById("button-remove").addEventListener("click", function () {
  console.log("Button Click");
});

document
  .getElementById("button-isEmpty")
  .addEventListener("click", function () {
    console.log("Button Click");
  });

document
  .getElementById("button-hasCurrentAccess")
  .addEventListener("click", function () {
    console.log("Button Click");
  });
