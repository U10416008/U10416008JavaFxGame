/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u10416008fxgame;

import java.security.SecureRandom;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
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
    int speed = 2;
    int create = 500;
    MeshView arM[] = new MeshView[4];
    ParallelTransition arCD = new ParallelTransition();
    Timeline arC;
    Timeline arD;
    Timeline rank;
    int createTimes = 0;
    public ArrowGame(){
        
    }
    public ArrowGame(int level){
        setStyle("-fx-background-color : transparent");
        
        switch (level) {
            case 0:
                speed = 2;
                create = 500;
                break;
            case 1:
                speed = 3;
                create = 350;
                break;
            default:
                speed = 5;
                create = 250;
                break;
        }
        
        arC = new Timeline(new KeyFrame(Duration.millis(create), e -> {
            group.getChildren().add(new MeshView(new Room3Ar()));
            group.getChildren().get(group.getChildren().size()-1).setLayoutY(-300);
            int direct = direction.nextInt(4);
            if(direct == 3){
                group.getChildren().get(group.getChildren().size()-1).setLayoutY(-270);
            }
            Rotate rz = new Rotate(90*direct,Rotate.Z_AXIS);
            group.getChildren().get(group.getChildren().size()-1).setLayoutX(-150 + 100*direct);
            group.getChildren().get(group.getChildren().size()-1).getTransforms().addAll(rz);
            createTimes++;
        }));
        arC.setCycleCount(100);
        arD = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            move();
        }));
        arD.setCycleCount(Timeline.INDEFINITE);
        arCD.getChildren().addAll(arD,arC);
        arCD.setCycleCount(1);
        paint();
        rank = new Timeline(new KeyFrame(Duration.millis(3000), e -> {
            stop();
            rank();
        }));
        rank.setCycleCount(1);
        
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

        arCD.play();
        getChildren().addAll(group);
        
    }
    public void move(){
        for(Node node: group.getChildren()){
            
                MeshView ar = (MeshView)node;
                ar.setLayoutY(ar.getLayoutY()+speed);              
                
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
        if(createTimes == 100){
            
            rank.play();
        }
        
    }
    public void stop(){
        arCD.stop();
    }
    public void rank(){
        Room3S S = new Room3S();
        Room3Ar arrow = new Room3Ar();
        MeshView finalRank = new MeshView();
        getChildren().clear();
        int duration = 500;
        int cycle = 5;
        if(score >= 900){
            S.paintS();
            finalRank = new MeshView(S);
            duration = 250;
            cycle = 10;
            
        }else if(score >= 800){
            S.paintA();
            finalRank = new MeshView(S);
            finalRank.setLayoutY(-50);
            duration = 300;
            cycle = 8;
            
        }else if(score >= 600){
            S.paintC();
            finalRank = new MeshView(S);
            duration = 400;
            cycle = 6;
            
        }else if(score >= 500){
            S.paintD();
            finalRank = new MeshView(S);
            duration = 500;
            cycle = 5;
        }else{
            S.paintF();
            finalRank = new MeshView(S);
            finalRank.setLayoutX(-120);
            finalRank.setLayoutY(200);
            duration = 2500;
            cycle = 1;
        }
        MeshView arrowReturn = new MeshView(arrow);
        arrowReturn.setLayoutX(-300);
        arrowReturn.setLayoutY(-150);
        arrowReturn.setOnMousePressed(e ->{
            createTimes = 0;
            this.score = 0;
            paint();
        });
        getChildren().addAll(finalRank,arrowReturn);
        RotateTransition rt = new RotateTransition(Duration.millis(duration), finalRank);
        rt.setAxis(Rotate.Y_AXIS);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setCycleCount(cycle);
        rt.play();
    }
}
