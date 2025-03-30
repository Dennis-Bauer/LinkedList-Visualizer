export class ListElement {
  constructor(value) {
    this.value = value;
    console.log("HAHAHHAHA");
  }

  get htmlString() {
    return `<div class="node-container">
                  <div class="node">${this.value}</div>
              </div>`;
  }
}
