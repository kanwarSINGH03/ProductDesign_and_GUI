package com.example.a3_2;

import javafx.scene.input.KeyEvent;

public class AppController {

    private BoxModel model;

    private InteractionModel iModel;

    private int curInd = -1;

    private int selInd;



    private enum InteractionState {
        READY, CURSOR, SELECTION, MANIPULATION
    }
    private InteractionState state = InteractionState.READY;

    public AppController(){

    }
    public void setModel(BoxModel m) {
        model = m;
    }

    public void setIModel(InteractionModel iModel) {
        this.iModel = iModel;
    }

    public void handleKeyPressed(KeyEvent ke){


//      switch (ke.getCode()){
//
//
//          case C:
//          {
//              if(ke.isControlDown()){
//                  model.addBox();
//              }
//              break;
//          }
//
//          case TAB:
//          {
//
//                iModel.unCurr();
//                if(curInd < model.getBoxes().size()-1  && curInd!= -1) {
//                    curInd ++;
//                }
//                else {
//                    curInd = 0;
//                }
//                System.out.println(curInd);
//                iModel.Current(model.cursorOnBox(curInd));
//                model.cursorOnBox(curInd).isCurrent(false);
//                break;
//
//          }
//      }

        switch (state)
        {
            case READY:{

                switch (ke.getCode())
                {
                    case C:
                    {
                        if(ke.isControlDown()){
                            model.addBox();
                            state = InteractionState.READY;
                        }
                        else
                        {

                        state = InteractionState.CURSOR;

                        }
                        break;
                    }

                }
            }
            case CURSOR:
            {

                switch (ke.getCode())
                {
                    case TAB:
                      {

                            if(curInd < model.getBoxes().size()-1  && curInd!= -1)
                            {
                                curInd ++;
                            }
                            else
                            {
                                curInd = 0;
                            }
                            System.out.println(curInd);
                            iModel.Current(model.cursorOnBox(curInd));
                            model.cursorOnBox(curInd).isCurrent(false);
                            iModel.unCurr();
                            break;
                      }
                    case LEFT:
                    {
                        Box box = model.cursorOnBox(curInd);
                        iModel.Current(model.findNearest(box,"Left"));

                        break;
                    }

                    case RIGHT:
                    {
                        Box box = model.cursorOnBox(curInd);
                        iModel.Current(model.findNearest(box,"Right"));
                        break;
                    }

                    case UP:
                    {
                        Box box = model.cursorOnBox(curInd);
                        iModel.Current(model.findNearest(box,"Up"));
                        break;
                    }

                    case DOWN:
                    {
                        Box box = model.cursorOnBox(curInd);
                        iModel.Current(model.findNearest(box,"Down"));
                        break;
                    }

                }

            }
            case SELECTION:{
                if(ke.isShiftDown())
                {
                    switch (ke.getCode())
                    {
                        case S:
                        {
                            model.selectAll();
                            state = InteractionState.MANIPULATION;
                            break;

                        }
                        case A:{
                            selInd = curInd +1;
                            if(selInd<model.getBoxes().size())
                            {
                                iModel.select(model.selectedBox(selInd));
                                state = InteractionState.MANIPULATION;
                            }
                            else
                            {
                                state =InteractionState.CURSOR;
                            }
                            break;
                        }
                    }
                }

            }
            case MANIPULATION:{

                if(ke.isShiftDown())

                    switch (ke.getCode())
                    {
                        case D:
                        case LEFT:
                        {

                            model.move(model.selectedBox(selInd),"Left");
                            break;
                        }
                        case RIGHT:
                        {
                            model.move(model.selectedBox(selInd),"Right");
                            break;
                        }
                        case UP:
                        {
                            model.move(model.selectedBox(selInd),"Up");
                            break;
                        }
                        case DOWN:
                        {
                            model.move(model.selectedBox(selInd),"Down");
                            break;
                        }
                        case U:
                        case J:
                        case L:
                        case R:
                        case T:
                        case B:
                        case H:
                        case V:

                    }

            }

        }



    }
}
