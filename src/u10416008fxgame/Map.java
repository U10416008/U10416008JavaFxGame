/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u10416008fxgame;

/**
 *
 * @author user
 */

import javafx.animation.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.*;
import java.security.SecureRandom;
import java.util.ArrayList;


public class Map extends Pane {
    boolean moveFinish = false;
    boolean ConOn =false;
    boolean finish = false;
    boolean sky = false;
    boolean lightOn = true;
    Controller controller = new Controller();
    Image image = new Image(getClass().getResourceAsStream("town.jpg"));
    Text star = new Text("");
    Timeline goFight;
    Tooltip btTooltip = new Tooltip("Something Is Here");
    ImageView imageFightRole = new ImageView(new Image(getClass().getResourceAsStream("FightMainRole.jpg")));
    ImageView imageFight = new ImageView(new Image(getClass().getResourceAsStream("FightPlant.jpg")));
    Text letFight = new Text("打架啦!!!!!");
    StringBuilder sb;
    int attack;
    int times = 0;
    int dx = 2;
    final int Loser = 15;
    public Map(){
        setStyle("-fx-background-color: black");
        setPrefSize(500,300);
        star.setFont(Font.font("Courier",FontWeight.BOLD,FontPosture.REGULAR,20));
        star.setFill(Color.RED);
    }
    public Image getImage(){
        return image;
    }
    public void setImage(String s){
        image = new Image(getClass().getResourceAsStream(s));
    }
    public void setFightImage(String s){
        imageFight = new ImageView(new Image(getClass().getResourceAsStream(s)));
    }
    public void setFightImageRole(String s){
        imageFightRole = new ImageView(new Image(getClass().getResourceAsStream(s)));
    }
    public void paintRoom(){
        Button TV = new Button( );
        SecureRandom btNumber = new SecureRandom();
        SecureRandom location = new SecureRandom();
        Image controllerImage = new Image(getClass().getResourceAsStream("Controller.jpg"));
        int x ,y =0;
        int number = btNumber.nextInt(10);
        ArrayList<Button> bt = new ArrayList<>();
        for(int i = 0 ; i < number ; i++){
            bt.add(new Button(""));
           
        }
        Text find = new Text("Find the Controller!");
        setImage("room.jpg");
        ImageView roomImage = new ImageView(getImage());
        find.setFont(Font.font("Courier",FontWeight.BOLD,FontPosture.REGULAR,20));     
        TV.setTooltip(btTooltip);
        TV.setStyle("-fx-background-color: transparent");
        TV.setPrefSize(35, 20);
        TV.setLayoutX(340);
        TV.setLayoutY(200);
        TV.setOnMouseEntered(e -> find.setText("Somethig Is Here"));
        TV.setOnMouseExited(e -> find.setText("Find the Controller!"));
        TV.setOnAction(e ->{
            if(ConOn == false){
                controller.createNew();
                ConOn = true;
                find.setText("You Find The Controller !");
                TV.setGraphic(new ImageView(controllerImage));
                
            }else{
                controller.closeController();
                ConOn =false;
            }
        });
        find.setLayoutX(30);
        find.setLayoutY(30);
        getChildren().clear();
        getChildren().addAll(roomImage,TV,find);
        for(int i = 0 ; i < bt.size() ; i++){
            x = location.nextInt(430/bt.size()) + i * 70 ;
            y = location.nextInt(260/bt.size()) + i * 40;
            
            while( x >= 315 && x <= 375 && y >= 180 && y <=220){
                x = location.nextInt(430/bt.size()) + i * 70 ;
                y = location.nextInt(260/bt.size()) + i * 40;
            }
            bt.get(i).setStyle("-fx-background-color: transparent");
            bt.get(i).setTooltip(btTooltip);
            bt.get(i).setPrefSize(35, 20);
            bt.get(i).setLayoutX(x);
            bt.get(i).setLayoutY(y);
            bt.get(i).setOnMouseEntered(e ->find.setText("Somethig Is Here"));
            bt.get(i).setOnMouseExited(e -> find.setText("Find the Controller!"));
            bt.get(i).setOnAction(e -> find.setText("You Find The TRASH !!"));
            getChildren().add(bt.get(i));
        }
    }
    public void paintRoom2(){
        setImage("room2.jpg");
        Button light = new Button();
        light.setStyle("-fx-background-color: transparent");
        light.setPrefSize(30,20);
        light.setLayoutX(225);
        light.setLayoutY(20);
        Button calender = new Button();
        calender.setStyle("-fx-background-color: transparent");
        calender.setPrefSize(30,35);
        calender.setLayoutX(90);
        calender.setLayoutY(86);
        light.setOnAction(e -> {
            if(lightOn == true){
                setImage("room2Dark.jpg");
                getChildren().remove(0);
                getChildren().add(0,new ImageView(getImage()));
                lightOn = false;
            }else{
                setImage("room2.jpg");
                getChildren().remove(0);
                getChildren().add(0,new ImageView(getImage()));
                lightOn = true;
            }
            
        });
        calender.setOnAction(e ->{
            CaculatorDate cD = new CaculatorDate();
            Stage secondStage = new Stage();
            cD.start(secondStage);
        });
        getChildren().clear();
        getChildren().addAll(new ImageView(getImage()),light,calender);
    }
    public void paintSkyStair(){
        setImage("roadBossStair.jpg");
        getChildren().clear();
        getChildren().addAll(new ImageView(getImage()));
    }
    public void paintToBoss(){
        setImage("roadToBoss.jpg");
        getChildren().clear();
        getChildren().addAll(new ImageView(getImage()));
    }
    public void paintLeftBoss(){
        setImage("roadIce.jpg");
        getChildren().clear();
        getChildren().addAll(new ImageView(getImage()));
    }
    public void paintRightBoss(){
        setImage("roadBossHot.jpg");
        getChildren().clear();
        getChildren().addAll(new ImageView(getImage()));
    }
    public void paintMiddleBoss(){
        setImage("roadBossSky.jpg");
        getChildren().clear();
        getChildren().addAll(new ImageView(getImage()));
    }
    
    public void paintTown(){
        setImage("town.jpg");
        getChildren().clear();
        getChildren().addAll(new ImageView(getImage()));
    }
    
    public void paintRoad2(){
        setImage("road2.jpg");
        getChildren().clear();
        getChildren().addAll(new ImageView(getImage()));
    }
    
    public void paintFight(){  
        SecureRandom critical = new SecureRandom();
	letFight.setText("打架啦!!!!!");
        letFight.setX(40);
        letFight.setY(285);
        letFight.setFont(Font.font("Courier",FontWeight.BOLD,FontPosture.REGULAR,80));
        letFight.setFill(Color.WHITE);
        times = 0;       
        sb = new StringBuilder(star.getText());
        star.setX(30);
        star.setY(30);
        imageFight.setX(-266);
        imageFight.setY(0);
        imageFightRole.setX(500);
        imageFightRole.setY(85);
        goFight = new Timeline(
            new KeyFrame(Duration.millis(10), e -> {
                if(imageFightRole.getX() == 0){
                    goFight.stop();
                    moveFinish = true;
                }
                move();                           
            }));
        this.setOnMousePressed(e ->{
            if(moveFinish == true){
                attack = critical.nextInt(3) + critical.nextInt(3);
                if((star.getText().equals("") == false )&& finish == false){                    
                    attack();
                    times++;
                }
                if((star.getText().equals("") == true) && times <=Loser){                
                    letFight.setText("Winner!!!");
                    finish = true;
                }
                if((star.getText().equals("") == false) && times ==Loser){
                    letFight.setText("Loser!!!");
                    finish = true;
                }    
            }
            
        });
        goFight.setCycleCount(Timeline.INDEFINITE);
        goFight.play();
        getChildren().clear();
        getChildren().addAll(new ImageView(getImage()), imageFightRole ,imageFight,star,letFight);
    }
    public void move(){
        imageFight.setX(imageFight.getX() + dx);
        imageFightRole.setX(imageFightRole.getX() - dx);
    }
    public void HP(String s){
        switch (s) {
            case "plant":
                setFightImageRole("FightMainRole.jpg");
                setImage("FightPlan.jpg");
                setFightImage("FightPlant.jpg");
                star.setText("||||||||");
                break;
            case "bear":
                setFightImageRole("FightMainRole.jpg");
                setImage("FightPlan.jpg");
                setFightImage("FightBear.jpg");
                star.setText("|||||||||||");
                break;
            case "waterfish": 
                setFightImageRole("FightMainRole.jpg");
                setImage("FightPlan.jpg");
                setFightImage("WaterFish.jpg");
                star.setText("||||||||||||");
                break;
            case "sky":
                setFightImageRole("FightMainRoleSky.jpg");
                setImage("FightSkyPlan.jpg");
                setFightImage("BossSky.jpg");
                star.setText("|||||||||||||||||||||||||||");
                break;
            case "Di":
                setFightImageRole("FightMainRoleIce.jpg");
                setImage("FightIcePlan.jpg");
                setFightImage("BossDi.jpg");
                star.setText("|||||||||||||||||||||||");
                break;
            case "hot":
                setFightImageRole("FightMainRoleHot.jpg");
                setImage("FightHotPlan.jpg");
                setFightImage("BossHot.jpg");
                star.setText("|||||||||||||||||||");
                break;
            default:
                break;
        }
    }
    public boolean getSky(){
        return sky;
    }
    public boolean getFinish(){
        return finish;
    }
    public void afterFight(){
        finish = false;
        moveFinish = false;
        sky = false ;
    }
    public void attack(){
        int damage = 0;
        if(attack == 2){
            letFight.setText("Miss~~~~");
        }else{
            
            if(attack == 0 || attack == 4){
                letFight.setText("Critical!!");
                damage = 2;
            }else if(attack == 1 || attack ==3){
                letFight.setText("Go!!!!!!");
                damage = 1;
            }
            if(sb.toString().length() <= damage){
                star.setText("");
            }else{
                sb.delete(0,damage);
                star.setText(sb.toString());
            }
                        
        }
    }
    public void setLeaveFight(){
        letFight.setText("逃跑囉~~~");
    }
    public void paintRoom3(){
        Room3 r3 = new Room3();
        Stage secondStage = new Stage();
        r3.start(secondStage);
        getChildren().clear();        
    }
    
}
