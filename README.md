# **Linked List Visualizer (German)** 

Dieses Projekt bietet ein **Visualisierungstool** für **verkettete Listen**, das in **Java** mit **JavaFX** und **JavaScript** programmiert wurde. Beide Versionen funktionieren für den Benutzer auf die gleiche Weise.

Es gibt zwei separate Source-Ordner, in denen jeweils die entsprechende Version enthalten ist.

Für genauere Informationen findest du in jedem Ordner eine separate **ReadMe**.
## **Funktionen**  

- **Anzeige vom Current-Zeiger**: Es wird nur der Knoten sichtbar gemacht, auf dem der Zeiger Current steht.  
- **Visualisierung der Zeiger**: Es werden die drei Zeiger (**Current**, **First**, **Last**) gezeigt.
- **Keine sichtbaren Werte in den Nodes**: Werte beim Current-Zeiger werden erst vollständig sichtbar, wenn `getContent()` aufgerufen wird.  
- **Voreingestellte Test-Liste** (Nur in Java): Eine vorgefertigte Liste kann genutzt und bearbeitet werden.  
- **Erstellung neuer Listen** (Nur in Java):  
  - Leere Liste  
  - Liste mit einem initialen Element  
- **Methodennamen als Button-Beschriftungen**: Die Buttons sind exakt so benannt wie die Methoden.  
- **Eingabe über Input-Box**: Werte werden aus der Input-Box entnommen.  
- **Anpassbare Darstellung** in der `Main`-Klasse (Nur in Java):  
  - **Fenstergröße**  
  - **Schriftart und Schriftgröße**  
  - **Farben der Pfeile**  
- **Anpassbare Darstellung** im source Ordner (Nur in JavaScript):
  - **Schriftart und Schriftfarbe**
  - **Größe und Farben jeglicher Elemente**
- **Integer-Liste**: Standardmäßig sind Zahlen auf **3 Ziffern begrenzt** (anpassbar in `Main`). (Begrenzung nur in Java)  

## **Methoden**  

### `next()`  
Verschiebt den **Current-Zeiger** nach rechts. Wenn er am Ende ist, wird er auf `null`/`undefined` gesetzt. Falls `Current == null`/`Current === undefined`, passiert nichts.  

### `toFirst()`  
Setzt den **Current-Zeiger** auf das erste Element. Wenn die Liste leer ist, bleibt `Current == null`/`Current === undefined`.  

### `toLast()`  
Setzt den **Current-Zeiger** auf das letzte Element. Wenn die Liste leer ist, bleibt `Current = null`/`Current = undefined`.  

### `append(Content)`  
Fügt das **Element ans Ende** der Liste hinzu (`Content` aus der Input-Box).  

### `insert(Content)`  
Fügt ein **Element rechts neben** dem Current-Zeiger ein (`Content` aus der Input-Box).  

### `remove()`  
Löscht das **Element, auf dem der Current-Zeiger steht**. Falls `Current == null`/`Current === undefined`, passiert nichts.  

### `hasCurrentAccess()`  
Gibt `true` zurück, wenn `Current` **nicht null** / **nicht undefined** ist, andernfalls `false`. Das Ergebnis wird im **Output-Label** angezeigt.  

### `setContent(Content)`  
Ändert den **Wert des aktuellen Knotens** (`Content` aus der Input-Box). Falls `Current == null`/`Current === undefined`, passiert nichts.  

### `getContent()`  
Macht die gespeicherte Zahl in der **List-View heller**, wenn `Current` auf einen gültigen Knoten zeigt.  

### `isEmpty()`  
Gibt `true` zurück, wenn die Liste **leer** ist.  

---

Diese **Linked List Visualisierung** bietet eine intuitive Möglichkeit, das Verhalten einer **verketteten Liste** zu verstehen und zu testen. 

---

# **Linked List Visualizer (English)**  

This project provides a **visualization tool** for **linked lists**, programmed in **Java** with **JavaFX** and **JavaScript**. Both versions work the same way for the user.

There are two separate source folders, each containing the respective version.

For more detailed information, you can find a separate **ReadMe** in each folder.

## **Features**

- **Current pointer display**: Only the node that the Current pointer is pointing to is made visible.
- **Pointer visualization**: The three pointers (**Current**, **First**, **Last**) are displayed.
- **No visible values in the nodes**: Values at the Current pointer are only fully visible when `getContent()` is called.
- **Preset test list** (Java only): A pre-configured list can be used and modified.
- **Create new lists** (Java only):
  - Empty list
  - List with an initial element
- **Method names as button labels**: The buttons are named exactly as the methods.
- **Input via input box**: Values are taken from the input box.
- **Customizable display** in the `Main` class (Java only):
  - **Window size**
  - **Font and font size**
  - **Arrow colors**
- **Customizable display** in the source folder (JavaScript only):
  - **Font and font color**
  - **Size and colors of all elements**
- **Integer list**: By default, numbers are **limited to 3 digits** (can be adjusted in `Main`). (Limitation only in Java)

## **Methods**

### `next()`
Moves the **Current pointer** to the right. If it's at the end, it is set to `null`/`undefined`. If `Current == null`/`Current === undefined`, nothing happens.

### `toFirst()`
Sets the **Current pointer** to the first element. If the list is empty, `Current == null`/`Current === undefined` remains.

### `toLast()`
Sets the **Current pointer** to the last element. If the list is empty, `Current = null`/`Current = undefined` remains.

### `append(Content)`
Adds the **element to the end** of the list (`Content` from the input box).

### `insert(Content)`
Inserts an **element to the right of** the Current pointer (`Content` from the input box).

### `remove()`
Deletes the **element that the Current pointer is pointing to**. If `Current == null`/`Current === undefined`, nothing happens.

### `hasCurrentAccess()`
Returns `true` if `Current` is **not null** / **not undefined**, otherwise returns `false`. The result is displayed in the **output label**.

### `setContent(Content)`
Changes the **value of the current node** (`Content` from the input box). If `Current == null`/`Current === undefined`, nothing happens.

### `getContent()`
Makes the stored number in the **list view brighter** if `Current` points to a valid node.

### `isEmpty()`
Returns `true` if the list is **empty**.

---

This **Linked List Visualization** provides an intuitive way to understand and test the behavior of a **linked list**.

# **Example Pictures (Beispiel Bilder)**