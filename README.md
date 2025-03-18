# **Linked List Visualizer (German)** 

Ein Visualisierungstool für verkettete Listen, programmiert in **Java** mit **JavaFX**.  

## **Funktionen**  

- **Anzeige vom Current-Zeiger**: Es wird nur der Knoten sichtbar gemacht, auf dem der Zeiger Current steht.  
- **Visualisierung der Zeiger**: Es werden die drei Zeiger (**Current**, **First**, **Last**) gezeigt.
- **Keine sichtbaren Werte in den Nodes**: Werte beim Current-Zeiger werden erst vollständig sichtbar, wenn `getContent()` aufgerufen wird.  
- **Voreingestellte Test-Liste**: Eine vorgefertigte Liste kann genutzt und bearbeitet werden.  
- **Erstellung neuer Listen**:  
  - Leere Liste  
  - Liste mit einem initialen Element  
- **Methodennamen als Button-Beschriftungen**: Die Buttons sind exakt so benannt wie die Methoden.  
- **Eingabe über Input-Box**: Werte werden aus der Input-Box entnommen.  
- **Anpassbare Darstellung** in der `Main`-Klasse:  
  - **Fenstergröße**  
  - **Schriftart und Schriftgröße**  
  - **Farben der Pfeile**  
- **Integer-Liste**: Standardmäßig sind Zahlen auf **3 Ziffern begrenzt** (anpassbar in `Main`).  

## **Methoden**  

### `next()`  
Verschiebt den **Current-Zeiger** nach rechts. Wenn er am Ende ist, wird er auf `null` gesetzt. Falls `Current == null`, passiert nichts.  

### `toFirst()`  
Setzt den **Current-Zeiger** auf das erste Element. Wenn die Liste leer ist, bleibt `Current == null`.  

### `toLast()`  
Setzt den **Current-Zeiger** auf das letzte Element. Wenn die Liste leer ist, bleibt `Current == null`.  

### `append(Content)`  
Fügt das **Element ans Ende** der Liste hinzu (`Content` aus der Input-Box).  

### `insert(Content)`  
Fügt ein **Element rechts neben** dem Current-Zeiger ein (`Content` aus der Input-Box).  

### `remove()`  
Löscht das **Element, auf dem der Current-Zeiger steht**. Falls `Current == null`, passiert nichts.  

### `hasCurrentAccess()`  
Gibt `true` zurück, wenn `Current` **nicht null** ist, andernfalls `false`. Das Ergebnis wird im **Output-Label** angezeigt.  

### `setContent(Content)`  
Ändert den **Wert des aktuellen Knotens** (`Content` aus der Input-Box). Falls `Current == null`, passiert nichts.  

### `getContent()`  
Macht die gespeicherte Zahl in der **List-View heller**, wenn `Current` auf einen gültigen Knoten zeigt.  

### `isEmpty()`  
Gibt `true` zurück, wenn die Liste **leer** ist.  

---

Diese **Linked List Visualisierung** bietet eine intuitive Möglichkeit, das Verhalten einer **verketteten Liste** zu verstehen und zu testen. 

---

# **Linked List Visualizer (English)**  

A visualization tool for linked lists, programmed in **Java** with **JavaFX**.  

## **Features**  

- **Current Pointer Display**: Only the node where the **Current pointer** is located is visible.  
- **Pointer Visualization**: The three pointers (**Current**, **First**, **Last**) are displayed.  
- **No visible values in the nodes**: Values at the Current pointer are only fully visible when `getContent()` is called.  
- **Predefined Test List**: A predefined list can be used and modified.  
- **Creating New Lists**:  
  - Empty list  
  - List with an initial element  
- **Method names as button labels**: The buttons are named exactly as the methods.  
- **Input via Input Box**: Values are taken from the input box.  
- **Customizable Display** in the `Main` class:  
  - **Window size**  
  - **Font style and size**  
  - **Arrow colors**  
- **Integer List**: By default, numbers are limited to **3 digits** (configurable in `Main`).  

## **Methods**  

### `next()`  
Moves the **Current pointer** to the next node. If it reaches the end, it is set to `null`. If `Current == null`, nothing happens.  

### `toFirst()`  
Sets the **Current pointer** to the first element. If the list is empty, `Current` remains `null`.  

### `toLast()`  
Sets the **Current pointer** to the last element. If the list is empty, `Current` remains `null`.  

### `append(Content)`  
Adds the **element to the end** of the list (`Content` from the input box).  

### `insert(Content)`  
Inserts an **element right next to** the Current pointer (`Content` from the input box).  

### `remove()`  
Deletes the **element at the Current pointer**. If `Current == null`, nothing happens.  

### `hasCurrentAccess()`  
Returns `true` if `Current` is **not null**, otherwise `false`. The result is displayed in the **Output label**.  

### `setContent(Content)`  
Changes the **value of the current node** (`Content` from the input box). If `Current == null`, nothing happens.  

### `getContent()`  
Makes the stored number in the **List-View lighter** when `Current` points to a valid node.  

### `isEmpty()`  
Returns `true` if the list is **empty**.  

---

This **Linked List Visualization** provides an intuitive way to understand and test the behavior of a **linked list**.

# **Example Pictures (Beispiel Bilder)**  
<img width="790" alt="List_normalView" src="https://github.com/user-attachments/assets/226676b7-6cba-4af7-be69-1b58dfbfd6a8" />
<img width="790" alt="List_CreateNewListView" src="https://github.com/user-attachments/assets/baa75520-8557-4167-ab63-bbdd86b9a1c1" />
<img width="789" alt="List_1Element_Current-Null_IsEmpty-False" src="https://github.com/user-attachments/assets/f238c367-aa5a-45f6-a9e9-9f870789129a" />
