export class ListElement {
  divElement;

  constructor(value) {
    this.value = value;
  }

  addPointer(pointerName) {
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
    this.divElement = parentElement.lastElementChild; // Speichert das hinzugefügte Element
  }
}
