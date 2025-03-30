export class ListElement {
  divElement;

  constructor(value) {
    this.value = value;
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
