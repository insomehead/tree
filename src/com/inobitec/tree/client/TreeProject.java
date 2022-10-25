package com.inobitec.tree.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.inobitec.tree.client.widget.ClientReactTreePanel;

public class TreeProject implements EntryPoint {

    private ClientReactTreePanel clientReactTreePanel = new ClientReactTreePanel();
    public static final TreeServiceAsync treeService = GWT.create(TreeService.class);
    
    public void onModuleLoad() {
        RootPanel.get("clientReactTreePanel").add(clientReactTreePanel);
    }

}
