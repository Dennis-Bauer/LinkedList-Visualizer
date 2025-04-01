package de.dennis.llvisualizer;

import de.dennis.llvisualizer.Panes.ElementObjekt;

/**
 * This class represents a list element. It contains the reference to the next list element as well as the value.
 * It also includes a graphic object, allowing modifications to what the user sees through the ListElement object.
 *
 * @author Dennis Bauer
 * @version 1.0
 */

public class ListElement {

    private int content;
    private ListElement next = null;

    // Graphic object
    private final ElementObjekt objekt;

    /**
     * This is the constructor
     * @param content The value of the element which gets created.
     */
    public ListElement(int content) {
        this.content = content;

        objekt = new ElementObjekt(content);
    }

    /**
     * Getter for the graphic object
     * @return The graphic object.
     */
    public ElementObjekt getGraphicObject() {
        return objekt;
    }

    /**
     * Getter for the next element.
     * @return The next element.
     */
    public ListElement getNext() {
        return next;
    }

    /**
     * Getter for the content.
     * @return The content.
     */
    public int getContent() {
        return content;
    }

    /**
     * Setter for the content.
     * @param content  The new value for the content.
     */
    public void setContent(int content) {
        this.content = content;
        getGraphicObject().setContent(content);
    }

    /**
     * Setter for the content.
     * @param next  The new value for the next element.
     */
    public void setNext(ListElement next) {
        this.next = next;
    }
}

