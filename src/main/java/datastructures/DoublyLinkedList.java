package datastructures;

public class DoublyLinkedList<T> {

    private Link<T> first;
    private Link<T> last;

    public void insertFirst(T data) {
        Link<T> temp = first;
        first = new Link<>(data);
        first.setNext(temp);
        if (temp != null) {
            temp.setPrevious(first);
        }

        if (last == null) {
            last = first;
        }
    }

    public void insertLast(T data) {
        if (last == null) {
            last = new Link<>(data);
            return;
        }

        Link<T> temp = last;
        last = new Link<>(data);
        last.setPrevious(temp);
        temp.setNext(last);
    }

    public T deleteFirst() {
        if (isEmpty()) {
            return null;
        }

        Link<T> temp = first;
        first = first.getNext();
        first.setPrevious(null);
        return temp.getData();
    }

    public T deleteLast() {
        if (isEmpty()) {
            return null;
        }

        Link<T> temp = last;
        last = last.getPrevious();
        if (last != null) {
            last.setNext(null);
        }
        return temp.getData();
    }

    public boolean delete(T dataToDelete) {
        Link<T> toDelete = findLink(dataToDelete);

        if (toDelete != null) {
            toDelete.getPrevious().setNext(toDelete.getNext());
            toDelete.getNext().setPrevious(toDelete.getPrevious());
            return true;
        }

        return false;
    }

    public boolean insertAfter(T afterThis, T dataToInsert) {
        Link<T> afterThisLink = findLink(afterThis);

        if (afterThisLink != null) {
            if (afterThisLink == last) {
                insertLast(dataToInsert);
                return true;
            }

            Link<T> newLink = new Link<>(dataToInsert);
            newLink.setNext(afterThisLink.getNext());
            newLink.setPrevious(afterThisLink);
            afterThisLink.setNext(newLink);
            return true;
        }

        return false;
    }

    public boolean insertBefore(T beforeThis, T dataToInsert) {
        Link<T> beforeThisLink = findLink(beforeThis);

        if (beforeThisLink != null) {
            if (beforeThisLink == first) {
                insertFirst(dataToInsert);
                return true;
            }

            Link<T> newLink = new Link<>(dataToInsert);
            newLink.setNext(beforeThisLink);
            newLink.setPrevious(beforeThisLink.getPrevious());
            beforeThisLink.getPrevious().setNext(newLink);
            beforeThisLink.setPrevious(newLink);
            return true;
        }

        return false;
    }

    private Link<T> findLink(T data) {
        Link<T> current = first;

        while (current != null) {
            if (current.getData().equals(data)) {
                return current;
            }
            current = current.getNext();
        }

        return null;
    }

    public T getFirst() {
        if (first != null) {
            return first.getData();
        }
        return null;
    }

    public T getLast() {
        if (last != null) {
            return last.getData();
        }
        return null;
    }

    public boolean isEmpty() {
        return first == null || last == null;
    }

    public int size() {
        Link<T> current = last;
        int size = 0;
        while (current != null) {
            size += 1;
            current = current.getPrevious();
        }

        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Link<T> current = first;

        while (current != null) {
            builder.append(current.getData());
            if (current.getNext() != null) {
                builder.append("->");
            }
            current = current.getNext();
        }

        return builder.toString();
    }

    private class Link<T> {
        private T data;
        private Link<T> next;
        private Link<T> previous;

        private Link(T data) {
            this.data = data;
        }

        private T getData() {
            return data;
        }

        private Link<T> getNext() {
            return next;
        }

        private void setNext(Link<T> next) {
            this.next = next;
        }

        private Link<T> getPrevious() {
            return previous;
        }

        private void setPrevious(Link<T> previous) {
            this.previous = previous;
        }
    }
}
