package de.dennis.llvisualizer;

import de.dennis.llvisualizer.Panes.ElementObjekt;

public class ListElement {

    private int content;
    private ListElement next = null;

    private final ElementObjekt objekt;

    public ListElement(int content) {
        this.content = content;

        objekt = new ElementObjekt(content);
    }

    public ElementObjekt getGraphicObject() {
        return objekt;
    }

    public ListElement getNext() {
        return next;
    }

    public void setContent(int content) {
        this.content = content;
        getGraphicObject().setContent(content);
    }

    public int getContent() {
        return content;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }
}

