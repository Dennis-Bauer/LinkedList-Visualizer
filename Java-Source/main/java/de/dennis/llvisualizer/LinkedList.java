package de.dennis.llvisualizer;

import de.dennis.llvisualizer.Panes.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

/**
 * This class represents the list itself.
 * Its primary task is to keep track of the current element, the first element, and the last element.
 * It also manages the list with several methods, which are listed and explained within the class.
 *
 * @author Dennis Bauer
 * @version 1.0
 */

public class LinkedList extends ScrollPane {

    // Graphical List
    private final ListView LIST_VIEW = new ListView();

    private int currentPos;
    private int listLength;

    // Pointer
    private ListElement first;
    private ListElement current;
    private ListElement last;

    /**
     * This is the first constructor. It creates a list with a given first element.
     * @param firstElement The first element with which the list will start.
     */
    public LinkedList(ListElement firstElement) {
        setContent(LIST_VIEW);

        setUpDesign();

        addFirstElement(firstElement);
    }

    /**
     * This is the second constructor. It creates an empty list.
     */
    public LinkedList() {
        setContent(LIST_VIEW);

        setUpDesign();

        currentPos = -1;
        listLength = 0;

        first = null;
        current = null;
        last = null;
    }

    /**
     * This method sets up the graphical representation of the list. It is in its own function because there are two constructors.
     */
    private void setUpDesign() {
        setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        setMinHeight(Main.WINDOW_HEIGHT * 0.35);
        setBackground(new Background(new BackgroundFill(Main.SECOND_COLOR, null, null)));
        setFitToWidth(true);
        setFitToHeight(true);
    }

    /**
     * Append adds a new element at the end of the list.
     * @param e The new element which gets added to the list.
     */
    public void append(ListElement e) {
        // Checks if the list is empty. If it is, the addFirstElement(e) method is used to set the first element.
        if (last == null) addFirstElement(e);
            // Verifies that 'last' is indeed the last element
        else if (last.getNext() == null) {
            listLength++;

            // Checks if the list has only one element. If so, the previous element is now only the first element, not both the first and last.
            if (first == last) last.getGraphicObject().setPosArrowToFirst();
            else last.getGraphicObject().setPosArrowVisible(false);

            // Adds the new element to the list.
            last.setNext(e);
            last = e;

            // Updates the visual representation of the last pointer to the new element.
            e.getGraphicObject().setPosArrowToLast();
            e.getGraphicObject().setPosArrowVisible(true);

            // Adds the new element to the visual list.
            LIST_VIEW.addNode(e, listLength);
        }
        else throw new IllegalCallerException("The 'next element' of the last element is not null! Therefore, it cannot be the last element!");
    }

    /**
     * Inserts a new element on the right side of the current pointer.
     * If the current pointer is null, the method does nothing.
     * @param e The new element to be added to the list.
     */
    public void insert(ListElement e) {
        // Checks if current is null.
        if (current != null) {
            listLength++;

            // Sets the new element between the current element and its old next element.
            e.setNext(current.getNext());
            current.setNext(e);

            // Checks if the current pointer is the last one.
            // This is necessary because, in this case, there are no two elements to place the new element between,
            // and the pointers need to be updated additionally.
            if (current == last) {
                last.getGraphicObject().setPosArrowVisible(false);
                last = e;
                last.getGraphicObject().setPosArrowToLast();
                last.getGraphicObject().setPosArrowVisible(true);
            }

            LIST_VIEW.addNode(e, currentPos);
        }
    }

    /**
     * Sets the content of the current element.
     * If the current element is null, the method does nothing.
     * @param content The new content that replaces the old one.
     */
    public void setContentFromNode(int content) {
        // Checks if current is null
        if (current != null) {
            // Uses the built-in method from ListElement to set the content
            current.setContent(content);
        }
    }

    /**
     * Removes the current element.
     * If the current element is null, the method does nothing.
     */
    public void remove() {
        // Checks if current is null
        if (current != null) {
            // Gets the previous element of current to set its next to current's next.
            ListElement previous = getPreviousElement();
            // Checks if previous is null. If yes, current is at the beginning of the list.
            // This is necessary because if current is at the beginning, there is no previous element to update.
            // Additionally, the pointers need to be adjusted accordingly.
            if (previous != null) {
                listLength--;

                // Checks if current is at the end of the list.
                // This is necessary because if current is at the end, there is no next element for the previous element.
                // Additionally, the pointers need to be adjusted.
                if (current == last) {
                    last = previous;
                    last.setNext(null);

                    last.getGraphicObject().setPosArrowToLast();
                    last.getGraphicObject().setPosArrowVisible(true);

                    current = null;

                    LIST_VIEW.removeNode(currentPos + 1);
                } else {
                    previous.setNext(current.getNext());

                    LIST_VIEW.removeNode(currentPos + 1);

                    current = current.getNext();
                    current.getGraphicObject().setCurrentArrowVisible(true);
                }
            } else {
                first = first.getNext();

                if (first != null) {
                    first.getGraphicObject().setPosArrowVisible(true);
                    first.getGraphicObject().setPosArrowToFirst();

                    current = current.getNext();
                    if (current != null) current.getGraphicObject().setCurrentArrowVisible(true);

                    LIST_VIEW.removeNode(1);
                } else {
                    LIST_VIEW.removeNode(1);

                    current = null;
                    first = null;
                    last = null;
                }
            }
        }
    }

    /**
     * Sets the current pointer to its next element.
     * If the current element is null, the method does nothing.
     * If the current's next element is null, current is also set to null.
     */
    public void next() {
        // Checks if current is null
        if (current != null) {
            current.getGraphicObject().setCurrentArrowVisible(false);
            current = current.getNext();

            currentPos++;
            if (current != null) current.getGraphicObject().setCurrentArrowVisible(true);
        }
    }

    /**
     * Sets the current pointer to the first element.
     * If there is no first element, the method does nothing.
     */
    public void toFirst() {
        // Checks if there is a first element
        if (first != null) {
            if (current != null) current.getGraphicObject().setCurrentArrowVisible(false);

            current = first;

            currentPos = 1;
            current.getGraphicObject().setCurrentArrowVisible(true);
        }
    }

    /**
     * Sets the current pointer to the last element.
     * If there is no last element, the method does nothing.
     */
    public void toLast() {
        // Checks if there is a last element
        if (last != null) {
            if (current != null) current.getGraphicObject().setCurrentArrowVisible(false);

            current = last;

            currentPos = listLength;
            current.getGraphicObject().setCurrentArrowVisible(true);
        }
    }

    /**
     * Returns the list element that the current pointer is pointing to.
     * It also activates the visual mechanism in the list, where the current element (if it exists)
     * is highlighted with a lighter number, so the user knows which element the computer is currently focused on.
     * @return Returns the current list element, or null if the element is null.
     */
    public ListElement getContentNode() {
        // Checks if current is null
        if (current != null) {
            // Sets the visual effect on the number in the visual list
            current.getGraphicObject().getContent();
            return current;
        } else return null;
    }

    /**
     * Returns whether the list is empty.
     * @return Returns true if there is a first and last element, otherwise false.
     */
    public boolean isEmpty() {
        return first == null && last == null;
    }

    /**
     * Returns whether the current element is accessible.
     * @return Returns true if current is not null, otherwise false.
     */
    public boolean hasCurrentAccess() {
        return current != null;
    }

    /**
     * Adds the first element to an empty list.
     * @param e The first element to be added to the list.
     */
    private void addFirstElement(ListElement e) {
        currentPos = 2;
        listLength = 1;

        first = e;
        last = e;

        e.getGraphicObject().setPosArrowToBoth();
        e.getGraphicObject().setPosArrowVisible(true);

        LIST_VIEW.addNode(e, 1);
    }

    /**
     * Returns the previous element from current.
     * @return Returns the found element, or null if no previous element is found.
     */
    private ListElement getPreviousElement() {
        // Checks if current is not the first element. If it is the first element, it can't have a previous element.
        if (current != first) {
            // Temporarily saves the current element
            ListElement temp = current;

            // Sets the current element to the first element
            toFirst();

            // Iterates through the list until it finds an element whose next element is the current element
            while (current.getNext() != temp) {
                next();

                if (current == last) return null;
            }
            // Saves the result (the previous element)
            ListElement result = current;

            current.getGraphicObject().setCurrentArrowVisible(false);
            // Sets the current element back to the saved current element so it doesn't get changed
            current = temp;
            current.getGraphicObject().setCurrentArrowVisible(true);

            // Returns the previous element
            return result;
        } else return null;
    }

}
