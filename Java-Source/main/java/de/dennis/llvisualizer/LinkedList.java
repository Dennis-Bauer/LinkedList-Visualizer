package de.dennis.llvisualizer;

import de.dennis.llvisualizer.Panes.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;


public class LinkedList extends ScrollPane {

    private final ListView LIST_VIEW = new ListView();

    private int currentPos;
    private int listLength;

    private ListElement first;
    private ListElement current;
    private ListElement last;

    public LinkedList(ListElement firstElement) {
        setContent(LIST_VIEW);

        setUpDesign();

        addFirstElement(firstElement);
    }

    public LinkedList() {
        setContent(LIST_VIEW);

        setUpDesign();

        currentPos = -1;
        listLength = 0;

        first = null;
        current = null;
        last = null;
    }

    private void setUpDesign() {
        setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        setMinHeight(Main.WINDOW_HEIGHT * 0.35);
        setBackground(new Background(new BackgroundFill(Main.PRIMARY_SECOND, null, null)));
        setFitToWidth(true);
        setFitToHeight(true);
    }

    public void append(ListElement e) {
        if (last == null ) addFirstElement(e);
        else if (last.getNext() == null) {
            listLength++;

            if (first == last) last.getGraphicObject().setPosArrowToFirst();
            else last.getGraphicObject().setPosArrowVisible(false);

            last.setNext(e);
            last = e;

            e.getGraphicObject().setPosArrowToLast();
            e.getGraphicObject().setPosArrowVisible(true);

            LIST_VIEW.addNode(e, listLength);
        }
        else throw new IllegalCallerException("Das 'Nächste Element' vom letztem Element, ist nicht Null! So kann es nicht das letzte Element sein!");
    }

    public void insert(ListElement e) {
        if (last == null && first == null) addFirstElement(e);
        else {
            if (current != null) {
                listLength++;

                e.setNext(current.getNext());
                current.setNext(e);

                if (current == last) {
                    last.getGraphicObject().setPosArrowVisible(false);
                    last = e;
                    last.getGraphicObject().setPosArrowToLast();
                    last.getGraphicObject().setPosArrowVisible(true);
                }

                LIST_VIEW.addNode(e, currentPos);
            } // Sonst eigentlich, fehler schmeißen
        }
    }

    public void setContentFromNode(int content) {
        if (current != null) {
            current.setContent(content);
        }
    }

    public void remove() {
        if (current != null) {
            ListElement previous = getPreviousElement();
            if (previous != null) {
                listLength--;

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

    public void next() {
        if (current != null) {
            current.getGraphicObject().setCurrentArrowVisible(false);
            current = current.getNext();

            currentPos++;
            if (current != null) current.getGraphicObject().setCurrentArrowVisible(true);
        }
    }

    public void toFirst() {
        if (first != null) {
            if (current != null) current.getGraphicObject().setCurrentArrowVisible(false);

            current = first;

            currentPos = 1;
            current.getGraphicObject().setCurrentArrowVisible(true);
        }
    }

    public void toLast() {
        if (last != null) {
            if (current != null) current.getGraphicObject().setCurrentArrowVisible(false);

            current = last;

            currentPos = listLength;
            current.getGraphicObject().setCurrentArrowVisible(true);
        }
    }

    public ListElement getContentNode() {
        if (current != null) {
            current.getGraphicObject().getContent();
            return current;
        } else return null;
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }

    public boolean hasCurrentAccess() {
        return current != null;
    }

    private void addFirstElement(ListElement e) {
        currentPos = 2;
        listLength = 1;

        first = e;
        last = e;

        e.getGraphicObject().setPosArrowToBoth();
        e.getGraphicObject().setPosArrowVisible(true);

        LIST_VIEW.addNode(e, 1);
    }

    private ListElement getPreviousElement() {
        if (current != first) {
            ListElement cur = current;

            toFirst();

            while (current.getNext() != cur) {
                next();

                if (current == last) return null;
            }
            ListElement result = current;

            current.getGraphicObject().setCurrentArrowVisible(false);
            current = cur;
            current.getGraphicObject().setCurrentArrowVisible(true);

            return result;
        } else return null;
    }

}
