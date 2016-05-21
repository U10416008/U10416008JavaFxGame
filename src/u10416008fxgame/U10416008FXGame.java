/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u10416008fxgame;

import javafx.application.Application;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.scene.input.*;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.util.Duration;
import java.security.SecureRandom;

/**
 *
 * @author user
 */
public class U10416008FXGame extends Application {
    boolean ConOn =false;
    boolean inRoom = false;
    boolean inTown = false;
    boolean onRoad2 = false;
    boolean fighting = false;
    boolean imageChange = false;
    boolean inRoom2 = false ;
    boolean onSkyStair = false ;
    boolean roadToBoss = false;
    boolean leftBoss = false;
    boolean rightBoss = false;
    boolean middleBoss = false;
    Timeline animation;
    Timeline imageUp;
    Timeline imageDown;
    Timeline imageRight;
    Timeline imageLeft;
    Timeline escFight;
    Timeline fightOrNot;
    FadeTransition goFight;
    FadeTransition goSkyFight;
    SequentialTransition fightOrder ;
    final int UP = 1;
    final int DOWN = 2;
    final int RIGHT = 3;
    final int LEFT = 4;
    int action;
    double dx = 0, dy = 0;
    double dxTB = 0, dyTB = 0;
    double dx2 = 0, dy2 = 0;
    double  dyOSS , dyLB, dyRB , dyMB = 0;
    double beforeFightX ,beforeFightY ;
    Controller controller = new Controller();
    Map map = new Map();
    Text location = new Text();
    Image imageRightStop = new Image(getClass().getResourceAsStream("RightSTOP.jpg"));
    Image imageLeftStop = new Image(getClass().getResourceAsStream("LeftSTOP.jpg"));
    Image imageUpStop = new Image(getClass().getResourceAsStream("UpSTOP.jpg"));
    Image imageDownStop = new Image(getClass().getResourceAsStream("DownStop.jpg"));
    Image imageRightMove = new Image(getClass().getResourceAsStream("RightMove.jpg"));
    Image imageLeftMove = new Image(getClass().getResourceAsStream("LeftMove.jpg"));
    Image imageUpMove = new Image(getClass().getResourceAsStream("UpMove.jpg"));
    Image imageDownMove = new Image(getClass().getResourceAsStream("DownMove.jpg"));
    Image imageSky = new Image(getClass().getResourceAsStream("FightSky.jpg"));
    ImageView imageMove = new ImageView(imageDownStop);
    ImageView imageSkyFight = new ImageView(imageSky);
    SecureRandom monster = new SecureRandom();
    SecureRandom srand = new SecureRandom();
    Pane pane = new Pane();
    
    @Override
    
    public void start(Stage primaryStage) {
        
        map.paintTown();
        inTown = true;
        pane.getChildren().addAll(map,imageMove,location,imageSkyFight);
        imageSkyFight.setVisible(false);
        imageMove.setX(50);
        imageMove.setY(150);
        location.setX(30);
        location.setY(30);
        location.setFont(Font.font ("Verdana",FontWeight.BOLD, 20));
        location.setFill(Color.RED);
        
        //move 
        animation = new Timeline(
            new KeyFrame(Duration.millis(10), e -> move()));
        //move action
        imageUp = new Timeline(
                new KeyFrame(Duration.millis(50), e -> setImage(imageUpStop)));
        imageDown = new Timeline(
                new KeyFrame(Duration.millis(50), e -> setImage(imageDownStop)));
        imageRight = new Timeline(
                new KeyFrame(Duration.millis(50), e -> setImage(imageRightStop)));
        imageLeft = new Timeline(
                new KeyFrame(Duration.millis(50), e -> setImage(imageLeftStop)));
        //fade out or in the normal fight
        goFight = new FadeTransition(Duration.millis(3000), pane);
        goFight.setFromValue(1.0);
        goFight.setToValue(0.1);
        goFight.setCycleCount(2);
        goFight.setAutoReverse(true);
        goFight.setCycleCount(1);
        //fade out or in the sky fight
        goSkyFight = new FadeTransition(Duration.millis(3000), imageSkyFight);
        goSkyFight.setFromValue(0.1);
        goSkyFight.setToValue(1);
        //fight 
        fightOrNot = new Timeline(
                new KeyFrame(Duration.millis(3000), e -> {
                    imageSkyFight.setVisible(false);
                    map.paintFight();
                    imageMove.setVisible(false);
                    location.setVisible(false);
                    
                }
                ));
        // the transition order to fight
        fightOrder = new SequentialTransition(); 
        fightOrder.getChildren().addAll(fightOrNot);
        fightOrder.setCycleCount(1);
        //escape the fight
        escFight = new Timeline(
                new KeyFrame(Duration.millis(3000), e -> {paintMap(); }));
        Scene scene = new Scene(pane , 500 ,300);
        
        scene.setOnKeyPressed(e -> {
            //not fighting
            if(fighting == false){
                //up ,down , left , right move 
                if(e.getCode() == KeyCode.UP){
                
                    action = UP;
                    animation.play();
                    imageUp.play();
                    setImage(imageUpMove);
                }
                if(e.getCode() == KeyCode.DOWN){
                    action = DOWN;
                    animation.play();
                    imageDown.play();
                    setImage(imageDownMove);
                }
                if(e.getCode() == KeyCode.RIGHT){
                    action = RIGHT;
                    animation.play();
                    imageRight.play();
                    setImage(imageRightMove);
                }                
                if(e.getCode() == KeyCode.LEFT){
                    action = LEFT;
                    animation.play();
                    imageLeft.play();
                    setImage(imageLeftMove);
                }
                //enter the fight
                if(e.getCode() == KeyCode.ENTER){
                    
                    if(leftBoss == true &&imageMove.getY() <=135 ){
                        fight(4);
                    }
                    if(rightBoss == true &&imageMove.getY() <=120 ){
                        fight(5);
                    }
                    if(middleBoss == true &&imageMove.getY() <=125 ){
                        fight(3);
                    }
                    beforeFight(imageMove.getX(),imageMove.getY());
                    
                }
                location.setText(imageMove.getX()+ "," + imageMove.getY());
                
            }
            //fighting
            else{
                goFight.setDuration(Duration.millis(3000));
                goFight.setCycleCount(2);
                //to finish the fight
                if(e.getCode() == KeyCode.ENTER){
                    if(map.getFinish() == true){
                        goFight.play();
                        escFight.play();
                        
                    }
                }
                //to escape the fight
                if(e.getCode() == KeyCode.ESCAPE){
                    if(map.getFinish() == false){
                        goFight.play();
                        escFight.play();
                        map.setLeaveFight();
                    }
                }
            }
            
        });
        scene.setOnKeyReleased(e ->{
            
            animation.stop();
            if(fighting == false){
                location.setText(imageMove.getX()+ "," + imageMove.getY());
            }
            
        });
        scene.setOnMousePressed(e -> {
            //get the location that mouse clicked
            System.out.println(e.getX()+ "," + e.getY());
        });
        
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.setHeight(328);
        primaryStage.setWidth(500);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    // main method
    public static void main(String[] args) {
        launch(args);
    }
    // move method
    public void move(){
        
        
        if(action == UP){
            dx = 0;
            dy = -5;
            dxTB = 0;
            dyTB = -5;
            dx2 = 0;
            dy2 = -5;
            dyOSS =-5;
            dyMB = -5;
            dyLB = -5;
            dyRB = -5;
            if(inTown == true){ 
                if(imageMove.getX() <= 135 && imageMove.getX() >= 130 && imageMove.getY() <= 120 && imageMove.getY() >= 110){
                    map.paintRoom();
                    inTown = false;
                    imageMove.setVisible(false);
                    location.setVisible(false);                
                    inRoom = true ;
                }
                if(imageMove.getX() <= 350 && imageMove.getX() >= 345 && imageMove.getY() <= 120 && imageMove.getY() >= 110){
                    map.paintRoom2();
                    inTown = false;
                    imageMove.setVisible(false);
                    location.setVisible(false);                
                    inRoom2 = true ;
                }
                if((imageMove.getX() > 35 && imageMove.getX() < 200 && imageMove.getY() == 115) 
                    || (imageMove.getX() > 275 && imageMove.getX() < 440 && imageMove.getY() == 115)
                    || (imageMove.getX() >= 50 && imageMove.getX() <= 250 && imageMove.getY() == 15)
                    || (imageMove.getX() >= 280 && imageMove.getX() <= 430 && imageMove.getY() == 20)
                    || (imageMove.getX() > 350 && imageMove.getX() < 395 && imageMove.getY() == 180)
                    || (imageMove.getX() > 60 && imageMove.getX() < 250 && imageMove.getY() == 230)
                    || (imageMove.getX() >= 130 && imageMove.getX() <= 175 && imageMove.getY() == 240)
                    || (imageMove.getX() <= 55 && imageMove.getY() <= 45)
                    || (imageMove.getX() > 430 && imageMove.getY() == 45)){
                    dy = 0;
                    dx = 0;
                }
            }
            
           
            
            if(roadToBoss == true &&(imageMove.getX() <= 225&& imageMove.getY()<=90 || imageMove.getX() >= 255&& imageMove.getY()<=90)){
                if(imageMove.getX() >= 130 && imageMove.getX() <=150){
                    roadToBoss = false;
                    leftBoss = true; 
                    map.paintLeftBoss();
                    imageMove.setX(235);
                    imageMove.setY(270);
                    
                }
                if(imageMove.getX() >= 330 && imageMove.getX() <=350){
                    roadToBoss = false;
                    rightBoss = true;                   
                    map.paintRightBoss();
                    imageMove.setX(235);
                    imageMove.setY(270);
                    
                }
                dyTB = 0;
                dxTB = 0;
                
            }
            if(onSkyStair == true && imageMove.getY() <= 30){
                    map.paintToBoss();
                    onSkyStair = false ;
                    roadToBoss = true;
                    imageMove.setX(235);
                    imageMove.setY(165);
            }
            if(imageMove.getY() <= 5){
                if(inTown == true){
                    inTown = false;
                    map.paintRoad2();
                    onRoad2 = true;
                    imageMove.setX(270);
                    imageMove.setY(270);
                }
                else if(onRoad2 == true && imageMove.getX()>=205 && imageMove.getX() <= 275){
                    map.paintSkyStair();
                    onSkyStair = true ;
                    onRoad2 = false;
                    imageMove.setX(235);
                    imageMove.setY(270);
                    
                }else if(roadToBoss == true){
                    middleBoss = true;
                    roadToBoss = false;
                    map.paintMiddleBoss();
                    imageMove.setX(235);
                    imageMove.setY(270);
                    
                    
                }
                dy = 0;
                dx = 0;
                dyTB = 0;
                dxTB = 0;
                dyMB = 0;
                
                dyRB = 0;
                if(imageMove.getX() <=205 || imageMove.getX() >= 275){
                    dy2 = 0;
                    dx2 = 0;
                }
            }
            if(imageMove.getY() <=120 ){
                dyLB = 0;
            }
            if(imageMove.getY() <=105 ){
                dyRB = 0;
            }
            if(imageMove.getY() <=110 ){
                dyMB = 0;
            }
            
            
        }
        if(action == DOWN){ 
            if(inRoom == true){
                map.paintTown();
                inTown = true;
                imageMove.setX(130);
                imageMove.setY(120);
                imageMove.setVisible(true);
                location.setVisible(true);
                inRoom = false;
                
            }
            if(inRoom2 == true){
                map.paintTown();
                inTown = true;
                imageMove.setX(345);
                imageMove.setY(120);
                imageMove.setVisible(true);
                location.setVisible(true);
                inRoom2 = false;
                
            }
            
            
            dx = 0;
            dy = 5;
            dxTB = 0;
            dyTB = 5;
            dx2 = 0;
            dy2 = 5;
            dyOSS = 5;
            dyMB = 5;
            dyLB = 5;
            dyRB = 5;
            if(inTown == true){
                if((imageMove.getX() > 60 && imageMove.getX() < 250&& imageMove.getY() == 155)
                    || (imageMove.getX() > 35 && imageMove.getX() < 175&& imageMove.getY() == 50)
                    || (imageMove.getX() > 305 && imageMove.getX() < 440&& imageMove.getY() == 50)
                    || (imageMove.getX() >= 280 && imageMove.getX() <= 305 && imageMove.getY() == 90)
                    || (imageMove.getX() >= 175 && imageMove.getX() < 200 && imageMove.getY() == 90)
                    || (imageMove.getX() > 350 && imageMove.getX() < 395 && imageMove.getY() == 170)
                    || (imageMove.getX() >= 420 && imageMove.getY() == 210)
                    || (imageMove.getX() >= 375 && imageMove.getX() <= 420 &&imageMove.getY() == 240)
                    || (imageMove.getX() <= 55  && imageMove.getY() == 240)){
                    dy = 0;
                    dx = 0;
                }
            }
            if(imageMove.getY() >= 165){
                if(roadToBoss == true && imageMove.getX() >= 225 && imageMove.getX() <= 260){
                    map.paintSkyStair();
                    onSkyStair = true;
                    roadToBoss = false;
                    imageMove.setX(235);
                    imageMove.setY(30);
                }
                dyTB = 0;
                dxTB = 0;
            }
            if(imageMove.getY() >= 270){
                if(leftBoss == true){
                    roadToBoss = true;
                    leftBoss = false;
                    map.paintToBoss();
                    imageMove.setX(140);
                    imageMove.setY(90);
                }
                if(rightBoss == true){
                    roadToBoss = true;
                    rightBoss = false;
                    map.paintToBoss();
                    imageMove.setX(340);
                    imageMove.setY(90);
                }
                if(middleBoss == true){
                    roadToBoss = true;
                    middleBoss = false;
                    map.paintToBoss();
                    imageMove.setX(235);
                    imageMove.setY(5);
                }
            }
            if(imageMove.getY() >= 255){
                if(onRoad2 == true){
                    map.paintTown();
                    onRoad2 = false;
                    inTown = true;
                    imageMove.setX(270);
                    imageMove.setY(5);
                }else if(onSkyStair == true){
                    map.paintRoad2();
                    onRoad2 = true;
                    onSkyStair = false;
                    imageMove.setX(270);
                    imageMove.setY(5);
                    
                }
                dy = 0;
                dx = 0;
                dyTB = 0;
                dxTB = 0;
                dy2 = 0;
                dx2 = 0;
                
            }
            if((imageMove.getY() >=225 && imageMove.getX() < 250)
                    || (imageMove.getY() >=195 && imageMove.getX() > 280)){
                dy2 = 0;
                dx2 = 0;
            }
            
        }
        if(action == RIGHT){
            
            dy = 0;
            dx = 5;
            dyTB = 0;
            dxTB = 5;
            dy2 = 0;
            dx2 = 5;
            dyOSS = 0;
            dyMB = 0;
            dyLB = 0;
            dyRB = 0;       
            if(inTown == true){
                if((imageMove.getX() == 35 && imageMove.getY() >= 50&& imageMove.getY() <115)
                    || (imageMove.getX() == 275 && imageMove.getY() >= 90&& imageMove.getY() <115)
                    || (imageMove.getX() == 305 && imageMove.getY() >= 50&& imageMove.getY() <115)
                    || (imageMove.getX() == 280 &&  imageMove.getY() <=10)
                    || (imageMove.getX() == 60 && imageMove.getY() >= 155&& imageMove.getY() <=230)
                    || (imageMove.getX() == 130 && imageMove.getY() >= 230&& imageMove.getY() <=240)
                    || (imageMove.getX() == 350 && imageMove.getY() >= 170&& imageMove.getY() <=180)
                    || (imageMove.getX() == 375 && imageMove.getY() >= 240)
                    || (imageMove.getX() == 420 && imageMove.getY() >= 210)
                    || (imageMove.getX() == 420 && imageMove.getY() < 40)){
                    dy = 0;
                    dx = 0;
                }
            }
            if(roadToBoss == true &&imageMove.getX() >= 255&& imageMove.getY()<=90){
                dxTB = 0;
                dyTB = 0;
            }
            if(imageMove.getX() >= 480){
                
                dy = 0;
                dx = 0;
                dyTB = 0;
                dxTB = 0;
                dy2 = 0;
                dx2 = 0;
            }
            if((imageMove.getX() >= 280 && imageMove.getY() < 5)
                    || (imageMove.getX() >= 280 && imageMove.getY() > 195)){
                dy2 = 0;
                dx2 = 0;
            }
            
        }
        if(action == LEFT){
            
            dy = 0;
            dx = -5;
            dyTB = 0;
            dxTB = -5; 
            dy2 = 0;
            dx2 = -5;
            dyOSS = 0;
            dyMB = 0;
            dyLB = 0;
            dyRB = 0;
           if(imageMove.getX() <= 10){
                
                dy = 0;
                dx = 0;
                dyTB = 0;
                dxTB = 0;
                dy2 = 0;
                dx2 = 0;
            }
            if(inTown == true){
                if((imageMove.getX() == 55 && imageMove.getY() <= 45)
                    || (imageMove.getX() == 55  && imageMove.getY() >= 240 && imageMove.getY() <= 255)
                    || (imageMove.getX() == 175  && imageMove.getY() >= 230 && imageMove.getY() < 240)
                    || (imageMove.getX() == 250  && imageMove.getY() >= 155 && imageMove.getY() < 230)
                    || (imageMove.getX() == 175&& imageMove.getY() <= 90 && imageMove.getY() >= 50)
                    || (imageMove.getX() == 200 && imageMove.getY() >= 90&& imageMove.getY() <115)
                    || (imageMove.getX() == 250 &&  imageMove.getY() <=10)
                    || (imageMove.getX() == 440&& imageMove.getY() < 115 &&  imageMove.getY() >= 50)
                    || (imageMove.getX() == 395 && imageMove.getY() >= 170&& imageMove.getY() <=180)){
                    dy = 0;
                    dx = 0;
                }
            }
            if(roadToBoss == true &&imageMove.getX() <= 225&& imageMove.getY()<=90){
                dxTB = 0;
                dyTB = 0;
            }
            if((imageMove.getX() <= 200 && imageMove.getY() < 5)
                    || (imageMove.getX() <= 250 && imageMove.getY() > 225)){
                dy2 = 0;
                dx2 = 0;
            }
            
        }
        if(onRoad2 == true){
            if((imageMove.getX() <= 140 && (imageMove.getY() >= 5 && imageMove.getY() <= 225)) 
                || (imageMove.getX() >= 295 && (imageMove.getY() >= 5 && imageMove.getY() <= 195))){
                    if(imageChange == false){
                        imageDownStop = new Image(getClass().getResourceAsStream("DownStopGrass.jpg"));
                        imageUpStop = new Image(getClass().getResourceAsStream("UpStopGrass.jpg"));
                        imageRightStop = new Image(getClass().getResourceAsStream("RightStopGrass.jpg"));
                        imageLeftStop = new Image(getClass().getResourceAsStream("LeftStopGrass.jpg"));
                        imageChange = true;
                    }
                    if(srand.nextInt(40) == 1 && fighting == false){
                        beforeFight(imageMove.getX() ,imageMove.getY());
                        fight(monster.nextInt(6));
                    }
            }else{
                if(imageChange == true){
                    imageDownStop = new Image(getClass().getResourceAsStream("DownStop.jpg"));
                    imageUpStop = new Image(getClass().getResourceAsStream("UpSTOP.jpg"));
                    imageRightStop = new Image(getClass().getResourceAsStream("RightSTOP.jpg"));
                    imageLeftStop = new Image(getClass().getResourceAsStream("LeftSTOP.jpg"));
                    imageChange = false;
                }
            }
                
        }
        if(fighting == true){
            dx = 0;
            dy = 0;
            dxTB = 0;
            dyTB = 0;
            dx2 = 0;
            dy2 = 0;
        }
        
        if(inTown == true){
            imageMove.setX(imageMove.getX() + dx);
            imageMove.setY(imageMove.getY() + dy);
        }
        if(roadToBoss == true){
            imageMove.setX(imageMove.getX() + dxTB);
            imageMove.setY(imageMove.getY() + dyTB);
        }
        if(onRoad2 == true){
            imageMove.setX(imageMove.getX() + dx2);
            imageMove.setY(imageMove.getY() + dy2);
        }
        if(onSkyStair == true){
            imageMove.setY(imageMove.getY() + dyOSS);
        }
        if(leftBoss == true){
            imageMove.setY(imageMove.getY() + dyLB);    
        }
        if(middleBoss == true){
            imageMove.setY(imageMove.getY() + dyMB);    
        }
        if(rightBoss == true){
            imageMove.setY(imageMove.getY() + dyRB);    
        }
        
        
    }
    // set the main role image
    public void setImage(Image s){
        imageMove.setImage(s);
    }
    // fight method
    public void fight(int mon){
        
        fighting = true;
        if(mon != 3 ){
            goFight.setDuration(Duration.millis(250));
            goFight.setCycleCount(12);
            if(fightOrder.getChildren().contains(goSkyFight) == true){
                fightOrder.getChildren().remove(goSkyFight);
            }
            goFight.play();
            fightOrder.play();
            
        }else{
            if(fightOrder.getChildren().contains(goSkyFight) == false){
                fightOrder.getChildren().add(0,goSkyFight);
            }
            imageSkyFight.setVisible(true);
            fightOrder.play();
        }
        switch (mon) {
            case 0:
                map.HP("plant");
                break;
            case 1:
                map.HP("bear");
                break;
            case 2:
                map.HP("waterfish");
                break;
            case 3:
                map.HP("sky");
                
                break;
            case 4:
                map.HP("Di");
                break;    
            case 5:
                map.HP("hot");
                break;
            default:
                break;
        }
        
        
    }
    // the method that get the location before fight 
    public void beforeFight(double x , double y){
        beforeFightX = x;
        beforeFightY = y;
    }
    // paint the previous map before fight when the fight is finished
    public void paintMap(){
        if(onRoad2 ==true){
            map.paintRoad2();                  
        }
        else if(leftBoss == true){
            map.paintLeftBoss();  
        }
        else if(rightBoss == true){
            map.paintRightBoss();  
        }
        else if(middleBoss == true){
            map.paintMiddleBoss();  
        }
        imageMove.setVisible(true);
        imageMove.setX(beforeFightX);
        imageMove.setY(beforeFightY);
        fighting = false;
        map.afterFight();
    }
}

