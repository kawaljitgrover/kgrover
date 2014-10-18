package datastructures;

public class SinglyLinkedList<T> {

    private Link<T> first;

    public void insertFirst(T data) {
        Link<T> temp = first;
        first = new Link<>(data);
        first.setNext(temp);
    }

    public void insertLast(T data) {
        if (first == null) {
            insertFirst(data);
            return;
        }

        Link<T> current = first;
        while (current != null) {
            if (current.getNext() == null) {
                current.setNext(new Link<>(data));
                break;
            }
            current = current.getNext();
        }

    }

    public void insertAfter(T afterThis, T data) {
        Link<T> current = first;

        while (current != null) {
            if (current.getData().equals(afterThis)) {
                break;
            }
            current = current.getNext();
        }

        if (current == null) {
            throw new RuntimeException("After This Link does not exist : " + afterThis);
        }

        Link<T> newLink = new Link<>(data);
        newLink.setNext(current.getNext());
        current.setNext(newLink);

    }

    public void insertBefore(T beforeThis, T data) {
        Link<T> current = first;
        Link<T> previous = null;
        while (current != null) {
            if (current.getData().equals(beforeThis)) {
                break;
            }
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            throw new RuntimeException("Before This Link does not exist : " + beforeThis);
        }

        if (previous == null) {
            insertFirst(data);
            return;
        }


        Link<T> newLink = new Link<>(data);
        newLink.setNext(current);
        previous.setNext(newLink);
    }

    public T deleteFirst() {
        Link<T> temp = first;
        first = first.getNext();
        return temp.getData();
    }

    public T deleteLast() {
        Link<T> current = first;
        Link<T> previous = null;
        while (current != null) {
            if (current.getNext() == null) {
                break;
            }
            previous = current;
            current = current.getNext();
        }

        if (first != null && previous == null) {
            return deleteFirst();
        }

        if (current != null && previous != null) {
            previous.setNext(null);
            return current.getData();
        }

        return null;
    }

    public T getHead() {
        if (first != null) {
            return first.getData();
        }
        return null;
    }

    public T getTail() {
        Link<T> current = first;
        while (current != null) {
            if (current.getNext() == null) {
                break;
            }
            current = current.getNext();
        }

        if (current != null) {
            return current.getData();
        }

        return null;
    }

    public boolean isExist(T data) {
        Link<T> current = first;

        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        int size = 0;
        Link<T> current = first;
        while (current != null) {
            size += 1;
            current = current.getNext();
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
    }
}
