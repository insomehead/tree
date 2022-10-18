package com.inobitec.tree.client.widget;

import java.util.Iterator;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.inobitec.tree.shared.command.Command;
import com.inobitec.tree.shared.model.Node;

public class TreeTable extends Composite {

    private static final String TREE = "Tree: ";
    private Tree tree = new Tree();
    private Label label;
    private VerticalPanel verticalPanel;
    private TreeItem item;

    private Command command;

    private void build() {
        tree = new Tree();
        label = new Label(TREE);
        verticalPanel = new VerticalPanel();
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    private void bindTable() {
        tree.addSelectionHandler(new SelectionHandler<TreeItem>() {

            @Override
            public void onSelection(SelectionEvent<TreeItem> event) {
                command.bindCommand();
            }
        });
    }

    public TreeTable(String style) {
        build();
        verticalPanel.add(label);
        tree.setStyleName(style);
        verticalPanel.add(tree);
        bindTable();
        initWidget(verticalPanel);
    }

    public void addRootItem(Node node) {
        item = new TreeItem();
        item.setText(node.getName());
        item.setUserObject(node);
        tree.addItem(item);
    }

//TODO СДЕЛАТЬ ОБНОВЛЕНИЕ ТАБЛИЦЫ
    public void addChildItem(Node node) {
        item = new TreeItem();
        item.setText(node.getName());
        item.setUserObject(node);

        int id = node.getParentId();
        Iterator<TreeItem> treeItemIterator = tree.treeItemIterator();
        while (treeItemIterator.hasNext()) {
            TreeItem itemFromTable = treeItemIterator.next();
            Node nodeFromTable = (Node) itemFromTable.getUserObject();
            if (id == nodeFromTable.getId()) {
                itemFromTable.addItem(item);
            }
        }
    }

    public Node getUserObj() {
        return (Node) tree.getSelectedItem().getUserObject();
    }
    
    public int getIdFromUserObj() {
        Node node = getUserObj();
        return node.getId();
    }
}
