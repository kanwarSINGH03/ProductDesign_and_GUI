package com.example.a2;

import javafx.scene.layout.Pane;

public class LayoutView extends Pane {

    private LinearLayout root;

    public LayoutView() {

        root = new LinearLayout();

        root.addChild(new SimWidget(50,200,200,SimWidget.VerticalPosition.MIDDLE));
        root.addChild(new SimWidget(100,800,100,SimWidget.VerticalPosition.TOP));
        root.addChild(new SimWidget(150,250,150,SimWidget.VerticalPosition.FILL));

        root.doLayout(this.getWidth(),this.getHeight());

        this.widthProperty().addListener((observable) -> root.doLayout(this.getWidth(),this.getHeight()));
        this.heightProperty().addListener((observable) -> root.doLayout(this.getWidth(),this.getHeight()));

        addRectangles(root);



    }

    /**
     *
     * @param root takes a linear layout a arguments and adds all the rectangles
     */

    public void addRectangles(LinearLayout root) {
        // add rectangles of root and its children to LayoutView
        this.getChildren().add(root.getLayout_container());
        for(SimWidget sw : root.getSim_list())
        {
            this.getChildren().add(sw.getRectangle());
        }
    }

    public static void main(String[] args) {
        LayoutView view = new LayoutView();
        System.out.println(view.getWidth());
    }




}
