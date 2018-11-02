package com.mean.ui.DataStruct;

import java.util.LinkedList;

/**
 * Created by renzhenhua on 2017/11/8.
 */

public class LinkList<E> {

    Node<E> first;
    Node<E> last;
    public int size;

    public LinkList() {
    }

    public void add(E e) {
        linkLast(e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == size) {
            linkLast(e);
        } else {
            if (index == 0) {
                Node<E> newNode = new Node<>(null, e, first);
                first.prev = newNode;
                first = newNode;
                size++;
            } else {
                Node<E> target = node(index);
                Node<E> prev = target.prev;
                Node<E> newNode = new Node<>(prev, e, target);
                prev.next = newNode;
                target.prev = newNode;
                size++;
            }
        }
    }

    public void remove(int index) {

        if (index < 0 || index >= size) {
            return;
        }

        if (index == size - 1) {
//            删除尾部

            Node<E> target = node(index);


            if (index == 0) {
                first = null;
                last=null;
            } else {
                last=last.prev;
                last.next=null;
            }
            size--;
        } else {
            if (index == 0) {
                first = first.next;
                first.prev = null;
            } else {
//        中间删除
                Node<E> target = node(index);
                Node<E> prev = target.prev;
                Node<E> next = target.next;
                prev.next = next;
                next.prev = prev;
            }
            size--;
        }
    }

    private void linkLast(E e) {
        Node<E> newNode = new Node<E>(last, e, null);
        Node<E> l = last;
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return node(index).item;
    }

    public Node<E> node(int index) {
        //        index处于前半部分
        if (index < size << 1) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {

            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    private static class Node<E> {
        E item;
        LinkList.Node<E> next;
        LinkList.Node<E> prev;

        Node(LinkList.Node<E> var1, E var2, LinkList.Node<E> var3) {
            this.item = var2;
            this.next = var3;
            this.prev = var1;
        }
    }
}