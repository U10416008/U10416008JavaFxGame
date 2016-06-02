/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u10416008fxgame;

import java.security.SecureRandom;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author user
 */
public class ArrowGame extends Pane {
    
    SecureRandom direction = new SecureRandom();
    Group group = new Group();
    int score = 0 ;
    MeshView arM[] = new MeshView[4];
    Timeline arC;
    Timeline arD;
    public ArrowGame(){
        setStyle("-fx-background-color : transparent");
    }
    public void paint(){
        Room3Ar arrow[] = new Room3Ar[4];
        Rotate rz[] = new Rotate[4];
        for(int i = 0; i<4 ;i++){
            arrow[i] = new Room3Ar();
            arM[i] = new MeshView(arrow[i]);
            rz[i] = new Rotate(90*i , Rotate.Z_AXIS);
            arM[i].getTransforms().addAll(rz[i]);
            arM[i].setLayoutX(-150 + 100*i);
            arM[i].setLayoutY(150);
            if(i == 3){
                arM[i].setLayoutY(180);
            }
        }
        
        getChildren().clear();
        getChildren().addAll(arM);
        play();
        
    }
    public void play(){
        
        ParallelTransition arCD = new ParallelTransition();
        arC = new Timeline(new KeyFrame(Duration.millis(500), e -> {
            group.getChildren().add(new MeshView(new Room3Ar()));
            group.getChildren().get(group.getChildren().size()-1).setLayoutY(-200);
            int direct = direction.nextInt(4);
            if(direct == 3){
                group.getChildren().get(group.getChildren().size()-1).setLayoutY(-170);
            }
            Rotate rz = new Rotate(90*direct,Rotate.Z_AXIS);
            group.getChildren().get(group.getChildren().size()-1).setLayoutX(-150 + 100*direct);
            group.getChildren().get(group.getChildren().size()-1).getTransforms().addAll(rz);
        }));
        arC.setCycleCount(100);
        arD = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            move();
        }));
        arD.setCycleCount(Timeline.INDEFINITE);
        arCD.getChildren().addAll(arD,arC);
        arCD.setCycleCount(1);
        arCD.play();
        getChildren().addAll(group);
        
    }
    public void move(){
        for(Node node: group.getChildren()){
            
                MeshView ar = (MeshView)node;
                ar.setLayoutY(ar.getLayoutY()+2);              
                
        }
    }
    public void control(KeyCode e){
        int i = 0;
        final int s10 = 10;
        final int s8 = 15;
        final int s6 = 20;
        final int s4 = 25;
        final int s2 = 30;
        
        if(e == KeyCode.LEFT){
            i = 0;
        }
        if(e == KeyCode.UP){
            i = 1;
        }
        if(e == KeyCode.RIGHT){
            i = 2;
        }
        if(e == KeyCode.DOWN){
            i = 3;
        }
        for(Node node: group.getChildren()){
                MeshView ar = (MeshView)node;
                if(ar.getLayoutX() == arM[i].getLayoutX()){
                    if(ar.getLayoutY() >= arM[i].getLayoutY()-s10 &&ar.getLayoutY() <= arM[i].getLayoutY()+s10){
                        ar.setVisible(false);
                        score += 10;
                    }
                    else if(ar.getLayoutX() == arM[i].getLayoutX()&& ar.getLayoutY() >= arM[i].getLayoutY()-s8 &&ar.getLayoutY() <= arM[i].getLayoutY()+s8){
                        ar.setVisible(false);
                        score += 8;
                    }
                    else if(ar.getLayoutX() == arM[i].getLayoutX()&& ar.getLayoutY() >= arM[i].getLayoutY()-s6 &&ar.getLayoutY() <= arM[i].getLayoutY()+s6){
                        ar.setVisible(false);
                        score += 6;
                    }
                    else if(ar.getLayoutX() == arM[i].getLayoutX()&& ar.getLayoutY() >= arM[i].getLayoutY()-s4 &&ar.getLayoutY() <= arM[i].getLayoutY()+s4){
                        ar.setVisible(false);
                        score += 4;
                    }
                    else if(ar.getLayoutX() == arM[i].getLayoutX()&& ar.getLayoutY() >= arM[i].getLayoutY()-s2 &&ar.getLayoutY() <= arM[i].getLayoutY()+s2){
                        ar.setVisible(false);
                        score += 2;
                    }
                }
                
            }
        System.out.println(score);
        
    }
}
