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
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
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
    @Override
    
    public void start(Stage primaryStage){
        PhongMaterial material1 = new PhongMaterial();
        material1.setDiffuseColor(Color.BLUE);
        material1.setSpecularColor(Color.LIGHTBLUE);
        material1.setSpecularPower(2.0);
        
        Room3Ob rb = new Room3Ob();
        
        MeshView mesh =new MeshView(rb);
        
        //mesh.setLayoutX(200);
        //mesh.setLayoutY(50);
        //mesh.setTranslateZ(0);
        mesh.setRotationAxis(Rotate.Y_AXIS);
        mesh.setRotate(135);
        mesh.setMaterial(material1);
        Cylinder pillar[] = new Cylinder[20];
        for(int i = 0; i < 10 ; i++){
            pillar[i] = new Cylinder (10 ,100);
            pillar[i].setRotationAxis(Rotate.X_AXIS);
            pillar[i].setMaterial(material1);
            pillar[i].setLayoutX(125 );
            //pillar[i].setLayoutY(20* i);
            pillar[i].setTranslateZ(-80 *  i );
            //pillar[i].setRotate(20);
        }
        for(int i = 10; i < 20 ; i++){
            pillar[i] = new Cylinder (10 ,100 );
            pillar[i].setRotationAxis(Rotate.X_AXIS);
            pillar[i].setMaterial(material1);
            pillar[i].setLayoutX( -125 );
            //pillar[i].setLayoutY( 20* (i-10));
            pillar[i].setTranslateZ(-80 * ( i - 10));
            //pillar[i].setRotate(20);
        }
        Group group = new Group(pillar);
        group.getChildren().addAll(mesh);
        Scene scene = new Scene(group, 600, 400);
        camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);
        camera.setTranslateZ(-900);
        scene.setCamera(camera);
        primaryStage.setTitle("Room3");
        primaryStage.setScene(scene);
        primaryStage.setHeight(328);
        primaryStage.setWidth(500);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
