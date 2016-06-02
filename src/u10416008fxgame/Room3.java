/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u10416008fxgame;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author user
 */
public class Room3 extends Application{
    PerspectiveCamera camera = new PerspectiveCamera(true);
    Pane pane = new Pane();
    Scene scene;
    boolean rotate = false;
    double mousePosX,mousePosY,mousePosZ;
    double mouseOldX ,mouseOldY,mouseOldZ;   
    double dx , dy ,dz;
    @Override
    
    public void start(Stage primaryStage){
        
        room3();
        
        Stop[] stops = new Stop[] {
            new Stop(0.0, Color.RED),
            new Stop(0.5, Color.ORANGE),
            new Stop(0.7, Color.YELLOW),
            new Stop(1.0, Color.GREEN)
        };
        LinearGradient lineargradient1 = new LinearGradient(
        0.0, 0.0, 0.0, 1.0, true, CycleMethod.REFLECT, stops);
        pane.setStyle("-fx-background-color: transparent");
        scene = new Scene(pane, 600, 400);
        scene.setFill(lineargradient1);
        scene.setCamera(camera);
        primaryStage.setTitle("Room3");
        primaryStage.setScene(scene);
        primaryStage.setHeight(328);
        primaryStage.setWidth(500);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public void room3(){
        PhongMaterial material1 = new PhongMaterial();
        material1.setDiffuseColor(Color.GREY);
        material1.setSpecularColor(Color.WHITE);
        material1.setSpecularPower(8.0);
        PhongMaterial material2 = new PhongMaterial();
        material2.setDiffuseColor(Color.LIGHTSKYBLUE);
        
        
        Room3Ob rb = new Room3Ob();
        Room3Ch ch = new Room3Ch();
        Box floor = new Box(300,30,300);
        floor.setLayoutY(65);
        floor.setTranslateZ(-150);
        floor.setMaterial(material1);      
        MeshView churchM =new MeshView(ch);
        churchM.setMaterial(material2);
        churchM.setLayoutY(-80);
        MeshView ceiling =new MeshView(rb);
        ceiling.setMaterial(material1);
        ceiling.setLayoutY(-180);
        ceiling.setTranslateZ(-150);
        Cylinder pillar[] = new Cylinder[20];
        for(int i = 0; i < 10 ; i++){
            pillar[i] = new Cylinder (5 ,100);
            pillar[i].setMaterial(material1);
            pillar[i].setLayoutX(125 );
            pillar[i].setTranslateZ(-15-30 * i );
        }
        for(int i = 10; i < 20 ; i++){
            pillar[i] = new Cylinder (5 ,100 );
            pillar[i].setMaterial(material1);
            pillar[i].setLayoutX( -125 );
            pillar[i].setTranslateZ(-15-30 * ( i - 10));
        }
        Group shrine = new Group();
        shrine.getChildren().addAll(floor);
        shrine.getChildren().addAll(pillar);
        shrine.getChildren().addAll(ceiling);
        shrine.setLayoutX(350);
        shrine.setLayoutY(50);
        Group church = new Group(churchM);
        church.setLayoutX(-350);
        church.setLayoutY(50);
        shrine.setOnMouseEntered(e ->{
            shrine.setTranslateZ(shrine.getTranslateZ()-100);
        });
        shrine.setOnMouseExited(e ->{
            shrine.setTranslateZ(shrine.getTranslateZ()+100);
        });
        shrine.setOnMousePressed(e ->{
            shrine(ceiling,floor,pillar);
        });
        church.setOnMouseEntered(e ->{
            church.setTranslateZ(church.getTranslateZ()-100);
        });
        church.setOnMouseExited(e ->{
            church.setTranslateZ(church.getTranslateZ()+100);
        });
        church.setOnMousePressed(e ->{
            church(churchM);
        });
        Rotate rz = new Rotate(0.0, Rotate.Z_AXIS);
        Rotate ry = new Rotate(40.0, Rotate.Y_AXIS);
        Rotate rx = new Rotate(0.0, Rotate.X_AXIS);
        Rotate cz = new Rotate(0.0, Rotate.Z_AXIS);
        Rotate cy = new Rotate(-75.0, Rotate.Y_AXIS);
        Rotate cx = new Rotate(0.0, Rotate.X_AXIS);
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0); 
        camera.setTranslateZ(-1500);
        shrine.getTransforms().addAll(rx,ry,rz);
        church.getTransforms().addAll(cx,cy,cz);
        pane.getChildren().clear();
        pane.getChildren().addAll(shrine,church);
        
    }
    public void shrine(MeshView mesh,Box floor,Cylinder pillar[]){
        PhongMaterial material1 = new PhongMaterial();
        material1.setDiffuseColor(Color.RED);
        material1.setSpecularColor(Color.CORAL);
        PhongMaterial material2 = new PhongMaterial();
        material2.setDiffuseColor(Color.DARKBLUE);
        material2.setSpecularColor(Color.LIGHTBLUE);
        Room3Ar ar = new Room3Ar();
        MeshView arrow = new MeshView(ar);
        arrow.setLayoutX(-300);
        arrow.setLayoutY(-150);
        Room3Ar arIn[] = new Room3Ar[3];
        MeshView arrowIn[] = new MeshView[3];
        Rotate az = new Rotate(90.0, Rotate.Z_AXIS);
        Rotate ax = new Rotate(60.0, Rotate.X_AXIS);
        for(int i = 0 ; i < 3 ; i++){
            arIn[i] = new Room3Ar();
            arrowIn[i] = new MeshView(arIn[i]);
            arrowIn[i].setTranslateZ(-300);
            arrowIn[i].setLayoutY(25);
            arrowIn[i].setLayoutX(-50+50*i);
            arrowIn[i].getTransforms().addAll(ax,az);
            
        }
        arrowIn[1].setMaterial(material1);
        arrowIn[2].setMaterial(material2);
        arrowIn[0].setOnMousePressed(e ->{
                toPlayArrow(0);
        });
        arrowIn[1].setOnMousePressed(e ->{
                toPlayArrow(1);
        });
        arrowIn[2].setOnMousePressed(e ->{
                toPlayArrow(2);
        });
        Group group = new Group();
        Rotate rz = new Rotate(0.0, Rotate.Z_AXIS);
        Rotate ry = new Rotate(0.0, Rotate.Y_AXIS);
        Rotate rx = new Rotate(0.0, Rotate.X_AXIS);
        
        
        RotateTransition rt = new RotateTransition(Duration.millis(3000), arrow);
        rt.setAxis(Rotate.X_AXIS);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setCycleCount(Timeline.INDEFINITE);
        rt.setAutoReverse(true);
        arrow.setOnMouseEntered(e ->{
            if(rotate == false){
                rt.play();
                rotate = true;
            }
        });
        arrow.setOnMouseExited(e ->{
            if(rotate == true){
                rt.stop();
                rotate = false;
            }
        });
        arrow.setOnMousePressed(e ->{
            room3();
        });
        
        group.getTransforms().addAll(rx,ry,rz);
        pane.getChildren().clear();
        camera.setTranslateZ(-800);
        group.getChildren().addAll(floor,mesh);
        group.getChildren().addAll(pillar);
        group.setLayoutY(50);
        pane.getChildren().addAll(group,arrow);
        pane.getChildren().addAll(arrowIn);
    }
    public void church(MeshView mesh){
        Room3Ar ar = new Room3Ar();
        MeshView arrow = new MeshView(ar);
        arrow.setLayoutX(-300);
        arrow.setLayoutY(-150);
        Group group = new Group();
        Rotate rz = new Rotate(0.0, Rotate.Z_AXIS);
        Rotate ry = new Rotate(-60.0, Rotate.Y_AXIS);
        Rotate rx = new Rotate(0.0, Rotate.X_AXIS);
        RotateTransition rt = new RotateTransition(Duration.millis(3000), arrow);
        rt.setAxis(Rotate.X_AXIS);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setCycleCount(Timeline.INDEFINITE);
        rt.setAutoReverse(true);
        arrow.setOnMouseEntered(e ->{
            if(rotate == false){
                rt.play();
                rotate = true;
            }
        });
        arrow.setOnMouseExited(e ->{
            if(rotate == true){
                rt.stop();
                rotate = false;
            }           
        });
        arrow.setOnMousePressed(e ->{
            room3();
        });
        group.getTransforms().addAll(rx,ry,rz);
        group.getChildren().addAll(mesh);
        pane.getChildren().clear();
        camera.setTranslateZ(-850);
        pane.getChildren().addAll(group,arrow);
    }
    public void toPlayArrow(int level){
        ArrowGame ag = new ArrowGame(level);
        scene.setRoot(ag);
        scene.setOnKeyPressed(e ->{
            ag.control(e.getCode());
            if(e.getCode() == KeyCode.ESCAPE){
                scene.setRoot(pane);
            }
        });
    }
}
