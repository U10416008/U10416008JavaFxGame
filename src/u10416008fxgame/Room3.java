/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u10416008fxgame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

/**
 *
 * @author user
 */
public class Room3 extends Application{
    PerspectiveCamera camera = new PerspectiveCamera(true);
    Pane pane = new Pane();;
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
        Scene scene = new Scene(pane, 600, 400);
        
        
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
        material1.setSpecularPower(2.0);
        PhongMaterial material2 = new PhongMaterial();
        material2.setDiffuseColor(Color.LIGHTGREY);
        
        
        Room3Ob rb = new Room3Ob();
        Box floor = new Box(300,30,300);
        floor.setLayoutY(65);
        floor.setTranslateZ(-150);
        floor.setMaterial(material2);      
        MeshView mesh =new MeshView(rb);
        mesh.setMaterial(material2);
        mesh.setLayoutY(-180);
        mesh.setTranslateZ(-150);
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
        Group group = new Group();
        group.getChildren().addAll(floor);
        group.getChildren().addAll(pillar);
        group.getChildren().addAll(mesh);
        group.setLayoutX(250);
        group.setLayoutY(50);
        group.setOnMouseEntered(e ->{
            group.setTranslateZ(group.getTranslateZ()-100);
        });
        group.setOnMouseExited(e ->{
            group.setTranslateZ(group.getTranslateZ()+100);
        });
        group.setOnMousePressed(e ->{
            shrine(mesh,floor,pillar);
        });
        Rotate rz = new Rotate(0.0, Rotate.Z_AXIS);
        Rotate ry = new Rotate(20.0, Rotate.Y_AXIS);
        Rotate rx = new Rotate(0.0, Rotate.X_AXIS);
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0); 
        camera.setTranslateZ(-1500);
        group.getTransforms().addAll(rx,ry,rz);
        pane.getChildren().clear();
        pane.getChildren().addAll(group);
        
    }
    public void shrine(MeshView mesh,Box floor,Cylinder pillar[]){
        Button returnRoom = new Button("返回");
        returnRoom.setPrefSize(100, 50);
        returnRoom.setLayoutX(-350);
        returnRoom.setLayoutY(-150);
        returnRoom.setOnAction(e ->{
            room3();
        });
        Group group = new Group();
        Rotate rz = new Rotate(0.0, Rotate.Z_AXIS);
        Rotate ry = new Rotate(0.0, Rotate.Y_AXIS);
        Rotate rx = new Rotate(0.0, Rotate.X_AXIS);
        group.getTransforms().addAll(rx,ry,rz);
        pane.getChildren().clear();
        camera.setTranslateZ(-800);
        group.getChildren().addAll(floor,mesh);
        group.getChildren().addAll(pillar);
        group.setLayoutY(50);
        pane.getChildren().addAll(group,returnRoom);
    }
}
